import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import shelter.Cat;

/**
 * Test class for the Cat class.
 */
public class CatTest {

  private Cat cat1;

  /**
   * Sets up the test fixture.
   * Called before every test case method.
   */
  @Before
  public void setUp() {
    cat1 = new Cat("Clair", 2, true, "Blue");
  }

  /**
   * Tests the getName method.
   */
  @Test
  public void getName() {
    assertEquals("Clair", cat1.getName());
  }

  /**
   * Tests the getAge method.
   */
  @Test
  public void getAge() {
    assertEquals(2, cat1.getAge());
  }

  /**
   * Tests the isVaccinated method.
   */
  @Test
  public void isVaccinated() {
    assertEquals(true, cat1.isVaccinated());
  }

  /**
   * Tests the getColor method.
   */
  @Test
  public void getColor() {
    assertEquals("Blue", cat1.getColor());
  }
}