package test.java;

import main.NQueens;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NQueensTests {
    @Test
    public void testNQueen4() {
        NQueens nQueens = new NQueens(4);
        assertTrue(nQueens.solveNQueens());
    }

    @Test
    public void testNQueen8() {
        NQueens nQueens = new NQueens(8);
        assertTrue(nQueens.solveNQueens());
    }

    @Test
    public void testNQueen2() {
        NQueens nQueens = new NQueens(2);
        assertFalse(nQueens.solveNQueens());
    }

    @Test
    public void testNQueen3() {
        NQueens nQueens = new NQueens(3);
        assertFalse(nQueens.solveNQueens());
    }

    @Test
    public void testNQueen1() {
        NQueens nQueens = new NQueens(1);
        assertTrue(nQueens.solveNQueens());
    }

}
