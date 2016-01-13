/********************************
 * Yossi Silberhaft
 * 89-750-04
 * Exercise 3
 * File: Point.java
 ********************************/
public class Point {
    private double x = 0;
    private double y = 0;

    //Constructor Method receives x and y coordinates
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    //Returns the x coordinate
    public double getX(){
        return this.x;
    }

    //Returns the y coordinate
    public double getY(){
        return this.y;
    }
}