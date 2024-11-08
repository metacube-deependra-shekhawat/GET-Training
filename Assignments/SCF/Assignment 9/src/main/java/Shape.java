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

    /**
     * This method will return the area of the circle
     */
    @Override
    public double getArea(){
        return Math.round(radius * radius * pi * 100.0) / 100.0;
    }

    /**
     * This method will return the perimeter(circumference) of the circle
     */
    @Override
    public double getPerimeter(){
        return 2 * pi * radius;
    }

    /**
     * This method will return the timestamp of the circle
     */
    @Override
    public int getTimestamp(){
        return timestamp;
    }

    /**
     * This method will return the type of circle
     */
    @Override
    public ShapeType getType(){
        return type;
    }

    /**
     * This method will return the Origin point of the circle
     */
    @Override
    public Point getOrigin(){
        return origin;
    }

    /**
     * This method will take a point as input and will return a boolean representing whether the circle encloses the point or not
     */
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

    /**
     * This method will return the area of the square
     */
    @Override
    public double getArea(){
        return Math.round(sideLength * sideLength * 100.0) / 100.0;
    }

    /**
     * This method will return the perimeter of the square
     */
    @Override
    public double getPerimeter(){
        return sideLength * 4;
    }

    /**
     * This method will return the timestamp of the square
     */
    @Override
    public int getTimestamp(){
        return timestamp;
    }

    /**
     * This method will return the Origin point of the square
    */
    @Override
    public Point getOrigin(){
        return origin;
    }

    /**
     * This method will return the type of square
     */
    @Override
    public ShapeType getType(){
        return type;
    }

    /**
     * This method will take a point as input and will return a boolean representing whether the square encloses the point or not
     */
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

    /**
     * This method will return the area of rectangle
     */
    @Override
    public double getArea(){
        return Math.round(length * width * 100.0) / 100.0;
    }

    /**
     * This method will return the perimeter of rectangle
     */
    @Override
    public double getPerimeter(){
        return  2 * (length + width);
    }

    /**
     * This method will return the timestamp of the rectangle
     */
    @Override
    public int getTimestamp(){
        return timestamp;
    }

    /**
     * This method will return the type of rectangle
     */
    @Override
    public ShapeType getType(){
        return type;
    }

    /**
     * This method will return the Origin point of the rectangle
     */
    @Override
    public Point getOrigin(){
        return origin;
    }

    /**
     * This method will take a point as input and will return a boolean representing whether the rectangle encloses the point or not
     */   @Override
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

    /**
     * This method will return area of the triangle
     */
    @Override
    public double getArea(){
        return Math.round((Math.sqrt(3) / 4) * (sideLength * sideLength) * 100.0) / 100.0;
    }

    /**
     * This method will return the perimeter of the triangle
     */
    @Override
    public double getPerimeter(){
        return 3 * sideLength;
    }

    /**
     * This method will return the timestamp of the triangle
     */
    @Override
    public int getTimestamp(){
        return timestamp;
    }

    /**
     * This method will return the type of triangle
     */
    @Override
    public ShapeType getType(){
        return type;
    }

    /**
     * This method will return the Origin point of the triangle
     */
    @Override
    public Point getOrigin(){
        return origin;
    }

    /**
     * This method will take a point as input and will return a boolean representing whether the triangle encloses the point or not
     */
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

    /**
     * This method will return the area of the polygon
     */
    @Override
    public double getArea(){
        double perimeter = getPerimeter();
        double apothem = sideLength / (2 * Math.tan(Math.PI / numOfSides));
        return Math.round(perimeter * apothem * 100.0) / 200.0;
    }

    /**
     * This method will return the perimeter
     */
    @Override
    public double getPerimeter(){
        return numOfSides * sideLength;
    }

    /**
     * This method will return the timestamp of the polygon
     */
    @Override
    public int getTimestamp(){
        return timestamp;
    }

    /**
     * This method will return type of polygon
     */
    @Override
    public ShapeType getType(){
        return type;
    }

    /**
     * This method will return the Origin point of the polygon
     */
    @Override
    public Point getOrigin(){
        return origin;
    }

    /**
     * This method will take a point as input and will return a boolean representing whether the polygon encloses the point or not
     */
    @Override
    public boolean isEnclosed(Point p){
        return isPointInside(points,p);
    }
}