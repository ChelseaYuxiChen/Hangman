import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import shelter.Bunny;

/**
 * Test class for the Bunny class.
 */
public class BunnyTest {
  private Bunny bunny;

  /**
   * Sets up the test fixture.
   * Called before every test case method.
   */
  @Before
  public void setUp() {
    bunny = new Bunny("Cam", 1, true, false);
  }

  /**
   * Tests the getName method.
   */
  @Test
  public void testGetName() {
    assertEquals("Cam", bunny.getName());
  }

  /**
   * Tests the getAge method.
   */
  @Test
  public void testGetAge() {
    assertEquals(1, bunny.getAge());
  }

  /**
   * Tests the isVaccinated method.
   */
  @Test
  public void testIsVaccinated() {
    assertEquals(true, bunny.isVaccinated());
  }

  /**
   * Tests the isDomesticated method.
   */
  @Test
  public void testIsDomesticated() {
    assertEquals(false, bunny.isDomesticated());
  }
}