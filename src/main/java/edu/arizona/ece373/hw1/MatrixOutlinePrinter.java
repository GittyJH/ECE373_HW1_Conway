//------------------------------------------------------
// Homework 1
// Written by: (your name and student ID)
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
        // TODO: reject a null matrix, then build the frame with a StringBuilder:
        // TODO:   a border line, one line per row, a border line, each ending in '\n'.
        // TODO: the inside of each line must come from printRow(matrix, row) so that
        // TODO: BoolMatrixPrinter can change it by overriding that one method.
        throw new UnsupportedOperationException("TODO");
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
        // TODO: return one blank character per column.
        throw new UnsupportedOperationException("TODO");
    }
}
