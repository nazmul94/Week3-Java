package employeeProgramme.behaviours;

import employeeProgramme.models.Employee;

/**
 * Created by nazmu on 13-Dec-16.
 */
public class EmployeePositionPredicate implements EmployeePredicate {
    @Override
    public boolean test(Employee employee, String input) {
        return employee.getPosition().equalsIgnoreCase(input);
    }
}
