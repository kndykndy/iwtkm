package iwtkm.season1.iwtkm02.model;

public abstract class AbstractPart {

  protected int id;
  protected String name;

  public AbstractPart(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{"
        + "id:" + id
        + ", name:'" + name + '\'' + '}';
  }

}
