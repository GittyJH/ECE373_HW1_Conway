//------------------------------------------------------
// Homework 1
// Written by: James Harron (23807128)
// ECE 373 Object-Oriented Software Design, Section 001 - Fall 2026
// The University of Arizona
//------------------------------------------------------
package edu.arizona.ece373.hw1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link GameOfLife} (Task 4).
 *
 * <p>The handout asks for a game initialized with a Blinker and a Glider that is checked after
 * one step and after ten steps. Those two tests are supplied and are used for grading, so your
 * printer must produce exactly the strings below. The {@code @Disabled} methods are yours.</p>
 */
class GameOfLifeTest {

    /** The printer used to compare whole generations as strings. */
    private final MatrixPrinter printer = new BoolMatrixPrinter();

    /** A 12x12 field holding a horizontal blinker at (1,1) and a glider at (5,5). */
    private GameOfLife game;

    /** Builds the standard blinker-and-glider game before every test. */
    @BeforeEach
    void setUp() {
        game = new GameOfLife(12, 12);
        game.addShape(Shape.blinker(), 1, 1);
        game.addShape(Shape.glider(), 5, 5);
    }

    @Test
    @DisplayName("after one step the game field changed as expected")
    void fieldAfterOneStep() {
        game.step();
        String expected = ""
                + "+------------+\n"
                + "|001000000000|\n"
                + "|001000000000|\n"
                + "|001000000000|\n"
                + "|000000000000|\n"
                + "|000000000000|\n"
                + "|000000000000|\n"
                + "|000001010000|\n"
                + "|000000110000|\n"
                + "|000000100000|\n"
                + "|000000000000|\n"
                + "|000000000000|\n"
                + "|000000000000|\n"
                + "+------------+\n";
        assertEquals(expected, printer.print(game));
    }

    @Test
    @DisplayName("after ten steps the game field changed as expected")
    void fieldAfterTenSteps() {
        for (int i = 0; i < 10; i++) {
            game.step();
        }
        String expected = ""
                + "+------------+\n"
                + "|000000000000|\n"
                + "|011100000000|\n"
                + "|000000000000|\n"
                + "|000000000000|\n"
                + "|000000000000|\n"
                + "|000000000000|\n"
                + "|000000000000|\n"
                + "|000000000000|\n"
                + "|000000000100|\n"
                + "|000000010100|\n"
                + "|000000001100|\n"
                + "|000000000000|\n"
                + "+------------+\n";
        assertEquals(expected, printer.print(game));
    }

    @Test
    @DisplayName("addShape rejects a shape that does not fit on the field")
    void addShapeRejectsShapesThatDoNotFit() {
        GameOfLife small = new GameOfLife(5, 5);
        assertThrows(IllegalArgumentException.class, () -> small.addShape(Shape.glider(), 3, 0));
        assertThrows(IllegalArgumentException.class, () -> small.addShape(Shape.glider(), 0, 3));
        assertThrows(IllegalArgumentException.class, () -> small.addShape(Shape.glider(), -1, 0));
    }

    @Test
    @DisplayName("a still life does not change")
    void stillLifeDoesNotChange() {
        GameOfLife game = new GameOfLife(6, 6);
        game.addShape(Shape.beehive(), 1, 1);

        MatrixPrinter printer = new BoolMatrixPrinter();
        String initialRender = printer.print(game);

        // Step through multiple generations
        for (int i = 0; i < 5; i++) {
            game.step();
        }

        // Verify the state remains identical to the initial pattern
        assertEquals(initialRender, printer.print(game));
    }

    @Test
    @DisplayName("a lone live cell dies of underpopulation")
    void loneCellDies() {
        GameOfLife game = new GameOfLife(3, 3);

        // Switch on a single cell in the center
        game.set(1, 1, GameOfLife.ALIVE);

        // Advance by one generation
        game.step();

        // Verify all cells are dead (0)
        for (int r = 0; r < game.getRows(); r++) {
            for (int c = 0; c < game.getColumns(); c++) {
                assertEquals(GameOfLife.DEAD, game.get(r, c),
                        String.format("Expected dead cell at (%d, %d)", r, c));
            }
        }
    }
}
