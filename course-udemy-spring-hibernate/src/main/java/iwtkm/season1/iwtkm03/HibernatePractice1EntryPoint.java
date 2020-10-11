package iwtkm.season1.iwtkm03;

import com.google.common.base.Verify;
import iwtkm.season1.iwtkm03.model.hibernatepractice._1norelation.KewlSinger;
import iwtkm.season1.iwtkm03.utilities.DateUtils;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * No relation Hibernate tut.
 *
 * For DDLs see ddls.txt within resources.
 *
 * From lj:
 * connect 'jdbc:derby://localhost:1527/udemydb01;create=true';
 * todo Derby local server must be launched for these tests
 *
 * From SquirrelSQL, IDEA db viewer:
 * jdbc:derby:c:\Users\Evgenii_Krapivin\Desktop\soft\Derby\db-derby-10.14.1.0-bin\bin\\udemydb01\\
 */
public class HibernatePractice1EntryPoint {

  private SessionFactory sessionFactory;

  // template singers
  private static final KewlSinger JIM_MORRISON =
      new KewlSinger("Jim", "Morrison", DateUtils.parseDate("01/01/1987"), "dead27club.com");
  private static final KewlSinger DAVE_GAHAN =
      new KewlSinger("Dave", "Gahan", DateUtils.parseDate("02/01/1987"), "depechemode.com");
  private static final KewlSinger DAVE_MUSTAINE =
      new KewlSinger("Dave", "Mustaine", DateUtils.parseDate("013/01/1987"), "megadeth.com");
  private static final KewlSinger ALICE_COOPER =
      new KewlSinger("Alice", "Cooper", DateUtils.parseDate("04/01/1987"), "alicecooper.com");
  private static final KewlSinger FABIO_LIONE =
      new KewlSinger("Fabio", "Lione", DateUtils.parseDate("05/01/1987"), "rhapsody.com");
  private static final KewlSinger RUSSEL_ALLEN =
      new KewlSinger("Russel", "Allen", DateUtils.parseDate("06/01/1987"), "symphonyx.net");
  private static final KewlSinger GLENN_HUGHES =
      new KewlSinger("Glenn", "Hughes", DateUtils.parseDate("07/01/1987"), "glennhughes.com");


  public static void main(String[] args) {
    try {
      new HibernatePractice1EntryPoint().execute();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      Runtime.getRuntime().exit(1);
    }
  }

  private void execute() throws ParseException {
    sessionFactory = new Configuration()
        .configure("config/hibernate.cfg.xml")
        .addAnnotatedClass(KewlSinger.class)
        .buildSessionFactory();

    sessionFactory = Verify.verifyNotNull(sessionFactory);

    truncateSingersTable();

    createInitialSingers();

    testListQuerying();

    renameRusselAllenToScoobyDoo();
  }

  private void truncateSingersTable() {
    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();
      // todo truncate does not work
      currentSession.createQuery("delete from KewlSinger")
          .executeUpdate();
      currentSession.getTransaction().commit();
    }

    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();
      // todo select below is a must!
      final Long countAfterTruncate = (Long) currentSession
          .createQuery("select count(*) from KewlSinger")
          .uniqueResult();
      currentSession.getTransaction().commit();
      Verify.verify(countAfterTruncate != null && countAfterTruncate == 0);
    }
  }

  private void createInitialSingers() {
    KewlSinger fabioLione;

    try (Session currentSession = sessionFactory.getCurrentSession()) {

      fabioLione = new KewlSinger(FABIO_LIONE);

      currentSession.beginTransaction();
      currentSession.save(new KewlSinger(JIM_MORRISON));
      currentSession.save(new KewlSinger(DAVE_GAHAN));
      currentSession.save(new KewlSinger(DAVE_MUSTAINE));
      currentSession.save(new KewlSinger(ALICE_COOPER));
      currentSession.save(fabioLione);
      currentSession.save(new KewlSinger(RUSSEL_ALLEN));
      currentSession.save(new KewlSinger(GLENN_HUGHES));
      currentSession.getTransaction().commit();
    }

    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();
      // todo select below is a must!
      final Long countAfterTruncate = (Long) currentSession
          .createQuery("select count(*) from KewlSinger")
          .uniqueResult();
      Verify.verify(countAfterTruncate != null && countAfterTruncate == 7);
      currentSession.getTransaction().commit();
    }

    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();
      final KewlSinger kewlSinger = currentSession.get(KewlSinger.class, fabioLione.getId());
      currentSession.getTransaction().commit();
      Verify.verify(kewlSinger != null && kewlSinger.equals(FABIO_LIONE));
    }
  }

  private void testListQuerying() {
    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();
      // todo use table column name if NOT USING table alias
      final List kewlSingersList = currentSession
          .createQuery("from KewlSinger where n='Dave'")
          .getResultList();
      currentSession.getTransaction().commit();
      Verify.verify(kewlSingersList != null && kewlSingersList.size() == 2);
      Verify.verify(kewlSingersList.contains(DAVE_GAHAN)
          && kewlSingersList.contains(DAVE_MUSTAINE));
      listSingers(kewlSingersList);
    }

    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();
      // todo use class field name if USING table alias
      @SuppressWarnings("unchecked") final List<KewlSinger> kewlSingersList = currentSession
          .createQuery("from KewlSinger ks where ks.officialWeb like '%.com'")
          .getResultList();
      currentSession.getTransaction().commit();
      Verify.verify(kewlSingersList != null && kewlSingersList.size() == 6);
      listSingers(kewlSingersList);
    }
  }

  private void listSingers(List<KewlSinger> kewlSingersList) {
    kewlSingersList.forEach(singer -> System.out.println("  " + singer));
  }

  private void renameRusselAllenToScoobyDoo() throws ParseException {
    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();
      final KewlSinger russelAllen = (KewlSinger) currentSession
          .createQuery("from KewlSinger ks where ks.name='Russel'")
          .getSingleResult();
      Verify.verify(RUSSEL_ALLEN.equals(russelAllen));
      russelAllen.setName("Scooby");
      russelAllen.setLastName("Doo");
      russelAllen.setDob(DateUtils.parseDate("23/02/1987"));
      currentSession.getTransaction().commit();
    }

    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();
      final KewlSinger singerFormerlyKnownAsRusselAllen = (KewlSinger) currentSession
          .createQuery("from KewlSinger ks where ks.officialWeb='symphonyx.net'")
          .getSingleResult();
      currentSession.getTransaction().commit();
      Verify.verify(singerFormerlyKnownAsRusselAllen != null);
      Verify.verify("Scooby".equals(singerFormerlyKnownAsRusselAllen.getName()));
      Verify.verify("Doo".equals(singerFormerlyKnownAsRusselAllen.getLastName()));
      listSingers(Collections.singletonList(singerFormerlyKnownAsRusselAllen));
    }
  }

}
