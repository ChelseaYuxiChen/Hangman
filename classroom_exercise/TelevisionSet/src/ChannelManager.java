/**
 * Created by Chelsea on 2024-07-22.
 */
public class ChannelManager {
  private int channel;

  public ChannelManager() {
    this.channel = 1;
  }


  /**
   * Changes the channel to the specified channel.
   *
   * @param channel the channel to change to
   */
  public void changeChannel(int channel) {
    channel = channel;
    System.out.println("Channel changed to " + channel);
  }
}
