/********************************
 * Yossi Silberhaft
 * 210028924
 * 89-750-04
 * Exercise 3
 * File: FileInfo.java
 ********************************/
import java.util.ArrayList;


public class FileInfo {
    private String clusterType;
    private int numberOfClusters = 0;
    private ArrayList<Point> pointsList;

    //This is the Constructor method
    public FileInfo(String type, int amount, ArrayList<Point> list){
        this.clusterType = type;
        this.numberOfClusters = amount;
        this.pointsList = list;
    }

    public String getType(){
        return this.clusterType;
    }

    public int getClusterAmount(){
        return this.numberOfClusters;
    }

    public ArrayList<Point> getPointList(){
        return this.pointsList;
    }
}