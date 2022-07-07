package pkg3dimensions;

/**
 * Shape3D subclass that represents a parallelepiped.
 * @author danielalfonso
 */
public class Parallelepiped extends Shape3D {
    
    private int length = 0;
    private int width = 0;
    private int height = 0;
    
    /**
     * Constructor for Parallelepiped class to create the parallelepiped
     * @param x
     * @param y
     * @param z
     * @param l
     * @param w
     * @param h 
     */
    public Parallelepiped(int x, int y, int z, int l, int w, int h) {
        
        super(x, y, z);
        
        // Defines all instance variables.
        length = l;
        width = w;
        height = h;
        
    }
    
    /**
     * Method that returns the volume of the parallelepiped.
     * @return 
     */
    @Override
    public double volume() {
        
        // Formula for volume (l * w * h).
        double VOLUME = length * width * height;
        
        return VOLUME;
    }
    
    /**
     * Method that returns the surface area of the parallelepiped.
     * @return 
     */
    @Override
    public double surfaceArea() {
        
        // Formala for surface area (2lw * 2lh * 2hw).
        double SA = (2 * length * width) + (2 * length * height) +
                    (2 * height * width);
        
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
        
        String line1 = "Parallelepiped";
        String line2 = "--------------";
        String line3 = "Center of shape (x, y, z): " + super.toString();
        String line4 = "Length: " + length;
        String line5 = "Width: " + width;
        String line6 = "Height: " + height;
        
        return line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" +
                line5 + "\n" + line6;
    }
    
}
