import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import shelter.Dog;

/**
 * Test class for the Dog class.
 */
public class DogTest {
  private Dog dog1;

  /**
   * Sets up the test fixture.
   * Called before every test case method.
   */
  @Before
  public void setUp() {
    dog1 = new Dog("Clair", 2, true, "border collie");
  }

  /**
   * Tests the getName method.
   */
  @Test
  public void testGetName() {
    assertEquals("Clair", dog1.getName());
  }

  /**
   * Tests the getAge method.
   */
  @Test
  public void testGetAge() {
    assertEquals(2, dog1.getAge());
  }

  /**
   * Tests the isVaccinated method.
   */
  @Test
  public void testIsVaccinated() {
    assertEquals(true, dog1.isVaccinated());
  }

  /**
   * Tests the getBreed method.
   */
  @Test
  public void testGetBreed() {
    assertEquals("border collie", dog1.getBreed());
  }
}