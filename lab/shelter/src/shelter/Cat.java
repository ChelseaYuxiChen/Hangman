package shelter;

/**
 * This class represents a cat with name, age, vaccinate status and color.
 */
public class Cat {
  private final String name;
  private final int age;
  private final boolean vaccinated;
  private final String color;

  /**
   * Construct a cat object with name, age, vaccinate status and color.
   * @param name the name of cat
   * @param age the age of cat
   * @param vaccinated the vaccinate status of cat
   * @param color the color of cat
   */
  public Cat(String name, int age, boolean vaccinated, String color) {
    this.name = name;
    this.age = age;
    this.vaccinated = vaccinated;
    this.color = color;
  }

  /**
   * Return the name of cat.
   * @return Return the name of cat
   */
  public String getName() {
    return name;
  }

  /**
   * Return the age of cat.
   * @return Return the age of cat
   */
  public int getAge() {
    return age;
  }

  /**
   * Return the vaccinate status of cat.
   * @return Return the vaccinate status of cat
   */
  public boolean isVaccinated() {
    return vaccinated;
  }

  /**
   * Return the color of cat.
   * @return Return the color of cat
   */
  public String getColor() {
    return color;
  }
}
