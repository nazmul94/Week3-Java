package day1;


public class Task4
{
    public static void main(String[] args)
    {
        switchOperator(2,3,'+');
    }

    static void switchOperator(int op1, int op2, char opr)
    {
        int result = 0;

        switch (opr)
        {
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op1 - op2;
                break;
            case '*':
                result = op1 * op2;
                break;
            case '/':
                result = op2 == 0? 0: op1 / op2;
                break;
            default:
                System.out.println("Enter valid operator");
        }
        System.out.println("Result: " + result);
    }
}
