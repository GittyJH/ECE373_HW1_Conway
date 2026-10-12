//------------------------------------------------------
// Homework 1
// Written by: (your name and student ID)
// ECE 373 Object-Oriented Software Design, Section 001 - Fall 2026
// The University of Arizona
//------------------------------------------------------
package edu.arizona.ece373.hw1;

/**
 * Turns a {@link Matrix} into a printable string.
 *
 * <p>Task 2 of the homework. This interface is what lets client code hold one variable and print
 * either an outline or the cell values, depending on the object behind it.</p>
 */
public interface MatrixPrinter {

    /**
     * Renders the given matrix as a string.
     *
     * <p>Implementations return a multi-line string; every line, including the last one, is
     * terminated by {@code '\n'}.</p>
     *
     * @param matrix the matrix to render, must not be {@code null}
     * @return the rendering of {@code matrix}
     * @throws IllegalArgumentException if {@code matrix} is {@code null} or holds values the
     *                                  implementation cannot render
     */
    String print(Matrix matrix);
}
