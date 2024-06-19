package movies;

import java.util.Objects;

/**
 * This class implements the movie interface. The movie has a title, director, and year of release.
 */
public class MovieImpl implements Movie {

  private final String title;
  private final Person director;
  private final int year;

  /**
   * Constructs a Movie object and initializes it to the movie's title, director and year.
   *
   * @param title    the title of this movie
   * @param director the name of the movie's director
   * @param year     the year the movie was released
   */
  public MovieImpl(String title, Person director, int year) {
    this.title = title;
    this.director = director;
    this.year = year;
  }

  @Override public String getTitle() {
    return this.title;
  }

  @Override public Person getDirector() {
    return this.director;
  }

  @Override public int getYear() {
    return this.year;
  }

  // Example: The Apartment (Billy Wilder, 1960)
  @Override public String toString() {
    return String.format(this.title + " (" + this.director.toString() + ", %d)", this.year);
  }

  // Order: year, title, director
  @Override public int compareTo(Movie o) {
    if (this.year == o.getYear()) {
      if (this.title.equalsIgnoreCase(o.getTitle())) {
        return this.director.compareTo(o.getDirector());
      }
      return this.title.compareToIgnoreCase(o.getTitle());
    }
    return this.year - o.getYear();
  }

  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    MovieImpl movie = (MovieImpl) object;
    return year == movie.year && java.util.Objects.equals(title, movie.title) &&
        java.util.Objects.equals(director, movie.director);
  }

  public int hashCode() {
    return Objects.hash(super.hashCode(), title, director, year);
  }
}
