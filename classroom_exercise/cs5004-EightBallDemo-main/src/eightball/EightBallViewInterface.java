package eightball;

/**
 * This will be the interface for the view.
 * It should accept a question from the user and return a response.
 * The response should be a number.
 * The view will display a localized response based on the number.
 *
 */
public interface EightBallViewInterface {

  void registerCallbacks(EightBallControllerInterface controller);


}
