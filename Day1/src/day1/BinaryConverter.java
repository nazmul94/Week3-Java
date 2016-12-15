package day1;

public class BinaryConverter
{
    public static void main(String[] args)
    {
        convertBinary("1010");
    }

    static void convertBinary(String numberAsString)
    {
        int result = 0;
        int multiplier = 1;

        for(int index = numberAsString.length()-1; index >= 0; index--)
        {
            if(numberAsString.charAt(index) == '1')
            {
                result += multiplier;
            }
            multiplier *= 2;
        }
        System.out.println("Decimal value: " + result);
    }
}
