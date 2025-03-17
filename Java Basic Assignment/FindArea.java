import java.util.Scanner;

public class FindArea {
    double PI = 3.14;

    // method to find the area of circle
    public static double areaOfcricle(double radius) {
        double area = 2 * 3.14 * radius;
        return area;
    }

    // method to find the area of rectangle
    public static double areaOfRectangle(double length, double breadth) {
        double area = 2 * length * breadth;
        return area;
    }

    // method to find the area of a Triangle
    public static double areaOfTriangle(double base, double heigth) {
        double area = 1 / 2 * base * heigth;
        return area;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the radius to find area of Circle");
        double radius = sc.nextDouble();

        System.out.println("Enter Length and Breadth to find area of Rectangle:");
        double length = sc.nextDouble();
        double breadth = sc.nextDouble();

        System.out.println("Enter base and heigth to find area of Triangle:");
        double base = sc.nextDouble();
        double heigth = sc.nextDouble();

        System.out.println("Area of circle is : " + areaOfcricle(radius));
        System.out.println("Area of Rectangle is : " + areaOfRectangle(length, breadth));
        System.out.println("Area of triangle is : " + areaOfTriangle(base, heigth));

        sc.close();
    }

}