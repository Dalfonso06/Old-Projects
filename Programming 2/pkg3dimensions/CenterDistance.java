package pkg3dimensions;

import java.util.Comparator;

/**
 * Class to help sort a list of shapes according to their distance from center.
 * @author danielalfonso
 */
public class CenterDistance implements Comparator {

    /**
     * Abstract method to compare elements of an array of Shape3D according
     * to their distance from the center.
     * @param o1
     * @param o2
     * @return 
     */
    @Override
    public int compare(Object o1, Object o2) {
        
        // Casts the o1 parameter as a Shape3D type.
        Shape3D shape1 = (Shape3D) o1;
        Shape3D shape2 = (Shape3D) o2;
        
        // Compares both elements according to distance.
        if (shape1.centerToOrigin() > shape2.centerToOrigin()){
            
            return 1;
        } else if (shape1.centerToOrigin() < shape2.centerToOrigin()) {
            
            return -1;
        } else {
            
            return 0;
        }
        
    }
    
}