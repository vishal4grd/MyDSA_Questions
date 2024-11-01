package today.streamapi.problems.oct29.problem;

import today.streamapi.problems.oct29.pojo.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionsJava8 {
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+91870548691", "784215493111")),
                new Student(2, "Amit", 25, "Male", "Computer Science", "Delhi", 67, Arrays.asList("+919876543210", "9012345678")),
                new Student(3, "Rahul", 28, "Male", "Electrical Engineering", "Kolkata", 124, Arrays.asList("+919876543210", "9012345678")),
                new Student(4, "Vivek", 32, "Female", "Civil Engineering", "Chennai", 125, Arrays.asList("+919876543210", "9012345678")),
                new Student(5, "Sachin", 29, "Male", "Electronics Engineering", "Hyderabad", 126, Arrays.asList("+919876543210", "9012345678")),
                new Student(6, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 90, Arrays.asList("+91870548691", "784215493111")),
                new Student(7, "Amit", 25, "Male", "Computer Science", "Delhi", 123, Arrays.asList("+919876543210", "9012345678")),
                new Student(8, "Rahul", 28, "Female", "Electrical Engineering", "Karnataka", 124, Arrays.asList("+919876543210", "9012345678")),
                new Student(9, "Vivek", 32, "Male", "Civil Engineering", "Chennai", 125, Arrays.asList("+919876543210", "9012345678")),
                new Student(10, "Sachin", 29, "Female", "Electronics Engineering", "Karnataka", 126, Arrays.asList("9876543210", "9012345678")),
                new Student(11, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("870548691", "784215493111")),
                new Student(12, "Amit", 25, "Male", "Computer Science", "Delhi", 123, Arrays.asList("9876543210", "9012345678"))
        ).collect(Collectors.toList());

//        1. Find the list of student whose rank is between 50 and 100

        List<Student> collect = studentList.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100).collect(Collectors.toList());
//        collect.forEach(System.out::println);

//        2. Find the Students who stays in Karnataka and names
        List<Student> studentStaysInKarnataka = studentList.stream()
                .filter(student -> student.getCity().equalsIgnoreCase("Karnataka"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());
//        studentStaysInKarnataka.forEach(System.out::println);

//         3. Find all departments names with no duplicate
        List<String> deptNames = studentList.stream()
                .map(Student::getDept)
                .distinct()
                .collect(Collectors.toList());

//        deptNames.forEach(System.out::println);

        //another way
        Set<String> deptNames1 = studentList.stream()
                .map(Student::getDept)
                .collect(Collectors.toSet());
//        deptNames1.forEach(System.out::println);

//        4. Find all the contact numbers
//        It is returning list of list but I want only list of contact number

        List<String> contactNumber = studentList.stream()
                .flatMap(student -> student.getContacts().stream())
                .collect(Collectors.toList());
//        System.out.println(contactNumber);

        //one2one - use map
        //one2many - use flatMap

//         5. Group The Student By Department Names
        Map<String, List<Student>> stuByDeptNames = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept));
//        System.out.println(stuByDeptNames);
//        stuByDeptNames.entrySet().forEach(e -> System.out.println(e.getKey() + e.getValue()));
        for(Map.Entry<String, List<Student>> entry : stuByDeptNames.entrySet()){
//            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
//        I just want the count of each dept like how many students are there
        Map<String, Long> deptWiseResult = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.counting()));
//        System.out.println(deptWiseResult);
//        6. Find the department who is having maximum number of student
        Map.Entry<String, Long> stringLongEntry = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
//        System.out.println(stringLongEntry);

//         7. Find the average age of male and female students
        Map<String, Double> avgAgeOfMaleAndFemale = studentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
//        System.out.println(avgAgeOfMaleAndFemale);

//        8. Find the highest rank in each department
        Map<String, Optional<Student>> studentEachDept = studentList.stream().collect(Collectors.groupingBy(Student::getDept , Collectors.minBy(Comparator.comparing(Student::getRank))));
//        System.out.println(studentEachDept);
//        studentEachDept.entrySet().forEach(e -> System.out.println(e.getKey() + e.getValue()));


//        9 . Find the student who has second rank
        Student sortedStudent = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(2)
                .findFirst().get();

//        System.out.println(sortedStudent.getRank());


    }
}
