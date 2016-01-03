/********************************
 * Yossi Silberhaft
 * 210028924
 * 89-750-04
 * Exercise 3
 * File: Point.java
 ********************************/
public class Point {
    private double x = 0;
    private double y = 0;
    private int cluster_number = 0;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }


    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setCluster(int n){
        this.cluster_number = n;
    }
}
