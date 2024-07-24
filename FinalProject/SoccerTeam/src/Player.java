import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a player in a soccer team.
 * A player has a last name, a first name, a birthdate, a preferred position and a skill level.
 */
public class Player {
  private String lastName;
  private String firstName;
  private LocalDate birthdate;
  private Position preferredPosition;
  private int skillLevel;
  private Integer jerseyNumber;
  private Position assignedPosition;
  private String id;

/**
   * Creates a player with the given last name, first name, birthdate, preferred position and skill
   * level.
   *
   * @param lastName the last name of the player
   * @param firstName the first name of the player
   * @param birthdate the birthdate of the player
   * @param preferredPosition the preferred position of the player
   * @param skillLevel the skill level of the player
   */
  public Player(String lastName, String firstName, LocalDate birthdate, Position preferredPosition,
                int skillLevel) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.birthdate = birthdate;
    this.preferredPosition = preferredPosition;
    this.skillLevel = skillLevel;
    this.id = UUID.randomUUID().toString();
  }


  /**
   * Returns the last name of the player.
   *
   * @return the last name of the player
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the last name of the player.
   *
   * @param lastName the last name of the player
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Returns the first name of the player.
   *
   * @return the first name of the player
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the first name of the player.
   *
   * @param firstName the first name of the player
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Returns the birthdate of the player.
   *
   * @return the birthdate of the player
   */
  public LocalDate getBirthdate() {
    return birthdate;
  }

  /**
   * Sets the birthdate of the player.
   *
   * @param birthdate the birthdate of the player
   */
  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }



  /**
   * Returns the skill level of the player.
   *
   * @return the skill level of the player
   */
  public int getSkillLevel() {
    return skillLevel;
  }

  /**
   * Sets the skill level of the player.
   *
   * @param skillLevel the skill level of the player
   */
  public void setSkillLevel(int skillLevel) {
    this.skillLevel = skillLevel;
  }

  public Integer getJerseyNumber() {
    return jerseyNumber;
  }

  public void setJerseyNumber(Integer jerseyNumber) {
    this.jerseyNumber = jerseyNumber;
  }

  /**
   * Returns a string representation of the player.
   *
   * @return a string representation of the player
   */
  @Override
  public String toString() {
    return "Player{" +
        "lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", birthdate=" + birthdate +
        ", preferredPosition=" + preferredPosition +
        ", skillLevel=" + skillLevel +
        '}';
  }

  /**
   * Returns the preferred position of the player.
   *
   * @return the preferred position of the player
   */
  public Position getPreferredPosition() {
    return preferredPosition;
  }

  public void setPreferredPosition(Position preferredPosition) {
    this.preferredPosition = preferredPosition;
  }

  public Position getAssignedPosition() {
    return assignedPosition;
  }

  public void setAssignedPosition(Position assignedPosition) {
    this.assignedPosition = assignedPosition;
  }

  public String getId() {
    return id;
  }
}
