/*
 * Daniel Alfonso PID: 6096463
 * Professor Shaw
 * Programming 2 COP 3337
 */
package linkedlist;
import java.util.Scanner;
import java.io.*;

/**
 * Tester class for the generic linked list
 * @author danielalfonso
 */
public class LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // New scanner object to read from file.
        Scanner scan = new Scanner("list-ops.txt");
        GenericLinkedList myList = new GenericLinkedList();
        
        // Defines scan to read from file given.
        try {
            
            scan = new Scanner(new File("list-ops.txt"));
            
        } catch (Exception e) {
            
            System.out.println("File does not exist");
            
        }
        
        // While the txt file has something after...
        while (scan.hasNext()) {
            
            String line = scan.next();
            
            // If the next method is Append.
            if (line.equals("APPEND")) {
                
                // Save the Nth term for append method.
                int N = scan.nextInt();

                // Appends to myList.
                myList.append(N);
                
                // Prints out the method and myList.
                System.out.println("Append " + N);
                System.out.println(myList);
                
            } else if (line.equals("ADD")) {
                
                // Saves Nth term and item to add (X).
                int N = scan.nextInt();
                int X = scan.nextInt();
                
                // Adds X to Nth index.
                myList.add(N, X);
                
                System.out.println("Add " + N + " " + X);
                System.out.println(myList);
                
            } else if (line.equals("DELETE")) {
                
                // Saves Nth term that wants to be deleted.
                int N = scan.nextInt();
                
                // Deletes at N.
                myList.delete(N);
                
                System.out.println("Delete " + N);
                System.out.println(myList);
                
            } else if (line.equals("SWAP")) {
                
                // Saves Nth and Mth index to swap.
                int N = scan.nextInt();
                int M = scan.nextInt();
                
                // Swaps values at N and M.
                myList.swap(N, M);
                
                System.out.println("Swap " + N + " " + M);
                System.out.println(myList);
                
            } else if (line.equals("REVERSE")) {
                
                // Reverses myList.
                myList.reverse();
                
                System.out.println("Reverse");
                System.out.println(myList);
                
            } else if (line.equals("CLEAR")) {
                
                // Clears list.
                myList.clear();
                
                System.out.println("Clear");
                System.out.println(myList);
            }
        }
        
        
    }
    
}
