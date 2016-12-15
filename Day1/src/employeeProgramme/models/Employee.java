package employeeProgramme.models;

import sun.util.resources.cldr.lag.LocaleNames_lag;

import java.time.LocalDate;

public class Employee extends Person
{
    //fields
    private String employeeId;
    private LocalDate hireDate;
    private String position;

    //Constructor
    public Employee() {}

    public Employee(int id, String firstName, String lastName, LocalDate dob, String employeeId, LocalDate hireDate, String position) {
        super(id, firstName, lastName, dob);
        this.employeeId = employeeId;
        this.hireDate = hireDate;
        this.position = position;
    }

    //Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s %s %s", super.toString(), this.employeeId, this.hireDate, this.position);
    }
}
