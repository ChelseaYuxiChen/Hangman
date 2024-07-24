package matrix;

/**
 * This interface represents all the operations offered by a matrix. A matrix is defined here as a
 * two-dimensional array of numbers.
 */
public interface Matrix {

  /**
   * Add this matrix to another and return the result as another matrix.
   *
   * @param other the other matrix to be added
   * @return the resulting matrix
   * @throws IllegalArgumentException if parameter is not the same size as the current matrix.
   */
  Matrix add(Matrix other) throws IllegalArgumentException;

  /**
   * Multiply this matrix by another and return the result as another matrix.
   *
   * @param other the other matrix to be multiplied
   * @return the resulting matrix
   * @throws IllegalArgumentException if parameter is not the right size for matrix multiplication
   */
  Matrix multiply(Matrix other) throws IllegalArgumentException;

  /**
   * Transpose this matrix and return the result as another matrix.
   *
   * @return the transposed matrix
   */
  Matrix transpose();

  /**
   * Determine if this matrix is the same as the parameter matrix.
   *
   * @param other the matrix to compare with
   * @return true if matrices are of the same size and have the same elements
   */
  boolean isSame(Matrix other);

  /**
   * Get the element at the specified row and column.
   *
   * @param row the row of the element
   * @param col the column of the element
   * @return the element at the specified row and column
   * @throws IllegalArgumentException if the row or column is out of bounds
   */
  double getElement(int row, int col) throws IllegalArgumentException;

  /**
   * Set the element at the specified row and column.
   *
   * @param row   the row of the element
   * @param col   the column of the element
   * @param value the value to set
   * @throws IllegalArgumentException if the row or column is out of bounds
   */
  void setElement(int row, int col, double value) throws IllegalArgumentException;

  /**
   * Get the number of rows in this matrix.
   *
   * @return the number of rows
   */
  int getRowCount();

  /**
   * Get the number of columns in this matrix.
   *
   * @return the number of columns
   */
  int getColumnCount();
}
