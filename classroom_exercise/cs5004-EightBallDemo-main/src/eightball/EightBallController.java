package eightball;

/**
 * Implementation of the EightBallControllerInterface
 */
public class EightBallController implements EightBallControllerInterface {

  private EightBallViewInterface view;
  private EightBallModelInterface model;

  /**
   * Constructor for the EightBallController.
   *
   * @param view the view
   * @param model the model
   */
  public EightBallController(EightBallViewInterface view, EightBallModelInterface model) {
    this.view = view;
    this.model = model;

    view.registerCallbacks(this);

  }

  public void go() {

  }

  public int askQuestion(String question) {
    return  model.askQuestion(question);
  }
}
