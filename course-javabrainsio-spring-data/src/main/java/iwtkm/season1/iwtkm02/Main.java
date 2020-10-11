package iwtkm.season1.iwtkm02;

import iwtkm.season1.iwtkm02.dao.PartDao;
import iwtkm.season1.iwtkm02.model.impl.Engine;
import java.util.List;
import java.util.Random;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Setup Derby in e.g. c:\Users\Evgenii_Krapivin\Desktop\soft\Derby\db-derby-10.14.1.0-bin\
 * Start Derby in server mode, running bin\startNetworkServer(.bat), it will show port, e.g. 1527
 * Run client, bin\lj(.bat)
 * To connect type: connect 'jdbc:derby://localhost:1527/db;create=true';
 * Execute DML/DDL SQL statements
 * To exit type: exit;
 *
 * fast commands to create db:
 * create table parts (id int, name varchar(32));
 * insert into parts(id, name) values(0, 'Engine BMW 1');
 * update parts set name='Engine BMW 7' where id=0;
 * select * from parts;
 * select count(*) from parts;
 */
public class Main {

  private ApplicationContext context;
  private PartDao<Engine> engineDao;

  private Random random = new Random();

  private static final String DERBY_DISTR_LOCATION =
      "c:\\Users\\Evgenii_Krapivin\\Desktop\\soft\\Derby\\db-derby-10.14.1.0-bin\\";
  private static final String ROOT_APP_CTX =
      "iwtkm/season1/iwtkm02/spring/context.xml";

  public static void main(String[] args) {
    new Main().execute();
  }

  private void execute() {
    System.setProperty("DERBY_HOME", DERBY_DISTR_LOCATION);

    context = new ClassPathXmlApplicationContext(ROOT_APP_CTX);

    engineDao = (PartDao) context.getBean("engineJdbcDaoImpl");
    System.out.println("Engines count: " + engineDao.getCount());
    System.out.println("Get engine by id 0: " + engineDao.getName(0));
    System.out.println("Got whole engine entity: " + engineDao.getById(0));

    listAllEngines();

    int n = random.nextInt(1000);
    System.out.println("Creating new engine with id:" + n);
    engineDao.createNew(new Engine(n, "New Engine #" + n, n + 10));
    listAllEngines();
  }

  private void listAllEngines() {
    System.out.println();
    final List<Engine> allEngines = engineDao.getAll();
    System.out.println("Getting all engines (" + allEngines.size() + "): ");
    allEngines.forEach(System.out::println);
  }

}
