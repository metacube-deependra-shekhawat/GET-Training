import java.util.Scanner;

public class Assignment2A {
   
    // This method will check if the given hexadecimal input is correct or not.
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

    // This method will convert the Hexadecimal string to a decimal number and returns it.
    public static int toDec(String hexString) {
        int length = hexString.length();
        int number = 0;
        for (int index = 0; index < length; index++) {
            char character = hexString.charAt(index);
            int value;
            if (character <= '9' && character >= '0') {
                value = character - '0';
            } else {
                if(character >= 'A' && character <= 'B'){
                    value = character - 'A' + 10;
                } else {
                    value = character - 'a' + 10;
                }
            }
            number += (value * Math.pow(16, length - index - 1));
        }
        return number;
    }

    // This method will convert a decimal number to a hexadecimal string and returns it.
    public static String toHex(int number) {
        StringBuilder hexString = new StringBuilder();
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

    // This method will compare two hexadecimal numbers
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
            if(n1 == n2) continue;
            else if(n1 < n2){
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
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

        int decimalValue1 = toDec(hexInput1);
        int decimalValue2 = toDec(hexInput2);
        if (decimalValue1 < decimalValue2) {
            int temp = decimalValue1;
            decimalValue1 = decimalValue2;
            decimalValue2 = temp;
        }

        int sum = decimalValue1 + decimalValue2;
        int difference = decimalValue1 - decimalValue2;
        int product = decimalValue1 * decimalValue2;
        int quotient = decimalValue1 / decimalValue2;

        String hexSum = toHex(sum);
        String hexDifference = toHex(difference);
        String hexProduct = toHex(product);
        String hexQuotient = toHex(quotient);

        System.out.println(hexSum + " " + hexDifference + " " + hexProduct + " " + hexQuotient);
    }
}