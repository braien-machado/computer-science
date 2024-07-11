package programmingone.staticmethodsandmembervariables.recordmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    StudentRecordManagementSystem.startProgram();
  }
}

/**
 * The {@code Student} class represents a student with a unique ID, name, age, and grade.
 * The ID is automatically assigned and incremented for each new student instance.
 */
class Student {

  /** Counter to generate unique student IDs. */
  private static int idCounter = 1;

  /** The name of the student. */
  String name;

  /** The unique ID of the student. */
  int id = 0;

  /** The age of the student. */
  short age;

  /** The grade of the student. */
  short grade;

  /**
   * Constructs a new {@code Student} with the specified name, age, and grade.
   * The unique ID is automatically assigned.
   *
   * @param name the name of the student
   * @param age the age of the student
   * @param grade the grade of the student
   */
  public Student(String name, short age, short grade) {
      this.name = name;
      this.age = age;
      this.grade = grade;
      this.id = idCounter++;
  }

  public String toString() {
    return String.format("{ ID: %d, Name: %s, Age: %d, Grade: %d }", id, name, age, grade);
  }

  void update(String name, short age, short grade) {
    this.name = name;
    this.age = age;
    this.grade = grade;
  }

  /**
   * Returns the unique ID of the student.
   *
   * @return the ID of the student
   */
  public int getId() {
      return id;
  }
}
 
class StudentRecordManagementSystem {
  private static Scanner scanner = new Scanner(System.in);
  private static ArrayList<Student> students = new ArrayList<>();

  private static final String DIVIDER = "------------------------------------------------------"; 
  
  private static void addStudent(String name, short age, short grade) {
    Student student = new Student(name, age, grade);

    students.add(student);

    System.out.println("Student added successfully!");
    System.out.println(student.toString());
  }

  private static void updateStudent(int id, String name, short age, short grade) {
    for (int index = 0; index < students.size(); index += 1) {
      Student student = students.get(index);
      if (student.id == id) {
        student.update(name, age, grade);
        System.out.println("Student updated successfully!");
        System.out.println(student.toString());
        return;
      }
    }

    System.out.println("Student with ID does not exist in our storage.");
  }

  private static void viewStudent(int id) {
    for (int index = 0; index < students.size(); index += 1) {
      Student student = students.get(index);
      if (student.id == id) {
        System.out.println(student.toString());
        return;
      }
    }

    System.out.println("Student with ID does not exist in our storage.");
  }

  public static void startProgram() {
    printMenu();
    int choice = doGetChoice();

    switch (choice) {
      case 1 -> {
        doAddStudent();
        startProgram();
      }
      case 2 -> {
        doUpdateStudent();
        startProgram();
      }
      case 3 -> {
        doViewStudent();
        startProgram();
      }
      case 0 -> {
        doExit();
      }
      default -> {
        break;
      }
    }
  }

  private static void printMenuOptions() {
    System.out.println(DIVIDER);
    System.out.println("1. Add New Student");
    System.out.println("2. Update Student Information");
    System.out.println("3. View Student Details");
    System.out.println("0. Exit");
    System.out.println(DIVIDER);
  }

  private static void printMenu() {
    System.out.println("UoPeople Demo SRM - Administrator Interface");
    printMenuOptions();
    System.out.println("Your choice must be 1, 2, 3, or 0 that must correspond\nto the option based on the action you chose to perform");
    System.out.println(DIVIDER);
  }

  private static void printChoicePrompt() {
    System.out.print("Your Choice =>: ");
  }

  private static int doGetChoice() {
    int choice = -1;
    boolean isChoice = false;

    printChoicePrompt();

    String invalidChoiceMessage = "Invalid choice. Your choice must be 1, 2, 3 or 0";

    while (!isChoice) {
      try {
        choice = Integer.parseInt(scanner.nextLine());

        if (choice < 0 || choice > 3) {
          System.out.println(invalidChoiceMessage);
          printChoicePrompt();
        } else {
          isChoice = true;
        }
      } catch (NumberFormatException e) {
        System.out.println(invalidChoiceMessage);
        printChoicePrompt();
      }
    }

    return choice;
  }

