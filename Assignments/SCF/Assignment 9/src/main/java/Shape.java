package main.java;

import java.util.List;
import static main.java.Point.isPointInside;

public interface Shape {

    double getArea();
    double getPerimeter();
    Point getOrigin();
    int getTimestamp();
    ShapeType getType();
    boolean isEnclosed(Point p);

    enum ShapeType {
        Circle,
        Triangle,
        Square,
        Rectangle,
        Polygon
    }
}


class Circle implements Shape {

    static double pi = 3.14;
    Point origin;
    double radius;
    ShapeType type = ShapeType.Circle;
    public int timestamp;

    public Circle(Point origin, int radius, int timestamp){
        this.origin = origin;
        this.radius = radius;
        this.timestamp = timestamp;
    }

    @Override
    public double getArea(){
        return radius * radius * pi;
    }

    @Override
    public double getPerimeter(){
        return 2 * pi * radius;
    }

    @Override
    public int getTimestamp(){
        return timestamp;
    }

    @Override
    public ShapeType getType(){
        return type;
    }

    @Override
    public Point getOrigin(){
        return origin;
    }

    @Override
    public boolean isEnclosed(Point p){
        return (p.x - origin.x) * (p.x - origin.x) + (p.y - origin.y) * (p.y - origin.y) <= radius * radius;
    }
}


class Square implements Shape {

    Point origin;
    int sideLength;
    ShapeType type = ShapeType.Square;
    List<Point> points;
    int timestamp;

    public Square(Point origin, int sideLength, int timestamp){
        this.origin = origin;
        this.sideLength = sideLength;
        this.timestamp = timestamp;
        points = Point.calculatePoints(origin,4,sideLength);
    }

    @Override
    public double getArea(){
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter(){
        return sideLength * 4;
    }

    @Override
    public int getTimestamp(){
        return timestamp;
    }
    
    @Override
    public Point getOrigin(){
        return origin;
    }

    @Override
    public ShapeType getType(){
        return type;
    }

   @Override
    public boolean isEnclosed(Point p){
        return isPointInside(points,p);
    }
}


class Rectangle implements Shape {

    Point origin;
    int length;
    int width;
    ShapeType type = ShapeType.Rectangle;
    List<Point> points;
    int timestamp;

    public Rectangle(Point origin, int length, int width, int timestamp){
        this.origin = origin;
        this.length = length;
        this.width = width;
        this.timestamp = timestamp;
        points = Point.calculateRectanglePoints(origin,length,width);
    }

    @Override
    public double getArea(){
        return length * width;
    }

    @Override
    public double getPerimeter(){
        return  2 * (length + width);
    }

    @Override
    public int getTimestamp(){
        return timestamp;
    }

    @Override
    public ShapeType getType(){
        return type;
    }

    @Override
    public Point getOrigin(){
        return origin;
    }

    @Override
    public boolean isEnclosed(Point p){
        return isPointInside(points,p);
    }
}


class Triangle implements Shape {

    Point origin;
    int sideLength;
    ShapeType type = ShapeType.Triangle;
    List<Point> points;
    int timestamp;

    public Triangle(Point origin, int sideLength, int timestamp){
        this.origin = origin;
        this.sideLength = sideLength;
        this.timestamp = timestamp;
        points = Point.calculatePoints(origin,3,sideLength);
    }

    @Override
    public double getArea(){
        return (Math.sqrt(3) / 4) * (sideLength * sideLength);
    }

    @Override
    public double getPerimeter(){
        return 3 * sideLength;
    }

    @Override
    public int getTimestamp(){
        return timestamp;
    }

    @Override
    public ShapeType getType(){
        return type;
    }

    @Override
    public Point getOrigin(){
        return origin;
    }

    @Override
    public boolean isEnclosed(Point p){
        return isPointInside(points,p);
    }
}


class Polygon implements Shape {

    Point origin;
    int sideLength;
    int numOfSides;
    ShapeType type = ShapeType.Polygon;
    List<Point> points;
    int timestamp;

    public Polygon(Point origin, int numOfSides, int sideLength, int timestamp){
        this.origin = origin;
        this.numOfSides = numOfSides;
        this.sideLength = sideLength;
        this.timestamp = timestamp;
        points = Point.calculatePoints(origin,numOfSides,sideLength);
    }

    @Override
    public double getArea(){
        double perimeter = getPerimeter();
        double apothem = sideLength / (2 * Math.tan(Math.PI / numOfSides));
        return (perimeter * apothem) / 2;
    }

    @Override
    public double getPerimeter(){
        return numOfSides * sideLength;
    }

    @Override
    public int getTimestamp(){
        return timestamp;
    }

    @Override
    public ShapeType getType(){
        return type;
    }

    @Override
    public Point getOrigin(){
        return origin;
    }

    @Override
    public boolean isEnclosed(Point p){
        return isPointInside(points,p);
    }
}