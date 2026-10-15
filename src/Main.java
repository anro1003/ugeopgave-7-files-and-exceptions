import CafeApp.Cafe;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static void main (String[] args)
    {

        // Opgave 1
        /*tilføj fejlhåndtering til promptNumber*/
        String msg = "Please Write a number";
        //promptNumber(msg); //Just commented out to avoid blocking every test

        //Opgave 2
        Drink drink = new Drink();
        drink.setPrice(4); //Valid
        try {
            drink.setPrice(-1); //Err
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("ERR [Exception caught]: " + e.getMessage());
        }

        //Opgave 2b
        ArrayList<String> string1 = new ArrayList<>(Arrays.stream((new String[] {"Jens","Peter","Kant","Jøgeren","Anders"})).toList());

        int index1 = 4;
        String s = Opgave2b.getItem(string1,index1);
        System.out.println("Index " + index1 + " was: " + s);
        try {
            System.out.println(Opgave2b.getItem(string1,7));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("ERR: " + e.getMessage());
        }

        //Opgave 3

        ArrayList<String> lines = new ArrayList<>();

        try {
            //Valid file
            lines = Opgave3.readLines("/home/deck/superfile.txt");
            System.out.println("Lines: ");
            for(String line : lines)
            {
                System.out.println(line);
            }
            System.out.println("");
            //Invalid file
            lines = Opgave3.readLines("~/file.txt");
            for(String line : lines)
            {
                System.out.println(line);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Err in file reader: " + e.getMessage());
        }

        //3b - Fra Opgave3.readLinesWithExceptionHandling(String path) to Opgave3.readLinesWithoutExceptionHandling(String path)


        //Opgave 4
        double combinedPrice = 0.0d;
        ArrayList<String> data = new ArrayList<>();
        data.add("Espresso, En kraftfuld og koncentreret kaffe, 25.0");
        data.add("Latte, Espresso med dampet mælk, 45.0");
        data.add("Cola, Kold og brusende, 30.0");
        data.add("Vand, Stille kildevand, gratis");

        for(String dataPoint : data)
        {
            String[] points = dataPoint.split(",");
            boolean validDouble = true;
            try{
                combinedPrice += Double.parseDouble(points[2].trim());
            }
            catch (NumberFormatException e)
            {
                System.out.println("String: \"" + points[2].trim() + "\" is not a valid double, presuming it's free");
                validDouble = false;
            }
            System.out.println(points[0].trim() + " - " + points[1].trim() + " (" + points[2].trim() + (validDouble ? " kr)" : ")"));
        }

        //Opgave 5
        System.out.println("Combined price of all drinks: " + combinedPrice);


        //Opgave 6
        Cafe cafe = new Cafe("data/menu.csv");
        cafe.showMenu();


    }
    public static int promptNumber(String msg) {
        System.out.println(msg);
        try {
            return Integer.parseInt(scan.nextLine());
        }
        catch(NumberFormatException e)
        {
            System.out.println("That was not a number...");
            return promptNumber(msg);
        }
    }
}
