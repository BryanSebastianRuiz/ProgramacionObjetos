package geometric_figures.shapes; 

import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creates a Scanner object to read user input

        while (true) { 
            System.out.println("Select the type of geometric shape: "); 
            System.out.println("1) Ellipse"); 
            System.out.println("2) Circle"); 
            System.out.println("3) Triangle"); 
            System.out.println("4) Rectangle"); 
            System.out.println("5) Square");
            System.out.println("6) Exit");
            int choice = scanner.nextInt(); // Reads the user's choice

            Shape shape = null; // Declares a Shape object, initialized to null

            switch (choice) { 
                case 1: // Case for Ellipse
                    System.out.println("Enter the semi-major axis: "); 
                    double semiMajorAxis = scanner.nextDouble();
                    System.out.println("Enter the semi-minor axis: "); 
                    double semiMinorAxis = scanner.nextDouble(); 
                    shape = new Ellipse(semiMajorAxis, semiMinorAxis); // Creates a new Ellipse object with the provided values
                    break; 
                case 2: // Case for Circle
                    System.out.println("Enter the radius: "); 
                    double radius = scanner.nextDouble(); 
                    shape = new Circle(radius); // Creates a new Circle object with the provided radius
                    break; 
                case 3: // Case for Triangle
                    System.out.println("Enter the base: "); 
                    double base = scanner.nextDouble(); 
                    System.out.println("Enter the height: "); 
                    double height = scanner.nextDouble(); 
                    System.out.println("Enter side A: "); 
                    double sideA = scanner.nextDouble(); 
                    System.out.println("Enter side B: "); 
                    double sideB = scanner.nextDouble(); 
                    System.out.println("Enter side C: "); 
                    double sideC = scanner.nextDouble(); 
                    shape = new Triangle(base, height, sideA, sideB, sideC); // Creates a new Triangle object with the provided values
                    break; 
                case 4: // Case for Rectangle
                    System.out.println("Enter the length: "); 
                    double length = scanner.nextDouble(); 
                    System.out.println("Enter the width: "); 
                    double width = scanner.nextDouble();
                    shape = new Rectangle(length, width); // Creates a new Rectangle object with the provided values
                    break; 
                case 5: // Case for Square
                    System.out.println("Enter the side: "); 
                    double side = scanner.nextDouble(); 
                    shape = new Square(side); // Creates a new Square object with the provided side length
                    break; 
                case 6: // Case for exiting the program
                    System.out.println("Exiting..."); 
                    scanner.close(); 
                    return; 
                default: 
                    System.out.println("Invalid option"); 
                    continue; 
            }

            System.out.println("Area: " + shape.getArea()); // Prints the area of the shape
            System.out.println("Perimeter: " + shape.getPerimeter()); // Prints the perimeter of the shape
        }
    }
}
