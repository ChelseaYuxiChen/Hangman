/**
 * TelevisionSet class represents a television set that can
 * be turned on or off, change volume and  channel.
 */
public class TelevisionSet {
  private PowerState powerState;
  private VolumeControl volumeControl;
  private ChannelManager channelManager;

  /**
   * Creates a new TelevisionSet object.
   */
  public TelevisionSet() {
    this.volumeControl = new VolumeControl();
    this.powerState = new PowerState();
    this.channelManager = new ChannelManager();
  }

  /**
   * Turns on the television.
   */
  public void turnOn() {
    powerState.turnOn();
  }

  /**
   * Turns off the television.
   */
  public void turnOff() {
    powerState.turnOff();
  }

  /**
   * Increases the volume by 1 unit.
   */
  public void increaseVolume() {
    if (powerState.isOn()) {
      volumeControl.increaseVolume();
    }
  }

  /**
   * Decreases the volume by 1 unit.
   */
  public void decreaseVolume() {
    if (powerState.isOn()) {
      volumeControl.decreaseVolume();
    }
  }

  /**
   * Changes the channel to the specified channel.
   *
   * @param channel the channel to change to
   */
  public void changeChannel(int channel) {
    if (powerState.isOn()) {
      channelManager.changeChannel(channel);
    }
  }
}
