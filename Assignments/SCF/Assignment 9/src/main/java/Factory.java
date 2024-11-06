package main.java;

import java.util.List;
import main.java.Shape.ShapeType;


public class Factory {

    static int timestamp = 1;

    public Shape createShape(Shape.ShapeType type, Point origin, int[] params){
        Shape shape = null;
        if(null == type){
            System.out.println("Not a valid type");
        } else switch (type) {
            case Square -> {
                Shape square = new Square(origin, params[0], timestamp);
                shape = square;
                timestamp++;
            }
            case Circle -> {
                Shape circle = new Circle(origin, params[0], timestamp);
                shape = circle;
                timestamp++;
            }
            case Rectangle -> {
                Shape rectangle = new Rectangle(origin, params[0], params[1], timestamp);
                shape = rectangle;
                timestamp++;
            }
            case Triangle -> {
                Shape triangle = new Triangle(origin, params[0], timestamp);
                shape = triangle;
                timestamp++;
            }
            case Polygon -> {
                Shape polygon = new Polygon(origin, params[0], params[1], timestamp);
                shape = polygon;
                timestamp++;
            }
            default -> System.out.println("Not a valid type");
        }
        return shape;
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        Screen screen = new Screen(1000,1000);

        int[] params = {10, 50};
        Point p = new Point(5,10);
        Shape poly = factory.createShape(ShapeType.Polygon, p, params);
        int[] params1 = {10, 25};
        Point p4 = new Point(50,10);
        Shape poly1 = factory.createShape(ShapeType.Polygon, p4, params1);
        screen.addShape(poly);
        screen.addShape(poly1);


        Point p1 = new Point(5,15), p2 = new Point(30,30);

        System.out.println(poly.getTimestamp());
        System.out.println(poly1.getTimestamp());

        if(poly.isEnclosed(p1)) System.out.println("Yes it is enclosed in the polygon");
        if(!poly.isEnclosed(p2)) System.out.println("Not enclosed in polygon");
        List<Shape> list1 = screen.getShapesSortedByArea();
        for(Shape shape: list1){
            System.out.println(shape.getArea());
        }

    }
}