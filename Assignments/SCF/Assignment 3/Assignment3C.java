import java.util.Scanner;

class Assignment3C {

    /**
     * This method will receive two parameters as arguments of type 'double' and calculate
     * the area of a triangle and returns a double value
     * @param height
     * @param width
     * @return double
     */
    public static double calculateAreaTriangle(double height, double width){
        double area = (double)(height/2)*width;
        return area;
    }

    /**
     * This method will receive one argument of type 'double' and calculate the area of 
     * a square and return a double value
     * @param side
     * @return double
     */
    public static double calculateAreaSquare(double side){
        double area = (double)(side * side);
        return area;
    }

    /**
     * This method will receive two argument of type 'double' and calculate the area of 
     * a rectangle and return a double value
     * @param length
     * @param width
     * @return double
     */
    public static double calculateAreaRectangle(double length, double width){
        double area = (double)(length * width);
        return area;
    }

    /**
     * This method will receive one argument of type 'double' and calculate the area of 
     * a circle and return a double value
     * @param radius
     * @return double
     */
    public static double calculateAreaCircle(double radius){
        double area = (double)(radius * radius * 3.14);
        return area;
    }
    public static void main(String[] args) {
        int choice;
        Scanner scn = new Scanner(System.in);
        System.out.println("Select a shape to find the area for:");
        System.out.println("Type 1 for Triangle");
        System.out.println("Type 2 for Square");
        System.out.println("Type 3 for Rectangle");
        System.out.println("Type 4 for Circle");
        System.out.print("Please enter you choice here: ");
        choice = scn.nextInt();
        switch (choice) {
            case 1 -> {
                double triangleHeight = scn.nextInt();
                double triangleWidth = scn.nextInt();
                System.out.println(calculateAreaTriangle(triangleHeight, triangleWidth));
            }
            case 2 -> {
                double squareSide = scn.nextInt();
                System.out.println(calculateAreaSquare(squareSide));
            }
            case 3 -> {
                double rectLength = scn.nextInt();
                double rectWidth = scn.nextInt();
                System.out.println(calculateAreaRectangle(rectLength, rectWidth));
            }
            case 4 -> {
                double circleRadius = scn.nextInt();
                System.out.println(calculateAreaCircle(circleRadius));
            }
            default -> throw new AssertionError();
        }
    }
}