import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import shelter.Bird;

/**
 * Test class for the Bird class.
 */
public class BirdTest {

  private Bird bird1;

  /**
   * Sets up the test fixture.
   * Called before every test case method.
   */
  @Before
  public void setUp() {
    bird1 = new Bird("Jay", 1, true, "Spe1");
  }

  /**
   * Tests the getName method.
   */
  @Test
  public void testGetName() {
    assertEquals("Jay", bird1.getName());
  }

  /**
   * Tests the getAge method.
   */
  @Test
  public void testGetAge() {
    assertEquals(1, bird1.getAge());
  }

  /**
   * Tests the isVaccinated method.
   */
  @Test
  public void testIsVaccinated() {
    assertEquals(true, bird1.isVaccinated());
  }

  /**
   * Tests the getSpecies method.
   */
  @Test
  public void testGetSpecies() {
    assertEquals("Spe1", bird1.getSpecies());
  }
}