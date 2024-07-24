package matrix;

/**
 * the implementation of the matrix.
 */
public class MatrixImpl implements Matrix {
  private final int cols;
  private final int rows;
  private final double[][] elements;

  /**
   * The constructor of the matrix.
   *
   * @param rows the row of the matrix
   * @param cols the column of the matrix
   * @throws IllegalArgumentException throw the IllegalArgumentException
   *                                  if row or column smaller than 0
   */
  @SuppressWarnings("checkstyle:LineLength")
  public MatrixImpl(final int rows, final int cols) throws IllegalArgumentException {
    if (cols < 0 || rows < 0) {
      throw new IllegalArgumentException("Row and column numbers must be non-negative.");
    }
    this.cols = cols;
    this.rows = rows;
    this.elements = new double[rows][cols];
  }


  @Override
  public Matrix add(Matrix other) throws IllegalArgumentException {
    if (this.cols != other.getColumnCount() || this.rows != other.getRowCount()) {
      throw new IllegalArgumentException(
          "Two matrices must have the same number of rows and columns");
    }
    MatrixImpl matrixAddition = new MatrixImpl(this.rows, this.cols);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        double sum = this.getElement(i, j) + other.getElement(i, j);
        matrixAddition.setElement(i, j, sum);
      }
    }
    return matrixAddition;
  }

  @Override
  public Matrix multiply(Matrix other) throws IllegalArgumentException {
    if (this.cols != other.getRowCount()) {
      throw new IllegalArgumentException("Cannot multiply matrices with incompatible dimensions.");
    }
    MatrixImpl matrixProduction = new MatrixImpl(this.rows, other.getColumnCount());
    for (int i = 0; i < this.getRowCount(); i++) {
      for (int j = 0; j < other.getColumnCount(); j++) {
        double product = 0;
        for (int k = 0; k < this.getColumnCount(); k++) {
          product += this.getElement(i, k) * other.getElement(k, j);
          matrixProduction.setElement(i, j, product);
        }
      }
    }
    return matrixProduction;
  }

  @Override
  public Matrix transpose() {
    MatrixImpl matrixTrans = new MatrixImpl(this.cols, this.rows);
    for (int i = 0; i < this.getRowCount(); i++) {
      for (int j = 0; j < this.getColumnCount(); j++) {
        matrixTrans.setElement(j, i, this.getElement(i, j));
      }
    }
    return matrixTrans;
  }

  @Override
  public boolean isSame(Matrix other) {
    if (this.rows != other.getRowCount() || this.cols != other.getColumnCount()) {
      return false;
    }

    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        if (this.getElement(i, j) != other.getElement(i, j)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public double getElement(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row >= getRowCount() || col < 0 || col >= getColumnCount()) {
      throw new IllegalArgumentException("Row or Column is invalid!");
    }
    return elements[row][col];
  }

  @Override
  public void setElement(int row, int col, double value) throws IllegalArgumentException {
    if (row < 0 || row >= getRowCount() || col < 0 || col >= getColumnCount()) {
      throw new IllegalArgumentException("Row or Column is invalid!");
    }
    elements[row][col] = value;
  }

  @Override
  public int getRowCount() {
    return rows;
  }

  @Override
  public int getColumnCount() {
    return cols;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{rows = ").append(rows).append(", cols = ").append(cols).append(", matrix = [");
    for (int i = 0; i < rows; i++) {
      sb.append("[");
      for (int j = 0; j < cols; j++) {
        sb.append(elements[i][j]);
        if (j < cols - 1) {
          sb.append(", ");
        }
      }
      sb.append("]");
      if (i < rows - 1) {
        sb.append(", ");
      }
    }
    sb.append("]}");
    return sb.toString();
  }
}

