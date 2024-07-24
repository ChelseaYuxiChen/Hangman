import commands.Controller;
import commands.Model;
import commands.View;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Main. this holds the main method that runs the program.
 */
public class Main {

  /**
   * The main method.
   *
   * @param args the args
   */
  public static void main(String[] args) {
    Model model = new Model();

    View view = new View("5004 MVC Example");

    Controller controller = new Controller(model);
    controller.setView(view);
    List<Integer> list = new ArrayList<>();


  }
  public Integer getFirst(List<Integer> list) {
    return list.get(0);
  }
}
