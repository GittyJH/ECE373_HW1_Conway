//------------------------------------------------------
// Homework 1
// Written by: (your name and student ID)
// ECE 373 Object-Oriented Software Design, Section 001 - Fall 2026
// The University of Arizona
//------------------------------------------------------
package edu.arizona.ece373.hw1;

/**
 * A rectangular, mutable matrix of {@code int} values.
 *
 * <p>Task 1 of the homework. The array of cells must stay {@code private}: everything outside
 * this class reaches the cells through the methods below.</p>
 */
public class Matrix {

    // TODO: declare the private field `data` holding a two-dimensional array of int.

    /**
     * Creates a matrix of the given size whose cells are all zero.
     *
     * @param rows    the number of rows, must be at least 1
     * @param columns the number of columns, must be at least 1
     * @throws IllegalArgumentException if {@code rows} or {@code columns} is less than 1
     */
    public Matrix(int rows, int columns) {
        // TODO: check that rows >= 1 and columns >= 1 (IllegalArgumentException otherwise),
        // TODO: then allocate the array field with that many rows and columns.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Creates a matrix that holds the given two-dimensional array of cells.
     *
     * @param data the cells, must be non-null, rectangular and at least 1x1
     * @throws IllegalArgumentException if {@code data} is {@code null}, has no rows, has no
     *                                  columns, has a {@code null} row, or is jagged
     */
    public Matrix(int[][] data) {
        // TODO: validate the argument (not null, at least 1 row, at least 1 column,
        // TODO: every row the same length) and store it in the field.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the cells of this matrix.
     *
     * @return the current values, {@code result[row][column]}
     */
    public int[][] getData() {
        // TODO: return the cells. Think about whether you hand out the field itself or a copy.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Replaces all cells of this matrix.
     *
     * <p>{@code GameOfLife.step()} uses this method to install the next generation.</p>
     *
     * @param data the new cells, must be non-null, rectangular and at least 1x1
     * @throws IllegalArgumentException if {@code data} is not a legal matrix body
     */
    public void setData(int[][] data) {
        // TODO: validate exactly like the array constructor, then store.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the number of rows of this matrix, i.e. the first dimension of the array.
     *
     * @return the row count, always at least 1
     */
    public int getRows() {
        // TODO: return the number of rows.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the number of columns of this matrix, i.e. the second dimension of the array.
     *
     * @return the column count, always at least 1
     */
    public int getColumns() {
        // TODO: return the number of columns.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the value of a single cell.
     *
     * @param row    the row index, {@code 0 <= row < getRows()}
     * @param column the column index, {@code 0 <= column < getColumns()}
     * @return the value stored in that cell
     * @throws IndexOutOfBoundsException if the coordinate is outside the matrix
     */
    public int get(int row, int column) {
        // TODO: bounds-check the coordinate and return the cell.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Stores a value in a single cell.
     *
     * @param row    the row index, {@code 0 <= row < getRows()}
     * @param column the column index, {@code 0 <= column < getColumns()}
     * @param value  the value to store
     * @throws IndexOutOfBoundsException if the coordinate is outside the matrix
     */
    public void set(int row, int column, int value) {
        // TODO: bounds-check the coordinate and write the cell.
        throw new UnsupportedOperationException("TODO");
    }
}
