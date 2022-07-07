/*  File: ArrayRecursion.java
 *
 *  Programmer: Daniel Alfonso
 *  Student ID: 6096463
 *  Programming 2  COP 3337 U04 1201
 *  Professor Gregory Shaw.
 *  
 *  I swear that the three filled methods are mine and only mine.
 *
 */

package arrayrecursion;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * A class that performs some simple array operations recursively
 * Modified by Daniel Alfonso to fill in recursive skeleton.
 * @author Greg
 */
public class ArrayRecursion
{
   // instance var's
   private int[] list ;       // array of ints
   private int size ;         // number of elements

   /**
    * Create an ArrayRecursion object. 
    * Creates an array with between 10 and 15 elements, and fills it with
    * random positive 2-digit ints
    */
   public ArrayRecursion() {
       
       Random r = new Random();
       size = r.nextInt(6) + 10;
       list = new int[size];

       for (int i = 0; i < size; i++) {
           
           list[i] = r.nextInt(90) + 10;
       }
   }

   /**
    * Return the list as a string
    * @return a string containing all ints stored in list
    */
   public String toString() {
       
       String out = "";
       for (int i = 0; i < size; i++) {
           
           out += list[i] + "  ";
       }
       
       return out + "\n";
   }

   /**
    * Returns the index of the largest value in the array.
    * @return the index of the largest value in the array
    */
   public int getIndexOfLargest()
   {
      return recursiveGetIndexOfLargest(list, size);
   }

   /**
    * Goes through an array and finds the highest value recursively.
    * @param list The array to look through.
    * @param count Size of the array.
    * @return The highest value of the array.
    */
   private int recursiveGetIndexOfLargest(int[] list, int count) {
       
       // If it's not at the bottom of the list.
       if (count != 0) {
           
           // Temporary index.
           int temp = recursiveGetIndexOfLargest(list, (count - 1));
           
           // Compares at index count - 1 with temp.
           if (list[count - 1] > list[temp]) {
               
               // if greater than temporary index redifine and return.
               temp = count - 1;
               return temp;
           }
           
           // Return if temp is already greater.
           return temp;
       }
       
       // Return once at the bottom of the array.
       return 0;
       
   }

   /**
    * Sort the array in descending order using the selection sort
    */
   public void sort()
   {
      recursiveSort(list, size);
   }

   /**
    * Sorts the array recursively by finding the highest value and moving it to
    * the end of the array.
    * @param list The array to sort.
    * @param count Size of the array.
    */
   private void recursiveSort(int[] list, int count) {
       
       if (count != 0) {
           
           // Hold the highest value of the list and last value to switch.
           int temp = list[count - 1];
           int max = recursiveGetIndexOfLargest(list, count);
           
           // Switch them.
           list[count - 1] = list[max];
           list[max] = temp;
           
           // Do the same thing without the last index already switched.
           recursiveSort(list, count - 1);
       }
         
   }
   
   /**
    * Indicates whether a given int is on the list
    * @param target the int to search for
    * @return true if target is on the list, false if not
    */
   public boolean contains (int target)
   {
      return recursiveContains(list,size,target) ;
   }
   
   /**
    * Returns whether or not a certain value passed is in the array.
    * @param list The array to look through.
    * @param count The size of the array.
    * @param target The value to look for.
    * @return Returns whether or not the target value is in the array.
    */
   private boolean recursiveContains(int[] list, int count, int target) {
      
       // If the index isn't at the bottom.
       if (count > 0) {
           
           // If the target is equal to value in list.
           if (target == list[count - 1]) {
               
               // Return true
               return true;
               
           } else {
               
               // return if it is contained as it goes down the list.
               return recursiveContains(list, (count - 1), target);
           }
       }
       
       // Once it reaches the bottom and target isn't there, return false.
       return false;
      
   }   
   
   public static void main(String[] args)
   {
      ArrayRecursion list = new ArrayRecursion();

      System.out.println("\nOriginal:  " + list);

      System.out.println("Largest value is at index: "
              + list.getIndexOfLargest());
      list.sort();
      System.out.println("\nSorted:    " + list);
     
      String target = JOptionPane.showInputDialog("Number to search for?") ;
      int searchee = Integer.parseInt(target) ;
      
      if (list.contains(searchee))
         System.out.println(searchee + " is on the list");
      else
         System.out.println(searchee + " is not on the list");
   }
}
