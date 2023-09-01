import java.sql.*;
import com.mysql.cj.jdbc.Driver;


public class JDBCEmployees {
    public static void main(String[] args) throws SQLException {

        DriverManager.registerDriver(new Driver());

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/codeup_test_db?allowPublicKeyRetrieval=true&useSSL=false",
                "root2",
                "tryagain"
        );

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT first_name FROM employees LIMIT 10");
        while (rs.next()){
            System.out.println(rs.getString(1));
        }


    }
}
