package shelter;

/**
 * The Main class serves as the entry point for the program. It initializes various animal objects,
 * creates a Shelter object with those animals, and prints information about each animal.
 */
public class Main {

  /**
   * Main entry point for the program.
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    Dog dog = new Dog("Fido", 4, true, "Golden Retriever");
    Cat cat = new Cat("Fluffy", 5, true, "brown");
    Bird bird = new Bird("Polly", 2, false, "Parrot");
    Bunny bunny = new Bunny("Bugs", 3, false, false);
    Shelter shelter = new Shelter(dog, cat, bird, bunny);

    // Printing Dog information
    System.out.println("Dog information:");
    System.out.println(shelter.getDogInfo());

    // Printing Cat information
    System.out.println("\nCat information:");
    System.out.println(shelter.getCatInfo());

    // Printing Bird information
    System.out.println("\nBird information:");
    System.out.println(shelter.getBirdInfo());

    // Printing Bunny information
    System.out.println("\nBunny information:");
    System.out.println(shelter.getBunnyInfo());

    // Printing summary of all animals
    System.out.println("\n---\n");
    System.out.println("Summary of all animals:");
    System.out.println(shelter.getSummary());
  }
}