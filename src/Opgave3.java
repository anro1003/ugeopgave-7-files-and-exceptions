import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Opgave3 {

    public static ArrayList<String> readLines(String path) throws FileNotFoundException
    {

        ArrayList<String> lines = new ArrayList<>();
        Scanner scan = new Scanner( new File(path)); //Throws automatically upwards because of the "throws" part of the declaration
        while(scan.hasNextLine())
        {
            lines.add(scan.nextLine());
        }
        return lines;
    }

    public static ArrayList readLinesWithExceptionHandling(String path) {
        ArrayList lines = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File(path));
            while (scan.hasNextLine()) {
                lines.add(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet");
        }
        return lines;
    }

    public static ArrayList<String> readLinesWithoutExceptionHandling(String path) throws FileNotFoundException{
        ArrayList<String> lines = new ArrayList<>();
            Scanner scan = new Scanner(new File(path));
            while (scan.hasNextLine()) {
                lines.add(scan.nextLine());
            }
            scan.close();
        return lines;
    }
}
