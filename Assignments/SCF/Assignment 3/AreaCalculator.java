import java.util.InputMismatchException;
import java.util.Scanner;

interface Shapes {
    public double getArea();
};

class Triangle implements Shapes {
    double height, base;

    /**
     * 
     * @param height double
     * @param base double
     */
    Triangle(double height,double base) {
        this.height = height;
        this.base = base;
    }
    
    /**
     * This method will return the area of triangle
     */
    @Override
    public double getArea(){
        double temp = (height / 2) * base;
        double area = Math.round(temp * 100.0) / 100.0;
        return area;
    }
}

class Square implements Shapes{
    double side;

    /**
     * 
     * @param side double
     */
    Square(double side) {
        this.side = side;
    }

    /**
     * This method will return area of square
     * @return double
     */  
    @Override
    public double getArea(){
        double temp = ((double)side * side);
        double area = Math.round(temp * 100.0) / 100.0;
        return area;
    }
}

class Rectangle implements Shapes {
    double width, length;

    /**
     * 
     * @param width double
     * @param length double
     */
    Rectangle(double width,double length) {
        this.length = length;
        this.width = width;
    }
    
    /**
     * This method will return area of rectangle
     * @return double
     */
    @Override
    public double getArea(){
        double temp =  ((double)width * length);
        double area = Math.round(temp * 100.0) / 100.0;
        return area;
    }
}

class Circle implements Shapes {
    static double pi = 3.14;
    double radius;

    /**
     * @param radius double
     */
    Circle(double radius){
        this.radius = radius;
    }

    /**
     * This method will return the area of a Circle
     * @return double
     */
    @Override
    public double getArea(){
        double temp = ((double)pi * radius * radius);
        double area = Math.round(temp * 100.0) / 100.0;
        return area;
    }
}

public class AreaCalculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);   
        while (true){
            System.out.println("Please Select on the following option");
            System.out.println("1 for Calculating Triangle's area");
            System.out.println("2 for Calculating Square's area");
            System.out.println("3 for Calculating Rectangle's area");
            System.out.println("4 for Calculating Circle's area");
            System.out.println("5 for Exiting");
            int input = scn.nextInt();
            switch (input) {
                case 1 -> {
                    double h,b;
                    while(true){
                        try {
                            scn.nextLine();
                            System.out.print("Please enter the height of the Triangle: ");
                            h = scn.nextDouble();
                            System.out.print("Please enter the base of the Triangle: ");
                            b = scn.nextDouble();
                            if(h < 0 || b < 0){
                                throw new Exception("Not a valid number");
                            }
                            break;
                        }
                         catch (InputMismatchException e) {
                            System.out.println("Invalid inputs, please try again");
                        } catch (Exception e){
                            System.out.println("Not a valid number");
                        }
                    }
                    Shapes triangle = new Triangle(h, b);
                    System.out.println(triangle.getArea());
                }
                case 2 -> {
                    double side;
                    while (true) { 
                        try {
                            System.out.print("Please enter the length of side of square: ");
                            side = scn.nextDouble();
                            if(side < 0){
                                throw new Exception("Not valid input");
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid inputs, please try again");
                        } catch (Exception e){
                            System.out.println("Not a valid number");
                        }
                    }
                    Shapes square = new Square(side);
                    System.out.println(square.getArea());
                }
                case 3 -> {
                    double l,w;
                    while(true){
                        try {
                            scn.nextLine();
                            System.out.print("Please enter the length of the Triangle: ");
                            l = scn.nextDouble();
                            System.out.print("Please enter the width of the Triangle: ");
                            w = scn.nextDouble();
                            if(l < 0 || w < 0){
                                throw new Exception("Not a valid number");
                            }
                            break;
                        }
                         catch (InputMismatchException e) {
                            System.out.println("Invalid inputs, please try again");
                        } catch (Exception e){
                            System.out.println("Not a valid number");
                        }
                    }                                          
                    Shapes rectangle = new Rectangle(w, l);
                    System.out.println(rectangle.getArea());
                }
                case 4 -> {
                    double radius;
                    while (true) { 
                        try {
                            System.out.println("Please enter the radius of circle");
                            radius = scn.nextDouble();                           
                            if(radius < 0){
                                throw new Exception("Not valid input");
                            }
                            break;
                        } catch (InputMismatchException e){
                            System.out.println("Invalid input, try again");
                        } catch (Exception e) {
                            System.out.println("Not a valid number");
                        }
                    }
                    Shapes circle = new Circle(radius);
                    System.out.println(circle.getArea());
                }
                case 5 ->{
                    scn.close();
                    return;
                }
                default -> {
                    throw new AssertionError();
                }
            }
        }
    }
}
