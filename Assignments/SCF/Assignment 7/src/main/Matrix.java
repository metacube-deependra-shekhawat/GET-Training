package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

final class Mat{
    final public HashMap<Integer, Integer> matrixMap;
    private final static int N = 999;
    private final int row,col;
    Mat(int row, int col, int[][] input){
        this.row = row;
        this.col = col;
        matrixMap = new HashMap<>();
        // HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int[] input1 : input) {
            int val = input1[0] * N + input1[1];
            matrixMap.put(val, input1[2]);
        }
        // matrixMap = (HashMap<Integer, Integer>) Map.copyOf(map);
    }

    public Mat getTranspose(Mat mat){
        int[][] newInput = new int[mat.matrixMap.size()][3];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : mat.matrixMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            int r = key/N;
            int c = key%N;
            newInput[i][0] = c;
            newInput[i][1] = r;
            newInput[i++][2] = value;
        }
        return new Mat(row,col,newInput);
    }

    public boolean isSymmetric(Mat mat){
        for(Map.Entry<Integer, Integer> entry: mat.matrixMap.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            int r = key/N;
            int c = key%N;
            int newKey = c*N+r;
            if(mat.matrixMap.containsKey(newKey)){
                if(!Objects.equals(mat.matrixMap.get(newKey), value)){
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    static public Mat addMatrix(Mat mat1, Mat mat2){
        if(mat1.row != mat2.row && mat1.col != mat2.col){
            throw new AssertionError("Dimension of the matrices are not same");
        }
        HashMap<Integer,Integer> map = new HashMap(); 
        for(Map.Entry<Integer, Integer> entry: mat1.matrixMap.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            map.put(key,value);
        }
        for(Map.Entry<Integer, Integer> entry: mat2.matrixMap.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(map.containsKey(key)){
                map.put(key,map.get(key)+value);
            } else {
                map.put(key,value);
            }
        }
        int n = map.size();
        int[][] newInput = new int[n][3];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            int r = key/N;
            int c = key%N;
            newInput[i][0] = r;
            newInput[i][1] = c;
            newInput[i++][2] = value;
        }
        return new Mat(mat1.row,mat1.col,newInput);
    }

    static public Mat multiplyMatrix(Mat mat1, Mat mat2){
        if(mat1.col != mat2.row){
            throw new AssertionError("Multiplication not possible");
        }
        HashMap<Integer,Integer> map = new HashMap(); 
        for(int i = 0; i < mat1.row; i++){
            for(int j = 0; j <= mat1.col; j++){
                for(int k = 0; k < mat2.col; k++){
                    int mat1Key = i*N+k;
                    int mat2Key = k*N+j;
                    if(!mat1.matrixMap.containsKey(mat1Key) || !mat2.matrixMap.containsKey(mat2Key)) continue;
                    int newKey = i*N+j;
                    int sum = mat1.matrixMap.get(mat1Key) * mat2.matrixMap.get(mat2Key);
                    if(map.containsKey(newKey)){
                        map.put(newKey,map.get(newKey)+sum);
                    } else {
                        map.put(newKey,sum);
                    }
                }
            }
        }
        int n = map.size();
        int[][] newInput = new int[n][3];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            int r = key/N;
            int c = key%N;
            newInput[i][0] = r;
            newInput[i][1] = c;
            newInput[i++][2] = value;
        }
        return new Mat(mat1.row,mat2.col,newInput);
    }

    public void display(){
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                int key = i*N+j;
                if(this.matrixMap.containsKey(key)){
                    System.out.print(this.matrixMap.get(key) + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
};

public class Matrix {
    public static void main(String[] args) {
        int n1 = 3, m1 = 3;
        int n2 = 3, m2 = 3;
        int[][] matInput1 = {{0,0,4},{0,2,7},{1,1,5},{1,2,3}};
        int[][] matInput2 = {{0,0,5},{0,1,3},{1,0,8},{1,2,5}};
        Mat mat1 = new Mat(2,3,matInput1);
        Mat mat2 = new Mat(2,3,matInput2);
        Mat mat3 = Mat.addMatrix(mat1, mat2);
        System.out.println("Addition");
        mat3.display();
        System.out.println();
        int[][] matInput11 = {{0,0,1},{0,1,1},{1,0,2},{1,1,2},{2,0,3},{2,1,3}};
        int[][] matInput12 = {{0,0,1},{0,1,1},{0,2,1},{1,0,2},{1,1,2},{1,2,2}};
        Mat mat11 = new Mat(3,2,matInput11);
        Mat mat12 = new Mat(2,3,matInput12);
        Mat mat13 = Mat.multiplyMatrix(mat11, mat12);
        System.out.println("Multiplication");
        mat13.display();
    }
}
