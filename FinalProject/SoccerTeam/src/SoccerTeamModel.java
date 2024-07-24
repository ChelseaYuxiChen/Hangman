import java.util.List;

/**
 * Created by Chelsea on 2024-07-22
 */
public interface SoccerTeamModel {
  public List<Player> getPlayers();

  public void addPlayer(Player player);
  public Team getTeam();
}
