package iwtkm.season1.iwtkm03.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PrefixedValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Prefixed {

  String prefix() default "BZZ";

  String message() default "must be prefixed";

  // javax.validation methods

  // todo Using this you may group related constraints
  Class<?>[] groups() default {};

  // todo Using this you're provided with detailed information about validation filure (code, severity, et.c)
  Class<? extends Payload>[] payload() default {};

}
