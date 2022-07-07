/*
 * Daniel Alfonso
 * PID: 6096462
 * Programming 2 COP 3337
 * Professor Shaw
 */
package pkg3dimensions;
import java.util.Arrays;

/**
 * Tester class for Shape3D classes and subclasses.
 * @author danielalfonso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* --- 1. --- */
        // Array to hold shapes.
        Shape3D[] shapeList = new Shape3D[4];
        
        // Defines all shapes and adds them to the list.
        shapeList[0] = new Sphere(2, 5, 8, 14);
        shapeList[1] = new Cone(-5, 4, -1, 11, 15);
        shapeList[2] = new Cylinder(-3, -7, -5, 14, 12);
        shapeList[3] = new Parallelepiped(7, 16, 9, 19, 9, 13);
        
        /* --- 2. --- */
        // Prints out all shapes in the array with their surface area.
        for (int i = 0; i < shapeList.length; i++) {
            
            System.out.println("\n" + shapeList[i]);
            System.out.println("Surface area: " + shapeList[i].surfaceArea()); 
        }
        
        // Just leaves space to make easier to read.
        System.out.println("\n" + "Volumes:");
        
        /* --- 3. --- */
        /* 
         * Sorts the array using the Arrays.sort() method. Due to compareTo
         * method in Shape3D subclasses, they are sorted in descending order.
         */
        Arrays.sort(shapeList);
        
        /* --- 4. --- */
        // Prints the class name and volume of all elements in shapeList.
        for (int i = 0; i < shapeList.length; i++) {
            
            System.out.println(shapeList[i].getClass().getSimpleName() + 
                    ": " + shapeList[i].volume());
        }
        
        /* --- 5. --- */
        // Creates an instance of CenterDistance for the sort parameter.
        CenterDistance distCompare = new CenterDistance();
        // Sorts list ascending according to the distance from the center.
        Arrays.sort(shapeList, distCompare);
        
        // Prints the class name and distance from center in shapeList array.
        System.out.println("\n" + "Distance from center: ");
        for (int i = 0; i < shapeList.length; i++) {
            
            System.out.println(shapeList[i].getClass().getSimpleName() +
                    ": " + shapeList[i].centerToOrigin());
        }
    }
    
}
