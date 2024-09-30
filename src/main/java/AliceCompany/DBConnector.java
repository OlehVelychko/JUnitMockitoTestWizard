package AliceCompany;

import java.sql.*;

public class DBConnector {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javarush_sql",
                "root", "AL5432al5432");

        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM user");

        while (results.next()) {
            Integer id = results.getInt(1);
            String name = results.getString(2);
            System.out.println(results.getRow() + ". " + id + "\t"+ name);
        }
        System.out.println();

        ResultSetMetaData metaData = results.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++)
        {
            String name = metaData.getColumnName(column);
            String className = metaData.getColumnClassName(column);
            String typeName = metaData.getColumnTypeName(column);
            int type = metaData.getColumnType(column);

            System.out.println(name + "\t" + className + "\t" + typeName + "\t" + type);
        }
        System.out.println();

        ResultSet count_results = statement.executeQuery("SELECT Count(*) FROM user");
        count_results.next();
        int count = count_results.getInt(1);
        System.out.printf("users count in user table is %d", count);
    }
}
