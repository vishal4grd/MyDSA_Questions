package today.streamapi.problems;

import today.pojo.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {
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
        employees.add(new Employee(3, "Abdul Daniel", 40000.0, 25, "HR", "HR Manager", "901 Maple St"));

//        Find list of employees whose name starts with alphabet A

            List<String> empNameWithA = employees.stream().filter(e -> e.getName().startsWith("A") || e.getName().startsWith("a")).map(Employee::getName).collect(Collectors.toList());
//        empNameWithA.forEach(System.out::println);

//        Group The employees By Department Names
        Map<String, List<Employee>> empWithDepName = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        for (Map.Entry<String, List<Employee>> entry : empWithDepName.entrySet()) {
//            System.out.println("Department: " + entry.getKey());
            for (Employee employee : entry.getValue()) {
//                System.out.println(employee.getName());
            }
        }


//        Find the max age of employees
        int maxAge = employees.stream().mapToInt(Employee::getAge).max().getAsInt();
//        System.out.println("Max Age : " + maxAge);

//        Find all department names (used set here to get the unique dept name )
        Set<String> deptNames = employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
//        System.out.println(deptNames);

//        Sort the employees based on their name
        List<Employee> nameSortedAsc = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
//        nameSortedAsc.forEach(System.out::println);
        for(Employee name: nameSortedAsc){
//            System.out.println(name.getName()); // this is a way to print only the employee name
        }
//        to get only the list of employee name
        List<String> empNameInAsc = employees.stream().map(Employee::getName).distinct().sorted().collect(Collectors.toList());
//        System.out.println(empNameInAsc);

//        sort with name and age with no duplicate
        List<Employee> empSortedWithNameAndAge = employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).distinct().collect(Collectors.toList());
//        empSortedWithNameAndAge.forEach(System.out::println);
//        sort employee in reverse order
        List<Employee> empSortedRevWithNameAndAge = employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge).reversed())
                                                    .distinct().collect(Collectors.toList());
//        empSortedRevWithNameAndAge.forEach(System.out::println);

//         print List of employee age in reverse order
        List<Employee> empAgeInRevOrder = employees.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
//        empAgeInRevOrder.forEach(System.out::println);

//         Print the highest salary employee in each department
        Map<String, Employee> highestSalInEachDept = employees.stream().collect(Collectors.groupingBy
                (Employee::getDepartment , Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
//        highestSalInEachDept.entrySet().forEach(e -> System.out.printf("Department : %s , Salary : %.2f%n", e.getKey(), e.getValue().getSalary()));
//        highestSalInEachDept.entrySet().forEach(e -> System.out.println("Department : " + e.getKey() + "        Salary : " + e.getValue()));

//         Find department wise counting of employee
        Map<String , Long> deptWiseCounting = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        deptWiseCounting.forEach((k,v) -> System.out.printf("Department : %s , Employee in each department : %d%n", k , v));

//         Find the department name which has the highest number of employee
        Map<String, Long> deptNameWhichHasHighestNumOfEmp = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        System.out.println(deptNameWhichHasHighestNumOfEmp.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());

//         Find the department names that these employees work for , where the number in employees in the department is over 3.
        Map<String , Long> deptMorethan3emp = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        deptMorethan3emp.entrySet().stream().filter(e -> e.getValue() > 3).forEach(System.out::println);
//         Find the department wise highest Salary

        Map<String , Optional<Employee>> deptWiseHighestSalary = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        deptWiseHighestSalary.entrySet().forEach(e -> System.out.printf("Deptartment Name : %s , Highest Salary: %.2f%n ", e.getKey() , e.getValue().get().getSalary()));
    }
}
