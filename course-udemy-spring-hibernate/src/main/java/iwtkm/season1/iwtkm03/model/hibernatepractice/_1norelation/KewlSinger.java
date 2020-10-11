package iwtkm.season1.iwtkm03.model.hibernatepractice._1norelation;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import iwtkm.season1.iwtkm03.utilities.DateUtils;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "singers")
public class KewlSinger implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;

  @Column(name = "n")
  private String name;

  @Column(name = "ln")
  private String lastName;

  @Column
  @Temporal(TemporalType.DATE)
  private Date dob;

  @Column(name = "web")
  private String officialWeb;

  /**
   * todo This constructor must exist for Hibernate to work correctly.
   */
  @SuppressWarnings("unused")
  public KewlSinger() {
  }

  public KewlSinger(String name, String lastName, Date dob, String officialWeb) {
    this.name = name;
    this.lastName = lastName;
    this.dob = dob;
    this.officialWeb = officialWeb;
  }

  public KewlSinger(KewlSinger anotherKewlSinger) {
    this.name = anotherKewlSinger.name;
    this.lastName = anotherKewlSinger.lastName;
    this.dob = anotherKewlSinger.dob;
    this.officialWeb = anotherKewlSinger.officialWeb;
  }

  public int getId() {
    return id;
  }

  /**
   * todo This setter is used by Hibernate.
   */
  @SuppressWarnings("unused")
  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getOfficialWeb() {
    return officialWeb;
  }

  public void setOfficialWeb(String officialWeb) {
    this.officialWeb = officialWeb;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("name", name)
        .add("lastName", lastName)
        .add("dob", DateUtils.formatDate(dob))
        .add("officialWeb", officialWeb)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KewlSinger that = (KewlSinger) o;
    return Objects.equal(name, that.name) &&
        Objects.equal(lastName, that.lastName) &&
        Objects.equal(dob, that.dob) &&
        Objects.equal(officialWeb, that.officialWeb);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name, lastName, dob, officialWeb);
  }

}
