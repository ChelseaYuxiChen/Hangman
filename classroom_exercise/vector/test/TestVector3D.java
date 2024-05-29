import static org.junit.Assert.assertEquals;

import vector.Vector3D;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the Vector.Vector3D class.
 * This class contains tests to verify the functionality of the Vector.Vector3D class.
 */
public class TestVector3D {

  private Vector3D vectorTest;

  /**
   * Sets up the test environment by creating a new Vector.Vector3D object
   * with components (10, 20, 30).
   */
  @Before
  public void setUp() {
    vectorTest = new Vector3D(10, 20, 30);
  }

  /**
   * Tests the getVectorX() method.
   */
  @Test
  public void getVectorX() {
    assertEquals(10.0, vectorTest.getX(), 0.0);
  }

  /**
   * Tests the getVectorY() method.
   */
  @Test
  public void getVectorY() {
    assertEquals(20.0, vectorTest.getY(), 0.0);
  }

  /**
   * Tests the getVectorZ() method.
   */
  @Test
  public void getVectorZ() {
    assertEquals(30, vectorTest.getZ(), 0.0);
  }

  /**
   * Tests the testToString() method.
   */
  @Test
  public void testToString() {
    assertEquals("(10.00, 20.00, 30.00)", vectorTest.toString());
  }

  /**
   * Tests the getMagnitude() method.
   */
  @Test
  public void getMagnitude() {
    assertEquals(37.416573867739416, vectorTest.getMagnitude(), 0.0);
  }

  /**
   * Tests the normalize() method.
   */
  @Test
  public void normalize() {
    assertEquals(new Vector3D(0.2672612419124244, 0.5345224838248488, 0.8017837257372731),
        vectorTest.normalize());
  }
}