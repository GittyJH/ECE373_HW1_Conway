//------------------------------------------------------
// Homework 1
// Written by: (your name and student ID)
// ECE 373 Object-Oriented Software Design, Section 001 - Fall 2026
// The University of Arizona
//------------------------------------------------------
package edu.arizona.ece373.hw1;

/**
 * A named pattern of live and dead cells that can be stamped onto a {@link GameOfLife} field.
 *
 * <p>Task 3 of the homework. A shape <em>is a</em> {@link Matrix} whose cells are only 0 or 1,
 * plus a name such as {@code "Beehive"}.</p>
 */
public class Shape extends Matrix {

    // TODO: declare the private field `name`.

    /**
     * Creates a named shape from a pattern of zeroes and ones.
     *
     * @param name the name of the shape, must not be {@code null} or blank
     * @param data the pattern, must be a legal matrix body containing only 0 and 1
     * @throws IllegalArgumentException if the name is missing, if {@code data} is not a legal
     *                                  matrix, or if any cell is not 0 or 1
     */
    public Shape(String name, int[][] data) {
        super(data);
        // TODO: check the name, check that every cell is 0 or 1, then store the name.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the name of this shape.
     *
     * @return the shape name
     */
    public String getName() {
        // TODO: return the name.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Renames this shape.
     *
     * @param name the new name, must not be {@code null} or blank
     * @throws IllegalArgumentException if the name is {@code null} or blank
     */
    public void setName(String name) {
        // TODO: check and store the name.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the classic still-life "beehive", a 3x4 pattern that never changes.
     *
     * @return a new beehive shape
     */
    public static Shape beehive() {
        // TODO: return a Shape named "Beehive" holding
        // TODO:   0 1 1 0 / 1 0 0 1 / 0 1 1 0
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the classic still-life "boat", a 3x3 pattern that never changes.
     *
     * @return a new boat shape
     */
    public static Shape boat() {
        // TODO: return a Shape named "Boat" holding
        // TODO:   1 1 0 / 1 0 1 / 0 1 0
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the horizontal phase of the oscillator "blinker", a 1x3 row of live cells.
     *
     * @return a new blinker shape
     */
    public static Shape blinker() {
        // TODO: return a Shape named "Blinker" holding a single row 1 1 1.
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the classic spaceship "glider", a 3x3 pattern that travels one cell down and one
     * cell to the right every four generations.
     *
     * @return a new glider shape
     */
    public static Shape glider() {
        // TODO: return a Shape named "Glider" holding
        // TODO:   0 1 0 / 0 0 1 / 1 1 1
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the still-life "block", a 2x2 square of live cells.
     *
     * @return a new block shape
     */
    public static Shape block() {
        // TODO: return a Shape named "Block" holding
        // TODO:   1 1 / 1 1
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns one phase of the period-two oscillator "toad", a 2x4 pattern.
     *
     * @return a new toad shape
     */
    public static Shape toad() {
        // TODO: return a Shape named "Toad" holding
        // TODO:   0 1 1 1 / 1 1 1 0
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Showcase for Task 3: builds a beehive and a boat and prints both with a
     * {@link BoolMatrixPrinter}.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        // TODO: create a Beehive and a Boat and print them through a MatrixPrinter variable.
        throw new UnsupportedOperationException("TODO");
    }
}
