package geometric_figures.shapes;

class Ellipse extends Shape {
    private double semiMajorAxis;
    private double semiMinorAxis;

    public Ellipse(double semiMajorAxis, double semiMinorAxis) {
        super(1); // Call the constructor of the superclass (Shape) with 1, indicating 1 side
        this.semiMajorAxis = semiMajorAxis; // Initialize the semi-major axis
        this.semiMinorAxis = semiMinorAxis; // Initialize the semi-minor axis
    }

    @Override
    public double getArea() {
        return Math.PI * semiMajorAxis * semiMinorAxis; // Area of the ellipse is π * semi-major axis * semi-minor axis
    }

    @Override
    public double getPerimeter() {
        return Math.PI * (3 * (semiMajorAxis + semiMinorAxis) - Math.sqrt((3 * semiMajorAxis + semiMinorAxis) * (semiMajorAxis + 3 * semiMinorAxis))); // Approximate the perimeter of the ellipse using Ramanujan's approximation
    }
}
