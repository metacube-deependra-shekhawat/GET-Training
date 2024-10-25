import java.util.Scanner;

public class StringOps {

    /**
     * This method will receive two strings as input and compare them whether they are eqaual or not
     * if equal this method will return 1 else 0
     * @param s1 String
     * @param s2 String
     * @return int
     */
    public static int compareStrings(String s1, String s2){
        if(s1.length() != s2.length()){
            return 0;
        } else {
            for(int i = 0; i < s1.length(); i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    return 0;
                }
            }
        }
        return 1;
    }

    /**
     * This method will receive string as input and reverse it and return it back
     * @param s String
     * @return String
     */
    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = sb.length()-1;
        while(l < r){
            char leftChar = sb.charAt(l);
            char rightChar = sb.charAt(r);
            sb.setCharAt(r, leftChar);
            sb.setCharAt(l, rightChar);
            l++;
            r--;
        }
        s = sb.toString();
        return s;
    }

    /**
     * This method will toggle the cases of every character in a string say a->A and A->a and return the string
     * @param s String
     * @return String
     */
    public static String toggleCases(String s){
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length(); i++){
            char ch = sb.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                ch -= 32; //a->97 A->65
            } else if(ch >= 'A' && ch <= 'Z'){
                ch += 32;
            }
            sb.setCharAt(i, ch);
        }
        s = sb.toString();
        return s;
    }

    /**
     * This method will find the word with the longest length in the given string
     * @param s String
     * @return String
     */
    public static String findLongest(String s){
        int i = 0, j = 0, n = s.length();
        int maxLen = 0;
        String ans = "";
        while(j < n){
            while(j < n && s.charAt(j) != ' ') j++;
            if(j-i >= maxLen){
                ans = s.substring(i,j);
                maxLen = j-i;
            }
            while(j < n && s.charAt(j) == ' '){
                j++;
            }
            i = j;
        }
        return ans;
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
        scanner.nextLine();
        switch (input) {
            case 1 -> {
                String s1,s2;
                System.out.print("Please enter the first string: ");
                s1 = scanner.nextLine();
                System.out.print("Please enter the second string: ");
                s2 = scanner.nextLine();
                System.out.println(compareStrings(s1,s2));
            }
            case 2 -> {
                System.out.print("Please enter the string to reverse: ");
                String sr = scanner.nextLine();
                System.out.println();
                System.out.println(reverseString(sr));
            }
            case 3 -> {
                System.out.print("Please enter the string to toggle: ");
                String st = scanner.nextLine();
                System.out.println();
                System.out.println(toggleCases(st));
            }
            case 4 -> {
                System.out.println("Please enter the string to find the longest word in it");
                String sw = scanner.nextLine();
                System.out.println();
                System.out.println(findLongest(sw));
            }
            default -> System.out.println("Not a valid input");
        }
    }
}