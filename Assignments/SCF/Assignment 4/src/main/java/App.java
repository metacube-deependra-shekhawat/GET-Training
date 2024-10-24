package main.java;

public class App {
    public static void main(String[] args) throws Exception {
        Problems prob = new Problems();
        int arr[] = {1,2,3,4,5,5,3,2,1};
        int ans = prob.longestMirror(arr);
        System.out.println(ans);
    }
}
