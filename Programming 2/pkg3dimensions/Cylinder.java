package pkg3dimensions;

/**
 * Shape3D subclass that represents a cylinder.
 * @author danielalfonso
 */
public class Cylinder extends Shape3D {
    
    // Initializes instance variables.
    private int height = 0;
    private int radius = 0;
    
    /**
     * Constructor to define Cylinder class.
     * @param x
     * @param y
     * @param z
     * @param h
     * @param r 
     */
    public Cylinder(int x, int y, int z, int r, int h) {
        
        super(x, y, z);
        
        // Defines instance variables.
        radius = r;
        height = h;
        
    }

    /**
     * Method that returns the volume of a cylinder.
     * @return 
     */
    @Override
    public double volume() {
        
        // Formula for volume
        double VOLUME = Math.PI * Math.pow(radius, 2) * height;
        
        return VOLUME;
    }

    /**
     * Method that returns the surface area of a cylinder.
     * @return 
     */
    @Override
    public double surfaceArea() {
        
        // Formula of cylinder (2 * PI * r * h + 2 * PI * r^2)
        double SA = (2 * Math.PI * radius * height) +
                    (2 * Math.PI * Math.pow(radius, 2));
        
        return SA;
    }

    /**
     * Comparable to compare volumes of different shapes.
     * @param o
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
        
        String line1 = "Cylinder";
        String line2 = "--------";
        String line3 = "Center of shape (x, y, z): " + super.toString();
        String line4 = "Radius: " + radius;
        String line5 = "Height: " + height;
        
        return line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" +
                line5;
    }
    
}
