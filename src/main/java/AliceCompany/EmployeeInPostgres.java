package AliceCompany;

import java.sql.Date;

public class EmployeeInPostgres {
    public Integer id;
    public String name;
    public String occupation;
    public Integer salary;
    public Integer age;
    public Date joinDate;

    @Override
    public String toString() {
        return "EmployeeInPostgres{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", joinDate=" + joinDate +
                '}';
    }
}
