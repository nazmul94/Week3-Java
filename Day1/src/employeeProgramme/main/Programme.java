package employeeProgramme.main;
import employeeProgramme.models.Employee;
import employeeProgramme.models.GeneratedEmployees;
import employeeProgramme.ui.CommandInterface;
import employeeProgramme.ui.SwingUI;

import static employeeProgramme.models.GeneratedEmployees.employees;

public class Programme
{
    public static void main(String[] args)
    {
        //Create Sample Data
        GeneratedEmployees.createEmployees();

        TaskProcessing.listAllEmployees();

        new SwingUI();

        //CommandInterface.display();
    }
}
