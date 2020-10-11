package iwtkm.season1.parts;

public class Engine extends AbstractPart {

  private boolean isRunning;

  public String getState() {
    return "Engine is " + (isRunning ? "running" : "not running");
  }

  public void setIsRunning() {
    isRunning = true;
  }

  @Override
  public String toString() {
    return "Engine{" + hashCode() + "," + getState() + '}';
  }

  /**
   * This methods is overridden to get caught by aspect.
   */
  @Override
  public void setName(String name) {
    super.setName(name);
  }

  public int unstableMethod() {
    if (isRunning) {
      throw new RuntimeException();
    }
    return -12345;
  }

}
