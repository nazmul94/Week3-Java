package employeeProgramme.main;
import employeeProgramme.behaviours.EmployeeFirstNamePredicate;
import employeeProgramme.behaviours.EmployeeLastNamePredicate;
import employeeProgramme.behaviours.EmployeePositionPredicate;
import employeeProgramme.behaviours.EmployeePredicate;
import employeeProgramme.database.ConnectDB;
import employeeProgramme.database.OperateDB;
import employeeProgramme.models.Employee;

import java.net.Inet4Address;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import static employeeProgramme.models.GeneratedEmployees.employees;

public class TaskProcessing
{
    private static final int NONE = -1;
    private static OperateDB db;

    public static void setUpDB() throws Exception
    {
        ConnectDB connectDb = new ConnectDB();
        db = new OperateDB(connectDb.getCon());
        //db.createEmployeeTable();
    }

    public static void refreshAllEmployees() throws SQLException
    {
        employees.clear();
        employees = db.queryAll();
    }

    public static void listAllEmployees()
    {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public static List<Employee> searchByString(EmployeePredicate p, String input)
    {
        List<Employee> result = new ArrayList<>();
        for(Employee e: employees)
        {
            if(p.test(e, input))
            {
                result.add(e);
            }
        }
        return result;
    }

    public static List<Employee> searchByString(Predicate<Employee> p)
    {
        List<Employee> result = new ArrayList<>();
        for(Employee e: employees)
        {
            if(p.test(e))
            {
                result.add(e);
            }
        }
        return result;
    }

    public static List<Employee> search(String input)
    {
        List<Employee> result;
        result = searchByString(new EmployeeFirstNamePredicate(), input);
        if(result.isEmpty())
        {
            result = searchByString(new EmployeeLastNamePredicate(), input);
        }
        if(result.isEmpty())
        {
            result = searchByString(employee -> employee.getPosition().equalsIgnoreCase(input));
        }
        if(result.size() >= 1)
        {
            return result;
        }
        return null;
    }

    public static String createNew(List<String> data)
    {
        try{    String[] dob = data.get(2).split("-");
            String[] hireD = data.get(4).split("-");

            Employee temp = new Employee(
                    NONE,
                    data.get(0),
                    data.get(1),
                    LocalDate.of(Integer.parseInt(dob[0]),
                            Integer.parseInt(dob[1]),
                            Integer.parseInt(dob[2])),
                    data.get(3),
                    LocalDate.of(Integer.parseInt(hireD[0]),
                            Integer.parseInt(hireD[1]),
                            Integer.parseInt(hireD[2])),
                    data.get(5)
            );
            db.addEmployee(temp);
            return "Successfully added: " + temp;
        }
        catch (Exception e){
            return "Failure: " + e;
        }
    }

    public static int searchByIndex(int id)
    {
        for(int i = 0; i < employees.size(); i++)
        {
            if(employees.get(i).getId() == id)
            {
                return i;
            }
        }
        return -1;
    }

    public static String editEmployee(int id, List<String> data)
    {
        try
        {
            String[] dob = data.get(3).split("-");
            String[] hireD = data.get(5).split("-");

            if(!("".equals(data.get(0))))
            {
                employees.get(id).setId(Integer.parseInt(data.get(0)));
            }
            if(!("".equals(data.get(1))))
            {
                employees.get(id).setFirstName(data.get(1));
            }
            if(!("".equals(data.get(2))))
            {
                employees.get(id).setLastName(data.get(2));
            }
            if(!("".equals(data.get(3))))
            {
                employees.get(id).setDob(LocalDate.of(
                        Integer.parseInt(dob[0]),
                        Integer.parseInt(dob[1]),
                        Integer.parseInt(dob[2])
                ));
            }
            if(!("".equals(data.get(4))))
            {
                employees.get(id).setEmployeeId(data.get(4));
            }
            if(!("".equals(data.get(5))))
            {
                employees.get(id).setDob(LocalDate.of(
                        Integer.parseInt(hireD[0]),
                        Integer.parseInt(hireD[1]),
                        Integer.parseInt(hireD[2])
                ));
            }
            if(!("".equals(data.get(6))))
            {
                employees.get(id).setPosition(data.get(6));
            }

            return "Successfully edited: " + employees.get(id);
        } catch (Exception e)
        {
            return "Failure to edit: caused by " + e;
        }
    }

    public static String removeEmployee(int index)
    {
        if(index != -1)
        {
            if (employees.get(index) == null)
            {
                return "Does not exist";
            } else
            {
                employees.remove(index);
            }
            return "Successfully removed";
        }
        return "Does not Exist";
    }

    public static void sortByFirstName()
    {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getFirstName().compareTo(e2.getFirstName());
            }
        });
    }

    public static void sortByLastName(){
        employees.sort((e1,e2) -> e1.getLastName().compareTo(e2.getLastName()));
    }

//    public static List<Employee> searchByLastName(List<Employee> employees, String input)
//    {
//        List<Employee> result = new ArrayList<>();
//        for(Employee e: employees)
//        {
//            if(e.getLastName().equalsIgnoreCase(input))
//            {
//                result.add(e);
//            }
//        }
//
//        return result;
//    }

    public static List<Employee> searchByFirstNameAndLastName(List<Employee> employees,String input1 ,String input2)
    {
        List<Employee> result = new ArrayList<>();
        for(Employee e: employees)
        {
            if(e.getFirstName().equalsIgnoreCase(input1) && e.getLastName().equalsIgnoreCase(input2))
            {
                result.add(e);
            }
        }

        return result;
    }
}
