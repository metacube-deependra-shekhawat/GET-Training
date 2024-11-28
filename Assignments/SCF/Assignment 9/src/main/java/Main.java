package main.java;

import java.util.List;
import main.java.Shape.ShapeType;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Screen screen = new Screen(1000,1000);

        int[] poly1Param = {10, 10};
        int[] poly2Param = {10, 25};
        int[] triangleParam = {5};
        int[] circleParam = {7};
        int[] rectangleParam = {15,20};
        Point poly1Origin = new Point(5,10);
        Point poly2Origin = new Point(50,10);
        Point triangleOrigin = new Point(10,15);
        Point circleOrigin = new Point(25,25);
        Point rectangleOrigin = new Point(25,25);
        Point p1 = new Point(5,15), p2 = new Point(30,30);

        Shape poly1 = factory.createShape(ShapeType.Polygon, poly1Origin, poly1Param);
        Shape poly2 = factory.createShape(ShapeType.Polygon, poly2Origin, poly2Param);
        Shape triangle = factory.createShape(ShapeType.Triangle, triangleOrigin, triangleParam);
        Shape circle = factory.createShape(ShapeType.Circle, circleOrigin, circleParam);
        Shape rectangle = factory.createShape(ShapeType.Rectangle, rectangleOrigin, rectangleParam);
        screen.addShape(poly1);
        screen.addShape(poly2);
        screen.addShape(triangle);
        screen.addShape(circle);
        screen.addShape(rectangle);

        System.out.println("Timestamp of poly1");
        System.out.println(poly1.getTimestamp());

        if(poly1.isEnclosed(p1)) System.out.println("Yes it is enclosed in the polygon");
        if(!poly1.isEnclosed(p2)) System.out.println("Not enclosed in polygon");
        List<Shape> list1 = screen.getShapesSortedByArea();
        for(Shape shape: list1){
            System.out.println(shape.getArea());
        }
    }
}
