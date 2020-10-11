package iwtkm.season1.iwtkm02.model.impl;

import iwtkm.season1.iwtkm02.model.AbstractPart;

public class Engine extends AbstractPart {

  private int horsePowers;

  public Engine(int id, String name, int horsePowers) {
    super(id, name);

    this.horsePowers = horsePowers;
  }

}
