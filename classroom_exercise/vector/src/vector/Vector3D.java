package vector;

import java.util.Objects;

/**
 * A class representing a three-dimensional vector.
 */
public class Vector3D {
  private double vectorX;
  private double vectorY;
  private double vectorZ;

  /**
   * Constructs a Vector.Vector3D with the specified components.
   *
   * @param vectorX the x-component of the vector
   * @param vectorY the y-component of the vector
   * @param vectorZ the z-component of the vector
   */
  public Vector3D(double vectorX, double vectorY, double vectorZ) {
    this.vectorX = vectorX;
    this.vectorY = vectorY;
    this.vectorZ = vectorZ;
  }

  /**
   * Returns the x-component of the vector.
   *
   * @return the x-component of the vector
   */
  public double getX() {
    return vectorX;
  }

  /**
   * Returns the y-component of the vector.
   *
   * @return the y-component of the vector
   */
  public double getY() {
    return vectorY;
  }

  /**
   * Returns the z-component of the vector.
   *
   * @return the z-component of the vector
   */
  public double getZ() {
    return vectorZ;
  }

  /**
   * Returns a string representation of the vector in the format "(x, y, z)".
   *
   * @return a string representation of the vector
   */
  @Override
  public String toString() {
    return String.format("(%.2f, %.2f, %.2f)", vectorX, vectorY, vectorZ);
  }

  /**
   * Returns the magnitude of the vector.
   *
   * @return the magnitude of the vector
   */
  public double getMagnitude() {
    return Math.sqrt(vectorX * vectorX + vectorY * vectorY + vectorZ * vectorZ);
  }

  /**
   * Returns a normalized version of the vector.
   *
   * @return a normalized version of the vector
   * @throws IllegalStateException if the vector is a zero vector
   */
  public Vector3D normalize() {
    double magnitude = this.getMagnitude();
    if (magnitude == 0) {
      throw new IllegalStateException("can not normalize a zero vector");
    }
    vectorX = vectorX / magnitude;
    vectorY = vectorY / magnitude;
    vectorZ = vectorZ / magnitude;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vector3D vector3D = (Vector3D) o;
    return Double.compare(vectorX, vector3D.vectorX) == 0
        && Double.compare(vectorY, vector3D.vectorY) == 0
        && Double.compare(vectorZ, vector3D.vectorZ) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(vectorX, vectorY, vectorZ);
  }

  /**
   * The main method to test the functionality of the Vector.Vector3D class.
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    Vector3D vector = new Vector3D(11.1, 22.2, 33.3);
    System.out.println("Original vector: " + vector);

    try {
      Vector3D normalizedVector = vector.normalize();
      System.out.println("Normalized vector: " + normalizedVector);
    } catch (IllegalStateException e) {
      System.err.println(e.getMessage());
    }
  }
}
