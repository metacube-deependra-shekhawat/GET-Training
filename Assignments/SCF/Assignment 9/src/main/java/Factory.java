package main.java;


public class Factory {

    static int timestamp = 1;

    /**
     * This method will create a object of Shape type
     * @param type shape which needs to be created
     * @param origin 
     * @param params
     * @return shape object
     */
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
}