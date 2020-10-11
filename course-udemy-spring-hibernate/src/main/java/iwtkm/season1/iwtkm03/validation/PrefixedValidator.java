package iwtkm.season1.iwtkm03.validation;

import com.google.common.base.Strings;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PrefixedValidator implements ConstraintValidator<Prefixed, String> {

  private String prefix;

  @Override
  public void initialize(Prefixed constraintAnnotation) {
    this.prefix = constraintAnnotation.prefix();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return !Strings.isNullOrEmpty(prefix) && !Strings.isNullOrEmpty(value)
        && value.startsWith(prefix);
  }

}
