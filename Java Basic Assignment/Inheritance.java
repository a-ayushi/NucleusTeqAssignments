
// Implement inheritance to create a "GraduateStudent" class that extends the "Student" class with additional features.

class Student {
    String name;
    int rollNumber;
    double marks;

    // constructore
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

// child class GraduateStudent which extends Student class
class GraduateStudent extends Student {
    String city;

    // constructor
    GraduateStudent(String name, int rollNumber, double marks, String city) {
        super(name, rollNumber, marks); // call parent class constructor
        this.city = city;
    }

    // method to show graduate students details
    void showGraduateInfo() {
        showStudentInfo(); // Calling parent class method
        System.out.println("City: " + city);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        GraduateStudent s1 = new GraduateStudent("Aayushi", 1101, 89.88, "Indore");

        System.out.println("Graduate Student Details:");
        s1.showGraduateInfo();
    }
}