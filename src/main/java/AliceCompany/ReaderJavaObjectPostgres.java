package AliceCompany;

import java.sql.*;

public class ReaderJavaObjectPostgres {
    public static void main(String[] args) throws Exception {
        // Подключение к базе данных PostgreSQL
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "postgres5432");

        // Получение сотрудника по ID
        EmployeeInPostgres employee = getEmployeeById(connection, 2);
        System.out.println(employee);
    }

    // Метод для получения сотрудника по ID
    public static EmployeeInPostgres getEmployeeById(Connection connection, int id) throws Exception {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee WHERE id = ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        statement.setInt(1, id);

        ResultSet results = statement.executeQuery();
        if (!results.first())
            return null;

        // Заполнение объекта Employee данными из ResultSet
        EmployeeInPostgres employee = new EmployeeInPostgres();
        employee.id = results.getInt(1);
        employee.name = results.getString(2);
        employee.occupation = results.getString(3);
        employee.salary = results.getInt(4);
        employee.age = results.getInt(5);
        employee.joinDate = results.getDate(6);
        return employee;
    }
}
