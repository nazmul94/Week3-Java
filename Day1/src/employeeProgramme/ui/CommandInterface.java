package employeeProgramme.ui;
import com.sun.javafx.tk.Toolkit;
import employeeProgramme.main.TaskProcessing;
import employeeProgramme.models.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static employeeProgramme.models.GeneratedEmployees.employees;

public class CommandInterface
{
    private static Scanner input = new Scanner(System.in);
    private static boolean _edit = false;

    //Method to display command input ui
    public static void display()
    {
        int choice;

        boolean _isRunning = true;
        while(_isRunning)
        {
            do
            {
                System.out.println("Welcome to employee awesome Boom programme");
                System.out.println("1. List all employees");
                System.out.println("2. add a new employee");
                System.out.println("3. search");
                System.out.println("4. edit an employee");
                System.out.println("5. remove an employee");
                System.out.println("6. Sort by first name");
                System.out.println("7. BOOM terminate");
                System.out.println("Input an option");

                choice = input.nextInt();
                System.out.println();
            } while(choice < 1 || choice > 7);

            switch (choice)
            {
                case 1:
                    TaskProcessing.listAllEmployees();
                    break;
                case 2:
                    System.out.println(TaskProcessing.createNew(inputDetails(null)));
                    break;
                case 3:
                    System.out.print("Enter search string ");
                    input.nextLine();
                    List<Employee> result = TaskProcessing.search(input.nextLine());
                    if(result != null)
                    {
                        for(Employee e : result)
                            System.out.println(e);
                    } else
                        System.out.println("Not found!");
                    break;
                case 4:
                    _edit = true;
                    input.nextLine();
                    TaskProcessing.listAllEmployees();
                    System.out.print("Enter ID to edit: ");
                    int index = TaskProcessing.searchByIndex(input.nextInt());
                    if(index == -1)
                    {
                        System.out.println("Record does not exist");
                    }
                    else
                    {
                        System.out.println(TaskProcessing.editEmployee(index, inputDetails(employees.get(index))));
                    }
                    _edit = false;
                    break;
                case 5:
                    TaskProcessing.listAllEmployees();
                    System.out.println("Enter ID to remove: ");
                    int indexToRemove = TaskProcessing.searchByIndex(input.nextInt());
                    System.out.println(TaskProcessing.removeEmployee(indexToRemove));
                    break;
                case 6:
                    TaskProcessing.sortByFirstName();
                    TaskProcessing.listAllEmployees();
                    break;
                case 7:
                    _isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }

    private static List<String> inputDetails(Employee current)
    {
        List<String> tempData = new ArrayList<>();
        input.nextLine();

        System.out.print("ID: " + (_edit ? current.getId() + "\nChange to: " : ""));
        tempData.add(input.nextLine());

        System.out.print("FirstName: " + (_edit ? current.getFirstName() + "\nChange to: " : ""));
        tempData.add(input.nextLine());

        System.out.print("LastName: " + (_edit ? current.getLastName() + "\nChange to: " : ""));
        tempData.add(input.nextLine());

        System.out.print("DOB (YYYY-MM-DD): " + (_edit ? current.getDob() + "\nChange to: " : ""));
        tempData.add(input.nextLine());

        System.out.print("Employee ID: " + (_edit ? current.getEmployeeId() + "\nChange to: " : ""));
        tempData.add(input.nextLine());

        System.out.print("HireDate (YYYY-MM-DD): " + (_edit ? current.getHireDate() + "\nChange to: " : ""));
        tempData.add(input.nextLine());

        System.out.print("Position: " + (_edit ? current.getPosition() + "\nChange to: " : ""));
        tempData.add(input.nextLine());

        return tempData;
    }
}
