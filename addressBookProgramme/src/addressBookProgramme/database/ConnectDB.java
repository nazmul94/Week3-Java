package addressBookProgramme.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB
{
    private Connection con;

    private final String username = "nazmul";
    private final String password = "Password100";
    private final String url = "jdbc:mysql://localhost:3306/EmployeeProgramme?UseSSL=false";

    public ConnectDB() throws Exception
    {
        //load the driver
        Class.forName("com.mysql.jdbc.Driver");
        //Connect to mySQL
        con = DriverManager.getConnection(url, username,password);
    }

    //Getter
    public Connection getCon()
    {
        return con;
    }
}
