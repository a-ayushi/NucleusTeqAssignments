// Explain the concept of encapsulation with a suitable example

class Student {
    // Private variables (Data Hiding)
    private String name;
    private int rollNumber;
    private double marks;

    // Constructor
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Getter Methods -To Access Private Data
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getMarks() {
        return marks;
    }

    // Setter Methods -To Modify Private Data
    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks! Please enter a value between 0 and 100.");
        }
    }

    // Method to Display Student Information
    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        // Object of Student class
        Student student = new Student("Aayushi", 1101, 85.5);

        // Displaying Initial Student Details
        System.out.println("Before Updating:");
        student.displayStudentInfo();

        // Updating Data
        student.setName("Astha");
        student.setMarks(95.0);

        // Updated Student Details
        System.out.println("\nAfter Updating:");
        student.displayStudentInfo();
    }
}
