package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import main.java.Shape.ShapeType;

public class Screen {
    int xMax;
    int yMax;
    List<Shape> shapesOnScreen;

    public Screen(int x, int y){
        this.xMax = x;
        this.yMax = y;
        shapesOnScreen = new ArrayList<>();
    }
    
    public boolean addShape(Shape shape){
        return shapesOnScreen.add(shape);
    }

    public boolean deleteShape(Shape shape){
        return shapesOnScreen.remove(shape);
    }

    public void deleteAllShapes(ShapeType type){
        for(Shape shape: shapesOnScreen){
            if(shape.getType() == type){
                shapesOnScreen.remove(shape);
            }
        }
    }

    public List<Shape> getShapesSortedByArea() {
        shapesOnScreen.sort(Comparator.comparingDouble(Shape::getArea));
        return new ArrayList<>(shapesOnScreen);
    }

    public List<Shape> getShapesSortedByPerimeter() {
        shapesOnScreen.sort(Comparator.comparingDouble(Shape::getPerimeter));
        return new ArrayList<>(shapesOnScreen);
    }

    public List<Shape> getShapesSortedByTimestamp() {
        shapesOnScreen.sort(Comparator.comparingInt(Shape::getTimestamp));
        return new ArrayList<>(shapesOnScreen);
    }

    public List<Shape> getShapesSortedByOriginDistance() {
        shapesOnScreen.sort(Comparator.comparingDouble(shape -> shape.getOrigin().distanceFromOrigin()));
        return new ArrayList<>(shapesOnScreen);
    }

    public List<Shape> isEnclosing(Point p){
        List<Shape> list = new ArrayList<>();
        for(Shape shape: shapesOnScreen){
            if(shape.isEnclosed(p)){
                list.add(shape);
            }
        }
        return list;
    }
}
