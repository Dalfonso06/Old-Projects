package pkg3dimensions;

/**
 * Shape3D subclass that represents a sphere.
 * @author danielalfonso
 */
public class Sphere extends Shape3D {
    
    // Holds radius value for the sphere.
    private int radius = 0;
    
    /**
     * Constructor method that defines size and location of the sphere.
     * @param x
     * @param y
     * @param z
     * @param radius 
     */
    public Sphere(int x, int y, int z, int radius) {
        
        super(x, y, z);
        this.radius = radius;
    }
    
    /**
     * Method that returns the volume of the sphere.
     * @return 
     */
    @Override
    public double volume() {
        
        // Formula to find the volume of a sphere. ((4/3) * PI * r^3)
        double VOLUME = (4/3) * Math.PI * Math.pow(radius, 3);
        
        return VOLUME;
    }
    
    /**
     * Method that returns the surface area of the sphere.
     * @return 
     */
    @Override
    public double surfaceArea() {
        
        double SA = 4 * Math.PI * Math.pow(radius, 2);
        
        return SA;
    }

    /**
     * Comparable to compare volumes of different shapes.
     * @param shape
     * @return 
     */
    @Override
    public int compareTo(Object o) {
        
        // Converting Object o to Shape3D.
        Shape3D shape = (Shape3D) o;
        
        // If the volume of the sphere is less than the shape it's compared to.
        if (volume() < shape.volume()) {
            
            return 1;
            
        // If the volume of the sphere is greater than the shape.
        } else if (volume() > shape.volume()) {
                
            return -1;
            
        // If the volume of the sphere is the same as the shape.
        } else {
            
            return 0;
        }
        
    }
    
    /**
     * toString method that returns name of class with specifications.
     * @return 
     */
    public String toString() { 
        
        String line1 = "Sphere";
        String line2 = "------";
        String line3 = "Center of shape (x, y, z): " + super.toString();
        String line4 = "Radius: " + radius;
        
        return line1 + "\n" + line2 + "\n" + line3 + "\n" + line4;
    }
    
}
