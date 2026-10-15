package CafeApp;

public class Drink
{
    private String name = "";
    private int price = 0;
    private int soldNumber = 0;
    public Drink(String name, int price, int soldNumber)
    {
        this.name = name;
        this.price = price;
        this.soldNumber = soldNumber;
    }

    public int getPrice()
    {
        return price;
    }

    public void setSoldNumber(int soldNumber)
    {
        this.soldNumber = soldNumber;
    }
    public void incrementSold()
    {
        this.soldNumber++;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name + ", " + price + ", " + soldNumber;
    }
}
