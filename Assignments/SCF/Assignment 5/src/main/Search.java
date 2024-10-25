package main;

import java.util.Arrays;

public class Search {
    /**
     * This is a recursive implementation of linear search will receive three inputs: an array, an index, and a target
     * @param arr the array in which the searching is taking place
     * @param ind the current index being searched for
     * @param target target to be found
     * @return the index of the target
     */
    public int lSearch(int[] arr, int ind, int target){
        if(ind == arr.length){
            return -1;
        } 
        if(arr[ind] == target){
            return ind;
        }
        return lSearch(arr,ind+1,target);
    }
    /**
     * This is a recursive implementation of binary search will receive four inputs: an array, intger l, intger r, and a target
     * @param arr the array in which the searching is taking place
     * @param l the left pointer of the array
     * @param r the right pointer of the array
     * @param target target to be found
     * @return the index of the target
     */
    public int bSearch(int[] arr, int l, int r, int target){
        if(l > r){
            return -1;
        }
        int mid = l + (r-l)/2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] > target){
            return bSearch(arr,l,mid-1,target);
        } else {
            return bSearch(arr, l+1, r, target);
        }
    }

    /**
     * Starter method for linear search
     * @param arr array in which the searching is taking place
     * @param target intger which is needed to be found
     * @return return index of the target
     */
    public int linearSearch(int[] arr, int target){
        if(arr.length == 0){
            throw new AssertionError("Array is Empty");
        }
        return lSearch(arr,0,target);
    }

    /**
     * Starter method for binary search
     * @param arr array in which the searching is taking place
     * @param target intger which is needed to be found
     * @return return index of the target
     */
    public int binarySearch(int[] arr, int target){
        if(arr.length == 0){
            throw new AssertionError("Array is Empty");
        }
        Arrays.sort(arr);
        return bSearch(arr,0,arr.length-1,target);
    }

    public static void main(String[] args) {
        Search search = new Search();
        int[] arr = {1,4,3,5,4,3,7,5,2,6};
        System.out.println(search.binarySearch(arr, 6));
        System.out.println(search.linearSearch(arr, 6));
    }
}
