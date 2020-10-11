package iwtkm.season1.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AroundLoggingAspect {

  @Around("execution(* iwtkm.season1.parts.WindShield.oneSingleMethod())")
  public Object logWindShieldAround(ProceedingJoinPoint proceedingJoinPoint) {
    Object result = null;

    try {
      System.out.println("around 6 Before");
      result = proceedingJoinPoint.proceed();
      System.out.println("around 6 After, result: " + result);
    } catch (Throwable throwable) {
      System.out.println("around 6 AfterThrowing");
    }

    System.out.println("around 6 AfterReturning");

    return result;
  }

  /**
   * Mind @ before the annotation keyword. This code is doubled in xml-style in context.
   */
//  @Around("@annotation(Loggable)")
  public Object logWindShieldSecondSingleMethodAround(ProceedingJoinPoint proceedingJoinPoint) {
    Object result = null;

    try {
      System.out.println("around 7 Before");
      result = proceedingJoinPoint.proceed();
      System.out.println("around 7 After, result: " + result);
    } catch (Throwable throwable) {
      System.out.println("around 7 AfterThrowing");
    }

    System.out.println("around 7 AfterReturning");

    return result;
  }

}
