package matrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Chelsea on 2024-06-17.
 * Test for the MatrixImpl.
 */
public class MatrixImplTest {
  private MatrixImpl matrix1;
  private MatrixImpl matrix2;
  private MatrixImpl matrix3;
  private MatrixImpl matrix4;

  /**
   * Sets up the matrices for testing.
   * Initializes matrix1, matrix2, matrix3, and matrix4 with predefined elements.
   */
  @Before
  public void setUp() {
    matrix1 = new MatrixImpl(2, 3);
    matrix1.setElement(0, 0, 1);
    matrix1.setElement(0, 1, 2);
    matrix1.setElement(0, 2, 3);
    matrix1.setElement(1, 0, 4);
    matrix1.setElement(1, 1, 5);
    matrix1.setElement(1, 2, 6);

    matrix2 = new MatrixImpl(2, 3);
    matrix2.setElement(0, 0, 1);
    matrix2.setElement(0, 1, 2);
    matrix2.setElement(0, 2, 3);
    matrix2.setElement(1, 0, 4);
    matrix2.setElement(1, 1, 5);
    matrix2.setElement(1, 2, 6);

    matrix3 = new MatrixImpl(3, 2);
    matrix3.setElement(0, 0, 1);
    matrix3.setElement(0, 1, 2);
    matrix3.setElement(1, 0, 3);
    matrix3.setElement(1, 1, 4);
    matrix3.setElement(2, 0, 5);
    matrix3.setElement(2, 1, 6);

    matrix4 = new MatrixImpl(1, 1);
    matrix4.setElement(0, 0, 2);
  }

  /**
   * Tests the constructor with negative dimensions.
   * Expects an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeDimension() {
    new MatrixImpl(-2, 3);
  }

  /**
   * Tests the addition of two matrices.
   * Verifies that the result is as expected.
   */
  @Test
  public void add() {
    MatrixImpl addition = (MatrixImpl) matrix1.add(matrix2);
    assertEquals(2, addition.getElement(0, 0), 0.0001);
    assertEquals(4, addition.getElement(0, 1), 0.0001);
    assertEquals(6, addition.getElement(0, 2), 0.0001);
    assertEquals(8, addition.getElement(1, 0), 0.0001);
    assertEquals(10, addition.getElement(1, 1), 0.0001);
    assertEquals(12, addition.getElement(1, 2), 0.0001);
  }

  /**
   * Tests the addition of matrices with different dimensions.
   * Expects an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddDifferentDimension() {
    matrix1.add(matrix3);
  }

  /**
   * Tests the multiplication of two matrices.
   * Verifies that the result is as expected.
   */
  @Test
  public void multiply() {
    MatrixImpl product = (MatrixImpl) matrix1.multiply(matrix3);
    assertEquals(22, product.getElement(0, 0), 0.0001);
    assertEquals(28, product.getElement(0, 1), 0.0001);
    assertEquals(49, product.getElement(1, 0), 0.0001);
    assertEquals(64, product.getElement(1, 1), 0.0001);
  }

  /**
   * Tests the multiplication of matrices with incompatible dimensions.
   * Expects an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMultiplyWrong() {
    matrix1.multiply(matrix2);
  }

  /**
   * Tests the transpose of a matrix.
   * Verifies that the result is as expected.
   */
  @Test
  public void transpose() {
    MatrixImpl trans = (MatrixImpl) matrix1.transpose();
    assertEquals(1, trans.getElement(0, 0), 0.0001);
    assertEquals(4, trans.getElement(0, 1), 0.0001);
    assertEquals(2, trans.getElement(1, 0), 0.0001);
    assertEquals(5, trans.getElement(1, 1), 0.0001);
    assertEquals(3, trans.getElement(2, 0), 0.0001);
    assertEquals(6, trans.getElement(2, 1), 0.0001);

    MatrixImpl trans1 = (MatrixImpl) matrix4.transpose();
    assertEquals(2, trans1.getElement(0, 0), 0.0001);
  }

  /**
   * Tests the equality of matrices.
   * Verifies that the isSame method correctly identifies whether matrices are identical or not.
   */
  @Test
  public void isSame() {
    assertTrue(matrix1.isSame(matrix2));
    assertFalse(matrix1.isSame(matrix3));
  }

  /**
   * Tests getting an element from the matrix.
   * Verifies that the correct value is returned.
   */
  @Test
  public void getElement() {
    assertEquals(1, matrix1.getElement(0, 0), 0.0001);
  }

  /**
   * Tests getting an element with invalid indices.
   * Expects an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetElementInvalid() {
    matrix1.getElement(4, 7);
  }

  /**
   * Tests setting an element in the matrix.
   * Verifies that the value is correctly set.
   */
  @Test
  public void setElement() {
    matrix1.setElement(0, 0, 9);
    assertEquals(9, matrix1.getElement(0, 0), 0.0001);
  }

  /**
   * Tests setting an element with invalid indices.
   * Expects an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetElementInvalid() {
    matrix1.setElement(6, 5, 2);
  }

  /**
   * Tests getting the row count of the matrix.
   * Verifies that the correct row count is returned.
   */
  @Test
  public void getRowCount() {
    assertEquals(2, matrix1.getRowCount());
  }

  /**
   * Tests getting the column count of the matrix.
   * Verifies that the correct column count is returned.
   */
  @Test
  public void getColumnCount() {
    assertEquals(3, matrix1.getColumnCount());
  }
}