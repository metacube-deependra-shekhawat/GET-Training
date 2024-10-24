// The objective of this assignment is to design a Hexadecimal Numbers Calculator
// The following class demonstrates the same

import java.util.Scanner;

public class Assignment2A {
   
    /**
     * This method receives a string as input and check whether the string represents a valid hexadecimal
     * number or not and returns an boolean for the same
     * @param hexString which needs to be validated
     * @return a boolean representing the result of validation
     */
    public static boolean isValid(String hexString) {
        for (int i = 0; i < hexString.length(); i++) {
            if ((hexString.charAt(i) >= '0' && hexString.charAt(i) <= '9') || 
            (hexString.charAt(i) >= 'A' && hexString.charAt(i) <= 'F') || 
            (hexString.charAt(i) >= 'a' && hexString.charAt(i) <= 'f')) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * This method takes an hexadecimal number as string as input and then convert the number to
     * an equivalent decimal number and return it
     * @param hexString which needs to converted into integer
     * @return returns the integer value
     */
    public static int toDec(String hexString) {
        int length = hexString.length();
        int number = 0;
        for (int index = 0; index < length; index++) {
            char character = hexString.charAt(index);
            int value;
            if (character <= '9' && character >= '0') {
                value = character - '0';
            } else {
                if(character >= 'A' && character <= 'F'){
                    value = character - 'A' + 10;
                } else {
                    value = character - 'a' + 10;
                }
            }
            number += (value * Math.pow(16, length - index - 1));
        }
        return number;
    }

    /**
     * This method takes an decimal number as integer as input and then convert the number to
     * an equivalent hexadecimal number string and return it
     * @param hexString which needs to converted into integer
     * @return returns the integer value
     */
    public static String toHex(int number) {
        StringBuilder hexString = new StringBuilder();
        if(number == 0) return "0";
        while (number > 0) {
            int remainder = number % 16;
            number /= 16;
            if (remainder < 10) {
                char character = (char) ('0' + remainder);
                hexString.append(character);
            } else {
                remainder -= 10;
                char character = (char) ('A' + remainder);
                hexString.append(character);
            }
        }
        return hexString.reverse().toString();
    }

    /**
     * This method will receive two strings as input and check whether which string is greater and which one is smaller
     * and prints the result
     * @param h1
     * @param h2
     * @return
     */
    public static int compare(String h1, String h2){
        if(h1.length() > h2.length()) return 1;
        else if(h1.length() < h2.length()) return -1;
        else {
            int n = h1.length();
            for(int i = 0; i < n; i++){
                char c1 = h1.charAt(i);
                char c2 = h2.charAt(i);
                int n1 = (c1 <= 'F' && c1 >= 'A') ? 10 + (c1 - 'A') : (c1-'0');
                int n2 = (c2 <= 'F' && c2 >= 'A') ? 10 + (c2 - 'A') : (c2-'0');
                if(n1 == n2) {
                } else if(n1 < n2){
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        }  
    }

     /**
     * This method will receive two Hexadecimal strings and convert them into decimal numbers, add them and 
     * convert the output back to Hexadecimal string and print it
     * @param h1
     * @param h2
     */
    public static void addNumbers(String h1, String h2){
        int num1 = toDec(h1);
        int num2 = toDec(h2);
        int tempOutput = num1+num2;
        String output = toHex(tempOutput);
        System.out.println("Output: " + output);
    }

     /**
     * This method will receive two Hexadecimal strings and convert them into decimal numbers, subtract them and 
     * convert the output back to Hexadecimal string and print it
     * @param h1
     * @param h2
     */
    public static void subtractNumbers(String h1, String h2){
        int num1 = toDec(h1);
        int num2 = toDec(h2);
        if(num1 < num2){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int tempOutput = num1-num2;
        String output = toHex(tempOutput);
        System.out.println("Output: " + output);
    }

     /**
     * This method will receive two Hexadecimal strings and convert them into decimal numbers, multiply them and 
     * convert the output back to Hexadecimal string and print it
     * @param h1
     * @param h2
     */
    public static void multiplyNumbers(String h1, String h2){
        int num1 = toDec(h1);
        int num2 = toDec(h2);
        int tempOutput = num1*num2;
        String output = toHex(tempOutput);
        System.out.println("Output: " + output);
    }

    /**
     * This method will receive two Hexadecimal strings and convert them into decimal numbers, divide them and 
     * convert the output back to Hexadecimal string and print it
     * @param h1
     * @param h2
     */
    public static void divideNumbers(String h1, String h2){
        int num1 = toDec(h1);
        int num2 = toDec(h2);
        int tempOutput = num1/num2;
        String output = toHex(tempOutput);
        System.out.println("Output: " + output);
    }

    /**
     * This method will receive two strings as input and will compare whether which among them is greater and smaller
     * @param h1 String
     * @param h2 String
     */
    public static void compareNumbers(String h1, String h2){
        int res = compare(h1, h2);
        switch (res) {
            case -1 -> System.out.println("First Number is smaller than Second number");
            case 1 -> System.out.println("First Number is greater than Second number");
            default -> System.out.println("Both Numbers are equal");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hexInput1, hexInput2;

        System.out.println("Please enter the first hexadecimal number");
        hexInput1 = scanner.nextLine();
        while (!isValid(hexInput1)) {       // Loop will run up until the user has not provided a correct hexadecimal number as input.
            System.out.println("This is not a valid hexadecimal number, please enter a new number");
            hexInput1 = scanner.nextLine();
        }
        System.out.println("Please enter the second hexadecimal number");
        hexInput2 = scanner.nextLine();
        while (!isValid(hexInput2)) {
            System.out.println("This is not a valid hexadecimal number, please enter a new number");
            hexInput2 = scanner.nextLine();
        }

        int input;
        System.out.println("Type 1 to add two Hexadecimal Numbers");
        System.out.println("Type 2 to subtract two Hexadecimal Numbers");
        System.out.println("Type 3 to multipy two Hexadecimal Numbers");
        System.out.println("Type 4 to divide two Hexadecimal Numbers");
        System.out.println("Type 5 to compare two Hexadecimal Numbers");
        System.out.println("Type 6 to exit");
        input = scanner.nextInt();
        switch (input) {
            case 1 -> addNumbers(hexInput1,hexInput2);
            case 2 -> subtractNumbers(hexInput1,hexInput2);
            case 3 -> multiplyNumbers(hexInput1,hexInput2);
            case 4 -> divideNumbers(hexInput1,hexInput2);
            case 5 -> compareNumbers(hexInput1,hexInput2);
            case 6 -> {
                return;
            }
            default -> System.out.println("Please select a valid option and try again");
        }  
    }
}