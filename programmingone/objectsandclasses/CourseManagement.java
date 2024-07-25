package programmingone.objectsandclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManagement {
  private static List<Course> courses = new ArrayList<>();
  private static Map<Integer, Student> students = new HashMap<>();

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

  private static Course findCourse(String courseCode) {
    for (Course course : courses) {
      if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
        return course;
      }
    }

    return null;
  }
}
