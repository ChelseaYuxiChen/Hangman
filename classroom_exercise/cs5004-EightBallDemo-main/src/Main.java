import eightball.*;
import eightball.EightBallController;

import javax.swing.text.View;

/**
 * The main class for the EightBall program.
 */

public class Main {
  /**
   * The main method for the EightBall program.
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    EightBallModelInterface model = new EightBallModel();
    EightBallViewInterface view = new EightBallView("La Bola Ocho");
    EightBallControllerInterface controller = new EightBallController(view, model);
    controller.go();
  }
}
