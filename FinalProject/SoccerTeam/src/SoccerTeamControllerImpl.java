import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chelsea on 2024-07-23
 */
public class SoccerTeamControllerImpl implements SoccerTeamController {
  public static final int TEAM_UPPER_LIMIT = 20;
  public static final int TEAM_LOWER_LIMIT = 10;
  public static final int LINEUP_LIMIT = 7;
  public static final int NUMBER_OF_GOALIE = 1;
  public static final int NUMBER_OF_DEFENDERS = 2;
  public static final int NUMBER_OF_MIDFIELDERS = 3;
  public static final int NUMBER_OF_FORWARD = 1;
  private SoccerTeamModel model;


  @Override
  public int hashCode() {
    return super.hashCode();
  }

  public SoccerTeamControllerImpl(SoccerTeamModel model) {
    this.model = model;
  }

  @Override
  public void generateTeam() throws IllegalStateException {
    List<Player> players = model.getPlayers();
    if (players.size() < TEAM_LOWER_LIMIT) {
      throw new IllegalStateException(" Team cannot be created unless more players are added");
    } else {
      players.sort(Comparator.comparingInt(Player::getSkillLevel));
      if (players.size() > TEAM_UPPER_LIMIT) {
        for (int i = TEAM_UPPER_LIMIT; i < players.size(); i++) {
          //clear jersey number
          players.get(i).setJerseyNumber(null);
        }
      }
      List<Integer> jerseyNumbers = new ArrayList<>();
      for (int i = 0; i < Math.min(TEAM_UPPER_LIMIT, players.size()); i++) {
        jerseyNumbers.add(i + 1);
      }
      if (!model.getTeam().getPlayers().isEmpty()) {
        //remove old team to generate new team
        model.getTeam().getPlayers().clear();
        model.getTeam().getStartingLineup().clear();
      }
      List<Player> needJerseyNumberPlayers = new ArrayList<>();
      for (int i = 0; i < Math.min(TEAM_UPPER_LIMIT, players.size()); i++) {
        Player player = players.get(i);
        if (player.getJerseyNumber() != null) {
          //remove used jersey number
          jerseyNumbers.remove(player.getJerseyNumber());
        } else {
          needJerseyNumberPlayers.add(player);
        }
        model.getTeam().addPlayer(player);
      }
      for (int i = 0; i < needJerseyNumberPlayers.size(); i++) {
        needJerseyNumberPlayers.get(i).setJerseyNumber(jerseyNumbers.get(i));
      }
    }
  }


  @Override
  public void generateStartingLineup() {
    // check if team is generated
    if (model.getTeam().getPlayers().isEmpty()) {
      generateTeam();
    }
    List<Player> players = model.getTeam().getPlayers();
    // get the first 7 availablePlayers in the team
    List<Player> availablePlayers = new ArrayList<>();
    for (int i = 0; i < LINEUP_LIMIT; i++) {
      availablePlayers.add(players.get(i));
    }
    List<Player> startingLineup = new ArrayList<>();

    // store the available positions
    Map<Position, Integer> availablePositions = new HashMap<>();
    availablePositions.put(Position.GOALIE, NUMBER_OF_GOALIE);
    availablePositions.put(Position.DEFENDER, NUMBER_OF_DEFENDERS);
    availablePositions.put(Position.MIDFIELDER, NUMBER_OF_MIDFIELDERS);
    availablePositions.put(Position.FORWARD, NUMBER_OF_FORWARD);


    // assign positions
    assignPosition(startingLineup, availablePlayers, Position.GOALIE, availablePositions);
    assignPosition(startingLineup, availablePlayers, Position.DEFENDER, availablePositions);
    assignPosition(startingLineup, availablePlayers, Position.MIDFIELDER, availablePositions);
    assignPosition(startingLineup, availablePlayers, Position.FORWARD, availablePositions);

    // fill remaining positions if needed
    while (!availablePlayers.isEmpty()) {
      for (Map.Entry<Position, Integer> entry : availablePositions.entrySet()) {
        Position position = entry.getKey();
        Integer count = entry.getValue();
        for (int i = 0; i < count; i++) {
          assignPosition(startingLineup, availablePlayers, position, availablePositions);
        }
      }
    }
    model.getTeam().setStartingLineup(startingLineup);
  }

  private void assignPosition(List<Player> startingLineup, List<Player> availablePlayers,
                              Position position, Map<Position, Integer> availablePositions) {
    for (Player player : availablePlayers) {
      if (availablePositions.containsKey(position) && player.getPreferredPosition().equals(position)) {
        player.setAssignedPosition(position);
        startingLineup.add(player);
        availablePlayers.remove(player);
        availablePositions.put(position, availablePositions.get(position) - 1);
        if (availablePositions.get(position) == 0) {
          availablePositions.remove(position);
        }
      }
    }
  }

  @Override
  public void addPlayer(String lastName, String firstName, LocalDate birthdate,
                        Position preferredPosition, int skillLevel) {
    Player player = new Player(lastName, firstName, birthdate, preferredPosition, skillLevel);
    model.addPlayer(player);
  }

  @Override
  public void removePlayer(String id) {
    model.getPlayers().removeIf(player -> player.getId().equals(id));
    model.getTeam().getPlayers().removeIf(player -> player.getId().equals(id));
    model.getTeam().getStartingLineup().removeIf(player -> player.getId().equals(id));
  }
}
