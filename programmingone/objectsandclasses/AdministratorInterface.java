package programmingone.objectsandclasses;

import java.util.Scanner;

public class AdministratorInterface {
  private AdministratorInterface() {
    throw new IllegalStateException("Utility class");
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void startProgram() {
    printMenu();
    int choice = doGetChoice();

    switch (choice) {
      case 1 -> {
        getUserInputAndAddTheCourse();
        startProgram();
        break;
      }
      case 2 -> {
        getUserInputAndAddTheStudent();
        startProgram();
        break;
      }
      case 3 -> {
        getUserInputAndEnrollTheStudent();
        startProgram();
        break;
      }
      case 4 -> {
        getUserInputAndAssignTheStudentAGrade();
        startProgram();
        break;
      }
      case 5 -> {
        getUserInputAndCalculateTheStudentOverallGrade();
        startProgram();
        break;
      }
      case 6 -> {
        viewAllCourses();
        startProgram();
        break;
      }
      case 7 -> {
        viewAllStudents();
        startProgram();
        break;
      }
      case 8 -> {
        doExit();
        break;
      }
      default -> {
        printRepeatedMark();
        System.out.println("Invalid choice. Please try again.");
        startProgram();
      }
    }
  }

  private static void printChoicePrompt() {
    System.out.print("Your Choice =>: ");
  }

  private static void printMenuOptions() {
    printRepeatedMark();
    System.out.println("1. Add a new course");
    System.out.println("2. Add a new student");
    System.out.println("3. Enroll a student in a course");
    System.out.println("4. Assign grade to a student");
    System.out.println("5. Calculate overall grade for a student");
    System.out.println("6. View all available courses");
    System.out.println("7. View all enrolled students");
    System.out.println("8. Exit");
    printRepeatedMark();
}

  private static void printMenu() {
    printRepeatedMark();
    System.out.println("Welcome to UoPeople CEGMS");
    System.out.println("Please enter the number corresponding to the operation you want to perform");
    printMenuOptions();
  }

  private static int doGetChoice() {
    int choice = -1;
    boolean isChoice = false;

    printChoicePrompt();

    String invalidChoiceMessage = "Invalid choice. The options are: 1, 2, 3, 4, 5, 6, 7 or 8";

    while (!isChoice) {
      try {
        choice = Integer.parseInt(scanner.nextLine());

        if (choice < 1 || choice > 8) {
          printRepeatedMark();
          System.out.println(invalidChoiceMessage);
          printRepeatedMark();
          printChoicePrompt();
        } else {
          isChoice = true;
        }
      } catch (NumberFormatException e) {
        printRepeatedMark();
        System.out.println(invalidChoiceMessage);
        printRepeatedMark();
        printChoicePrompt();
      }
    }

    return choice;
  }

  private static void printRepeatedMark() {
    System.out.println(Character.toString('=').repeat(40));
  }

  private static void doExit() {
    printRepeatedMark();
    System.out.println("You chose to quit the program. Bye for now");
    printRepeatedMark();
  }

  private static void goBackToMainMenu(String message) {
    printRepeatedMark();
    System.out.println(message);
  }

  private static void getUserInputAndCalculateTheStudentOverallGrade() {
    int studentID = 0;

    studentID = getStudentIdInput("Enter the Known Student ID to calculate the overall grade or enter letter Q to quit the procedure: ");

    if (studentID == 0) {
      goBackToMainMenu("You chose to quit the \"Calculate overall grade for a student\" Procedure");
      return;
    }

    double overallGrade = CourseManagement.calculateOverallGrade(studentID);

    if (overallGrade != -1) {
      System.out.printf("Overall Grade: %.1f (%s)%n", overallGrade, convertGradeToLetter(overallGrade));
    }
  }

  private static int getStudentIdInput(String initialMessage) {
    int studentID = 0;

    while (studentID <= 0) {
      printRepeatedMark();
      System.out.print(initialMessage);
  
      String userInput = scanner.nextLine();
  
      if (userInput.equalsIgnoreCase("Q")) {
        return 0;
      }
  
      try {
        studentID = Integer.parseInt(userInput);
  
      } catch (NumberFormatException e) {
        printRepeatedMark();
        System.out.println("Invalid Student ID value. The value must be positive integer greater than 0");
      }
    }

    return studentID;
  }

  private static String getStringInput(String initialMessage) {
    String input = "";

    while (input.length() == 0) {
      printRepeatedMark();
      System.out.print(initialMessage);
  
      input = scanner.nextLine().trim();
  
      if (input.equalsIgnoreCase("Q")) {
        return null;
      }
    }

    return input;
  }

  private static void getUserInputAndAssignTheStudentAGrade() {
    int studentID = 0;
    int grade = -1;
    String courseCode = "";

    String quitMessage = "You chose to quit the \"Assign grade to a student\" Procedure";

    studentID = getStudentIdInput("Enter the Known Student ID to grade or enter letter Q to quit the procedure: ");

    if (studentID == 0) {
      goBackToMainMenu(quitMessage);
      return;
    }

    courseCode = getStringInput("Enter the Course Code to grade for the student or enter letter Q to quit the procedure: ");

    if (courseCode == null) {
      goBackToMainMenu(quitMessage);
      return;
    }

    while (grade < 0) {
      printRepeatedMark();
      System.out.print("Enter the Grade to Assign the student or enter letter Q to quit the procedure: ");
  
      String userInput = scanner.nextLine();
  
      if (userInput.equalsIgnoreCase("Q")) {
        goBackToMainMenu(quitMessage);
        return;
      }
  
      try {
        int parsedInput = Integer.parseInt(userInput);

        if (parsedInput < 0 && parsedInput > 100) {
          throw new NumberFormatException();
        }
        
        grade = parsedInput;
      } catch (NumberFormatException e) {
        printRepeatedMark();
        System.out.println("Invalid grade value. The value must be positive integer between 0 and 100 inclusive");
      }
    }

    CourseManagement.assignGrade(studentID, courseCode, grade);
  }

  private static void getUserInputAndEnrollTheStudent() {
    int studentID = 0;
    String courseCode = "";

    String quitMessage = "You chose to quit the \"Enroll a student in a course\" Procedure";

    studentID = getStudentIdInput("Enter the Known Student ID to enroll or enter letter Q to quit the procedure: ");

    if (studentID == 0) {
      goBackToMainMenu(quitMessage);
      return;
    }

    courseCode = getStringInput("Enter the Course Code to grade for the student or enter letter Q to quit the procedure: ");

    if (courseCode == null) {
      goBackToMainMenu(quitMessage);
      return;
    }

    CourseManagement.enrollStudent(studentID, courseCode);
  }

  private static void getUserInputAndAddTheStudent() {
    String studentName = "";

    studentName = getStringInput("Enter the Student Full name or enter letter Q to quit the procedure: ");

    if (studentName == null) {
      goBackToMainMenu("You chose to quit the \"Add a new student\" Procedure");
      return;
    }

    CourseManagement.addStudent(studentName);
  }

  private static void getUserInputAndAddTheCourse() {
    String courseCode = "";
    String courseName = "";
    int capacity = 0;

    String quitMessage = "You chose to quit the \"Add a new course\" Procedure";

    courseCode = getStringInput("Enter the Course Code or enter letter Q to quit the procedure: ");

    if (courseCode == null) {
      goBackToMainMenu(quitMessage);
      return;
    }

    courseName = getStringInput("Enter the Course Name or enter letter Q to quit the procedure: ");

    if (courseName == null) {
      goBackToMainMenu(quitMessage);
      return;
    }

    while (capacity <= 0) {
      printRepeatedMark();
      System.out.print("Enter the Course Maximum Capacity or enter letter Q to quit the procedure: ");
  
      String userInput = scanner.nextLine();
  
      if (userInput.equalsIgnoreCase("Q")) {
        goBackToMainMenu(quitMessage);
        return;
      }
  
      try {
        int parsedInput = Integer.parseInt(userInput);

        if (parsedInput <= 0) {
          throw new NumberFormatException();
        }
        
        capacity = parsedInput;
      } catch (NumberFormatException e) {
        printRepeatedMark();
        System.out.println("Invalid capacity value. The value must be positive integer greater than 0");
      }
    }

    CourseManagement.addCourse(courseCode, courseName, capacity);
  }

  private static void viewAllCourses() {
    CourseManagement.viewAllCourses();
  }

  private static void viewAllStudents() {
    CourseManagement.viewAllStudents();
  }

  private static String convertGradeToLetter(double grade) {
    if (grade >= 4) return "A+";
    if (grade >= 3.7) return "A";
    if (grade >= 3.3) return "B+";
    if (grade >= 3) return "B";
    if (grade >= 2.7) return "C+";
    if (grade >= 2.3) return "C";
    if (grade >= 2) return "D";
    if (grade >= 1) return "E";
    return "F";
  }
}
