public class Drink {
    private double price = 0;

    public Drink()
    {

    }

    public void setPrice(double price) throws IllegalArgumentException
    {
        if(price < 0)
        {
            throw new IllegalArgumentException("Price is less than 0");
        }
    }
    public double getPrice()
    {
        return price;
    }
}
