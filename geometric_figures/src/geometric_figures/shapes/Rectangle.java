package geometric_figures.shapes;

class Rectangle extends Quadrilateral {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        
        this.length = length; // Assigning the passed length to the instance variable length
        
        this.width = width; // Assigning the passed width to the instance variable width
    }

    @Override
    public double getArea() {
        return length * width; // Area of a rectangle is length multiplied by width
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width); // Perimeter of a rectangle is 2 times the sum of length and width
    }
}
