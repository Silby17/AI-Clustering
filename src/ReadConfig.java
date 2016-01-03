import java.io.*;
import java.util.ArrayList;
/********************************
 * Yossi Silberhaft
 * 210028924
 * 89-750-04
 * Exercise 3
 * File: ReadConfig.java
 ********************************/

public class ReadConfig {
    //Constructor Method that will receive the input file name
    public FileInfo readFromFile(String filename){
        //Deceleration of variables
        int counter = 0;
        int amount = 0;
        String type = "";
        //This flag will signal if we have passed the comma of the coordinates
        boolean FLAG;

        //Open the input stream of the input file
        InputStream in = getClass().getResourceAsStream(filename);
        Reader rd = null;
        BufferedReader br = null;
        //Create a new list of Points
        ArrayList<Point> pointList = new ArrayList<Point>();

        //Start reading the input file line-by-line
        try{
            String currentLine;
            br = new BufferedReader(new InputStreamReader(in));
            while((currentLine = br.readLine()) != null){
                //Set the flag to false
                FLAG = false;
                if(counter == 0){
                    type = currentLine;
                    counter++;
                }
                else if(counter == 1){
                    amount = Integer.parseInt(currentLine);
                    counter++;
                }
                else{
                    //Create a string builder to parse from strings to Double
                    StringBuilder xsb = new StringBuilder();
                    StringBuilder ysb = new StringBuilder();
                    int i = 0;
                    while(i < currentLine.length()){
                        if(currentLine.charAt(i) != ',' && FLAG == false){
                            xsb.append(currentLine.charAt(i));
                            i++;
                        }
                        else if(currentLine.charAt(i) == ','){
                            FLAG = true;
                            i++;
                        }
                        else if(currentLine.charAt(i) != ',' && FLAG == true){
                            ysb.append(currentLine.charAt(i));
                            i++;
                        }
                    }
                    //Create x and y points of type double
                    Double x = Double.parseDouble(xsb.toString());
                    Double y = Double.parseDouble(ysb.toString());
                    //Create a new Point with values
                    Point tempPoint = new Point(x, y);
                    //Add the new Point to the List of Points
                    pointList.add(tempPoint);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        //Returns a new FileInfo object
        return new FileInfo(type, amount, pointList);
    }
}