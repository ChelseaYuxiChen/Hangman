package hangman;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class HangmanModelImplTest {

  private HangmanModelImpl hangman;

  @Before
  public void setUp() {
    // Initialize the HangmanModelImpl with a file containing some words for testing
    hangman = new HangmanModelImpl("res/test.txt");
  }

  @Test
  public void testInitialize() {
    // Verify that the word is chosen and the current state is correctly initialized
    assertNotNull(hangman.getCurrentState());
    assertTrue(hangman.getCurrentState().matches("[_]+"));
  }

  @Test
  public void testMakeValidGuess() {
    String initialState = hangman.getCurrentState();
    assertTrue(hangman.makeGuess('a')); // Assuming 'a' is in the word
    assertNotEquals(initialState, hangman.getCurrentState());
  }

  @Test
  public void testMakeInvalidGuess() {
    String initialState = hangman.getCurrentState();
    assertFalse(hangman.makeGuess('z')); // Assuming 'z' is not in the word
    assertEquals(initialState, hangman.getCurrentState());
    assertEquals(5, hangman.getGuessesRemaining());
  }

  @Test
  public void testMakeDuplicateGuess() {
    hangman.makeGuess('a');
    try {
      hangman.makeGuess('a');
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertEquals("The letter has already been guessed.", e.getMessage());
    }
  }

  @Test
  public void testGameOver() {
    // Make incorrect guesses until the game is over
    char[] guesses = {'w', 'o', 't', 'a', 'r', 'e', 'q', 'l'};
    for (char guess : guesses) {
      hangman.makeGuess(guess);
    }
    assertFalse(hangman.isGameOver());
    assertEquals(1, hangman.getGuessesRemaining());
  }

  @Test
  public void testWinningGame() {
    // This test assumes a specific word for simplicity. In a real test, you'd mock the word selection.
    writeSingleWordFile("apple");
    hangman = new HangmanModelImpl("res/test.txt");
    assertTrue(hangman.makeGuess('a'));
    assertTrue(hangman.makeGuess('p'));
    assertTrue(hangman.makeGuess('l'));
    assertTrue(hangman.makeGuess('e'));
    assertTrue(hangman.isGameOver());
    assertFalse(hangman.getCurrentState().contains("_"));
  }

  @Test
  public void testGetWordListEmptyFile() {
    writeEmptyFile();
    try {
      new HangmanModelImpl("src/test/resources/empty.txt");
      fail("Expected IllegalStateException");
    } catch (IllegalStateException e) {
      assertEquals("The file is empty.", e.getMessage());
    }
  }

  @Test
  public void testGetWordListNonExistentFile() {
    try {
      new HangmanModelImpl("src/test/resources/nonexistent.txt");
      fail("Expected IllegalStateException");
    } catch (IllegalStateException e) {
      // Expecting exception due to non-existent file
    }
  }

  private void writeSingleWordFile(String word) {
    try {
      File file = new File("src/test/resources/single_word.txt");
      try (FileWriter writer = new FileWriter(file)) {
        writer.write(word);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeEmptyFile() {
    try {
      File file = new File("src/test/resources/empty.txt");
      file.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}