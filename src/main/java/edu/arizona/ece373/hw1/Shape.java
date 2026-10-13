//------------------------------------------------------
// Homework 1
// Written by: James Harron (23807128)
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

    // Declares the private field `name`.
    private String name;

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
        // Checks the name, checks that every cell is 0 or 1, then stores the name.
        validateName(name);
        validateBinaryCells();
        this.name = name;
    }

    /**
     * Returns the name of this shape.
     *
     * @return the shape name
     */
    public String getName() {
        return name;
    }

    /**
     * Renames this shape.
     *
     * @param name the new name, must not be {@code null} or blank
     * @throws IllegalArgumentException if the name is {@code null} or blank
     */
    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    /**
     * Returns the classic still-life "beehive", a 3x4 pattern that never changes.
     *
     * @return a new beehive shape
     */
    public static Shape beehive() {
        // Returns a Shape named "Beehive" holding
        //  0 1 1 0 / 1 0 0 1 / 0 1 1 0
        int[][] pattern = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 0}
        };
        return new Shape("Beehive", pattern);
    }

    /**
     * Returns the classic still-life "boat", a 3x3 pattern that never changes.
     *
     * @return a new boat shape
     */
    public static Shape boat() {
        // Returns a Shape named "Boat" holding
        //  1 1 0 / 1 0 1 / 0 1 0
        int[][] pattern = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        return new Shape("Boat", pattern);
    }

    /**
     * Returns the horizontal phase of the oscillator "blinker", a 1x3 row of live cells.
     *
     * @return a new blinker shape
     */
    public static Shape blinker() {
        // Returns a Shape named "Blinker" holding a single row 1 1 1.
        int[][] pattern = {
                {1, 1, 1}
        };
        return new Shape("Blinker", pattern);
    }

    /**
     * Returns the classic spaceship "glider", a 3x3 pattern that travels one cell down and one
     * cell to the right every four generations.
     *
     * @return a new glider shape
     */
    public static Shape glider() {
        // Returns a Shape named "Glider" holding
        //  0 1 0 / 0 0 1 / 1 1 1
        int[][] pattern = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}
        };
        return new Shape("Glider", pattern);
    }

    /**
     * Returns the still-life "block", a 2x2 square of live cells.
     *
     * @return a new block shape
     */
    public static Shape block() {
        // Returns a Shape named "Block" holding
        //  1 1 / 1 1
        int[][] pattern = {
                {1, 1},
                {1, 1}
        };
        return new Shape("Block", pattern);
    }

    /**
     * Returns one phase of the period-two oscillator "toad", a 2x4 pattern.
     *
     * @return a new toad shape
     */
    public static Shape toad() {
        // Returns a Shape named "Toad" holding
        //  0 1 1 1 / 1 1 1 0
        int[][] pattern = {
                {0, 1, 1, 1},
                {1, 1, 1, 0}
        };
        return new Shape("Toad", pattern);
    }

    /**
     * Showcase for Task 3: builds a beehive and a boat and prints both with a
     * {@link BoolMatrixPrinter}.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        Shape beehive = Shape.beehive();
        Shape boat = Shape.boat();

        MatrixPrinter printer = new BoolMatrixPrinter();

        System.out.println(beehive.getName() + ":");
        System.out.print(printer.print(beehive));

        System.out.println(boat.getName() + ":");
        System.out.print(printer.print(boat));
    }

    /**
     * Validates that the provided name is non-null and non-blank.
     *
     * @param name the string to check
     * @throws IllegalArgumentException if {@code name} is {@code null} or empty/whitespace
     */
    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Shape name must not be null or blank.");
        }
    }

    /**
     * Validates that every cell in the underlying matrix is either 0 or 1.
     *
     * @throws IllegalArgumentException if any cell value is not 0 or 1
     */
    private void validateBinaryCells() {
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getColumns(); c++) {
                int val = get(r, c);
                if (val != 0 && val != 1) {
                    throw new IllegalArgumentException(
                            String.format("Shape cells must be 0 or 1, found %d at (%d, %d).", val, r, c)
                    );
                }
            }
        }
    }
}
