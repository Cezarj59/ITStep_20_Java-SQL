
package homework_20.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BancoDados {
 public static Connection getConn() {
        String host = "localhost";
        String port = "3306";
        String banco = "myStore";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + banco;

        String user = "root";
        String pass = "";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return conn;
    }
}
