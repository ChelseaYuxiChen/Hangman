import java.time.LocalDate;

/**
 * Created by Chelsea on 2024-07-22
 */
public interface SoccerTeamController {
  public void generateTeam();
  public void generateStartingLineup();
  public void addPlayer(String lastName, String firstName, LocalDate birthdate, Position preferredPosition,
                        int skillLevel);
  public void removePlayer(String id);
}
