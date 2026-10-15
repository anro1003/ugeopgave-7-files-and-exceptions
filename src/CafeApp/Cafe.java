package CafeApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cafe
{
    private ArrayList<Drink> coffeeMenu = new ArrayList<>();
    private String menuPath = "";
    private String csvHeaders = "";

    public Cafe(String menuCSVPath)
    {
        menuPath = menuCSVPath;
        try {
            loadData();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Failed to create Cafe - Menu CSV not found");
            System.exit(1);
        }
    }

    private void loadData() throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File(menuPath));
        if(!scanner.hasNextLine())
        {
            throw new RuntimeException("Menu file is empty");
        }
        csvHeaders = scanner.nextLine();
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] dataPoints = line.split(", ");
            try {
                coffeeMenu.add(new Drink(dataPoints[0], Integer.parseInt(dataPoints[1]), Integer.parseInt(dataPoints[2])));
            }
            catch(NumberFormatException e)
            {
                System.out.println("On CSV input: " + line);
                System.out.println("Failed to parse data from CSV - Err: " + e.getMessage());
            }

        }
    }

    public void saveData()
    {
        try {
            FileWriter writer = new FileWriter(menuPath);
            writer.write(csvHeaders + "\n");
            String dataToWrite = "";
            for (Drink drink : coffeeMenu)
            {
                dataToWrite += drink.toString() + "\n";
            }
            dataToWrite = dataToWrite.substring(0,dataToWrite.length()-1);
            writer.write(dataToWrite);
            writer.close();
            System.out.println("Menu Saved");
        }
        catch (IOException e)
        {
            System.out.println("Failed to save menu - Err: " + e.getMessage());
        }
    }

    public void showMenu()
    {
        while(true) {
            System.out.println("Menu:");
            for (int i = 0; i < coffeeMenu.size(); i++) {

                System.out.println((i + 1) + ". " + coffeeMenu.get(i).getName());
            }

            int selectedDrinkIndex = -1;
            Scanner scanner = new Scanner(System.in);
            while (true) //To avoid StackOverflow exceptions from infinite recursion
            {
                System.out.print("Please choose an item > ");
                try {
                    selectedDrinkIndex = Integer.parseInt(scanner.nextLine());
                    if (selectedDrinkIndex - 1 >= coffeeMenu.size() || selectedDrinkIndex - 1 < 0) {
                        throw new IllegalArgumentException("Index out of bounds");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("\nThat's not a number");
                } catch (IllegalArgumentException e) {
                    System.out.println("\nThat number is not on the menu..");
                }
            }
            Drink selectedDrink = coffeeMenu.get(selectedDrinkIndex - 1);
            System.out.println("Your choice of \"" + selectedDrink.getName() + "\" will cost you: " + selectedDrink.getPrice() + " kr");
            System.out.println("Thank you for your order!");
            selectedDrink.incrementSold();
            saveData();
            System.out.print("Want to order more? (\"y\" for yes, anything else for no) > ");
            char response = scanner.next().charAt(0);
            System.out.print("\n");
            if(response != 'y')
            {
                break;
            }
        }

    }

}