  private static String getStudentNameInput() {
    String studentName;

    while (true) {
      System.out.println("Student name =>: ");
      studentName = scanner.nextLine();

      if (studentName.length() >= 2 && studentName.length() <= 50) {
        break;
      }

      System.out.println("Invalid Student name.");
    }

    return studentName;
  }

  private static short getStudentAgeInput() {
    short studentAge;

    while (true) {
      try {
        studentAge = Short.parseShort(scanner.nextLine());

        if (studentAge >= 6 && studentAge <= 100) {
          break;
        }
  
        System.out.println("Invalid Student age.");

      } catch (NumberFormatException e) {
        System.out.println("Invalid Student age.");
      }
    }

    return studentAge;
  }

  private static short getStudentGradeInput() {
    short studentGrade;

    while (true) {
      try {
        studentGrade = Short.parseShort(scanner.nextLine());

        if (studentGrade >= 0 && studentGrade <= 100) {
          break;
        }
  
        System.out.println("Invalid Student grade.");

      } catch (NumberFormatException e) {
        System.out.println("Invalid Student grade.");
      }
    }

    return studentGrade;
  }

  private static int getStudentIdInput() {
    int studentId;

    while (true) {
      System.out.println("Enter the Student ID or 0 to exit this procedure =>: ");

      try {
        studentId = Integer.parseInt(scanner.nextLine());

        if (studentId < 0) {
          System.out.println("Invalid Student ID. Student ID must be positive integer");
        } else if (studentId == 0 || idExists(studentId)) {
          break;
        }
  
        System.out.println("No student found with the ID provided.");
      } catch (NumberFormatException e) {
        System.out.println("Invalid Student ID. Student ID must be positive integer");
      }
    }

    return studentId;
  }

  private static void doAddStudent() {
    System.out.println("You chose to add a new student. You must enter the name, age and grade for the student. Note that:");
    System.out.println("\tStudent name length must range from 2 to 50");
    System.out.println("\tStudent age must range from 6 to 100");
    System.out.println("\tStudent grade must range from 6 to 100");
    System.out.println(DIVIDER);

    String studentName = getStudentNameInput();
    short studentAge = getStudentAgeInput();
    short studentGrade = getStudentGradeInput();

    addStudent(studentName, studentAge, studentGrade);
  }

  private static void doUpdateStudent() {
    System.out.println("You chose to update student information. You will be asked for the Student ID first, if it exists, you can then update the name, age and grade.\nNote that:");
    System.out.println("\tStudent ID must be positive integer");
    System.out.println("\tStudent name length must range from 2 to 50");
    System.out.println("\tStudent age must range from 6 to 100");
    System.out.println("\tStudent grade must range from 6 to 100");
    System.out.println(DIVIDER);

    int studentId = getStudentIdInput();

    if (studentId == 0) return;

    String studentName = getStudentNameInput();
    short studentAge = getStudentAgeInput();
    short studentGrade = getStudentGradeInput();

    updateStudent(studentId, studentName, studentAge, studentGrade);
  }

  private static void doViewStudent() {
    System.out.println("You chose to view student details. You will be asked for the Student ID first, if it exists, the details will be displayed.\nNote that:");
    System.out.println("\tStudent ID must be positive integer");
    System.out.println(DIVIDER);

    int studentId = getStudentIdInput();

    if (studentId == 0) return;

    viewStudent(studentId);
  }

  private static void doExit() {
    System.out.println("You chose to exit the program, bye for now!");
  }

  private static boolean idExists(int id) {
    for (int index = 0; index < students.size(); index += 1) {
      Student student = students.get(index);
      if (student.id == id) {
        return true;
      }
    }

    return false;
  }
}
