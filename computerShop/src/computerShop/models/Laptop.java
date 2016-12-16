package computerShop.models;

public class Laptop extends Computer
{
    //Fields
    private String displayQuality;
    private double displaySize;

    //Constructors
    public Laptop() {}

    public Laptop(int id, String name, String processor, int ramSize, String graphicsCard, int storageCapacity, int price, String displayQuality, double displaySize) {
        super(id, name, processor, ramSize, graphicsCard, storageCapacity, price);
        this.displayQuality = displayQuality;
        this.displaySize = displaySize;
    }

    //Getters and Setters
    public String getDisplayQuality() {
        return displayQuality;
    }
    public void setDisplayQuality(String displayQuality) {
        this.displayQuality = displayQuality;
    }
    public double getDisplaySize() {
        return displaySize;
    }
    public void setDisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }

    //Methods
    @Override
    public String toString()
    {
        return String.format("%s %s %s", super.toString(), this.displayQuality, this.displaySize);
    }
}
