package programmingone.objectsandclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a student in the system.
 */
public class Student {
    private String studentName;
    private int studentID;
    private List<Course> enrolledCourses;
    private Map<Course, Integer> grades;
    private static int idCounter = 1;

    /**
     * Constructs a new Student with the specified name.
     * 
     * @param studentName the name of the student
     */
    public Student(String studentName) {
        this.studentName = studentName;
        this.studentID = idCounter;
        idCounter++;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    /**
     * Gets the name of the student.
     * 
     * @return the student's name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Gets the unique ID of the student.
     * 
     * @return the student's ID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Gets the list of courses the student is currently enrolled in.
     * 
     * @return a list of enrolled courses
     */
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * Gets the map of grades assigned to the student, where each entry 
     * contains a course and the corresponding grade.
     * 
     * @return a map of courses and their associated grades
     */
    public Map<Course, Integer> getGrades() {
        return grades;
    }

    /**
     * Enrolls the student in the specified course if there is space available 
     * in the course. If the course is at full capacity, a message is printed 
     * indicating that the capacity has been reached.
     * 
     * @param course the course to enroll the student in
     */
    public void enrollInCourse(Course course) {
        if (course.getCurrentEnrollment() < course.getMaximumCapacity()) {
            enrolledCourses.add(course);
            course.incrementEnrollment();
            return;
        }

        System.out.println("Course capacity reached.");
    }

    /**
     * Assigns a grade to the student for a specific course. If the student is not 
     * enrolled in the course or the grade is not in the valid range (0-100), 
     * appropriate messages are printed.
     * 
     * @param course the course for which the grade is being assigned
     * @param grade the grade to assign, must be between 0 and 100 inclusive
     */
    public void assignGrade(Course course, int grade) {
        if (enrolledCourses.contains(course)) {
            if (grade >= 0 && grade <= 100) {
                grades.put(course, grade);
                return;
            }

            System.out.println("Invalid grade. Must be between 0 and 100.");
            return;
        }

        System.out.println("Student not enrolled in the course.");
    }

    /**
     * Returns a string representation of the student.
     * 
     * @return a string representing the student's details
     */
    @Override
    public String toString() {
        return "Student{" +
            "studentName='" + studentName + '\'' +
            ", studentID=" + studentID +
            '}';
    }
}
