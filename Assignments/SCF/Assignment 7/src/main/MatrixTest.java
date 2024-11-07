package main;
import static org.junit.Assert.*;

import org.junit.Test;
public class MatrixTest {
    
    // Test to check out if two matrices are transpose
    @Test
    public void checkTranposeIfEqual(){
        int[][] matInput1 = {{0,0,1},{0,1,2}};
        int[][] matInput2 = {{1,0,2},{0,0,1}};
        Mat inputMatrix = new Mat(2,2,matInput1);
        Mat expectedMatrix = new Mat(2,2,matInput2);
        assertEquals(expectedMatrix.matrixMap,inputMatrix.getTranspose(inputMatrix).matrixMap);
    }

    // Test to check out if two matrices are not transpose
    @Test
    public void checkTranposeIfNotEqual(){
        int[][] matInput1 = {{0,0,1},{0,1,2}};
        int[][] matInput2 = {{1,1,2},{0,0,1}};
        Mat inputMatrix = new Mat(2,2,matInput1);
        Mat expectedMatrix = new Mat(2,2,matInput2);
        assertNotEquals(expectedMatrix.matrixMap,inputMatrix.getTranspose(inputMatrix).matrixMap);
    }

    // Test case for checking if a matrix is symmetric
    @Test
    public void checkSymmetricTrue(){
        int[][] matInput1 = {{0,0,2},{0,2,4},{2,0,4},{1,0,4},{0,1,4},{1,1,5},{1,2,7},{2,1,7}};
        Mat inputMatrix = new Mat(3,3,matInput1);
        assertTrue(inputMatrix.isSymmetric(inputMatrix));
    }

    // Test case for checking if a matrix is not symmetric
    @Test
    public void checkSymmetricFalse(){
        int[][] matInput1 = {{0,0,2},{0,2,4},{1,0,4},{1,1,5},{2,1,7}};
        Mat inputMatrix = new Mat(3,3,matInput1);
        assertFalse(inputMatrix.isSymmetric(inputMatrix));
    }

    // Test case for multiplication of two matrices
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

    // Test case for addition of two matrices
    @Test
    public void additionOfTwoMatrix(){
        int[][] matInput1 = {{0,0,4},{0,2,7},{1,1,5},{1,2,3},{2,2,6}};
        int[][] matInput2 = {{0,0,5},{0,1,3},{1,0,8},{1,2,5},{2,1,5}};
        int[][] matOutput = {{0,0,9},{0,2,7},{0,1,3},{1,1,5},{1,0,8},{1,2,8},{2,1,5},{2,2,6}};
        Mat mat1 = new Mat(3,3,matInput1);
        Mat mat2 = new Mat(3,3,matInput2);
        Mat mat3 = new Mat(3,3,matOutput);
        assertEquals(mat3.matrixMap,Mat.addMatrix(mat1, mat2).matrixMap);
    }
}