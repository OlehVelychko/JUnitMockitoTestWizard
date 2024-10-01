package AliceCompany;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="task")
public class EmployeeTaskInPostgres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Для автоинкрементного поля
    @Column(name="id")
    public Integer id;

    @Column(name="name", nullable = false)
    public String description;

    // Связь многие-к-одному с employee
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    public EmployeeInPostgres employee;

    @Column(name="deadline")
    public Date deadline;
}
