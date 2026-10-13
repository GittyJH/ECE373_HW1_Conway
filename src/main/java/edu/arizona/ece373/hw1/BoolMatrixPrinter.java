//------------------------------------------------------
// Homework 1
// Written by: James Harron (23807128)
// ECE 373 Object-Oriented Software Design, Section 001 - Fall 2026
// The University of Arizona
//------------------------------------------------------

package edu.arizona.ece373.hw1;

/**
 * Prints a matrix whose cells are only {@code 0} or {@code 1}, values and all.
 *
 * <p>A 2x4 matrix whose two rows both hold {@code 0, 0, 1, 0} must render as</p>
 *
 * <pre>
 * +----+
 * |0010|
 * |0010|
 * +----+
 * </pre>
 *
 * <p>Only the row hook is overridden; the frame is inherited from
 * {@link MatrixOutlinePrinter}.</p>
 */
public class BoolMatrixPrinter extends MatrixOutlinePrinter {

  /** The character printed for a cell that holds {@code 0}. */
  public static final char DEAD = '0';

  /** The character printed for a cell that holds {@code 1}. */
  public static final char ALIVE = '1';

  /**
   * Renders one row as its cell values.
   *
   * @param matrix the matrix being printed, never {@code null}
   * @param row    the index of the row to render
   * @return one character per column, {@code '0'} or {@code '1'}
   * @throws IllegalArgumentException if any cell of the row holds a value other than 0 or 1
   */
  @Override
  protected String printRow(Matrix matrix, int row) {
    int cols = matrix.getColumns();
    StringBuilder sb = new StringBuilder();

    for (int c = 0; c < cols; c++) {
      int val = matrix.get(row, c);
      if (val == 0) {
        sb.append(DEAD);
      } else if (val == 1) {
        sb.append(ALIVE);
      } else {
        throw new IllegalArgumentException(
            String.format("Invalid cell value at (%d, %d): expected 0 or 1, found %d", row, c, val)
        );
      }
    }

    return sb.toString();
  }
}
