package main;

public class Factors {

    /**
     * This function will receive three integers as input: x, y, and fact and will return the lcm of x and y
     * @param x first integer number
     * @param y second integer number
     * @param fact potential common factor
     * @return integer lcm of x and y
     */
    public int findLCM(int x, int y, int multiple) { // num1 * num2 = lcm * hcf     5,7 -> fun(5,7,7)->fun(5,7,1)->fun(5,7,35)
        if (x == 0 || y == 0) {
            throw new AssertionError("Cannot compute LCM for zero values.");
        }
        if (multiple % x == 0 && multiple % y == 0) {
            return multiple;
        }
        return findLCM(x, y, multiple + 1);
    }

    /**
     * This method will receive two integer values x and y and return their hcf
     * @param x first interger number
     * @param y second integer number
     * @return integer hcf of x and y
     */
    public int findHCF(int x, int y){
        if(x < 0 || y < 0) return findHCF(Math.abs(x), Math.abs(y));
        if(x == 0) return y;
        if(y == 0) return x;
        if(x >= y){
            return findHCF(x%y,y);
        } else {
            return findHCF(y,x);
        }
    }

    public static void main(String[] args) {
        Factors factor = new Factors();
        int hcf = factor.findHCF(10,7);
        int lcm = factor.findLCM(5, 20, 1);
        System.out.println(hcf);
        System.out.println(lcm);
    }

}
