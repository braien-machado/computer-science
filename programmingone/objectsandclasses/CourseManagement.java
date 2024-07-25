package programmingone.objectsandclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A utility class for managing courses and students in the system.
 * Provides methods to add courses, enroll students, assign grades, 
 * and calculate overall grades.
 */
public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static Map<Integer, Student> students = new HashMap<>();

    private CourseManagement() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Adds a new course to the system.
     * 
     * @param courseCode the unique code of the course
     * @param courseName the name of the course
     * @param maximumCapacity the maximum number of students that can enroll in the course
     */
    public static void addCourse(String courseCode, String courseName, int maximumCapacity) {
        try {
            Course course = new Course(courseCode, courseName, maximumCapacity);
            courses.add(course);
            System.out.println("Course added successfully");
            System.out.println(course);
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    /**
     * Enrolls a student in a specified course if the student ID and course code are valid 
     * and if there is space available in the course.
     * 
     * @param studentID the ID of the student
     * @param courseCode the code of the course
     */
    public static void enrollStudent(int studentID, String courseCode) {
        Student student = students.get(studentID);
        Course course = findCourse(courseCode);

        if (student != null && course != null) {
            student.enrollInCourse(course);

            System.out.println("Student enrolled successfully");
            System.out.println(student);
            System.out.println(course);
            return;
        }

        System.out.println("Invalid student ID or course code.");
    }

    /**
     * Assigns a grade to a student for a specified course. Validates that the student is enrolled 
     * in the course and that the grade is within the range of 0 to 100.
     * 
     * @param studentID the ID of the student
     * @param courseCode the code of the course
     * @param grade the grade to be assigned, must be between 0 and 100 inclusive
     */
    public static void assignGrade(int studentID, String courseCode, int grade) {
        Student student = students.get(studentID);
        Course course = findCourse(courseCode);

        if (student != null && course != null) {
            student.assignGrade(course, grade);

            System.out.println("Grade assigned successfully");
            System.out.println(student);
            System.out.println(course);
            return;
        }

        System.out.println("Invalid student ID or course code.");
    }

    /**
     * Calculates the overall grade point average (GPA) for a student based on their grades.
     * 
     * @param studentID the ID of the student
     * @return the GPA of the student, or -1 if the student ID is invalid or no grades are available
     */
    public static double calculateOverallGrade(int studentID) {
        Student student = students.get(studentID);

        if (student == null) {
            System.out.println("Invalid student ID.");
            return -1;
        }

        Map<Course, Integer> grades = student.getGrades();

        if (grades.size() == 0) {
            System.out.println("No grades available for the student.");
            return -1;
        }

        System.out.println("Grades for student");
        System.out.println(student);

        double totalGrades = 0;

        for (Map.Entry<Course, Integer> entry : grades.entrySet()) {
            Course course = entry.getKey();
            int grade = entry.getValue();

            System.out.println(course);
            System.out.printf("Grade: %d%n", grade);

            totalGrades += convertGradeToPoints(grade);
        }

        return totalGrades / grades.size();
    }

    /**
     * Converts a numerical grade to grade points based on predefined ranges.
     * 
     * @param grade the grade to convert
     * @return the equivalent grade points
     */
    private static double convertGradeToPoints(int grade) {
        if (grade >= 94) return 4;
        if (grade >= 90) return 3.7;
        if (grade >= 84) return 3.3;
        if (grade >= 80) return 3;
        if (grade >= 74) return 2.7;
        if (grade >= 70) return 2.3;
        if (grade >= 60) return 2;
        if (grade >= 50) return 1;
        return 0;
    }

    /**
     * Adds a new student to the system with the specified name.
     * 
     * @param studentName the name of the student
     */
    public static void addStudent(String studentName) {
        try {
            Student student = new Student(studentName);
            students.put(student.getStudentID(), student);

            System.out.println("Student added successfully");
            System.out.println(student);
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    /**
     * Displays all available courses in the system.
     */
    public static void viewAllCourses() {
        if (courses.size() == 0) {
            System.out.println("No Courses Available at the moment. You need to add courses.");
            return;
        }

        System.out.println("Available Courses:");

        for (Course course : courses) {
            System.out.println(course);
        }
    }

    /**
     * Displays all students currently enrolled in the system.
     */
    public static void viewAllStudents() {
        if (students.size() == 0) {
            System.out.println("No Students have been enrolled in a course yet. You need to enroll students.");
            return;
        }

        System.out.println("Enrolled Students:");

        for (Student student : students.values()) {
            System.out.println(student);
        }
    }

    /**
     * Finds and returns a course by its code.
     * 
     * @param courseCode the code of the course to find
     * @return the course with the specified code, or null if no such course exists
     */
    private static Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }

        return null;
    }
}
