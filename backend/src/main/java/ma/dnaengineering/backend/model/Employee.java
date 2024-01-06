package ma.dnaengineering.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="EMP-SYSTEM")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;
    private String jobTitle;

    private double salary;


    public Employee(String employeeName, String jobTitle, double salary) {
        this.employeeName = employeeName;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
}