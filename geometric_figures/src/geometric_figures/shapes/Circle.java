package geometric_figures.shapes;

class Circle extends Ellipse {
    private double radius;

    public Circle(double radius) {
        // Calls the constructor of the superclass (Ellipse) with the radius as both the semi-major and semi-minor axes
        // Circle is a special case of ellipse where both axes are equal
        super(radius, radius); // Initializes the radius of the circle with the provided radius value
        this.radius = radius;
    }
}
