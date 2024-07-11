package programmingone.staticmethodsandmembervariables.recordmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The {@code Main} class is the entry point for the Student Record Management System application.
 */
public class Main {
  /**
   * The main method that starts the Student Record Management System program.
   *
   * @param args the command line arguments
   */
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

  /**
   * Returns a string representation of the student.
   *
   * @return a string representation of the student
   */
  public String toString() {
    return String.format("{ ID: %d, Name: %s, Age: %d, Grade: %d }", id, name, age, grade);
  }

  /**
   * Updates the student's name, age, and grade.
   *
   * @param name the new name of the student
   * @param age the new age of the student
   * @param grade the new grade of the student
   */
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

/**
 * The {@code StudentRecordManagementSystem} class provides methods to manage student records,
 * including adding, updating, and viewing student information.
 * This class cannot be instantiated and is designed for utility purposes.
 */
class StudentRecordManagementSystem {

    /** Scanner for user input. */
    private static final Scanner scanner = new Scanner(System.in);

    /** List to store student records. */
    private static final ArrayList<Student> students = new ArrayList<>();

    /** Divider line for console output. */
    private static final String DIVIDER = "------------------------------------------------------";

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private StudentRecordManagementSystem() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Adds a new student to the system.
     *
     * @param name  the name of the student
     * @param age   the age of the student
     * @param grade the grade of the student
     */
    private static void addStudent(String name, short age, short grade) {
        Student student = new Student(name, age, grade);
        students.add(student);
        System.out.println("Student added successfully!");
        System.out.println(student.toString());
    }

    /**
     * Updates the information of an existing student.
     *
     * @param id    the ID of the student to update
     * @param name  the new name of the student
     * @param age   the new age of the student
     * @param grade the new grade of the student
     */
    private static void updateStudent(int id, String name, short age, short grade) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.update(name, age, grade);
                System.out.println("Student updated successfully!");
                System.out.println(student.toString());
                return;
            }
        }
        System.out.println("Student with ID does not exist in our storage.");
    }

    /**
     * Displays the details of a student.
     *
     * @param id the ID of the student to view
     */
    private static void viewStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println(student.toString());
                return;
            }
        }
        System.out.println("Student with ID does not exist in our storage.");
    }

    /**
     * Starts the student record management program.
     * Displays a menu and prompts the user for actions.
     */
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
            case 0 -> doExit();
            default -> {
                break;
            }
        }
    }

    /**
     * Prints the menu options for the user.
     */
    private static void printMenuOptions() {
        System.out.println(DIVIDER);
        System.out.println("1. Add New Student");
        System.out.println("2. Update Student Information");
        System.out.println("3. View Student Details");
        System.out.println("0. Exit");
        System.out.println(DIVIDER);
    }

    /**
     * Prints the menu header and options for the user.
     */
    private static void printMenu() {
        System.out.println(DIVIDER);
        System.out.println("UoPeople Demo SRM - Administrator Interface");
        printMenuOptions();
        System.out.println("Your choice must be 1, 2, 3, or 0 that must correspond to the option based on the action you chose to perform");
    }

    /**
     * Prints the prompt for user choice.
     */
    private static void printChoicePrompt() {
        System.out.println(DIVIDER);
        System.out.print("Your Choice =>: ");
    }

    /**
     * Gets the user's menu choice.
     *
     * @return the user's choice as an integer
     */
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

    /**
     * Prompts the user for a valid student name.
     *
     * @return the student name as a string
     */
    private static String getStudentNameInput() {
        String studentName;

        while (true) {
            System.out.println(DIVIDER);
            System.out.print("Student name =>: ");
            studentName = scanner.nextLine();

            if (studentName.length() >= 2 && studentName.length() <= 50) {
                break;
            }

            System.out.println("Invalid Student name.");
        }

        return studentName;
    }

    /**
     * Prompts the user for a valid student age.
     *
     * @return the student age as a short
     */
    private static short getStudentAgeInput() {
        short studentAge;

        while (true) {
            System.out.println(DIVIDER);
            System.out.print("Student age =>: ");
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

    /**
     * Prompts the user for a valid student grade.
     *
     * @return the student grade as a short
     */
    private static short getStudentGradeInput() {
        short studentGrade;

        while (true) {
            System.out.println(DIVIDER);
            System.out.print("Student grade =>: ");
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

    /**
     * Prompts the user for a valid student ID.
     *
     * @return the student ID as an integer
     */
    private static int getStudentIdInput() {
        int studentId;

        while (true) {
            System.out.println(DIVIDER);
            System.out.print("Enter the Student ID or 0 to exit this procedure =>: ");

            try {
                studentId = Integer.parseInt(scanner.nextLine());

                if (studentId < 0) {
                    System.out.println("Invalid Student ID. Student ID must be positive integer");
                } else if (studentId == 0 || idExists(studentId)) {
                    break;
                } else {
                    System.out.println("No student found with the ID provided.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Student ID. Student ID must be positive integer");
            }
        }

        return studentId;
    }

    /**
     * Prompts the user for student information and adds a new student to the system.
     */
    private static void doAddStudent() {
        System.out.println("You chose to add a new student. You must enter the name, age and grade for the student. Note that:");
        System.out.println("\tStudent name length must range from 2 to 50");
        System.out.println("\tStudent age must range from 6 to 100");
        System.out.println("\tStudent grade must range from 6 to 100");

        String studentName = getStudentNameInput();
        short studentAge = getStudentAgeInput();
        short studentGrade = getStudentGradeInput();

        addStudent(studentName, studentAge, studentGrade);
    }

    /**
     * Prompts the user for student ID and updates the student's information if the ID exists.
     */
    private static void doUpdateStudent() {
        System.out.println("You chose to update student information. You will be asked for the Student ID first, if it exists, you can then update the name, age and grade.\nNote that:");
        System.out.println("\tStudent ID must be positive integer");
        System.out.println("\tStudent name length must range from 2 to 50");
        System.out.println("\tStudent age must range from 6 to 100");
        System.out.println("\tStudent grade must range from 6 to 100");

        int studentId = getStudentIdInput();

        if (studentId == 0) return;

        String studentName = getStudentNameInput();
        short studentAge = getStudentAgeInput();
        short studentGrade = getStudentGradeInput();

        updateStudent(studentId, studentName, studentAge, studentGrade);
    }

    /**
     * Prompts the user for student ID and displays the student's details if the ID exists.
     */
    private static void doViewStudent() {
        System.out.println("You chose to view student details. You will be asked for the Student ID first, if it exists, the details will be displayed.\nNote that:");
        System.out.println("\tStudent ID must be positive integer");

        int studentId = getStudentIdInput();

        if (studentId == 0) return;

        viewStudent(studentId);
    }

    /**
     * Exits the program.
     */
    private static void doExit() {
        System.out.println("You chose to exit the program, bye for now!");
    }

    /**
     * Checks if a student ID exists in the system.
     *
     * @param id the ID to check
     * @return true if the ID exists, false otherwise
     */
    private static boolean idExists(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
