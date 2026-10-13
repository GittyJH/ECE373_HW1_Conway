//------------------------------------------------------
// Homework 1
// Written by: James Harron (23807128)
// ECE 373 Object-Oriented Software Design, Section 001 - Fall 2026
// The University of Arizona
//------------------------------------------------------
package edu.arizona.ece373.hw1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link Matrix} (Task 1).
 *
 * <p>The tests below are the ones the handout asks for; they are supplied so that you can run
 * them while you implement {@code Matrix}. They fail until the class works. The methods marked
 * {@code @Disabled} are yours to write: delete the annotation and fill in the body.</p>
 */
class MatrixTest {

    @ParameterizedTest(name = "new Matrix({0}, {1}) is rejected")
    @CsvSource({"0,4", "4,0", "-1,4", "4,-1", "0,0"})
    @DisplayName("the size constructor reports illegal arguments")
    void sizeConstructorRejectsIllegalDimensions(int rows, int columns) {
        assertThrows(IllegalArgumentException.class, () -> new Matrix(rows, columns));
    }

    @Test
    @DisplayName("the array constructor reports illegal arguments")
    void arrayConstructorRejectsIllegalArguments() {
        assertThrows(IllegalArgumentException.class, () -> new Matrix(null));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(new int[0][0]));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(new int[3][0]));
    }

    @ParameterizedTest(name = "a {0}x{1} matrix reports {0} rows and {1} columns")
    @CsvSource({"1,1", "2,4", "3,4", "7,2"})
    @DisplayName("the row and column methods return the expected number of rows and columns")
    void reportsItsDimensions(int rows, int columns) {
        Matrix fromSize = new Matrix(rows, columns);
        assertEquals(rows, fromSize.getRows());
        assertEquals(columns, fromSize.getColumns());

        Matrix fromArray = new Matrix(new int[rows][columns]);
        assertEquals(rows, fromArray.getRows());
        assertEquals(columns, fromArray.getColumns());
    }

    @Test
    @DisplayName("getData returns the values that were passed to the constructor")
    void getDataReturnsTheStoredValues() {
        // Build a matrix from an int[][] you write out by hand, then check with
        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6}
        };

        Matrix matrix = new Matrix(expected);
        // assertArrayEquals that getData() gives those values back.
        assertArrayEquals(expected, matrix.getData());

        // Verify defensive copying: mutating returned array should not alter internal state
        int[][] retrieved = matrix.getData();
        retrieved[0][0] = 99;
        assertEquals(1, matrix.get(0, 0));
    }

    @Test
    @DisplayName("setData replaces the contents of the matrix")
    void setDataReplacesContents() {
        // Creates a matrix, calls setData with a different array, and checks that
        int[][] initialData = {
                {1, 2},
                {3, 4}
        };
        Matrix matrix = new Matrix(initialData);

        int[][] newData = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        matrix.setData(newData);
        // getRows, getColumns and getData all reflect the new array.
        // Verify dimensions updated
        assertEquals(3, matrix.getRows());
        assertEquals(3, matrix.getColumns());

        // Verify updated values
        assertArrayEquals(newData, matrix.getData());

        // Verify defensive copying on setData: mutating source array should not affect matrix
        newData[0][0] = 999;
        assertEquals(10, matrix.get(0, 0));
    }
}
