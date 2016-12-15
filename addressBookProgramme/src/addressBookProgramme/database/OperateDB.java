package addressBookProgramme.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import addressBookProgramme.models.Contact;

public class OperateDB 
{
    private Connection con;

    public OperateDB(Connection con)
    {
        this.con = con;
    }

    //Method run only once to create employee table
    public void createContactTable() throws SQLException
    {
        Statement statement = con.createStatement();

        statement.executeUpdate("CREATE TABLE contact (" +
                "id INTEGER NOT NULL AUTO_INCREMENT," +
                "first_name VARCHAR(50) NOT NULL," +
                "last_name VARCHAR(100) NOT NULL," +
                "phone_number INTEGER NOT NULL," +
                "street VARCHAR(50) NOT NULL," +
                "city VARCHAR(50)," +
                "post_code VARCHAR(50) NOT NULL," +
                "country VARCHAR(50) NOT NULL," +
                "PRIMARY KEY (id))");
    }

    public List<Contact> query(String queryStrings) throws SQLException
    {
        Statement statement = con.createStatement();

        ResultSet rs;
        Contact temp;
        List<Contact> tempContacts = new ArrayList<>();

        //get the result from ResultSet object, executeQuery method returns ResultSet
        rs = statement.executeQuery(queryStrings);
        while(rs.next())
        {
            //for each row inside a ResultSet
            temp = new Contact(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
            );

            tempContacts.add(temp);
        }
        return tempContacts;
    }

    public List<Contact> queryAll() throws SQLException
    {
        return query("SELECT * FROM employee");
    }

    public void addContact(Contact temp) throws SQLException
    {
        PreparedStatement statement = con.prepareStatement(
                "INSERT INTO employee " +
                        "(first_name,last_name,dob,employee_id,hire_date,position) VALUES" +
                        " (?,?,?,?,?,?)");

        statement.setString(1, temp.getPerson().getFirstName());
        statement.setString(2, temp.getPerson().getLastName());
        statement.setLong(3, temp.getPhoneNumber());
        statement.setString(4, temp.getAddress().getStreet());
        statement.setString(5, temp.getAddress().getCity());
        statement.setString(6, temp.getAddress().getPostCode());
        statement.setString(7, temp.getAddress().getCountry());

        statement.executeUpdate();
        statement.close();
    }
}
