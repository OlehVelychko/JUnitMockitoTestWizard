package AliceCompany;

import java.sql.*;

public class SaverJavaObjectMySQL {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javarush_sql",
                "root", "AL5432al5432");

        Statement statement = connection.createStatement();

        EmployeeInMySQL employeeInMySQL = new EmployeeInMySQL();
        employeeInMySQL.name = "Rita";
        employeeInMySQL.salary = 250;

        boolean added = addEmployee(connection, employeeInMySQL);
        System.out.println(added);

    }

    public static boolean addEmployee(Connection connection, EmployeeInMySQL employeeInMySQL) throws Exception {
        // Создаем и подготавливаем запрос на вставку данных в таблицу
        String insertQuery = "INSERT INTO employee(name, occupation, salary, join_date ) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);

        // Заполняем запрос данными из объекта Employee
        statement.setString(1, employeeInMySQL.name);
        statement.setString(2, employeeInMySQL.occupation);
        statement.setInt(3, employeeInMySQL.salary);
        statement.setDate(4, (Date) employeeInMySQL.joinDate);

        // Выполняем наш запрос, и он возвращает true, если новая строка добавилась
        int count = statement.executeUpdate();
        return count > 0;
    }
}
