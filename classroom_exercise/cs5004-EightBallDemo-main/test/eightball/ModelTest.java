package eightball;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ModelTest {

  @Test
  public void askQuestion() {
    EightBallModel model = new EightBallModel();
    assertEquals(-1, model.askQuestion(""));

    int result = model.askQuestion("Is this a test?");
    assertEquals(result, model.askQuestion("Is this a test?"));
  }
}