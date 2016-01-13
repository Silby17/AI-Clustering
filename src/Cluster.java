/********************************
 * Yossi Silberhaft
 * 89-750-04
 * Exercise 3
 * File: Cluster.java
 ********************************/
import java.util.ArrayList;
import java.util.List;

class Cluster {
    //Deceleration of variables
    protected List<Point> pointList = new ArrayList<Point>();
    private int amount;

    //Constructor method that receives a point and places it into the list
    public Cluster(Point p) {
        this.pointList.add(p);
    }


    //Returns the amount
    public int getAmount() {
        return this.amount;
    }

    //Returns the list of points
    public List<Point> getPointList() {
        return this.pointList;
    }


    //This checks if the point is already in the cluster
    // and returns True if ye, else returns false
    public boolean checkCluster(Point point) {
        return this.pointList.contains(point);
    }

    //Adds point to the pointsList
    public void addPoint(Point nPoint) {
        this.pointList.add(nPoint);
    }

    //Adds a list of points to the current list of points
    public void addMultPoints(List<Point> multPoints) {
        this.pointList.addAll(multPoints);
    }


    //This Function checks the distance between two given Points
    public double checkDistance(Point a, Point b) {
        double result = Math.sqrt((a.getX() - b.getX()) *
                (a.getX() - b.getX()) + (a.getY() - b.getY()) *
                (a.getY() - b.getY()));
        return result;
    }

    //This changes the value of the current amount
    public void changeAmount(int n) {
        this.amount = n;
    }


    //This will check the distance between two Clusters
    public double checkDistance(Cluster cluster, String algo) {
        if (algo.equalsIgnoreCase("average link")) {
            double dist = 0;
            int i = 0;
            for (Point n : pointList) {
                for (Point m : cluster.getPointList()) {
                    i++;
                    dist += checkDistance(n, m);
                }
            }
            double result = dist / (double) i;
            return result;
        } else {
            double dist = -1;
            for (Point n : pointList) {
                for (Point m : cluster.getPointList()) {
                    if (dist == -1 || checkDistance(n, m) < dist) {
                        dist = checkDistance(n, m);
                    }
                }
            }
            return dist;
        }
    }
}