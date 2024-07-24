import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a soccer team model.
 * A soccer team model has a list of players and a team.
 */
public class SoccerTeamModelImpl implements SoccerTeamModel {

  private List<Player> players;
  private Team team;

  /**
   * Creates a soccer team model with an empty list of players and a team.
   */
  public SoccerTeamModelImpl() {
    this.team = new Team();
    this.players = new ArrayList();
  }

  /**
   * Returns the list of players in the soccer team model.
   *
   * @return the list of players in the soccer team model
   */
  @Override
  public List<Player> getPlayers() {
    return players;
  }

  /**
   * Adds a player to the soccer team model.
   *
   * @param player the player to add
   */
  @Override
  public void addPlayer(Player player) {
    players.add(player);
  }

  /**
   * Gets the soccer team.
   *
   * @return the soccer team
   */
  @Override
  public Team getTeam() {
    return team;
  }
}
