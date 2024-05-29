package shelter;

/**
 * The Shelter class manages the information about various animals in the shelter.
 * It includes methods to return information about each animal.
 */
public class Shelter {
  private final Bird bird;
  private final Bunny bunny;
  private final Cat cat;
  private final Dog dog;

  /**
   * Constructs a Shelter with the specified animals.
   *
   * @param dog   the dog in the shelter
   * @param cat   the cat in the shelter
   * @param bird  the bird in the shelter
   * @param bunny the bunny in the shelter
   */
  public Shelter(shelter.Dog dog, shelter.Cat cat, shelter.Bird bird, shelter.Bunny bunny) {
    this.bird = bird;
    this.bunny = bunny;
    this.cat = cat;
    this.dog = dog;
  }


  /**
   * Returns the information about the bird in the shelter.
   *
   * @return a string containing the bird's details
   */
  public String getBirdInfo() {
    String vaccinatedInfo;
    if (bird.isVaccinated()) {
      vaccinatedInfo = "vaccinated";
    } else {
      vaccinatedInfo = "not vaccinated";
    }
    return ("Bird: " + bird.getName() + ", " + bird.getAge() + " years old, " + vaccinatedInfo
        + ", " + bird.getSpecies());
  }

  /**
   * Returns the information about the bunny in the shelter.
   *
   * @return a string containing the bunny's details
   */
  public String getBunnyInfo() {
    String vaccinatedInfo;
    if (bunny.isVaccinated()) {
      vaccinatedInfo = "vaccinated";
    } else {
      vaccinatedInfo = "not vaccinated";
    }

    String domesticatedInfo;
    if (bunny.isDomesticated()) {
      domesticatedInfo = "domesticated";
    } else {
      domesticatedInfo = "not domesticated";
    }

    return ("Bunny: " + bunny.getName() + ", " + bunny.getAge() + " years old, " + vaccinatedInfo
        + ", " + domesticatedInfo);
  }

  /**
   * Returns the information about the cat in the shelter.
   *
   * @return a string containing the cat's details
   */
  public String getCatInfo() {
    String vaccinatedInfo;
    if (cat.isVaccinated()) {
      vaccinatedInfo = "vaccinated";
    } else {
      vaccinatedInfo = "not vaccinated";
    }
    return ("Cat: " + cat.getName() + ", " + cat.getAge() + " years old, " + vaccinatedInfo + ", "
        + cat.getColor());
  }

  /**
   * Returns the information about the dog in the shelter.
   *
   * @return a string containing the dog's details
   */
  public String getDogInfo() {
    String vaccinatedInfo;
    if (dog.isVaccinated()) {
      vaccinatedInfo = "vaccinated";
    } else {
      vaccinatedInfo = "not vaccinated";
    }
    return ("Dog: " + dog.getName() + ", " + dog.getAge() + " years old, " + vaccinatedInfo + ", "
        + dog.getBreed());
  }

  /**
   * Returns a summary of information about all the animals in the shelter.
   *
   * @return a string containing the details of all animals
   */
  public String getSummary() {
    return (getDogInfo() + "\n" + getCatInfo() + "\n" + getBirdInfo() + "\n" + getBunnyInfo());
  }
}