package employeeProgramme.behaviours;

import employeeProgramme.models.Employee;

public class EmployeeFirstNamePredicate implements EmployeePredicate {
    @Override
    public boolean test(Employee employee, String input) {
        return employee.getFirstName().equalsIgnoreCase(input);
    }
}
