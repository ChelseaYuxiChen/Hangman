package shelter;

/**
 * This class represents a dog with name, age, vaccinate status and breed.
 */
public class Dog {
  private final String name;
  private final int age;
  private final boolean vaccinated;
  private final String breed;

  /**
   * Construct a dog object with name, age, vaccinated status and breed.
   * @param name the name of bird
   * @param age the age of bird
   * @param vaccinated the vaccinate status of bird
   * @param breed the breed of bird
   */
  public Dog(String name, int age, boolean vaccinated, String breed) {
    this.name = name;
    this.age = age;
    this.vaccinated = vaccinated;
    this.breed = breed;



  }

  /**
   * Return the name of dog.
   * @return Return the name of dog
   */
  public String getName() {
    return name;
  }

  /**
   * Return the age of dog.
   * @return Return the age of dog
   */
  public int getAge() {
    return age;
  }

  /**
   * Return the vaccinate status of dog.
   * @return Return the vaccinate status of dog
   */
  public boolean isVaccinated() {
    return vaccinated;
  }

  /**
   * Return the breed of cat.
   * @return Return the breed of cat
   */
  public String getBreed() {
    return breed;
  }
}
