package today.streamapi.problems.oct29.pojo;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    private int id;
    private String firstName;
    private int age;
    private String gender;
    private String dept;
    private String city;
    private int rank;
    private List<String> contacts;
}
