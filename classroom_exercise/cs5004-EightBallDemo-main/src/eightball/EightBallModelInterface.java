package eightball;

/**
 * Interface for the model for the EightBall game.
 * The model will implement a random response to a question.
 * It only has to return a random number n
 * where 0 <= n < 10.
 */
public interface EightBallModelInterface {

  int askQuestion(String question);
}
