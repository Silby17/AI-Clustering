/********************************
 * Yossi Silberhaft
 * 89-750-04
 * Exercise 3
 * File: java_ex3.java
 ********************************/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class java_ex3 {
    //This is the main function that will run the Program
    public static void main(String[] args) throws IOException {
        //Deceleration of Variables
        List<Point> pointsList;
        List<Cluster> clusterList;
        String algo;
        int amount;

        //Creates a new instance to read from the file
        ReadConfig config = new ReadConfig();

        //Creates an info class that will hold all the information from the
        //text file
        FileInfo info = new ReadConfig().readFromFile("input.txt");

        //Assign the variables values
        amount = info.getClusterAmount();
        algo = info.getType();
        pointsList = info.getPointList();

        //Create a new List of type Cluster
        clusterList = new ArrayList<Cluster>();

        //This will setup the Clusters
        for (Point n : pointsList) {
            clusterList.add(new Cluster(n));
        }

        //THis function will combine the clusters
        while (clusterList.size() > amount) {
            double dist = -1;
            int a = -1;
            int b = -1;
            for (int i = 0; i < clusterList.size(); i++) {
                for (int j = i + 1; j < clusterList.size(); j++) {
                    if (dist == -1 || clusterList.get(i).checkDistance(
                            clusterList.get(j), algo) < dist) {
                        a = i;
                        b = j;
                        dist = clusterList.get(i).checkDistance(
                                clusterList.get(j), algo);
                    }
                }
            }
            clusterList.get(a).addMultPoints(clusterList.get(b).getPointList());
            clusterList.remove(b);
        }

        //Set the clusters amount
        int k = 0;
        for (Cluster c : clusterList) {
            k += 1;
            c.changeAmount(k);
        }

        //Attempt to write the outcomes to a output txt file
        try {
            writeToFile(pointsList, clusterList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**********************************************************
     * This Function will write the outcome of the algorithm
     * to an output file called = "output.txt"
     * @param points - Receive the list of Points
     * @param clusters - Receive the list of Clusters
     * @throws IOException - If there is an error with Output
     **********************************************************/
    public static void writeToFile(List<Point> points, List<Cluster> clusters)
            throws IOException {
        //Create a new file called "output.txt"
        File outputFile = new File("output.txt");
        outputFile.createNewFile();

        //Create a new BufferedReader
        BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));

        //Start iterating through the list of Points and List of Clusters
        for (Point p : points) {
            for (Cluster c : clusters) {
                if (c.checkCluster(p)) {
                    out.append(String.valueOf(c.getAmount()) + "\n");
                }
            }
        }
        //Close the output file
        out.close();
    }
}