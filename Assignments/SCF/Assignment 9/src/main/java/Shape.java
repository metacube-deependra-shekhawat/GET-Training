package main.java;

import java.util.List;

public interface Shape {
    double getArea();
    double getPerimeter();
    Point getOrigin();
    boolean isEnclosed(Point p);
    int timestamp=0;

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

    @Override
    public double getArea(){
        return radius * radius * pi;
    }

    @Override
    public double getPerimeter(){
        return 2 * pi * radius;
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

    @Override
    public double getArea(){
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter(){
        return sideLength * 4;
    }
    
    @Override
    public Point getOrigin(){
        return origin;
    }

    @Override
    public boolean isEnclosed(Point p){
        return true;
    }
}


class Rectangle implements Shape {

    Point origin;
    int length;
    int width;
    ShapeType type = ShapeType.Rectangle;
    List<Point> points;

    @Override
    public double getArea(){
        return length * width;
    }

    @Override
    public double getPerimeter(){
        return  2 * (length + width);
    }
    
    @Override
    public Point getOrigin(){
        return origin;
    }

    @Override
    public boolean isEnclosed(Point p){
        return true;
    }
}


class Triangle implements Shape {

    Point origin;
    int height;
    int base;
    ShapeType type = ShapeType.Triangle;
    List<Point> points;

    @Override
    public double getArea(){
        return height * base / 2;
    }

    @Override
    public double getPerimeter(){
        return base + (Math.sqrt(base * base + height * height) * 2);
    }

    @Override
    public Point getOrigin(){
        return origin;
    }

    @Override
    public boolean isEnclosed(Point p){
        return true;
    }
}


class Polygon implements Shape {

    Point origin;
    int sideLength;
    int numOfSides;
    ShapeType type = ShapeType.Polygon;
    List<Point> points;

    @Override
    public double getArea(){
        return 10;
    }

    @Override
    public double getPerimeter(){
        return numOfSides * sideLength;
    }

    @Override
    public Point getOrigin(){
        return origin;
    }

    @Override
    public boolean isEnclosed(Point p){
        return true;
    }
}