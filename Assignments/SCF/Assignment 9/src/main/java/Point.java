package main.java;

import java.util.ArrayList;
import java.util.List;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * This method will return the distance between origin and shape's origin
     * @return double the distance from origin to origin of shape
     */
    public double distanceFromOrigin(){
        return Math.sqrt(x*x + y*y);
    }

    /**
     * This method will return all thed points of a polygon
     * @param p the origin point
     * @param numOfSides 
     * @param length
     * @return list of points
     */
    static List<Point> calculatePoints(Point p, int numOfSides, int length){
        List<Point> points = new ArrayList<>();
        points.add(p);
        double angleIncrement = 2 * Math.PI / numOfSides;
        double currentAngle = 0;
        for(int i = 1; i < numOfSides; i++){
            int nx = (int) (points.get(i-1).x + length * Math.cos(currentAngle));
            int ny = (int) (points.get(i-1).y + length * Math.sin(currentAngle));
            currentAngle += angleIncrement;
            Point nextVertex = new Point(nx, ny);
            points.add(nextVertex);
        }
        return points;
    }
    
    /**
     * This method will return the list of points of a rectangle
     * @param p the origin point of rectangle
     * @param length
     * @param width
     * @return
     */
    static List<Point> calculateRectanglePoints(Point p, int length, int width){
        List<Point> points = new ArrayList<>();
        Point p1 = new Point(p.x+length,p.y);
        Point p2 = new Point(p.x+length,p.y+width);
        Point p3 = new Point(p.x,p.y+width);
        points.add(p);
        points.add(p1);
        points.add(p2);
        points.add(p3);
        return points;
    }

    /**
     * This method will return a boolean checking if a point is enclosed by a shape of not
     * @param points
     * @param p
     * @return
     */
    static boolean isPointInside(List<Point> points, Point p) {
        int n = points.size();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            Point a = points.get(i);
            Point b = points.get((i + 1) % n);
            if ((p.y > a.y) != (p.y > b.y) && 
                (p.x < (b.x - a.x) * (p.y - a.y) / (b.y - a.y) + a.x)) {
                count++;
            }
        }
        return count % 2 == 1;
    }
}
