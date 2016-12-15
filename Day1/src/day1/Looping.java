package day1;

public class Looping
{
    public static void main(String[] args)
    {
        String[] data = {"A", "B", "C", "D"};

        //while, do while
        whileLoop(data);
        doWhile(data);

        //for
        forLoop(data);

        //foreach
    }

    static void whileLoop(String[] input)
    {
        int index = 0;
        while (index < input.length)
        {
            if(input[index].equals("B")) {
                System.out.println("Found!");
                break;
            }
            index++;
        }
    }

    static void doWhile(String[] input)
    {
        int index = 0;

        do
        {
            if(input[index].equals("C"))
            {
                System.out.println(input[index]);
            }
            index++;
        } while(index < input.length);
    }

    static void forLoop(String[] input)
    {
        String result = "";

        for(int index = 0; index < input.length; index++)
        {
            result += String.format(input[index] + " ");
        }
        System.out.println(result);
    }

    static void foreachLoop(String[] input)
    {
        for(String letter: input)
        {
            System.out.println(letter);
        }
    }
}
