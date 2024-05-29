package shelter;

/**
 * This class represents a bird with name, age, vaccinate status and species.
 */
public class Bird {
  private final String name;
  private final int age;
  private final boolean vaccinated;
  private final String species;

  /**
   * Construct a bird object with name, age, vaccinated status and species.
   * @param name the name of bird
   * @param age the age of bird
   * @param vaccinated the vaccinated status of bird
   * @param species the species of bird
   */
  public Bird(String name, int age, boolean vaccinated, String species) {
    this.name = name;
    this.age = age;
    this.vaccinated = vaccinated;
    this.species = species;
  }

  /**
   * Return the name of bird.
   * @return Return the name of bird
   */
  public String getName() {
    return name;
  }

  /**
   * Return the age of bird.
   * @return Return the age of bird
   */
  public int getAge() {
    return age;
  }

  /**
   * Return the vaccinated status of bird.
   * @return Return the vaccinated status of bird
   */
  public boolean isVaccinated() {
    return vaccinated;
  }

  /**
   * Return the species of bird.
   * @return Return the species of bird
   */
  public String getSpecies() {
    return species;
  }
}
