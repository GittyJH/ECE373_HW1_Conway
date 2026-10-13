//------------------------------------------------------
// Homework 1
// Written by: James Harron (23807128)
// ECE 373 Object-Oriented Software Design, Section 001 - Fall 2026
// The University of Arizona
//------------------------------------------------------
package edu.arizona.ece373.hw1;

/**
 * Prints the outline (the frame) of a matrix and leaves the inside blank.
 *
 * <p>A 2x4 matrix must render as</p>
 *
 * <pre>
 * +----+
 * |    |
 * |    |
 * +----+
 * </pre>
 *
 * <p>with a {@code '\n'} after every line, including the last one.</p>
 */
public class MatrixOutlinePrinter implements MatrixPrinter {

    /** The character drawn at the four corners of the frame. */
    public static final char CORNER = '+';

    /** The character drawn along the top and bottom edges of the frame. */
    public static final char HORIZONTAL = '-';

    /** The character drawn along the left and right edges of the frame. */
    public static final char VERTICAL = '|';

    /**
     * Renders {@code matrix} as a framed block of text.
     *
     * @param matrix the matrix to render, must not be {@code null}
     * @return the framed rendering of {@code matrix}
     * @throws IllegalArgumentException if {@code matrix} is {@code null}, or if
     *                                  {@link #printRow(Matrix, int)} rejects a row
     */
    @Override
    public String print(Matrix matrix) {
        // Rejects a null matrix.
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null.");
        }
        StringBuilder sb = new StringBuilder();
        int cols = matrix.getColumns();
        int rows = matrix.getRows();

        // Top border line: e.g. "+----+\n"
        sb.append(CORNER);
        for (int c = 0; c < cols; c++) {
            sb.append(HORIZONTAL);
        }
        sb.append(CORNER).append('\n');

        // Middle content lines: e.g. "|    |\n"
        for (int r = 0; r < rows; r++) {
            sb.append(VERTICAL);
            sb.append(printRow(matrix, r));
            sb.append(VERTICAL).append('\n');
        }

        // Bottom border line: e.g. "+----+\n"
        sb.append(CORNER);
        for (int c = 0; c < cols; c++) {
            sb.append(HORIZONTAL);
        }
        sb.append(CORNER).append('\n');

        return sb.toString();
    }

    /**
     * Renders the inside of one row, without the surrounding {@link #VERTICAL} characters.
     *
     * <p>The returned string must be exactly {@code matrix.getColumns()} characters long,
     * otherwise the frame will not line up. Subclasses override this method.</p>
     *
     * @param matrix the matrix being printed, never {@code null}
     * @param row    the index of the row to render
     * @return the characters that belong between the two border characters of this line
     */
    protected String printRow(Matrix matrix, int row) {
        int cols = matrix.getColumns();
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < cols; c++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
