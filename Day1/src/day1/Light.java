package day1;

import java.util.Scanner;

public class Light
{

    static final int lightSpeed = 187370;
    static long days;
    static long seconds;
    static long distance;

    public static void main(String[] arg)
    {
        //Scanner is a utility class that deals with input and output
        System.out.println("Light speed in miles: " + lightSpeed);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of days: ");
        days = input.nextLong();

        System.out.println("Light travels " + lightSpeedCalculator(days) + " miles in " + days + " days");
    }

    static long lightSpeedCalculator(long days)
    {
        seconds = days * 24 * 3600;
        return lightSpeed * seconds;
    }
}
