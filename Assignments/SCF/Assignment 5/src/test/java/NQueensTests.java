package test.java;

import main.NQueens;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NQueensTests {
    @Test
    public void fourQueens() {
        NQueens nQueens = new NQueens(4);
        assertTrue(nQueens.solveNQueens());
    }

    @Test
    public void eightQueens() {
        NQueens nQueens = new NQueens(8);
        assertTrue(nQueens.solveNQueens());
    }

    @Test
    public void twoQueens() {
        NQueens nQueens = new NQueens(2);
        assertFalse(nQueens.solveNQueens());
    }

    @Test
    public void threeQueens() {
        NQueens nQueens = new NQueens(3);
        assertFalse(nQueens.solveNQueens());
    }

    @Test
    public void oneQueen() {
        NQueens nQueens = new NQueens(1);
        assertTrue(nQueens.solveNQueens());
    }

}
