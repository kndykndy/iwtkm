package iwtkm.season1.iwtkm03.model.hibernatepractice._2onetoone;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import iwtkm.season1.iwtkm03.utilities.DateUtils;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "singers_with_details")
public class KewlSingerWithDetails implements Serializable {

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

  /**
   * todo We define ALL cascade type to cascade all operations with related entity, e.g.
   * merge, refresh, persist, etc.
   * By default, no ops are cascaded!
   */
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "details_id")
  private KewlSingerDetails kewlSingerDetails;

  /**
   * todo This constructor must exist for Hibernate to work correctly.
   */
  @SuppressWarnings("unused")
  public KewlSingerWithDetails() {
  }

  public KewlSingerWithDetails(String name, String lastName, Date dob) {
    this.name = name;
    this.lastName = lastName;
    this.dob = dob;
  }

  public KewlSingerWithDetails(KewlSingerWithDetails anotherKewlSingerWithDetails) {
    this.name = anotherKewlSingerWithDetails.name;
    this.lastName = anotherKewlSingerWithDetails.lastName;
    this.dob = anotherKewlSingerWithDetails.dob;
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

  public KewlSingerDetails getKewlSingerDetails() {
    return kewlSingerDetails;
  }

  public void setDetails(
      KewlSingerDetails kewlSingerDetails) {
    this.kewlSingerDetails = kewlSingerDetails;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("name", name)
        .add("lastName", lastName)
        .add("dob", DateUtils.formatDate(dob))
        .add("details", kewlSingerDetails)
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
    KewlSingerWithDetails that = (KewlSingerWithDetails) o;
    return Objects.equal(name, that.name) &&
        Objects.equal(lastName, that.lastName) &&
        Objects.equal(dob, that.dob);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name, lastName, dob);
  }

}
