package employeeProgramme.behaviours;

import employeeProgramme.models.Employee;

public interface EmployeePredicate
{
    //Define Behaviour
    boolean test(Employee employee, String input);
}
