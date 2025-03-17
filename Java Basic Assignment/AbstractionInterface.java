// Explain the concept of interfaces and abstract classes with examples.

interface Language {
    void sayHello(); // Abstract method

    default void sayGoodbye() {
        System.out.println("Goodbye!");
    }
}

// Abstract class
abstract class Greeting {
    String name;

    // Constructor
    Greeting(String name) {
        this.name = name;
    }

    // Abstract method
    abstract void greet();

    // Concrete method (already implemented)
    void thankYou() {
        System.out.println("Thank you, " + name + "!");
    }
}

class EnglishGreeting extends Greeting implements Language {
    EnglishGreeting(String name) {
        super(name);
    }

    // Implementing the abstract method
    @Override
    void greet() {
        System.out.println("Hello, " + name + "! Welcome.");
    }

    // Implementing the interface method
    @Override
    public void sayHello() {
        System.out.println("Good Morning!");
    }
}

public class AbstractionInterface {
    public static void main(String[] args) {
        // English greeting
        EnglishGreeting engGreet = new EnglishGreeting("Aayushi");
        engGreet.greet(); // Abstract method implementation
        engGreet.sayHello(); // Interface method implementation
        engGreet.thankYou(); // Concrete method from abstract class
        engGreet.sayGoodbye(); // Default method from interface

    }
}
