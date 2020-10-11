package iwtkm.season1.iwtkm03;

import com.google.common.base.Verify;
import iwtkm.season1.iwtkm03.model.hibernatepractice._2onetoone.KewlSingerDetails;
import iwtkm.season1.iwtkm03.model.hibernatepractice._2onetoone.KewlSingerWithDetails;
import iwtkm.season1.iwtkm03.utilities.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * One to one relation Hibernate tut.
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
public class HibernatePractice2EntryPoint {

  private SessionFactory sessionFactory;

  private static final KewlSingerWithDetails MARTIN_L_GORE =
      new KewlSingerWithDetails("Martin L.", "Gore", DateUtils.parseDate("01/01/1960"));

  public static void main(String[] args) {
    try {
      new HibernatePractice2EntryPoint().execute();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      Runtime.getRuntime().exit(1);
    }
  }

  private void execute() {
    sessionFactory = new Configuration()
        .configure("config/hibernate.cfg.xml")
        .addAnnotatedClass(KewlSingerWithDetails.class)
        .addAnnotatedClass(KewlSingerDetails.class)
        .buildSessionFactory();

    sessionFactory = Verify.verifyNotNull(sessionFactory);

    truncateTables();

    veryFirstTest();
    bidirectionalTest();
    cascadeDelete();
  }

  private void truncateTables() {
    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();
      // todo truncate does not work in HQL
      currentSession.createQuery("delete from KewlSingerWithDetails")
          .executeUpdate();
      currentSession.createQuery("delete from KewlSingerDetails")
          .executeUpdate();
      currentSession.getTransaction().commit();
    }

    verifyAmount(0, 0);
  }

  private void veryFirstTest() {
    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();

      final KewlSingerWithDetails martinGore = new KewlSingerWithDetails(MARTIN_L_GORE);
      martinGore.setDetails(new KewlSingerDetails(175, "depechemode.com"));

      currentSession.save(martinGore);

      currentSession.getTransaction().commit();
    }

    verifyAmount(1, 1);
  }

  private void bidirectionalTest() {
    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();

      final KewlSingerDetails kewlSingerDetails = (KewlSingerDetails) currentSession
          .createQuery("from KewlSingerDetails where height=175")
          .getSingleResult();

      currentSession.getTransaction().commit();

      Verify.verify(kewlSingerDetails != null);
      Verify.verify(kewlSingerDetails.getKewlSingerWithDetails() != null);
      Verify.verify(MARTIN_L_GORE.getLastName()
          .equals(kewlSingerDetails.getKewlSingerWithDetails().getLastName()));

      System.out.println("bidirectionalTest:");
      System.out.println(kewlSingerDetails.getKewlSingerWithDetails().toString());
    }
  }

  private void cascadeDelete() {
    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();

      final KewlSingerDetails kewlSingerDetails = (KewlSingerDetails) currentSession
          .createQuery("from KewlSingerDetails where height=175")
          .getSingleResult();

      // todo but before deleting we need to break bi-directional link, cause from details side
      // delete op is not cascaded
      kewlSingerDetails.getKewlSingerWithDetails().setDetails(null);
      currentSession.delete(kewlSingerDetails);

      currentSession.getTransaction().commit();
    }

    verifyAmount(1, 0);
  }

  private void verifyAmount(int singersAmount, int detailsAmount) {
    try (Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();
      // todo Select before count is a must!
      final Long singerAmountToVerify = (Long) currentSession
          .createQuery("select count(*) from KewlSingerWithDetails")
          .uniqueResult();
      final Long detailsAmountToVerify = (Long) currentSession
          .createQuery("select count(*) from KewlSingerDetails")
          .uniqueResult();
      currentSession.getTransaction().commit();
      Verify.verify(singerAmountToVerify != null && singerAmountToVerify == singersAmount);
      Verify.verify(detailsAmountToVerify != null && detailsAmountToVerify == detailsAmount);
    }
  }

}
