package pkg3dimensions;

/**
 * Class to represent a single point in 3 dimensions.
 * @author danielalfonso
 */
public class Point3D {
    
    // Initializes x, y, z.
    private int x = 0;
    private int y = 0;
    private int z = 0;
    
    /**
     * Constructor method to set x, y, and z variables.
     * @param x
     * @param y
     * @param z 
     */
    public Point3D(int x, int y, int z) {
        
        // Redefines all instance variables.
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Returns x value.
     * @return 
     */
    public int getX() {
        
        return x;
    }
    
    /**
     * Returns y value.
     * @return 
     */
    public int getY() {
        
        return y;
    }
    
    /**
     * Returns z value.
     * @return 
     */
    public int getZ() {
        
        return z;
    }
    
    /**
     * Creates a string representation of the class returning x, y, z variables
     * separated by points.
     * @return 
     */
    public String toString() {
        
        return x + " " + y + " " + z;
    }
}
