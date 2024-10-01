package AliceCompany;

import java.sql.*;

public class ConnectorDBPostgres {
    public static void main(String[] args) throws SQLException {
        // Подключение к базе данных PostgreSQL
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "postgres5432");

        // Выполнение запроса к таблице employee
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM employee");

        // Обработка результатов запроса
        while (results.next()) {
            Integer id = results.getInt(1);
            String name = results.getString(2);
            System.out.println(results.getRow() + ". " + id + "\t" + name);
        }
        System.out.println();

        // Получение метаданных результата
        ResultSetMetaData metaData = results.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            String name = metaData.getColumnName(column);
            String className = metaData.getColumnClassName(column);
            String typeName = metaData.getColumnTypeName(column);
            int type = metaData.getColumnType(column);

            System.out.println(name + "\t" + className + "\t" + typeName + "\t" + type);
        }
        System.out.println();

        // Получение количества записей в таблице employee
        ResultSet countResults = statement.executeQuery("SELECT Count(*) FROM employee");
        countResults.next();
        int count = countResults.getInt(1);
        System.out.printf("Employee count in employee table is %d%n", count);
    }
}
