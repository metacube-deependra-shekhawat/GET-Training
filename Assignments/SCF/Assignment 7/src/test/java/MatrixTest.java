package test.java;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Mat;

import static org.junit.jupiter.api.Assertions.*;

class MatTest {
    private Mat mat1;
    private Mat mat2;

    @BeforeEach
    void setUp() {
        int[][] input1 = {
            {0, 0, 1},
            {0, 1, 2},
            {1, 0, 3},
            {1, 1, 4}
        };
        mat1 = new Mat(2, 2, input1);

        int[][] input2 = {
            {0, 0, 5},
            {0, 1, 6},
            {1, 0, 7},
            {1, 1, 8}
        };
        mat2 = new Mat(2, 2, input2);
    }

    @Test
    void testAddMatrix() {
        Mat result = Mat.addMatrix(mat1, mat2);
        assertEquals(6, result.matrixMap.get(0 * 999 + 0));
        assertEquals(8, result.matrixMap.get(0 * 999 + 1));
        assertEquals(10, result.matrixMap.get(1 * 999 + 0));
        assertEquals(12, result.matrixMap.get(1 * 999 + 1));
    }

    @Test
    void testMultiplyMatrix() {
        int[][] input3 = {
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 0},
            {1, 1, 1}
        };
        Mat mat3 = new Mat(2, 2, input3);
        Mat result = Mat.multiplyMatrix(mat1, mat3);
        assertEquals(1, result.matrixMap.get(0 * 999 + 0));
        assertEquals(2, result.matrixMap.get(0 * 999 + 1));
        assertEquals(3, result.matrixMap.get(1 * 999 + 0));
        assertEquals(4, result.matrixMap.get(1 * 999 + 1));
    }

    @Test
    void testGetTranspose() {
        Mat transposed = mat1.getTranspose(mat1);
        assertEquals(1, transposed.matrixMap.get(0 * 999 + 0));
        assertEquals(3, transposed.matrixMap.get(0 * 999 + 1));
        assertEquals(2, transposed.matrixMap.get(1 * 999 + 0));
        assertEquals(4, transposed.matrixMap.get(1 * 999 + 1));
    }

    @Test
    void testIsSymmetric() {
        assertTrue(mat1.isSymmetric(mat1));
        int[][] input4 = {
            {0, 0, 1},
            {0, 1, 2},
            {1, 0, 2},
            {1, 1, 1}
        };
        Mat mat4 = new Mat(2, 2, input4);
        assertFalse(mat4.isSymmetric(mat4));
    }

    @Test
    void testAddMatrixDimensionMismatch() {
        int[][] input5 = {
            {0, 0, 1},
            {0, 1, 2}
        };
        Mat mat5 = new Mat(1, 2, input5);
        assertThrows(AssertionError.class, () -> Mat.addMatrix(mat1, mat5));
    }

    @Test
    void testMultiplyMatrixDimensionMismatch() {
        int[][] input6 = {
            {0, 0, 1},
            {1, 0, 2}
        };
        Mat mat6 = new Mat(2, 1, input6);
        assertThrows(AssertionError.class, () -> Mat.multiplyMatrix(mat1, mat6));
    }
}
