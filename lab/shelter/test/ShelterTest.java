import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import shelter.Bird;
import shelter.Bunny;
import shelter.Cat;
import shelter.Dog;
import shelter.Shelter;

/**
 * Test class for the Shelter class.
 */
public class ShelterTest {

  private Shelter shelter1;
  private Dog dog1;
  private Cat cat1;
  private Bunny bunny1;
  private Bird bird1;

  /**
   * Sets up the test fixture.
   * Called before every test case method.
   */
  @Before
  public void setUp() {
    dog1 = new Dog("Clair", 2, false, "border collie");
    bird1 = new Bird("Jay", 1, false, "Spe1");
    bunny1 = new Bunny("Cam", 1, false, false);
    cat1 = new Cat("Clair", 2, false, "Blue");
    shelter1 = new Shelter(dog1, cat1, bird1, bunny1);
  }

  /**
   * Tests the getBirdInfo method.
   */
  @Test
  public void getBirdInfo() {
    assertEquals("Bird: Jay, 1 years old, not vaccinated, Spe1", shelter1.getBirdInfo());
  }

  /**
   * Tests the getBunnyInfo method.
   */
  @Test
  public void getBunnyInfo() {
    assertEquals("Bunny: Cam, 1 years old, not vaccinated, not domesticated",
        shelter1.getBunnyInfo());
  }

  /**
   * Tests the getCatInfo method.
   */
  @Test
  public void getCatInfo() {
    assertEquals("Cat: Clair, 2 years old, not vaccinated, Blue", shelter1.getCatInfo());
  }

  /**
   * Tests the getDogInfo method.
   */
  @Test
  public void getDogInfo() {
    assertEquals("Dog: Clair, 2 years old, not vaccinated, border collie", shelter1.getDogInfo());
  }

  /**
   * Tests the getSummary method.
   */
  @Test
  public void getSummary() {
    assertEquals("Dog: Clair, 2 years old, not vaccinated, border collie" + "\n"
        + "Cat: Clair, 2 years old, not vaccinated, Blue" + "\n"
        + "Bird: Jay, 1 years old, not vaccinated, Spe1" + "\n"
        + "Bunny: Cam, 1 years old, not vaccinated, not domesticated", shelter1.getSummary());
  }
}