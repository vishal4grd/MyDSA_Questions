package today.streamapi.problems;

import today.pojo.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SteramApiQuestions {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 50000.0, 30, "IT", "Software Engineer", "123 Main St"));
        employees.add(new Employee("Jane Smith", 60000.0, 28, "Finance", "Accountant", "456 Elm St"));
        employees.add(new Employee("Bob Johnson", 70000.0, 35, "Marketing", "Manager", "789 Oak St"));
        employees.add(new Employee("Alice Brown", 40000.0, 25, "HR", "HR Manager", "901 Maple St"));
        employees.add(new Employee("Mike Davis", 55000.0, 32, "IT", "Data Analyst", "111 Pine St"));
        employees.add(new Employee("Emily Chen", 65000.0, 29, "Finance", "Financial Analyst", "222 Cedar St"));
        employees.add(new Employee("David Lee", 75000.0, 38, "Marketing", "Marketing Manager", "333 Spruce St"));
        employees.add(new Employee("Sarah Taylor", 45000.0, 26, "HR", "HR Generalist", "444 Fir St"));
        employees.add(new Employee("Kevin White", 60000.0, 31, "IT", "IT Manager", "555 Willow St"));
        employees.add(new Employee("Lisa Nguyen", 70000.0, 36, "Finance", "Financial Manager", "666 Oak St"));

        //Find list of employees whose name starts with alphabet A

        List<Employee> aEmp = employees.stream().filter(e -> e.getName().startsWith("A") || e.getName().startsWith("a")).collect(Collectors.toList());
        System.out.println(aEmp.get(0).getName());

        //Group The employees By Department Names
//        Map<String, List<Employee>> deptMap = employees.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment()));
        Map<String, List<Employee>> deptMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)); // or we can replace the lambda expn by method reference
        for (Map.Entry<String, List<Employee>> entry : deptMap.entrySet()) {
            for (Employee emp : entry.getValue()) {
                System.out.println(emp.getDepartment());
            }
        }
        //Find the max age of employees
//        int maxAge = employees.stream().mapToInt(emp -> emp.getAge()).max().getAsInt();
        int maxAge = employees.stream().mapToInt(Employee::getAge).max().getAsInt();
        System.out.println("Max age is :  " + maxAge);

//        Find all department names
        List<String> deptNames = employees.stream().map(Employee::getDepartment).collect(Collectors.toList());
        System.out.println(deptNames);

//        Find the count of employee in each department
        Map<String, Long> listCount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Count of employee in each department :  " + listCount);
    }
}
