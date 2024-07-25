package programmingone.objectsandclasses;

import java.util.Scanner;

/**
 * A utility class providing an interactive command-line interface for administrators
 * to manage courses and students. It offers functionality to add courses, add students,
 * enroll students in courses, assign grades, calculate overall grades, and view lists
 * of courses and students.
 */
public class AdministratorInterface {
    private AdministratorInterface() {
        throw new IllegalStateException("Utility class");
    }

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Starts the program and presents the main menu to the user. 
     * Handles user input to perform various operations based on the choice.
     */
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

    /**
     * Retrieves and validates the user's choice from the menu. Ensures that the choice is
     * an integer between 1 and 8.
     * 
     * @return the valid choice entered by the user
     */
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

    /**
     * Prompts the user to enter a student ID and calculates the student's overall grade.
     * Displays the overall grade and its letter equivalent.
     */
    private static void getUserInputAndCalculateTheStudentOverallGrade() {
        int studentID = getStudentIdInput("Enter the Known Student ID to calculate the overall grade or enter letter Q to quit the procedure: ");

        if (studentID == 0) {
            goBackToMainMenu("You chose to quit the \"Calculate overall grade for a student\" Procedure");
            return;
        }

        double overallGrade = CourseManagement.calculateOverallGrade(studentID);

        if (overallGrade != -1) {
            System.out.printf("Overall Grade: %.1f (%s)%n", overallGrade, convertGradeToLetter(overallGrade));
        }
    }

    /**
     * Prompts the user to enter a student ID and validates the input.
     * 
     * @param initialMessage the message displayed to prompt the user
     * @return the validated student ID or 0 if the user chooses to quit
     */
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

                if (studentID <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                printRepeatedMark();
                System.out.println("Invalid Student ID value. The value must be positive integer greater than 0");
            }
        }

        return studentID;
    }

    /**
     * Retrieves a non-empty string input from the user.
     * 
     * @param initialMessage the message displayed to prompt the user
     * @return the validated string input or null if the user chooses to quit
     */
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

    /**
     * Prompts the user to enter details to assign a grade to a student for a specific course.
     * Validates the inputs and calls the corresponding method in `CourseManagement`.
     */
    private static void getUserInputAndAssignTheStudentAGrade() {
        int studentID = getStudentIdInput("Enter the Known Student ID to grade or enter letter Q to quit the procedure: ");

        String quitMessage = "You chose to quit the \"Assign grade to a student\" Procedure";

        if (studentID == 0) {
            goBackToMainMenu(quitMessage);
            return;
        }

        String courseCode = getStringInput("Enter the Course Code to grade for the student or enter letter Q to quit the procedure: ");

        if (courseCode == null) {
            goBackToMainMenu(quitMessage);
            return;
        }

        int grade = -1;
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

                if (parsedInput < 0 || parsedInput > 100) {
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

    /**
     * Prompts the user to enter details to enroll a student in a specific course.
     * Validates the inputs and calls the corresponding method in `CourseManagement`.
     */
    private static void getUserInputAndEnrollTheStudent() {
        int studentID = getStudentIdInput("Enter the Known Student ID to enroll or enter letter Q to quit the procedure: ");

        if (studentID == 0) {
            goBackToMainMenu("You chose to quit the \"Enroll a student in a course\" Procedure");
            return;
        }

        String courseCode = getStringInput("Enter the Course Code to enroll the student in or enter letter Q to quit the procedure: ");

        if (courseCode == null) {
            goBackToMainMenu("You chose to quit the \"Enroll a student in a course\" Procedure");
            return;
        }

        CourseManagement.enrollStudent(studentID, courseCode);
    }

    /**
     * Prompts the user to enter details to add a new student.
     * Validates the inputs and calls the corresponding method in `CourseManagement`.
     */
    private static void getUserInputAndAddTheStudent() {
        String studentName = getStringInput("Enter the Student Full name or enter letter Q to quit the procedure: ");

        if (studentName == null) {
            goBackToMainMenu("You chose to quit the \"Add a new student\" Procedure");
            return;
        }

        CourseManagement.addStudent(studentName);
    }

    /**
     * Prompts the user to enter details to add a new course.
     * Validates the inputs and calls the corresponding method in `CourseManagement`.
     */
    private static void getUserInputAndAddTheCourse() {
        String courseCode = getStringInput("Enter the Course Code or enter letter Q to quit the procedure: ");

        String quitMessage = "You chose to quit the \"Add a new course\" Procedure";

        if (courseCode == null) {
            goBackToMainMenu(quitMessage);
            return;
        }

        String courseName = getStringInput("Enter the Course Name or enter letter Q to quit the procedure: ");

        if (courseName == null) {
            goBackToMainMenu(quitMessage);
            return;
        }

        int capacity = 0;
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

    /**
     * Displays all available courses by calling the corresponding method in `CourseManagement`.
     */
    private static void viewAllCourses() {
        CourseManagement.viewAllCourses();
    }

    /**
     * Displays all enrolled students by calling the corresponding method in `CourseManagement`.
     */
    private static void viewAllStudents() {
        CourseManagement.viewAllStudents();
    }

    /**
     * Converts a numeric grade to its corresponding letter grade.
     * 
     * @param grade the numeric grade to convert
     * @return the letter grade corresponding to the numeric grade
     */
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
