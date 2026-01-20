// 2. Write a program that accepts radius of a circle and displays area of the circle. Overload the 
// constructor to accept radius as input and another circle object as input. Then show the effect of 
// shallow vs deep copy of objects. Declare a constant pi equals to 3.14 using OOP concept.
// Sajjad Ahmed Shaaz, 002410501093

import java.util.Scanner;

public class Circle {
    static final double PI=3.14;
    double radius;

    Circle(double radius) {
        this.radius=radius;
    }

    Circle (Circle c1) {
        this.radius=c1.radius;       
    }

    double calculateArea() {
        return PI*radius*radius;
    }

    public static void main(String[] args) {
        System.out.println("Enter radius of circle:");
        Scanner sc=new Scanner(System.in);
        double r=sc.nextDouble();
        Circle c1=new Circle(r);
        System.out.println("Area of circle with radius "+c1.radius+" is: "+c1.calculateArea());

        Circle c3=c1;
        System.out.println("Shallow copy: ");
        System.out.println("Area of circle with radius "+c3.radius+" is: "+c3.calculateArea());
        c1.radius=10; // modifying radius of original object
        System.out.println("After modifying radius of original object:");
        System.out.println("Area of circle c3 with radius "+c3.radius+" is: "+c3.calculateArea());


        Circle c2=new Circle(c1); // using copy constructor
        System.out.println("Deep copy: ");
        System.out.println("Area of circle with radius "+c2.radius+" is: "+c2.calculateArea());
        c1.radius=15; // modifying radius of original object
        System.out.println("After modifying radius of original object:");
        System.out.println("Area of circle c2 with radius "+c2.radius+" is: "+c2.calculateArea());

        sc.close();
    }
}
