package iwtkm.season1.parts;

import iwtkm.season1.aspects.Loggable;

public class WindShield extends AbstractPart {

  public String oneSingleMethod() {
    System.out.println("iwtkm.season1.parts.WindShield: oneSingleMethod");

    return "LOL";
  }

  @Loggable
  public String secondSingleMethod() {
    System.out.println("iwtkm.season1.parts.WindShield: secondSingleMethod");

    return "LOL2";
  }

}
