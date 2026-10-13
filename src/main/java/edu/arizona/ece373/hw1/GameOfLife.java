//------------------------------------------------------
// Homework 1
// Written by: James Harron (23807128)
// ECE 373 Object-Oriented Software Design, Section 001 - Fall 2026
// The University of Arizona
//------------------------------------------------------
package edu.arizona.ece373.hw1;

/**
 * A Conway's Game of Life field.
 *
 * <p>Task 4 of the homework. The field <em>is a</em> {@link Matrix} in which {@code 1} means the
 * cell is alive and {@code 0} means it is dead. Cells outside the field always count as dead, so
 * the field does not wrap around at the edges.</p>
 *
 * <p>The rules for one generation are:</p>
 * <ul>
 *   <li>a live cell with fewer than two live neighbours dies;</li>
 *   <li>a live cell with two or three live neighbours survives;</li>
 *   <li>a live cell with more than three live neighbours dies;</li>
 *   <li>a dead cell with exactly three live neighbours becomes alive.</li>
 * </ul>
 */
public class GameOfLife extends Matrix {

    /** Value of a cell that is alive. */
    public static final int ALIVE = 1;

    /** Value of a cell that is dead. */
    public static final int DEAD = 0;

    /**
     * Creates an empty game field of the given size; every cell starts dead.
     *
     * @param rows    the height of the field, must be at least 1
     * @param columns the width of the field, must be at least 1
     * @throws IllegalArgumentException if {@code rows} or {@code columns} is less than 1
     */
    public GameOfLife(int rows, int columns) {
        super(rows, columns);
    }

    /**
     * Stamps a shape onto the field with its top-left cell at the given coordinate.
     *
     * @param shape  the shape to place, must not be {@code null}
     * @param row    the field row that receives row 0 of the shape
     * @param column the field column that receives column 0 of the shape
     * @throws IllegalArgumentException if {@code shape} is {@code null}, if the coordinate is
     *                                  negative, or if the shape does not fit entirely on the field
     */
    public void addShape(Shape shape, int row, int column) {
        // Reject null, negative coordinates, and shapes that would stick out of the field;
        if (shape == null) {
            throw new IllegalArgumentException("Shape cannot be null.");
        }
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException("Placement row and column must be non-negative.");
        }
        if (row + shape.getRows() > getRows() || column + shape.getColumns() > getColumns()) {
            throw new IllegalArgumentException("Shape does not fit entirely within the field bounds.");
        }
        // Copies every cell of the shape onto the field.
        for (int r = 0; r < shape.getRows(); r++) {
            for (int c = 0; c < shape.getColumns(); c++) {
                set(row + r, column + c, shape.get(r, c));
            }
        }
    }

    /**
     * Advances the field by one generation.
     *
     * <p>Compute the whole next generation into a local two-dimensional array first, and only
     * then install it with the inherited {@link Matrix#setData(int[][])}.</p>
     */
    public void step() {
        int rows = getRows();
        int cols = getColumns();
        int[][] nextGeneration = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int liveNeighbours = countLiveNeighbours(r, c);
                int currentState = get(r, c);

                if (currentState == ALIVE) {
                    // Underpopulation or Overpopulation -> cell dies; otherwise survives
                    if (liveNeighbours < 2 || liveNeighbours > 3) {
                        nextGeneration[r][c] = DEAD;
                    } else {
                        nextGeneration[r][c] = ALIVE;
                    }
                } else {
                    // Reproduction -> dead cell becomes alive
                    if (liveNeighbours == 3) {
                        nextGeneration[r][c] = ALIVE;
                    } else {
                        nextGeneration[r][c] = DEAD;
                    }
                }
            }
        }

        setData(nextGeneration);
    }

    /**
     * Counts how many of the eight cells around a coordinate are alive.
     *
     * @param row    the row of the cell whose neighbours are counted
     * @param column the column of the cell whose neighbours are counted
     * @return a number between 0 and 8
     */
    public int countLiveNeighbours(int row, int column) {
        int count = 0;
        int totalRows = getRows();
        int totalCols = getColumns();

        for (int rDelta = -1; rDelta <= 1; rDelta++) {
            for (int cDelta = -1; cDelta <= 1; cDelta++) {
                // Skip the cell itself
                if (rDelta == 0 && cDelta == 0) {
                    continue;
                }

                int neighborRow = row + rDelta;
                int neighborCol = column + cDelta;

                // Check grid boundaries (cells outside count as dead)
                if (neighborRow >= 0 && neighborRow < totalRows && neighborCol >= 0 && neighborCol < totalCols) {
                    if (get(neighborRow, neighborCol) == ALIVE) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * Showcase for Task 4: builds a field holding a blinker and a glider and steps it a fixed
     * number of generations.
     *
     * @param args optional; args[0] is the number of generations to run, default 20
     * @throws InterruptedException if the animation is interrupted while sleeping between frames
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Welcome to Conway's Game of Life Simulation ===");
        System.out.println();

        int generations = 20;
        if (args != null && args.length > 0) {
            try {
                generations = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid generation count argument provided. Falling back to default (20).");
            }
        }

        GameOfLife game = new GameOfLife(10, 15);

        // Add a Blinker and a Glider pattern
        game.addShape(Shape.blinker(), 1, 1);
        game.addShape(Shape.glider(), 3, 6);

        MatrixPrinter printer = new BoolMatrixPrinter();

        for (int gen = 0; gen <= generations; gen++) {
            System.out.println("Generation " + gen + ":");
            System.out.print(printer.print(game));

            if (gen < generations) {
                Thread.sleep(300);
                game.step();
            }
        }

        System.out.println();
        System.out.println("=== Game of Life Simulation Completed Successfully ===");
    }
}
