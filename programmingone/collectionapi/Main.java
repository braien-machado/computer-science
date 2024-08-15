package programmingone.collectionapi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    EmployeeManager.main();
  }
}

class Employee {
  private String name;
  private int age;
  private String department;
  private double salary;

  public Employee(String name, int age,  String department, double salary) {
    this.name = name;
    this.age = age;
    this.department = department;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getDepartment() {
    return department;
  }

  public double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return "Employee Information:\n" +
      "Name: " + name + "\n" +
      "Department: " + department + "\n" +
      "Age: " + age + "\n" +
      "Salary: $" + String.format("%.2f", salary);
  }
}

class EmployeeManager {
  private static int ageThreshold = -1;

  private EmployeeManager() {
    throw new IllegalStateException("Utility class");
  }

  private static void println(String message) {
    System.out.println(message);
  }

  private static void print(String message) {
    System.out.print(message);
  }

  public static void main() {
    println("Please, provide a dataset count");

    Scanner scanner = new Scanner(System.in);
    List<Employee> employees = new ArrayList<>();

    int datasetCount = 0;

    while(true) {
      println("A valid dataset count range is greater than 1 and less than or equal to 10");
      print("Your dataset count -> ");

      try {
        int input = Integer.parseInt(scanner.nextLine());

        if (input > 1 && input <= 10) {
          datasetCount = input;
          break;
        }
      } catch (Exception e) {
        println("Invalid dataset count. Try again.");
      }
    }

    int i = 0;
    while (i < datasetCount) {
      println("Enter an employee name, age, department, and salary, splitted by semicolon. E.g: Bruce, 27, Department, 50000.00");
      print("Your entry -> ");

      String input = scanner.nextLine().trim();

      var parts = input.split(",");

      try {
        if (parts.length != 4) {
          throw new IllegalArgumentException("You must provide 4 parts of information, splitted by semicolon.");
        }

        String name = parts[0].trim();

        if (name.isEmpty()) {
          throw new IllegalArgumentException("The name part cannot be empty");
        }

        int age = parseAge(parts[1].trim());

        String department = parts[2].trim();

        if (department.isEmpty()) {
          throw new IllegalArgumentException("The department part cannot be empty");
        }

        double salary;

        salary = parseSalary(parts[3].trim());

        Employee employee = new Employee(name, age, department, salary);

        employees.add(employee);

        println("Employee dataset successfully added.");
        i += 1;
      } catch (Exception e) {
        println(e.getMessage());
      }
    }

    interface ToStringFunction<T> {
      public String applyAsString(T x);
    }

    ToStringFunction<Employee> concatenateDetails = (Employee employee) -> employee.getName() + " - " + employee.getDepartment();

    var employeeDetails = employees.stream().map(concatenateDetails::applyAsString).toList();

    if (!employeeDetails.isEmpty()) {
      employeeDetails.forEach(EmployeeManager::println);
    } else {
      println("No data at the moment");
    }

    OptionalDouble averageSalary = employees.stream().mapToDouble(Employee::getSalary).average();

    if (averageSalary.isPresent()) {
      BigDecimal avgSalary = BigDecimal.valueOf(averageSalary.getAsDouble());
      println("Average Salary in USD: " + avgSalary);
    } else {
      println("No employees to calculate average salary.");
    }

    println("Enter a age threshold to filter the employees");

    while (true) {
      print("Your entry -> ");

      try {
        int threshold = Integer.parseInt(scanner.nextLine());

        if (threshold >= 0) {
          ageThreshold = threshold;
          break;
        }

        throw new IllegalArgumentException();
      } catch (Exception e) {
        println("Invalid threshold. Age threshold must be greater than or equal to zero");
      }
    }

    List<Employee> filteredEmployees = employees.stream().filter(employee -> employee.getAge() >= ageThreshold).toList();

    if (filteredEmployees.isEmpty()) {
      println("No employees with that age threshold");
    } else {
      filteredEmployees.forEach(em -> println(em.toString()));
    }

    println("The program ends here. Bye for now.");
    scanner.close();
  }

  private static double parseSalary(String string) {
    try {
      double salaryInput = Double.parseDouble(string);

      if (salaryInput < 0) {
        throw new IllegalArgumentException();
      }

      return salaryInput;
    } catch (Exception e) {
      throw new IllegalArgumentException("The salary part must be realistic...");
    }
  }

  private static int parseAge(String string) {
    try {
      int ageInput = Integer.parseInt(string);

      if (ageInput <= 0) {
        throw new IllegalArgumentException();
      }

      return ageInput;
    } catch (Exception e) {
      throw new IllegalArgumentException("The age part must be realistic...");
    }
  }
}

