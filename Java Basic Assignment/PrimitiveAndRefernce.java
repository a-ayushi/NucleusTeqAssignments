public class PrimitiveAndRefernce {
    public static void main(String[] args) {

        // primitive data types
        int rollNumer = 1101;
        char section = 'B';
        boolean isPlaced = true;
        double height = 5.4;

        System.out.println("-------Primitive Data Types-------");
        System.out.println("Roll Number: " + rollNumer);
        System.out.println("Section " + section);
        System.out.println("placement: " + isPlaced);
        System.out.println("height " + height);
        System.out.println();

        // REFERCE DATA TYPES
        System.out.println("\n-------Reference Data Types-------");

        // 1. String
        String name = "Aayushi";
        System.out.println("\n1. String type");
        System.out.println("Name:" + name);

        // 2. Arrays
        System.out.println("\n2. Array type");
        int[] marks = { 90, 80, 78, 98, 90 };
        System.out.println("marks of first subject: " + marks[0]);

        // 3. Objects
        System.out.println("\n3. Object type");
        Student s1 = new Student("Aayushi", 1101);
        System.out.println("Name: " + s1.name + ", Roll Number: " + s1.rollNumber);
    }
}

class Student {
    String name;
    int rollNumber;

    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
}