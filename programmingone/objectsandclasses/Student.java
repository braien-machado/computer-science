package programmingone.objectsandclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
  private String studentName;
  private int studentID;
  private List<Course> enrolledCourses;
  private Map<Course, Integer> grades;
  private static int idCounter = 1;

  public Student(String studentName) {
    this.studentName = studentName;
    this.studentID = idCounter;
    idCounter++;
    this.enrolledCourses = new ArrayList<>();
    this.grades = new HashMap<>();
  }

  public String getStudentName() {
    return studentName;
  }

  public int getStudentID() {
    return studentID;
  }

  public List<Course> getEnrolledCourses() {
    return enrolledCourses;
  }

  public Map<Course, Integer> getGrades() {
    return grades;
  }

  public void enrollInCourse(Course course) {
    if (course.getCurrentEnrollment() < course.getMaximumCapacity()) {
      enrolledCourses.add(course);
      course.incrementEnrollment();
      return;
    }

    System.out.println("Course capacity reached.");
  }

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

  @Override
  public String toString() {
    return "Student{" +
      "studentName='" + studentName + '\'' +
      ", studentID=" + studentID +
      '}';
  }
}
