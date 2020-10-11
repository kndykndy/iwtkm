package iwtkm.season1.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ASPECT is what are we hacking
 */
@Aspect
public class LoggingAspect {

  /**
   * ADVICE is a piece of code that's applied; all methods here are advices;
   *
   * POINTCUT is a point at which an advice is applied; here, all text within @Before and similar
   * annotations;
   */
  @Before("execution(public String getName())")
  public void logExecutionBeforeAnyParticularMethod() {
    System.out.println("1 Logging before execution of public String getName()");
  }

  /**
   * Works only if class explicitly contains/overrides it, does not work for inherited methods.
   */
  @Before("execution(public String iwtkm.season1.parts.Motor.getName())")
  public void logExecutionBeforeSpecificClassMethod() {
    System.out.println("2 Logging before execution of "
        + "public String iwtkm.season1.parts.Motor.getName()");
  }

  /**
   * (..) means ZERO-or-MORE arguments; it it were (*) AOP would search for ONE-or-MORE
   *
   * we may define wildcards even in partial packages, e.g. * iwtkm.season1.parts.*.get*(..)
   */
  @Before("execution(* get*(..))")
  public void logExecutionBeforeSpecificClassMethodWithWildcard() {
    System.out.println("3 Logging before execution of * get*(..)");
  }

  @Pointcut("execution(* set*(..))")
  public void allSetters() {
  }

  @Pointcut("execution(* do*(..))")
  public void allDoMethods() {
  }

  @Before("allSetters()")
  public void logBeforeAnySetterWithWildcard() {
    System.out.println("4 Logging before execution of external pointcut");
  }

  /**
   * Is not applicable to static methods.
   */
  @After("within(iwtkm.season1.parts.BackMirror)")
  public void logAllMethodsWithinSpecificClass() {
    System.out.println("5 Logging after all methods within class iwtkm.season1.parts.BackMirror");
  }

  /**
   * Pointcuts could be joined via &&.
   */
  @After("within(iwtkm.season1.parts.BackMirror) && allDoMethods()")
  public void logAfterComplexWithinAllMethodsAndAllSetters() {
    System.out.println("6 Logging after complex advice: "
        + "within all methods of iwtkm.season1.parts.BackMirror "
        + "and do* methods");
  }

}
