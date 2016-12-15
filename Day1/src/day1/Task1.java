package day1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 2000: ");
        int num1 = input.nextInt();
        System.out.println(whichNumber(num1));
    }

    static String whichNumber(int number)
    {
        String output;

        if(number >= 0 && number <= 100)
        {
            output = "Number is less than 100";
        }
        else if (number <= 500)
        {
            output = "Number is greater than 100 but less-than/equal-to 500";
        }
        else if (number <= 1000)
        {
            output = "Number is greater than 500 but less-than/equal-to 1000";
        }
        else if (number <= 200)
        {
            output = "Number is greater than 1000 but less-than/equal-to 2000";
        }
        else
        {
            output = "Bogus!";
        }

        return output;
    }
}

