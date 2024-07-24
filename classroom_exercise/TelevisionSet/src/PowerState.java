/**
 * Created by Chelsea on 2024-07-22.
 */
public class PowerState {
  private boolean isOn;

  public PowerState() {
    this.isOn = false;
  }

  /**
   * Turns on the television.
   */
  public void turnOn() {
    isOn = true;
    System.out.println("TV is now on.");
  }

  /**
   * Turns off the television.
   */
  public void turnOff() {
    isOn = false;
    System.out.println("TV is now off.");
  }

  public boolean isOn() {
    return isOn;
  }
}
