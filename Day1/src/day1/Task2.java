package day1;

import java.util.Scanner;

/**
 * Created by student on 12-Dec-16.
 */
public class Task2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a character: ");
        char inputChar = input.next().charAt(0);
        System.out.println(checkChar(inputChar));
    }

    static String checkChar(char charac)
    {
        String output2;

        if(Character.isUpperCase(charac))
        {
            output2 = "Uppercase";
        }
        else if (Character.isLowerCase(charac))
        {
            output2 = "Lowercase";
        }
        else if (Character.isDigit(charac))
        {
            output2 = "Number";
        }
        else
        {
            output2 = "Bogus";
        }

        return output2;
    }
}
