package iwtkm.season1.aspects;

import iwtkm.season1.parts.Engine;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EnhancedLoggingAspect {

  /**
   * JOINPOINT is a exact point of applying advice
   */
  @Before("allMethodsWithinEngine()")
  public void logEnhAllMethods(JoinPoint joinPoint) {
    // prints join point rule (e.g. here within(iwtkm...
    System.out.println("enh1 " + joinPoint.toString());

    // gets target object instance to which advice is applied
    Engine engine = (Engine) joinPoint.getTarget();
    System.out.println("enh2 " + engine.toString());
  }

  @Before("allMethodsWithinEngine() && args(name)")
  public void logEnhSetterVarName(String name) {
    System.out.println("enh3 " + name);
  }

  @Pointcut("within(iwtkm.season1.parts.Engine)")
  public void allMethodsWithinEngine() {
  }

  /**
   * Will run only if method is returned correctly, i.e. no exceptions, etc.
   */
  @AfterReturning("execution(* iwtkm.season1.parts.Engine.unstableMethod(..))")
  public void logEnhAfterSuccessfulReturning(JoinPoint joinPoint) {
    System.out.println("enh4 " + joinPoint.getTarget().toString());
  }

  /**
   * In contrast to logEnhAfterSuccessfulReturning method will fire only on exception
   */
  @AfterThrowing("execution(* iwtkm.season1.parts.Engine.unstableMethod(..))")
  public void legEnhAfterUnsuccessfulReturning(JoinPoint joinPoint) {
    System.out.println("enh4.5 PANIC " + joinPoint.getTarget().toString());
  }

  /**
   * Will run only if method is returned correctly, i.e. no exceptions, etc. Will print return
   * value.
   */
  @AfterReturning(
      pointcut = "execution(* iwtkm.season1.parts.Engine.unstableMethod(..))",
      returning = "returnInt")
  public void logEnhAfterSuccessfulReturningAndPrintReturn(JoinPoint joinPoint, int returnInt) {
    System.out.println("enh5 " + joinPoint.getTarget().toString() + " , return val " + returnInt);
  }

  /**
   * In contrast to logEnhAfterSuccessfulReturning method will fire only on exception Will log
   * exception details
   */
  @AfterThrowing(
      pointcut = "execution(* iwtkm.season1.parts.Engine.unstableMethod(..))",
      throwing = "e")
  public void legEnhAfterUnsuccessfulReturningAndPrintEx(JoinPoint joinPoint, Throwable e) {
    System.out.println("enh5.5 PANIC " + joinPoint.getTarget().toString() + " , ex: " + e);
  }

}
