package shelter;

/**
 * This class represents a bunny with name, age, vaccinate status and domesticate status.
 */
public class Bunny {
  private final String name;
  private final int age;
  private final boolean vaccinated;
  private final Boolean domesticated;

  /**
   * Construct a bunny object with name, age, vaccinated status and domesticate status.
   * @param name the name of bird
   * @param age the age of bird
   * @param vaccinated the vaccinate status of bird
   * @param domesticated the domesticate status of bird
   */
  public Bunny(String name, int age, boolean vaccinated, boolean domesticated) {
    this.name = name;
    this.age = age;
    this.vaccinated = vaccinated;
    this.domesticated = domesticated;
  }

  /**
   * Return the name of bunny.
   * @return Return the name of bunny
   */
  public String getName() {
    return name;
  }

  /**
   * Return the age of bunny.
   * @return Return the age of bunny
   */
  public int getAge() {
    return age;
  }

  /**
   * Return the vaccinate status of bunny.
   * @return Return the vaccinate status of bunny
   */
  public boolean isVaccinated() {
    return vaccinated;
  }

  /**
   * Return the domesticate status of bunny.
   * @return Return the domesticate status of bunny
   */
  public Boolean isDomesticated() {
    return domesticated;
  }
}
