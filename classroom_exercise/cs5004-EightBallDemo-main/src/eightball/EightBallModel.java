package eightball;

/**
 * Represents a model for the Magic 8 Ball game.
 */
public class EightBallModel implements EightBallModelInterface {

  String lastQuestion;
  int lastAnswer;

  /**
   * returns a random number between 0 and 10.
   *
   * @return a random number between 0 and 10.
   */
  @Override
  public int askQuestion(String question) {

    if (question == null) {
      throw new IllegalArgumentException("Question cannot be null");
    }

    // Check if the question is empty and return -1
    if (question.isEmpty()) {
      return -1;
    }

    if (this.lastQuestion != null && this.lastQuestion.equals(question)) {
      return lastAnswer;
    }

    int result = (int) (Math.random() * 10);
    this.lastQuestion = question;
    this.lastAnswer = result;
    return result;
  }
}
