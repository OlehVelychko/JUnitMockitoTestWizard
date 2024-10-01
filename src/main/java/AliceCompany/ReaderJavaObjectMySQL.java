package AliceCompany;

import java.sql.*;

public class ReaderJavaObjectMySQL {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javarush_sql",
                "root", "AL5432al5432");

        Statement statement = connection.createStatement();

        EmployeeInMySQL employeeInMySQL = new EmployeeInMySQL();

        EmployeeInMySQL employeeInMySQLById = getEmployeeById(connection, 2);
        System.out.println(employeeInMySQLById);

    }

    public static EmployeeInMySQL getEmployeeById(Connection connection, int id) throws Exception {
        // Создаем и подготавливаем запрос для получения сотрудника из таблицы
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee WHERE id = ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        statement.setInt(1, id);

        // Выполняем наш запрос, и он возвращает null, если строк в результате запроса нет
        ResultSet results = statement.executeQuery();
        if (!results.first())
            return null;

        // Заполняем объект Employee данными из ResultSet
        EmployeeInMySQL employeeInMySQL = new EmployeeInMySQL();
        employeeInMySQL.id = results.getInt(1);
        employeeInMySQL.name = results.getString(2);
        employeeInMySQL.occupation = results.getString(3);
        employeeInMySQL.salary = results.getInt(4);
        employeeInMySQL.joinDate = results.getDate(5);
        return employeeInMySQL;
    }
}
