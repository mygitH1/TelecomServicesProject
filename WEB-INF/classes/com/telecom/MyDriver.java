/*
 * MyDriver.java
 */

package com.telecom;
import java.sql.*;

public class MyDriver {
    
    /** Creates a new instance of MyDriver */
    private MyDriver() {}
    
    static Connection con;

    public static Connection getConnection()throws Exception
    {
        if (con==null)
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:rams","telecom","telecom");
        }
        else
        {
            if(con.isClosed())
            {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con=DriverManager.getConnection("jdbc:odbc:telecom","telecom","telecom");
            }
        }
        return con;
    }
}