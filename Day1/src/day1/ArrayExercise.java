package day1;

public class ArrayExercise {

    public static void main(String[] args)
    {
        //Task 1
        int[] data1 = {1,2,6};
        int[] data2 = {6,1,2,3};
        int[] data3 = {3,2,1};
        System.out.println("Task 1 : " + firstLast6(data1));
        System.out.println("Task 1 : " + firstLast6(data2));
        System.out.println("Task 1 : " + firstLast6(data3));

        //Task 2
        int[] data21 = {1,2,3};
        int[] data22 = {1,2,3,1};
        int[] data23 = {1,2,1};
        System.out.println("Task 2 : " + sameFirstLast(data21));
        System.out.println("Task 2 : " + sameFirstLast(data22));
        System.out.println("Task 2 : " + sameFirstLast(data23));

        //Task 3
        int[] dat31 = {7,3};
        int[] data32 = {7,3,2};
        int[] data33 = {1,3};
        System.out.println("Task 3 : " + commonEnd(data21, dat31));
        System.out.println("Task 3 : " + commonEnd(data21, data32));
        System.out.println("Task 3 : " + commonEnd(data21, data33));

        //Task 4
        int[] data42 = {11,5,9};
        int[] data43 = {2,11,3};
        System.out.print("Task 4 : ");
        for(int i: maxEnd3(data21))
        {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.print("Task 4 : ");
        for(int i: maxEnd3(data42))
        {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.print("Task 4 : ");
        for(int i: maxEnd3(data43))
        {
            System.out.print(i + ",");
        }
        System.out.println();

        //Task 5
        int[] data51 = {2,5};
        int[] data52 = {4,3};
        int[] data53 = {4,5};
        System.out.println("Task 5 : " + has23(data51));
        System.out.println("Task 5 : " + has23(data52));
        System.out.println("Task 5 : " + has23(data53));

        //Task 6
        int[] data61 = {2,1,2,3,4};
        int[] data62 = {2,2,0};
        int[] data63 = {1,3,5};
        System.out.println("Task 6 : " + numOfEven(data61));
        System.out.println("Task 6 : " + numOfEven(data62));
        System.out.println("Task 6 : " + numOfEven(data63));

        //Task 7
        int[] data71 = {10,3,5,6};
        int[] data72 = {7,2,10,9};
        int[] data73 = {2,10,7,2};
        System.out.println("Task 7 : " + bigDiff(data71));
        System.out.println("Task 7 : " + bigDiff(data72));
        System.out.println("Task 7 : " + bigDiff(data73));

        //Task 8
        int[] data81 = {1,2,2,1};
        int[] data82 = {1,1};
        int[] data83 = {1,2,2,1,13,4,3};
        System.out.println("Task 8 : " + sum13(data81));
        System.out.println("Task 8 : " + sum13(data82));
        System.out.println("Task 8 : " + sum13(data83));

        //Task 9
        int[] data91 = {1,2,2};
        int[] data92 = {1,2,2,6,88,99,7};
        int[] data93 = {1,1,6,7,2};
        System.out.println("Task 9 : " + sum67(data91));
        System.out.println("Task 9 : " + sum67(data92));
        System.out.println("Task 9 : " + sum67(data93));

        //Task 10
        int[] data101 = {1,2,2};
        int[] data102 = {1,2,1,2};
        int[] data103 = {2,1,2};
        System.out.println("Task 10 : " + has22(data101));
        System.out.println("Task 10 : " + has22(data102));
        System.out.println("Task 10 : " + has22(data103));
    }

    static boolean firstLast6(int[] input)
    {
        return (input[0] == 6 || input[input.length-1] == 6);
    }

    static boolean sameFirstLast(int[] input)
    {
        return (input[0] == input[input.length-1]);
    }

    static boolean commonEnd(int[] input1, int[] input2)
    {
        return (input1[0] == input2[0] || input1[input1.length-1] == input2[input2.length-1]);
    }

    static int[] maxEnd3(int[] input)
    {
        int val = input[0] > input[input.length-1]? input[0] : input[input.length-1];
        int[] newArray = new int[3];
        for (int i = 0; i < 3; i++)
        {
            newArray[i] = val;
        }
        return newArray;
    }

    static boolean has23(int[] input)
    {
        return (input[0] ==2 || input[0] == 3 || input[1] == 2 || input[1] == 3);
    }

    static int numOfEven(int[] input)
    {
        int numOfEven = 0;
        for(int num : input)
        {
            if(num % 2 == 0)
            {
                numOfEven++;
            }
        }
        return  numOfEven;
    }

    static int bigDiff(int[] input)
    {
        int bigNumber = input[0];
        int smallNumber = input[0];
        for(int index = 0; index < input.length; index++)
        {
            if(input[index] > bigNumber)
            {
                bigNumber = input[index];
            }
            if(input[index] < smallNumber)
            {
                smallNumber = input[index];
            }
        }
        return bigNumber - smallNumber;
    }

    static int sum13(int[] input)
    {
        int sum = 0;
        for(int number : input)
        {
            if(number == 13)
                break;
            sum += number;
        }
        return sum;
    }

    static int sum67(int[] input)
    {
        int sum = 0;
        boolean canAdd = true;
        for(int index = 0; index < input.length; index++)
        {
            if(canAdd && input[index] !=6)
            {
                sum += input[index];
            }
            else if (input[index] == 6)
            {
                canAdd = false;
            }
            else if(input[index] == 7)
            {
                canAdd = true;
            }
        }
        return sum;
    }

    static boolean has22(int[] input)
    {
        boolean firstTwo = false;
        boolean secondTwo = false;
        for(int index = 0; index < input.length; index++)
        {
            if(input[index] == 2)
            {
                if(firstTwo)
                {
                    secondTwo = true;
                }
                else
                {
                    firstTwo = true;
                }
            }
            else
            {
                firstTwo = false;
            }
        }
        return secondTwo;
    }
}
