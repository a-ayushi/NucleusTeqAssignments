//parent class
class Parent {

    // method overloading
    void operation() {
        System.out.println("I am the Parent class!");

    }

    void operation(int num1, int num2) {
        System.out.println("Addition:" + (num1 + num2));

    }
}

// child class
class Child extends Parent {
    // method overriding
    @Override
    void operation() {
        System.out.println("I am Child class.");
    }
}

public class Polymorphism {
    public static void main(String[] args) {

        // access a parent method
        Parent p = new Parent();
        p.operation();
        p.operation(10, 20);

        Parent p1 = new Child();// parent reference and child object
        p1.operation();
    }
}