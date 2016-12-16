package computerShop.models;

public abstract class Computer
{
    //Fields
    private int id;
    private String name;
    private String processor;
    private int ramSize;
    private String graphicsCard;
    private int storageCapacity;
    private int price;

    //(Overloaded) Constructors
    public Computer(){};

    public Computer(int id, String name, String processor, int ramSize, String graphicsCard, int storageCapacity, int price) {
        this.id = id;
        this.name = name;
        this.processor = processor;
        this.ramSize = ramSize;
        this.graphicsCard = graphicsCard;
        this.storageCapacity = storageCapacity;
        this.price = price;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProcessor() {
        return processor;
    }
    public void setProcessor(String processor) {
        this.processor = processor;
    }
    public int getRamSize() {
        return ramSize;
    }
    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }
    public String getGraphicsCard() {
        return graphicsCard;
    }
    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }
    public int getStorageCapacity() {
        return storageCapacity;
    }
    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }
    public int getPrice() {
        return price;
    }
    //double
    //Check this setter
    public void setPrice(int price) {
        if(price > 0)
            this.price = price;
    }

    @Override
    public String toString()
    {
        return String.format("[%s]\t %s\t %s\t %s\t %s\t %s\t", this.id, this.name, this.processor, this.ramSize, this.graphicsCard, this.storageCapacity);
    }
}
