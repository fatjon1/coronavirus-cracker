package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    //$servername = "localhost"; $username = "root"; $password = "Dp6ibZWAR2vD3RiME"; $dbname = "statistics";
   //jdbc:mysql://192.168.15.25:3306/yourdatabase
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String MYSQL_DB_URL = "jdbc:mysql://localhost:3306/coronavirus";
    private static final String MYSQL_DB_USER = "root";
    private static final String MYSQL_DB_PASSWORD = "";

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName(MYSQL_DRIVER);
        Connection con = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASSWORD);
        return con;
    }
}
