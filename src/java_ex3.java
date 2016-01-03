/********************************
 * Yossi Silberhaft
 * 210028924
 * 89-750-04
 * Exercise 3
 * File: java_ex3.java
 ********************************/
public class java_ex3 {
    public static void main(String[] args){
        ReadConfig config = new ReadConfig();

        FileInfo info = new ReadConfig().readFromFile("input.txt");

        System.out.println("Done reading from File");

    }
}
