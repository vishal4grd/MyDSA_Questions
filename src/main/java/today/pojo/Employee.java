package today.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;
    private String department;
    private String designation;
    private String address;

}