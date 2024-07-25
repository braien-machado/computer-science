package programmingone.objectsandclasses;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a course in the system.
 */
public class Course {
    private String courseCode;
    private String courseName;
    private int maximumCapacity;
    private int currentEnrollment;
    private static int totalEnrolledStudents = 0;
    private static Set<String> courseCodes = new HashSet<>();

    /**
     * Constructs a new Course with the specified details.
     * 
     * @param courseCode the unique code for the course
     * @param courseName the name of the course
     * @param maximumCapacity the maximum number of students that can enroll in the course
     * @throws IllegalArgumentException if the course code already exists
     */
    public Course(String courseCode, String courseName, int maximumCapacity) {
        if (Course.courseCodes.contains(courseCode)) {
            throw new IllegalArgumentException("Course code already exists.");
        }

        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maximumCapacity = maximumCapacity;
        this.currentEnrollment = 0;
        Course.courseCodes.add(courseCode);
    }

    /**
     * Gets the course code.
     * 
     * @return the course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Gets the course name.
     * 
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Gets the maximum capacity of the course.
     * 
     * @return the maximum capacity
     */
    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    /**
     * Gets the current number of students enrolled in the course.
     * 
     * @return the current enrollment
     */
    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    /**
     * Gets the total number of students enrolled across all courses.
     * 
     * @return the total number of enrolled students
     */
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    /**
     * Sets the total number of students enrolled across all courses.
     * 
     * @param totalEnrolledStudents the total number of enrolled students
     */
    private static void setTotalEnrolledStudents(int totalEnrolledStudents) {
        Course.totalEnrolledStudents = totalEnrolledStudents;
    }

    /**
     * Increments the current enrollment by one, if the maximum capacity has not been reached.
     * Updates the total number of enrolled students across all courses.
     */
    public void incrementEnrollment() {
        if (this.currentEnrollment < this.maximumCapacity) {
            currentEnrollment++;
            setTotalEnrolledStudents(Course.totalEnrolledStudents + 1);
            return;
        }

        System.out.println("Course capacity reached.");
    }

    /**
     * Returns a string representation of the course.
     * 
     * @return a string representing the course details
     */
    @Override
    public String toString() {
        return "Course{" +
            "courseCode='" + courseCode + '\'' +
            ", courseName='" + courseName + '\'' +
            ", maximumCapacity=" + maximumCapacity +
            '}';
    }
}
