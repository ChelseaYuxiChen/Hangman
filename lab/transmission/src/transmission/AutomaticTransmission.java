package transmission;

import java.sql.SQLOutput;

/**
 * Created by Chelsea on 2024-05-29.
 * Transmissions are represented by the speed a car is traveling and the gear
 * that the car is in when it is traveling that speed.
 */
public class AutomaticTransmission implements Transmission {
  private int speed;
  private int gear;
  private int[] thresholds;

  /**
   * Constructor for the AutomaticTransmission class.
   *
   * @param threshold1 threshold for the first speed level
   * @param threshold2 threshold for the second speed level
   * @param threshold3 threshold for the third speed level
   * @param threshold4 threshold for the forth speed level
   * @param threshold5 threshold for the fifth speed level
   * @throws IllegalArgumentException throw the IllegalArgumentException when
   *                                  threshold smaller than 0 or not in increasing order.
   */
  public AutomaticTransmission(int threshold1, int threshold2, int threshold3, int threshold4,
                               int threshold5) throws IllegalArgumentException {
    if (threshold1 <= 0 || threshold2 <= threshold1 || threshold3 <= threshold2
        || threshold4 <= threshold3 || threshold5 <= threshold4) {
      throw new IllegalArgumentException(
          "Threshold should be greater than 0 and in increasing order. \n");
    }
    this.thresholds = new int[] {threshold1, threshold2, threshold3, threshold4, threshold5};
    this.speed = 0;
    this.gear = 0;
  }

  /**
   * Update the gear info according to the speed level.
   */
  private void updateGear() {
    if (this.speed >= thresholds[4]) {
      this.gear = 6;
    } else if (this.speed >= thresholds[3]) {
      this.gear = 5;
    } else if (this.speed >= thresholds[2]) {
      this.gear = 4;
    } else if (this.speed >= thresholds[1]) {
      this.gear = 3;
    } else if (this.speed >= thresholds[0]) {
      this.gear = 2;
    } else if (this.speed > 0) {
      this.gear = 1;
    } else if (this.speed == 0) {
      this.gear = 0;
    }
  }

  /**
   * Increases the speed of this Transmission by 1 MPH.
   */
  @Override
  public void increaseSpeed() {
    this.speed++;
    updateGear();
  }

  /**
   * Decreases the speed of this Transmission by 1 MPH.
   *
   * @throws IllegalStateException if calling this method would cause the speed to go below 0
   */
  @Override
  public void decreaseSpeed() throws IllegalStateException {
    if (speed > 0) {
      speed--;
      updateGear();
    } else {
      throw new IllegalStateException("Speed can not be negative. \n");
    }
  }

  /**
   * Gets the speed of this Transmission.
   *
   * @return the speed
   */
  @Override
  public int getSpeed() {
    return speed;
  }

  /**
   * Gets the gear of this Transmission.
   *
   * @return the gear
   */
  @Override
  public int getGear() {
    return gear;
  }

  /**
   * Return the representation of AutoTransmission.
   *
   * @return Return the representation of AutoTransmission
   */
  @Override
  public String toString() {
    return "Transmission ("
        + "speed = " + speed
        + ", gear = " + gear
        + ")";
  }
}
