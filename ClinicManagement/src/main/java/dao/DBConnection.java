package dao;
import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:49161:XE", "abhi", "qwert");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

