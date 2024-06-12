package geometric_figures.shapes;

class Triangle extends Shape {
    private double base;
    private double height;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double base, double height, double sideA, double sideB, double sideC) {
        super(3);// Calls the constructor of the superclass Shape with 3 sides
        
        this.base = base; // Initialize the base of the triangle
        this.height = height; // Initialize the height of the triangle
        this.sideA = sideA; // Initialize side A of the triangle
        this.sideB = sideB; // Initialize side B of the triangle    
        this.sideC = sideC; // Initialize side C of the triangle
    }

    @Override
    public double getArea() {   
        return 0.5 * base * height; // Calculate and return the area of the triangle
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC; // Calculate and return the perimeter of the triangle
    }
}
