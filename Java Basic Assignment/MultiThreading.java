// Explore multithreading in Java to perform multiple tasks concurrently.

//NOTE: Runnable can also be used 
class MyThread extends Thread {
    // overriding run method of THread class
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello! I am aayushi.");
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        // creating object of mythread class
        MyThread t1 = new MyThread();

        // starting the run method of mythread class
        t1.start();// creates a new thread

        // the execution of threads will be unexpected, both threads will run
        // concurrently
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello! I am Arun. ");
        }
    }
}
