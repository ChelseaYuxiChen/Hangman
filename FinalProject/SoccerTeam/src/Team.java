import java.util.ArrayList;
import java.util.List;

/**
 * [是否需要setplayer？]
 * This class represents a team in a soccer league.
 * A team has a list of players.
 */
public class Team {
  private List<Player> players;
  private List<Player> startingLineup;

  /**
   * Creates a team with an empty list of players.
   */
  public Team() {
    this.players = new ArrayList<>();
  }

  /**
   * Returns the list of players in the team.
   *
   * @return the list of players in the team
   */
  public List<Player> getPlayers() {
    return players;
  }

  /**
   * Adds a player to the team.
   *
   * @param player the player to add
   */
  public void addPlayer(Player player) {
    this.players.add(player);
  }

  /**
   * Removes a player from the team.
   *
   * @param player the player to remove
   */
  public void removePlayer(Player player) {
    this.players.remove(player);
  }
  public void setStartingLineup(List<Player> startingLineup) {
    this.startingLineup = startingLineup;
  }

  public List<Player> getStartingLineup() {
    return startingLineup;
  }

  /**
   * Returns a string representation of the team.
   *
   * @return a string representation of the team
   */
  @Override
  public String toString() {
    return "Team{" +
        "players=" + players +
        '}';
  }


}
