package iwtkm.season1.iwtkm03.model.hibernatepractice._2onetoone;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "singers_details")
public class KewlSingerDetails implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;

  @Column
  private int height;

  @Column(name = "web")
  private String officialWeb;

  /**
   * This is reverse relation in the bi-directional one-to-one mapping.
   * Here, mappedBy is a property within the class, that is referring to this one. It tell Hibernate
   * to look at JoinColumn annotation of that field.
   * Note cascading all actions besides DELETE operation.
   */
  @OneToOne(mappedBy = "kewlSingerDetails",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private KewlSingerWithDetails kewlSingerWithDetails;

  /**
   * todo
   * This constructor must exist for Hibernate to work correctly.
   */
  public KewlSingerDetails() {
  }

  public KewlSingerDetails(int height, String officialWeb) {
    this.height = height;
    this.officialWeb = officialWeb;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getOfficialWeb() {
    return officialWeb;
  }

  public void setOfficialWeb(String officialWeb) {
    this.officialWeb = officialWeb;
  }

  public KewlSingerWithDetails getKewlSingerWithDetails() {
    return kewlSingerWithDetails;
  }

  public void setKewlSingerWithDetails(
      KewlSingerWithDetails kewlSingerWithDetails) {
    this.kewlSingerWithDetails = kewlSingerWithDetails;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("height", height)
        .add("officialWeb", officialWeb)
        .toString();
  }

}
