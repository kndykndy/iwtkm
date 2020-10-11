package iwtkm.season1.service;

import iwtkm.season1.parts.AbstractPart;

public class PartsService {

  private AbstractPart engine;
  private AbstractPart motor;
  private AbstractPart steeringWheel;

  public AbstractPart getMotor() {
    return motor;
  }

  public void setMotor(AbstractPart motor) {
    this.motor = motor;
  }

  public AbstractPart getSteeringWheel() {
    return steeringWheel;
  }

  public void setSteeringWheel(AbstractPart steeringWheel) {
    this.steeringWheel = steeringWheel;
  }

  public AbstractPart getEngine() {
    return engine;
  }

  public void setEngine(AbstractPart engine) {
    this.engine = engine;
  }

}
