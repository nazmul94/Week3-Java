package day1;

import java.util.Scanner;

public class Task3
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Which ice cream size would you like?");
        String choice = input.next();
        iceCream(choice);
    }

    static void iceCream(String size)
    {
        double price = 0;

        switch (size)
        {
            case "small":
                price = 1.25;
                break;
            case "medium":
                price = 2.25;
                break;
            case "large":
                price = 3.25;
                break;
            case "huge":
                price = 4.00;
                break;
            default:
                System.out.println("We don't support that size");
        }

        if(price != 0.00)
            System.out.println("Price of " + size + " is: £" + price);
    }
}


