package today.streamapi.problems;

import today.pojo.Employee;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamApiQuestions {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", 50000.0, 30, "IT", "Software Engineer", "123 Main St"));
        employees.add(new Employee(10, "Jane Smith", 60000.0, 28, "Finance", "Accountant", "456 Elm St"));
        employees.add(new Employee(4, "Bob Johnson", 70000.0, 35, "Marketing", "Manager", "789 Oak St"));
        employees.add(new Employee(3, "Alice Brown", 40000.0, 25, "HR", "HR Manager", "901 Maple St"));
        employees.add(new Employee(5, "Mike Davis", 55000.0, 32, "IT", "Data Analyst", "111 Pine St"));
        employees.add(new Employee(7, "Emily Chen", 65000.0, 29, "Finance", "Financial Analyst", "222 Cedar St"));
        employees.add(new Employee(6, "David Lee", 75000.0, 38, "Marketing", "Marketing Manager", "333 Spruce St"));
        employees.add(new Employee(9, "Sarah Taylor", 45000.0, 26, "HR", "HR Generalist", "444 Fir St"));
        employees.add(new Employee(8, "Kevin White", 60000.0, 31, "IT", "IT Manager", "555 Willow St"));
        employees.add(new Employee(2, "Lisa Nguyen", 70000.0, 36, "Finance", "Financial Manager", "666 Oak St"));
        employees.add(new Employee(2, "Lisa Nguyen", 70000.0, 36, "Finance", "Financial Manager", "666 Oak St"));

        //Find list of employees whose name starts with alphabet A

        List<Employee> aEmp = employees.stream().filter(e -> e.getName().startsWith("A") || e.getName().startsWith("a")).collect(Collectors.toList());
//        System.out.println(aEmp.get(0).getName());

        //Group The employees By Department Names
//        Map<String, List<Employee>> deptMap = employees.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment()));
        Map<String, List<Employee>> deptMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)); // or we can replace the lambda expn by method reference
        for (Map.Entry<String, List<Employee>> entry : deptMap.entrySet()) {
            for (Employee emp : entry.getValue()) {
//                System.out.println(emp.getDepartment());
            }
        }
        //Find the max age of employees6
//        int maxAge = employees.stream().mapToInt(emp -> emp.getAge()).max().getAsInt();
        int maxAge = employees.stream().mapToInt(Employee::getAge).max().getAsInt();
//        System.out.println("Max age is :  " + maxAge);

//        Find all department names
        List<String> deptNames = employees.stream().map(Employee::getDepartment).collect(Collectors.toList());
//        System.out.println(deptNames);

//        Find the count of employee in each department
//        Map<String, Long> listCount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        Map<String, List<Employee>> listCount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//        System.out.println("Count of employee in each department :  " + listCount);
        for (Map.Entry<String, List<Employee>> emp : listCount.entrySet()) {
//                System.out.println("Key: " + emp.getKey() + "value " +  emp.getValue());
        }
//        listCount.entrySet().stream().forEach(e-> System.out.println("Key: " + e.getKey() + "          value " +  e.getValue()));
//        listCount.entrySet().stream().forEach(e-> System.out.printf("Department name: %s , Number of Employees in each department: %s%n " , e.getKey(), e.getValue()));

        List<Employee> sortedEmplist = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
//        sortedEmplist.forEach(System.out::println);

        // sort with name and age with no duplicate
        List<Employee> sortedEmplistNameandSalary = employees.stream().distinct().sorted(Comparator.comparing(Employee::getId).thenComparing(Employee::getName)).collect(Collectors.toList());
//        sortedEmplistNameandSalary.forEach(System.out::println);

        //sort employee in reverse order
        List<Employee> sortNameRevOrder = employees.stream().distinct().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
//        sortNameRevOrder.forEach(System.out::println);

        // print List of employee age in reverse order
        List<Employee> empListAgeRevOrder = employees.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
//        empListAgeRevOrder.forEach(System.out::println);

        // Print the highest salary employee in each department

        Map<String , Employee> res = employees.stream().collect(Collectors.groupingBy
                (Employee::getDepartment, Collectors.collectingAndThen(Collectors.maxBy(
                        Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
//        res.entrySet().forEach(e -> System.out.println("Department :" + e.getKey() + "          Salary :" + e.getValue()));

        // Find department wise counting of employee
        Map<String, Long> deptWiseCounting = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        deptWiseCounting.entrySet().forEach(e -> System.out.println("Department : " + e.getKey() +"   Number of employees : " + e.getValue()));
//        deptWiseCounting.forEach((key, value) -> System.out.println("Department : " + key + "   Number of employees : " + value));
//        deptWiseCounting.forEach((key, value) -> System.out.printf("Department : %s , Number of Employees : %d%n", key, value));

//        Find the department name which has the highest number of employee
        Map<String, Long> deptNameHighSalary  = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        String depps =  deptNameHighSalary.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
//        System.out.println(" Department Name with Highest salary : " + depps);

//      Find the department names that these employees work for , where the number in employees in the department is over 3.
        Map<String, Long> deptNameHighSalary1  = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        deptNameHighSalary1.entrySet().stream().filter(e -> e.getValue() > 3).forEach(System.out::println);

//        Find the department wise highest Salary
         Map<String,Optional<Employee>> res12 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(
                 Comparator.comparingDouble(Employee::getSalary))));
//         res12.forEach((key, value)-> System.out.println("Department name  : " + key + "         Salary : " +value.get().getSalary() + "Name of the employees : "+ value.get().getName()) );
//         res12.forEach((key, value)-> System.out.printf("Department name: %s, Employee Name : %s, Salary: %.2f%n", key , value.get().getName(),
//                 value.get().getSalary()));

    }
}
