# Homework 1 — Conway's Game of Life (starter)

ECE 373 — Object-Oriented Software Design · The University of Arizona · Fall 2026
Instructor: Jingdi Chen

This is the skeleton you start from. Every class and method the handout asks for is already
declared with the right signature; the bodies throw `UnsupportedOperationException("TODO")` and
carry a `// TODO:` comment saying what to implement. The project compiles as handed out, and it
keeps compiling while you work.

## Layout

```
src/main/java/edu/arizona/ece373/hw1/
    Matrix.java                 Task 1  the int matrix, with a private data field
    MatrixPrinter.java          Task 2  interface: Matrix -> String
    MatrixOutlinePrinter.java   Task 2  draws the frame, delegates the inside to printRow
    BoolMatrixPrinter.java      Task 2  overrides printRow to draw 0/1 values
    Shape.java                  Task 3  a named 0/1 Matrix (Beehive, Boat, Blinker, Glider)
    GameOfLife.java             Task 4  the game field: addShape, step, main
src/test/java/edu/arizona/ece373/hw1/
    MatrixTest.java
    MatrixPrinterTest.java
    GameOfLifeTest.java
```

## Suggested order of work

1. `Matrix` — the two constructors, the validation, `getRows`/`getColumns`, `get`/`set`.
   Run `MatrixTest`; it should go green.
2. `MatrixPrinter` + `MatrixOutlinePrinter` — build the frame in `print` and the blank inside in
   `printRow`. Then `BoolMatrixPrinter`, which overrides **only** `printRow`. Run
   `MatrixPrinterTest`.
3. `Shape` — extend `Matrix`, add the name, check the 0/1 rule, write the factory methods and the
   `main` that prints a Beehive and a Boat.
4. `GameOfLife` — `countLiveNeighbours`, then `step`, then `addShape`, then the animated `main`.
   Run `GameOfLifeTest`.

## The exact output format (this is graded)

The handout shows the pictures but not the characters, so the format is fixed here and the
supplied tests depend on it. For an *R* × *C* matrix `print` returns *R* + 2 lines, **each ending
in `\n`, including the last one**:

```
+----+        <- '+', C times '-', '+'
|    |        <- '|', the C characters returned by printRow, '|'
|    |
+----+
```

`MatrixOutlinePrinter.printRow` returns `C` blanks. `BoolMatrixPrinter.printRow` returns `C`
characters, `'0'` or `'1'`, and throws `IllegalArgumentException` if it meets any other value.

So a 2×4 matrix whose rows both hold `0, 0, 1, 0` prints as

```
+----+
|0010|
|0010|
+----+
```

## Game rules used by `step`

Cells outside the field always count as dead (the field does **not** wrap around).

* a live cell with fewer than 2 live neighbours dies;
* a live cell with 2 or 3 live neighbours survives;
* a live cell with more than 3 live neighbours dies;
* a dead cell with exactly 3 live neighbours becomes alive.

Compute the whole next generation into a **local** array and install it with `setData` at the
end. If you write new values straight into the field, later cells in the same sweep are judged
against a half-updated generation and the oscillators break.

## Tests

`MatrixTest`, `MatrixPrinterTest` and `GameOfLifeTest` already contain the tests the handout
names, including the two Blinker + Glider generation checks used for grading. They fail until you
implement the classes — that is expected. The methods marked `@Disabled` are the ones you are
asked to write yourself: delete the annotation and fill in the body.

Run everything with:

```
mvn test
```

## What you still have to add yourself

* **CheckStyle.** The handout requires you to add the CheckStyle plugin to `pom.xml` so that
  `mvn test` writes a report into `target/`, fix 3–5 of its suggestions, and commit that fix with
  the message `improved code convention` as your last commit. The starter `pom.xml` deliberately
  does not contain the plugin; wiring it up is part of the assignment.
* **JavaDoc** on every public class and method you add.
* **Atomic commits** in a Git repository hosted on GitHub. The commit history is graded.
* Fill in `// Written by: (your name and student ID)` in the header of every file, and name your
  project `Homework1_{FullName}`.
