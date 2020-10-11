package iwtkm.season1;

import iwtkm.season1.parts.AbstractPart;
import iwtkm.season1.parts.BackMirror;
import iwtkm.season1.parts.Engine;
import iwtkm.season1.parts.WindShield;
import iwtkm.season1.service.PartsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    /*
      To reach this xml:
      go to project settings - Modules - choose module - Dependencies tab
      add new Jars or directories folder (right containing this xml!) as a Sources
     */
    final ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//    final PartsService partsService = (PartsService) context.getBean("partsService");
    final PartsService partsService = context.getBean("partsService", PartsService.class);
    System.out.println(partsService.getMotor().getName());
    System.out.println(partsService.getSteeringWheel().getName());

    partsService.getMotor().setName("der motorr");
    partsService.getSteeringWheel().setName("die steerung wheelung");

    BackMirror.doSmth2Static();
    final BackMirror backMirror = (BackMirror) context.getBean("backMirror");
    backMirror.doSmth1();
    backMirror.setBgg();

    AbstractPart engine = partsService.getEngine();
    System.out.println(((Engine) engine).getState());
//    ((Engine) engine).setIsRunning();
    engine.setName("BMW namung");
    ((Engine) engine).unstableMethod();

    WindShield windShield = (WindShield) context.getBean("windShield");
    windShield.oneSingleMethod();
    windShield.secondSingleMethod();
  }

}
