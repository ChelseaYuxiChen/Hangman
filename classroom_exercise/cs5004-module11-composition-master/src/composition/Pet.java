package composition;

/**
 * Pet class that composes Diet, Habitat, and Health.
 */
class Pet {
  private final Diet diet;
  private final Habitat habitat;
  private final Health health;

  /**
   * Constructor.
   */
  public Pet() {
    diet = new Diet();
    habitat = new Habitat();
    health = new Health();
  }

  /**
   * Care for pet by feeding it, cleaning its habitat, and checking up its health.
   */
  void careForPet() {
    diet.feed(); // Reusing Diet functionality
    habitat.clean(); // Reusing Habitat functionality
    health.checkup(); // Reusing Health functionality
    System.out.println("Pet care tasks are completed.");
  }
}

