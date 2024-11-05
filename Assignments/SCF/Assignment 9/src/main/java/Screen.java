package main.java;

import java.util.List;

public class Screen {
    List<Shape> shapesOnScreen;
    
    public boolean addShape(Shape shape){
        return shapesOnScreen.add(shape);
    }

    public boolean deleteShape(Shape shape){
        return shapesOnScreen.remove(shape);
    }

    public boolean deleteAllShapes(){
        shapesOnScreen.clear();
        return true;
    }
}
