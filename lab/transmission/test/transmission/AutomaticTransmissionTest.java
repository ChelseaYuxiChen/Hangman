package transmission;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for AutomaticTransmission.
 * Created by Chelsea on 2024-05-29
 */
public class AutomaticTransmissionTest {
  private AutomaticTransmission automaticTransmissionTestt;

  /**
   * Sets up the test environment by initializing an AutomaticTransmission object.
   *
   * @throws Exception if there is any error during setup
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    automaticTransmissionTestt = new AutomaticTransmission(20, 40, 60, 80, 100);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new AutomaticTransmission(-10, 40, 60, 80, 100);
    });
    assertEquals("Threshold should be greater than 0 and in increasing order. \n",
        exception.getMessage());

    Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
      new AutomaticTransmission(80, 40, 60, 10, 100);
    });
    assertEquals("Threshold should be greater than 0 and in increasing order. \n",
        exception.getMessage());
  }

  /**
   * Tests the increaseSpeed method.
   * Verifies that the speed and gear values are correctly updated when speed is increased.
   */
  @Test
  public void increaseSpeed() {
    automaticTransmissionTestt.increaseSpeed();
    assertEquals(1, automaticTransmissionTestt.getSpeed());
    assertEquals(1, automaticTransmissionTestt.getGear());

    for (int i = 1; i <= 55; i++) {
      automaticTransmissionTestt.increaseSpeed();
    }
    assertEquals(56, automaticTransmissionTestt.getSpeed());
    assertEquals(3, automaticTransmissionTestt.getGear());
  }

  /**
   * Tests the decreaseSpeed method.
   * Verifies that the speed and gear values are correctly updated when speed is decreased.
   * Also tests that an exception is thrown when trying to decrease speed below 0.
   */
  @Test
  public void decreaseSpeed() throws IllegalStateException {
    for (int i = 1; i <= 55; i++) {
      automaticTransmissionTestt.increaseSpeed();
    }

    for (int i = 1; i <= 55; i++) {
      automaticTransmissionTestt.decreaseSpeed();
    }
    assertEquals(0, automaticTransmissionTestt.getSpeed());
    assertEquals(0, automaticTransmissionTestt.getGear());


    Exception exception = assertThrows(IllegalStateException.class, () -> {
      automaticTransmissionTestt.decreaseSpeed();
    });
    assertEquals("Speed can not be negative. \n", exception.getMessage());
  }

  /**
   * Tests the getSpeed method.
   */
  @Test
  public void getSpeed() {
    assertEquals(0, automaticTransmissionTestt.getSpeed());
    automaticTransmissionTestt.increaseSpeed();
    assertEquals(1, automaticTransmissionTestt.getSpeed());
  }

  /**
   * Tests the getGear method.
   */
  @Test
  public void getGear() {
    assertEquals(0, automaticTransmissionTestt.getGear());
    automaticTransmissionTestt.increaseSpeed();
    assertEquals(1, automaticTransmissionTestt.getGear());
  }

  /**
   * Tests the ToString method.
   */
  @Test
  public void testToString() {
    assertEquals("Transmission(speed = 0, gear = 0)", automaticTransmissionTestt.toString());
  }
}