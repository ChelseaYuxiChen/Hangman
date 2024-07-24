package eightball;

/**
 * Interface for the controller for the EightBallModel game.
 * The controller will accept any question.  It will then
 * ask the model to answer the question.  The controller will
 * then ask the view to display the answer.
 */
public interface EightBallControllerInterface {

  void go();

  int askQuestion(String question);


}
