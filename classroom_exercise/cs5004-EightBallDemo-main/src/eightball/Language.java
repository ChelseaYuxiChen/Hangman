package eightball;

/**
 * Represents the languages that the Magic 8-Ball can be displayed in.
 */
public enum Language {
  English("en"),
  Spanish("es");

  private String display;

  Language(String display) {
    this.display = display;
  }

  @Override
  public String toString() {
    return display;
  }
}
