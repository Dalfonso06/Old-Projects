package pkg3dimensions;
import java.lang.Math;

/**
 * Abstract class that implements Comparable interface to later compare volumes
 * for its subclasses.
 * @author danielalfonso
 */
public abstract class Shape3D implements Comparable {
    
    // Initializes the Point3D object for the center of shape.
    private Point3D center = new Point3D(-100, -100, -100);
    
    /**
     * Constructor that creates the center of the 3D shape as a point.
     * @param x
     * @param y
     * @param z 
     */
    public Shape3D(int x, int y, int z) {
        
        center = new Point3D(x, y, z);
    }
    
    /**
     * Gets the distance from the center of the shape to the origin.
     * @return final number computed (finalDistance)
     */
    public double centerToOrigin () {
        
        /* 
         * Using pythagorean theorem, firstDistance grabs the hypotnuse of
         * the x distance and y distance. Then using that distance it grabs
         * the hypotnuse of firstDistance and the z distance. This gets the
         * the distance of the center of the shape, the origin (0,0,0)
         */
        double firstDistance = Math.sqrt(Math.pow(center.getX(), 2) + 
                                         Math.pow(center.getY(), 2));
        
        double finalDistance = Math.sqrt(Math.pow(firstDistance, 2) +
                                         Math.pow(center.getZ(), 2));
        
        return finalDistance;
    }
    
    public Point3D getPoint() {
        
        return center;
    }
    
    /**
     * Abstract method to return volume of shape.
     * @return 
     */
    public abstract double volume();
    
    /**
     * Abstract method to return surface area of shape.
     * @return 
     */
    public abstract double surfaceArea();
    
    /**
     * Returns the center of the 3D shape.
     * @return 
     */
    public String toString() {
        
        return center.toString();
    }
}
