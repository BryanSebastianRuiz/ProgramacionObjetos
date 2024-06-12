package geometric_figures.shapes;

abstract class Quadrilateral extends Shape {
    public Quadrilateral() {
        super(4); // Calls the constructor of the superclass Shape with 4 sides
    }

    @Override
    public abstract double getArea();

    @Override
    public abstract double getPerimeter();
}
