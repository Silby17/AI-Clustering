/********************************
 * Yossi Silberhaft
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

    /***************************************************************
     * This function will return the Algorithm type
     ***************************************************************/
    public String getType(){
        return this.clusterType;
    }

    /***************************************************************
     * This function will return the number of clusters
     ***************************************************************/
    public int getClusterAmount(){
        return this.numberOfClusters;
    }


    /***************************************************************
     * This function will return the List of Points
     ***************************************************************/
    public ArrayList<Point> getPointList(){
        return this.pointsList;
    }
}