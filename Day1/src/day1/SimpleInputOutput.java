package day1;

import java.io.*;
import java.util.Scanner;

public class SimpleInputOutput
{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.print("Enter a string: ");
        //read the character
        char str = input.next().charAt(0);
        System.out.println("Using scanner output first char: " + str);
        System.out.println();

        System.out.print("Enter another string: ");
        String str2 = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            str2 = br.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Using input stream reader: " + str2);

        //Write to a text file
        String filename = "example.txt";
        try
        {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str2);
            bw.close();
        }
        catch (IOException ex)
        {
            System.out.println("Error writing to the file: [" + filename + "]");
        }
    }
}
