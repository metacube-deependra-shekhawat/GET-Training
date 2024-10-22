import java.util.Scanner;

public class Assignment3A {

    /*
     * This method will first scan two strings and then compare them whether if they are equal or not
     * print 0 in case the strings are not eqaul or 1 if equal
     */
    public static void compareStrings(){
        Scanner scanner = new Scanner(System.in);
        String s1,s2;
        System.out.println("Please enter the first string");
        s1 = scanner.nextLine();
        System.out.println("Please enter the second string");
        s2 = scanner.nextLine();
        if(s1.length() != s2.length()){
            System.out.println(0);
        } else {
            for(int i = 0; i < s1.length(); i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    System.out.println(0);
                    return;
                }
            }
            System.out.println(1);
        }
    }

    /*
     * This method will first scan a string, reverse it and then print it to the console
     */
    public static void reverseString(){
        Scanner scanner = new Scanner(System.in);
        String s;
        s = scanner.nextLine();
        StringBuffer sb = new StringBuffer(s);
        int l = 0, r = sb.length()-1;
        while(l < r){
            char leftChar = sb.charAt(l);
            char rightChar = sb.charAt(r);
            sb.setCharAt(r, leftChar);
            sb.setCharAt(l, rightChar);
        }
        s = sb.toString();
        System.out.println(s);
    }

    /**
     * This method will first scan a string, toggle the cases for every character in a string
     * and the print it to the console
     */
    public static void toggleCases(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuffer sb = new StringBuffer(s);
        for(int i = 0; i < sb.length(); i++){
            char ch = sb.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                ch -= 32;
            } else if(ch >= 'A' && ch <= 'Z'){
                ch += 32;
            }
            sb.setCharAt(i, ch);
        }
        s = sb.toString();
        System.out.println(s);
    }

    /*
     * This method will first scan a string as input and find the longest word in the string
     * and print that word to the console
     */
    public static void findLongest(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = 0, j = 0, n = s.length();
        int maxLen = 0;
        String ans = "";
        while(j < n){
            while(j < n && s.charAt(j) != ' ') j++;
            if(j-i > maxLen){
                ans = s.substring(i,j-1);
                maxLen = j-i;
            }
            i = j+1;
            j++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        System.out.println("Please select one of following operations:");
        System.out.println("Select 1 to check if two strings are equal");
        System.out.println("Select 2 to reverse a string");
        System.out.println("Select 3 to toggle the cases of characters in a string");
        System.out.println("Select 4 to find the word with longest length in a string");
        input = scanner.nextInt();
        switch (input) {
            case 1:
                compareStrings();
                break;
            case 2:
                reverseString();
                break;
            case 3:
                toggleCases();
                break;
            case 4:
                findLongest();
                break;
            default:
                System.out.println("Not a valid input");
        }
    }
}