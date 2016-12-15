package employeeProgramme.database;

import employeeProgramme.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperateDB
{
    private Connection con;

    public OperateDB(Connection con)
    {
        this.con = con;
    }

    //Method run only once to create employee table
    public void createEmployeeTable() throws SQLException
    {
        Statement statement = con.createStatement();

        statement.executeUpdate("CREATE TABLE employee (" +
                "id INTEGER NOT NULL AUTO_INCREMENT," +
                "first_name VARCHAR(50) NOT NULL," +
                "last_name VARCHAR(100) NOT NULL," +
                "dob DATE NOT NULL," +
                "employee_id VARCHAR(10) NOT NULL," +
                "hire_date DATE NOT NULL," +
                "position VARCHAR(50) NOT NULL," +
                "PRIMARY KEY (id))");
    }

    public List<Employee> query(String queryStrings) throws SQLException
    {
        Statement statement = con.createStatement();

        ResultSet rs;
        Employee temp;
        List<Employee> tempEmployees = new ArrayList<>();

        //get the result from ResultSet object, executeQuery method returns ResultSet
        rs = statement.executeQuery(queryStrings);
        while(rs.next())
        {
            //for each row inside a ResultSet
            temp = new Employee(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4).toLocalDate(),
                    rs.getString(5),
                    rs.getDate(6).toLocalDate(),
                    rs.getString(7)
            );

            tempEmployees.add(temp);
        }
        return tempEmployees;
    }

    public List<Employee> queryAll() throws SQLException
    {
        return query("SELECT * FROM employee");
    }

    public void addEmployee(Employee temp) throws SQLException
    {
        PreparedStatement statement = con.prepareStatement(
                "INSERT INTO employee " +
                        "(first_name,last_name,dob,employee_id,hire_date,position) VALUES" +
                        " (?,?,?,?,?,?)");

        statement.setString(1, temp.getFirstName());
        statement.setString(2, temp.getLastName());
        statement.setDate(3, Date.valueOf(temp.getDob()));
        statement.setString(4, temp.getEmployeeId());
        statement.setDate(5, Date.valueOf(temp.getHireDate()));
        statement.setString(6, temp.getPosition());

        statement.executeUpdate();
        statement.close();
    }
}
