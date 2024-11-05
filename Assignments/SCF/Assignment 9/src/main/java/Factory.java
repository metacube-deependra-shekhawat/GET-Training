package main.java;

import java.util.List;
import main.java.Shape.ShapeType;

public class Factory {

    static int timestamp = 1;

    public void createShape(Shape.ShapeType type, Point origin, List<Integer> params){
        if(type == Shape.ShapeType.Square){
            Shape square = new Square(origin, params.get(0), timestamp);
            timestamp++;
        } else if(type == ShapeType.Circle){
            Shape circle = new Circle(origin, params.get(0), timestamp);
            timestamp++;
        } else if(type == ShapeType.Rectangle){
            Shape rectangle = new Rectangle(origin, params.get(0), params.get(1), timestamp);
            timestamp++;
        } else if(type == ShapeType.Triangle){
            Shape triangle = new Triangle(origin, params.get(0), params.get(1), timestamp);
            timestamp++;
        } else if(type == ShapeType.Polygon){
            Shape polygon = new Polygon(origin, params.get(0), params.get(1), timestamp);
            timestamp++;
        } else {
            System.out.println("Not a valid type");
        }
    }
}
