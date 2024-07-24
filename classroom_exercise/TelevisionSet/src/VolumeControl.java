/**
 * Created by Chelsea on 2024-07-22.
 */
public class VolumeControl {
  private int currentVolume;

  public VolumeControl() {
    this.currentVolume = 10;
  }

  /**
   * Increases the volume by 1 unit.
   */
  public void increaseVolume() {
    if (currentVolume < 100) {
      currentVolume++;
      System.out.println("Volume increased to " + currentVolume);
    }
  }

  /**
   * Decreases the volume by 1 unit.
   */
  public void decreaseVolume() {
    if (currentVolume > 0) {
      currentVolume--;
      System.out.println("Volume decreased to " + currentVolume);
    }
  }
}
