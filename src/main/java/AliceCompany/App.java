package AliceCompany;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javarush_sql",
                "root", "AL5432al5432");

        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM user");

        while (results.next()) {
            Integer id = results.getInt(1);
            String name = results.getString(2);
            System.out.println(results.getRow() + ". " + id + "\t"+ name);
        }
    }
}
