
package computerShop.ui;
import computerShop.main.TaskProcessing;
import java.util.Scanner;

public class CommandInterface
{
    private static Scanner input = new Scanner(System.in);

    public static void display()
    {
        int choice;
        boolean _isRunning = true;

        while(_isRunning) {

            do {
                System.out.println("Welcome to MR. Robot's Computer Shop");
                System.out.println("1. List all Computers");
                System.out.println("2. Add a new Computer");
                System.out.println("3. Search a Computer");
                System.out.println("4. Edit a listed Computer");
                System.out.println("5. Remove a Computer");
                System.out.println("6. Sort by name");
                System.out.println("7. Exit this programme");
                System.out.println("Enter an option code: ");

                choice = input.nextInt();
            } while (choice < 1 || choice > 7);

            switch (choice)
            {
                case 1:
                    TaskProcessing.listAllComputers();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    break;

            }
        }
    }
}
