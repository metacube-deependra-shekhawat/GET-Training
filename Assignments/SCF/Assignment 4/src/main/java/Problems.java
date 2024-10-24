package main.java;
import java.util.ArrayList;

public class Problems {

    /**
     * This method will receive an array as input and will return the length of longest mirror subarray present
     * int the array using dynamic programming and will throw Assertion error in case the size of the array is 0
     * @param arr int array
     * @return length of longest mirror subarray
     */
    public int longestMirror(int[] arr){
        int n = arr.length;
        if(n == 0){
            throw new AssertionError("Zero elements present in the array");
        }
        int ans = 0;
        int[][] dp = new int[n+1][n+1];
        int[] rarr = new int[n];
        for(int i = 0; i < n; i++){
            rarr[i] = arr[n-i-1];
        }
        int maxm = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr[i] == rarr[j])
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                maxm = Math.max(maxm, dp[i][j]);
            }
        }
        return maxm;   
    }    

    /**
     * This method will receive an array of integers and find out the position
     * where the sum of elements before this position will be equal to sum of elements
     * after this position
     * @param arr int array
     * @return integer which is the position asked for
     */
    public int splitArray(int[] arr){
        int n = arr.length;
        if(n == 0){
            throw new AssertionError("Zero elements present in the array");
        }
        int totalSum = arr[0];
        for(int i = 1; i < n; i++){
            totalSum += arr[i];
        }
        if(totalSum % 2 != 0){
            return -1;
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == totalSum/2){
                return i+1;
            }
        }
        return -1;
    }

    /**
     * This method will receive an array, and two integers as input and will
     * try to fix the position of all Y valued elements present in the array 
     * right next to X and then returns the modified array and if it is not
     * possible it will return an empty array
     * @param arr int[]
     * @param x int
     * @param y int
     * @return
     */
    public int[] fixXY(int[] arr, int x, int y){
        if(arr.length == 0){
            throw new AssertionError("No elements present in the array");
        }
        if(arr[arr.length-1] == x){
            throw new AssertionError("x cannot be at the end.");
        }
        ArrayList<Integer> xIndex = new ArrayList<>();       
        ArrayList<Integer> yIndex = new ArrayList<>();       
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x){
                if(i < arr.length && arr[i] == arr[i+1]){
                    throw new AssertionError("Two consecutive x's are not allowed.");
                }
                xIndex.add(i);
            } else if(arr[i] == y){
                yIndex.add(i);
            }
        }
        if(xIndex.size() != yIndex.size()){
            throw new AssertionError("The number of x's and y's must be equal");
        }
        int sz = xIndex.size();
        while(sz > 0){
            sz--;
            int yInd = yIndex.get(sz);
            int xInd = xIndex.get(sz);
            xIndex.remove(sz);
            yIndex.remove(sz);
            if(yInd != xInd+1){
                int temp = arr[xInd+1];
                arr[xInd+1] = arr[yInd];
                arr[yInd] = temp;
            }
        }
        return arr;
    }

    /**
     * This method will receive an array as input and will find out the number of
     * clums present in the array
     * @param arr int[]
     * @return int which is the number of clums present in the array
     */
    public int findClums(int[] arr){
        int n = arr.length;
        if(n == 0){
            throw new AssertionError("Array is empty");
        }
        int i = 0;
        int ans = 0;
        while(i < n-1){
            if(i < n-1 && arr[i] == arr[i+1]){
                ans++;
                while(i < n-1 && arr[i] == arr[i+1]){
                    i++;
                }
            }
            i++;
        } 
        return ans;
    }
}