package programmingone.objectsandclasses;

import java.util.HashSet;
import java.util.Set;

public class Course {
  private String courseCode;
  private String courseName;
  private int maximumCapacity;
  private int currentEnrollment;
  private static int totalEnrolledStudents = 0;
  private static Set<String> courseCodes = new HashSet<>();

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

  public String getCourseCode() {
    return courseCode;
  }

  public String getCourseName() {
    return courseName;
  }

  public int getMaximumCapacity() {
    return maximumCapacity;
  }

  public int getCurrentEnrollment() {
    return currentEnrollment;
  }

  public static int getTotalEnrolledStudents() {
    return totalEnrolledStudents;
  }

  private static void setTotalEnrolledStudents(int totalEnrolledStudents) {
    Course.totalEnrolledStudents = totalEnrolledStudents;
  }

  public void incrementEnrollment() {
    if (this.currentEnrollment < this.maximumCapacity) {
      currentEnrollment++;
      setTotalEnrolledStudents(Course.totalEnrolledStudents + 1);
      return;
    }

    System.out.println("Course capacity reached.");
  }

  @Override
  public String toString() {
    return "Course{" +
      "courseCode='" + courseCode + '\'' +
      ", courseName='" + courseName + '\'' +
      ", maximumCapacity=" + maximumCapacity +
      '}';
  }
}
