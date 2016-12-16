package computerShop.models;

import java.util.ArrayList;
import java.util.List;

public class GeneratedComputers
{
    public static List<Computer> catalogue = new ArrayList<>();

    //Method to create database
    public  static void generateDatabase()
    {
        Laptop xps15 = new Laptop(1,"dell xps15 9550", "intel coire i7-6700HQ",16, "nvidia gtx 960", 512, 1600, "UHD", 15.6);

        catalogue.add(xps15);
    }
}
