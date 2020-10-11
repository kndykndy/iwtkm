package iwtkm.season1.iwtkm03.model;

import com.google.common.base.Joiner;
import iwtkm.season1.iwtkm03.validation.Prefixed;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AwesomeHuman {

  public enum AwesomenessLevel {
    JUST_GREAT("Just great"),
    EXTRA_SMOOTH("Extra smooth"),
    SUPER_AWESOME("Super awesome");

    private String displayName;
    private String name;

    public static Map<String, String> getValuesMap() {
      return new LinkedHashMap<String, String>() {{
        for (AwesomenessLevel awesomenessLevel : AwesomenessLevel.values()) {
          put(awesomenessLevel.getName(), awesomenessLevel.getDisplayName());
        }
      }};
    }

    public static AwesomenessLevel getByValue(String value) {
      for (AwesomenessLevel awesomenessLevel : values()) {
        if (awesomenessLevel.name.equalsIgnoreCase(value)) {
          return awesomenessLevel;
        }
      }

      return null;
    }

    AwesomenessLevel(String displayName) {
      this.displayName = displayName;
      this.name = name();
    }

    public String getDisplayName() {
      return displayName;
    }

    public String getName() {
      return name;
    }

  }

  public enum KewlnessItem {
    MEGA_KEWL("Mega kewl"),
    COLOSSAL_KEWL("Colossal kewl");

    private final String displayName;
    private final String name;

    public static Map<String, String> getValuesMap() {
      return new LinkedHashMap<String, String>() {{
        for (KewlnessItem kewlnessItem : KewlnessItem.values()) {
          put(kewlnessItem.getName(), kewlnessItem.getDisplayName());
        }
      }};
    }

    public static KewlnessItem getByValue(String value) {
      for (KewlnessItem kewlnessItem : values()) {
        if (kewlnessItem.name.equalsIgnoreCase(value)) {
          return kewlnessItem;
        }
      }

      return null;
    }

    KewlnessItem(String displayName) {
      this.displayName = displayName;
      this.name = name();
    }


    public String getDisplayName() {
      return displayName;
    }

    public String getName() {
      return name;
    }

  }

  private String firstName;

  @NotNull(message = "hey, it's required!") // todo thus field is required
  @Size(min = 2, message = "wow, it must be at least 2 letters")
  private String lastName;

  private String primarySkill;

  private AwesomenessLevel awesomenessLevel;

  private Set<KewlnessItem> kewlnessItems;

  /**
   * todo
   * This field must be of a wrapper type, and not the primitive one, cause in that way we'll get
   * strange conversion exceptions.
   */
  @NotNull(message = "hey, it's required!")
  @Min(value = 100, message = "u must be kidding, u worth 100 minimum amazingness points!")
  @Max(value = 100500, message = "well, u'r amazing, but there's a top of 100500 points")
  private Integer amazingnessPoints;

  /**
   * todo
   * This field use3s custom validation
   */
  @NotNull(message = "hey, it's required!")
  @Pattern(regexp = "^[a-zA-Z0-9]{6}", message = "wow, ur incredibleness code should contain six chars or digits")
  @Prefixed(prefix = "AWE", message = "hey, ur code must start with AWE prefix")
  private String incrediblenessCode;

  public static Map<String, String> getSkillsMap() {
    return new LinkedHashMap<String, String>() {{
      put("Java", "Java");
      put("Scala", "Scala");
      put("BigData", "BigData");
    }};
  }

  public AwesomeHuman() {
  }

  /**
   * Used at posting form results.
   */
  @SuppressWarnings("unused")
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Used at form displaying and templates.
   */
  @SuppressWarnings("unused")
  public String getFirstName() {
    return firstName;
  }

  /**
   * Used at posting form results.
   */
  @SuppressWarnings("unused")
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Used at form displaying and templates.
   */
  @SuppressWarnings("unused")
  public String getLastName() {
    return lastName;
  }

  /**
   * Used at posting form results.
   */
  @SuppressWarnings("unused")
  public void setPrimarySkill(String primarySkill) {
    this.primarySkill = primarySkill;
  }

  /**
   * Used at form displaying and templates.
   */
  @SuppressWarnings("unused")
  public String getPrimarySkill() {
    return primarySkill;
  }

  /**
   * Used at form displaying and templates.
   */
  @SuppressWarnings("unused")
  public String getAwesomenessLevel() {
    return awesomenessLevel != null ? awesomenessLevel.getDisplayName() : null;
  }

  /**
   * Used at posting form results.
   */
  @SuppressWarnings("unused")
  public void setAwesomenessLevel(String awesomenessLevel) {
    this.awesomenessLevel = AwesomenessLevel.getByValue(awesomenessLevel);
  }

  /**
   * Used at form displaying and templates.
   */
  @SuppressWarnings("unused")
  public Set<KewlnessItem> getKewlnessItems() {
    return kewlnessItems;
  }

  /**
   * Used at posting form results.
   */
  @SuppressWarnings("unused")
  public void setKewlnessItems(Set<String> kewlnessItems) {
    if (kewlnessItems != null && !kewlnessItems.isEmpty()) {
      this.kewlnessItems = new TreeSet<KewlnessItem>() {{
        for (String kewlnessItem : kewlnessItems) {
          add(KewlnessItem.getByValue(kewlnessItem));
        }
      }};
    }
  }

  /**
   * Used at form displaying and templates.
   */
  @SuppressWarnings("unused")
  public Integer getAmazingnessPoints() {
    return amazingnessPoints;
  }

  /**
   * Used at posting form results.
   */
  @SuppressWarnings("unused")
  public void setAmazingnessPoints(Integer amazingnessPoints) {
    this.amazingnessPoints = amazingnessPoints;
  }

  /**
   * Used at form displaying and templates.
   */
  @SuppressWarnings("unused")
  public String getIncrediblenessCode() {
    return incrediblenessCode;
  }

  /**
   * Used at posting form results.
   */
  @SuppressWarnings("unused")
  public void setIncrediblenessCode(String incrediblenessCode) {
    this.incrediblenessCode = incrediblenessCode;
  }

  @Override
  public String toString() {
    return "AwesomeHuman{'" + firstName + "','" + lastName + "\'"
        + ",skill:" + primarySkill
        + "," + (awesomenessLevel != null ? awesomenessLevel.getDisplayName() : "-")
        + ",kewlness:[" + Joiner.on(',').skipNulls()
        .join(kewlnessItems != null ? kewlnessItems : Collections.EMPTY_SET) + "]"
        + "," + (amazingnessPoints != null ? amazingnessPoints : "-")
        + "}";
  }

}
