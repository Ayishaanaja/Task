package Encapsulation;

import java.util.ArrayList;

class Course {
 private String courseName;
 private int maxCapacity;
 private ArrayList<String> enrolledStudents;

 public Course(String courseName, int maxCapacity) {
     this.courseName = courseName;
     this.maxCapacity = maxCapacity;
     this.enrolledStudents = new ArrayList<>();
 }

 public String getCourseName() {
     return courseName;
 }

 public int getMaxCapacity() {
     return maxCapacity;
 }

 public int getEnrolledCount() {
     return enrolledStudents.size();
 }

 public void enrollStudent(String studentName) {
     if (enrolledStudents.size() < maxCapacity) {
         enrolledStudents.add(studentName);
         System.out.println(studentName + " has been enrolled in " + courseName);
     } else {
         System.out.println("Enrollment failed: " + courseName + " is full.");
     }
 }
 public void removeStudent(String studentName) {
     if (enrolledStudents.remove(studentName)) {
         System.out.println(studentName + " has been removed from " + courseName);
     } else {
         System.out.println(studentName + " is not enrolled in " + courseName);
     }
 }

 public void listStudents() {
     System.out.println("Students enrolled in " + courseName + ": " + enrolledStudents);
 }
}

public class CourseEnrollment {
 public static void main(String[] args) {
     Course course = new Course("Java Programming", 2);

     course.enrollStudent("Alice");
     course.enrollStudent("Bob");
     course.enrollStudent("Charlie"); 

     course.listStudents();

     course.removeStudent("Bob");
     course.enrollStudent("Charlie"); 
     course.listStudents();
 }
}
