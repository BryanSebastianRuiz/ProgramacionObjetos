package geometric_figures.shapes; 

abstract class Shape { 
    private int numberOfSides; 

    public Shape(int numberOfSides) { 
        this.numberOfSides = numberOfSides; // Assigns the passed value to the numberOfSides field
    }

    public int getNumberOfSides() { 
        return numberOfSides; // Returns the value of the numberOfSides field
    }

    public abstract double getArea(); 
    
    public abstract double getPerimeter(); 
}
