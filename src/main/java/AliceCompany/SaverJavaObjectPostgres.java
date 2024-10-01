package AliceCompany;

import java.sql.*;

public class SaverJavaObjectPostgres {
    public static void main(String[] args) throws Exception {
        // Подключение к базе данных PostgreSQL
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "postgres5432");

        // Создание объекта Employee и добавление его в базу данных
        EmployeeInPostgres employee = new EmployeeInPostgres();
        employee.name = "Rita";
        employee.occupation = "Service Manager";
        employee.salary = 1000000;
        employee.age = 35;
        employee.joinDate = Date.valueOf("2018-09-10");

        boolean added = addEmployee(connection, employee);
        System.out.println("Employee added: " + added);
    }

    // Метод для добавления сотрудника в базу данных
    public static boolean addEmployee(Connection connection, EmployeeInPostgres employee) throws Exception {
        String insertQuery = "INSERT INTO employee(name, occupation, salary, age, join_date) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);

        statement.setString(1, employee.name);
        statement.setString(2, employee.occupation);
        statement.setInt(3, employee.salary);
        statement.setInt(4, employee.age);
        statement.setDate(5, employee.joinDate);

        int count = statement.executeUpdate();
        return count > 0;
    }
}
