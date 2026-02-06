package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String phoneNumber;
    private String position;
    private String employmentDate;
    private double salary;
    private String department;
}
