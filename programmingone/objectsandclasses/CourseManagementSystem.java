package programmingone.objectsandclasses;

/**
 * The entry point for the Course Enrollment and Grade Management System (CEGMS).
 * This class contains the `main` method that starts the application.
 */
public class CourseManagementSystem {
    
    /**
     * The main method to launch the Course Enrollment and Grade Management System.
     * It initializes the application by displaying a welcome message and
     * invoking the `startProgram` method from the `AdministratorInterface` class.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Demo UoPeople Course Enrollment and Grade Management System (CEGMS)");

        AdministratorInterface.startProgram();
    }
}
