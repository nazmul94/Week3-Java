package employeeProgramme.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//List<T> (Reference Type - objects based NOT primitives)
public class GeneratedEmployees
{
    public static List<Employee> employees = new ArrayList<>();

    //Method to create database
    public static void createEmployees()
    {
        Employee alex = new Employee(1, "Alex", "Kennedy", LocalDate.of(1983,4,16), "JIT001",LocalDate.of(2010,10,10), "Trainer");
        Employee nazmul = new Employee(2, "Nazmul", "Mumtahin", LocalDate.of(1994,9,21), "JIT002",LocalDate.of(2016,11,28), "Trainee");
        Employee david = new Employee(3, "Alex", "Bechkam", LocalDate.of(1980,2,11), "FootBaller",LocalDate.of(1999,02,02), "Captain of BFC");
        Employee james = new Employee(4, "James", "Bond", LocalDate.of(1973,1,23), "007",LocalDate.of(2007,4,2), "Agent");

        employees.add(alex);
        employees.add(nazmul);
        employees.add(david);
        employees.add(james);
    }
}
