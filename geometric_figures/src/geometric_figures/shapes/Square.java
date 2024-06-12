package geometric_figures.shapes; 

class Square extends Rectangle { 
    private double side; 

    public Square(double side) { 
        super(side, side); // Call the superclass (Rectangle) constructor with side as both length and width
        this.side = side; // Assign the side parameter to the instance variable side
    }
}