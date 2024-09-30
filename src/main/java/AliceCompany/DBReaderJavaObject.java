package AliceCompany;

import java.sql.*;

public class DBReaderJavaObject {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javarush_sql",
                "root", "AL5432al5432");

        Statement statement = connection.createStatement();

        Employee employee = new Employee();

        Employee employeeById = getEmployeeById(connection, 2);
        System.out.println(employeeById);

    }

    public static Employee getEmployeeById(Connection connection, int id) throws Exception {
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
        Employee employee = new Employee();
        employee.id = results.getInt(1);
        employee.name = results.getString(2);
        employee.occupation = results.getString(3);
        employee.salary = results.getInt(4);
        employee.joinDate = results.getDate(5);
        return employee;
    }
}
