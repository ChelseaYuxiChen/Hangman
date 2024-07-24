package nocomposition;

/**
 * Pet class that handles everything related to the pet without using composition.
 */
class Pet {

  /**
   * Feeds the pet.
   */
  void feed() {
    System.out.println("Feeding the pet.");
  }

  /**
   * Cleans the pet's habitat.
   */
  void cleanHabitat() {
    System.out.println("Cleaning the habitat.");
  }

  /**
   * Performs a health checkup on the pet.
   */
  void performHealthCheckup() {
    System.out.println("Performing a health checkup.");
  }

  /**
   * Care for pet by feeding it, cleaning its habitat, and checking up its health.
   */
  void careForPet() {
    feed(); // Directly handling feeding
    cleanHabitat(); // Directly handling habitat cleaning
    performHealthCheckup(); // Directly handling health checkups
    System.out.println("Pet care tasks are completed.");
  }
}

