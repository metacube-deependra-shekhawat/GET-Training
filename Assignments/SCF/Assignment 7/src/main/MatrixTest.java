package main;
import static org.junit.Assert.*;

import org.junit.Test;
public class MatrixTest {
    @Test
    public void checkTranposeIfEqual(){
        int[][] matInput1 = {{0,0,1},{0,1,2}};
        int[][] matInput2 = {{1,0,2},{0,0,1}};
        Mat inputMatrix = new Mat(2,2,matInput1);
        Mat expectedMatrix = new Mat(2,2,matInput2);
        assertEquals(expectedMatrix.matrixMap,inputMatrix.getTranspose().matrixMap);
    }

    @Test
    public void checkTranposeIfNotEqual(){
        int[][] matInput1 = {{0,0,1},{0,1,2}};
        int[][] matInput2 = {{1,1,2},{0,0,1}};
        Mat inputMatrix = new Mat(2,2,matInput1);
        Mat expectedMatrix = new Mat(2,2,matInput2);
        assertNotEquals(expectedMatrix.matrixMap,inputMatrix.getTranspose().matrixMap);
    }

    @Test
    public void checkSymmetricTrue(){
        int[][] matInput1 = {{0,0,2},{0,2,4},{2,0,4},{1,0,4},{0,1,4},{1,1,5},{1,2,7},{2,1,7}};
        Mat inputMatrix = new Mat(3,3,matInput1);
        assertTrue(inputMatrix.isSymmetric());
    }

    @Test
    public void checkSymmetricFalse(){
        int[][] matInput1 = {{0,0,2},{0,2,4},{1,0,4},{1,1,5},{2,1,7}};
        Mat inputMatrix = new Mat(3,3,matInput1);
        assertFalse(inputMatrix.isSymmetric());
    }

    @Test
    public void multiplicationOfTwoMatrix(){
        int[][] matInput11 = {{0,0,1},{0,1,1},{1,0,2},{1,1,2},{2,0,3},{2,1,3}};
        int[][] matInput12 = {{0,0,1},{0,1,1},{0,2,1},{1,0,2},{1,1,2},{1,2,2}};
        int[][] matOutput = {{0,0,3},{0,1,3},{0,2,3},{1,0,6},{1,1,6},{1,2,6},{2,0,9},{2,1,9},{2,2,9}};
        Mat mat11 = new Mat(3,2,matInput11);
        Mat mat12 = new Mat(2,3,matInput12);
        Mat mat13 = new Mat(3,3,matOutput);
        assertEquals(mat13.matrixMap,Mat.multiplyMatrix(mat11, mat12).matrixMap);
    }
}