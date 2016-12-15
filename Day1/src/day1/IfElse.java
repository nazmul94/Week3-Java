package day1;


import java.util.Scanner;

public class IfElse
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a month (1 - 12): ");
        System.out.println(whichSeason(input.nextInt()));

    }

    static String whichSeason(int month)
    {
        String season;

        if (month == 12 || month == 1 || month == 2)
        {
            season = "Winter";
        }
        else if (month == 3 || month == 4 || month == 5)
        {
            season = "Spring";
        }
        else if (month == 6 || month == 7 || month == 8)
        {
            season = "Summer";
        }
        else if (month == 9 || month == 10 || month == 11)
        {
            season = "Spring";
        }
        else
        {
           season = "Bogus month";
        }

        return "The month of " + month + " is in season " + season + ".";
    }



}
