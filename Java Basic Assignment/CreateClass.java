// Create a class to represent a student with attributes like name, roll number, and marks.

class Student {
  // Attributes
  String name;
  int rollNumber;
  double marks;

  // constructor
  Student(String name, int rollNumber, double marks) {
    this.name = name;
    this.rollNumber = rollNumber;
    this.marks = marks;
  }

  void showStudentInfo() {
    System.out.println("Student Name: " + name);
    System.out.println("Roll Number: " + rollNumber);
    System.out.println("Marks: " + marks);
  }
}

public class CreateClass {

  public static void main(String[] args) {

    Student s1 = new Student("Aayushi", 1101, 89.8);
    Student s2 = new Student("Ayush", 1108, 87.0);

    System.out.println("STUDENT 1 INFO: ");
    s1.showStudentInfo();

    System.out.println();
    System.out.println("STUDENT 2 INFO:");
    s2.showStudentInfo();
  }
}