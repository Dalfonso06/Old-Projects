package linkedlist;

/**
 * Generic class that implements a Node class to represent a Linked list.
 * (Singly-linked))
 * @author danielalfonso
 */
public class GenericLinkedList <E> {
    
    private Node head; // pointer to first Node on the list
    
    /**
     * Java class used to be implemented to generic linked list.
     */
    private class Node {
        
        private E type; // variable to point to the object type in array.
        private Node next; // Point to the next item on the list.
        
        /**
         * Constructor for the Node class that defines the type instance
         * variable.
         * @param x Passed to define type variable.
         */
        public Node (E x) {
            
            type = x;
            next = null;
        }
    }
    // End of Node class inside Generic Linked List.
    
    /**
     * Constructor to create an empty list.
     */
    public GenericLinkedList() {
        
        head = null; // List is empty to start with.
    }
    
    /**
     * Method that returns the last node of your linked list. Used later for
     * appending.
     * @return 
     */
    private Node lastNode() {
        
        // Checks if linked list is empty.
        if (head == null) {
            
            return null; // There is no last node.
            
        } else { // Checks the last node.
            
            // Start with checking the beginning of the list.
            Node temp = head;
            
            // While the next node is not empty, meaning it isn't the last node.
            while (temp.next != null) {
                
                temp = temp.next; // Move to the next node.
            }
            
            // After while loop return the temp node.
            return temp;
        }
    }

    /**
     * Append an object to the end of the list
     * @param x the object to be appended
     */
    public void append(E x) {
        
        // create new Node with "info" member pointing to x
        Node temp = new Node(x);
        
        // First checks if list is empty.
        if (head == null) { 
            
            head = temp; // the added node goes in the front of the list.
            
        } else { 
            
            // If it isn't empty, add it after the last node (append).
            lastNode().next = temp;
        }
    }
    
    /**
     * Method that adds item x at index N.
     * @param N
     * @param x 
     */
    public void add(int N, E x) {
        
        Node temp1 = head; // temp is head of list.
        
        // If someone wants to add item at the front of list.
        if (N <= 1) {
            
            add(2, head.type); // Two head valus at the beginning.
            Node temp = head.next;
            head = new Node(x); // Redefines the head value.
            head.next = temp;
        
        } else {
            
            for (int i = 1; i < (N - 1); i++) {
            
                // Goes down the list to get to index N.
                temp1 = temp1.next; 
            }
        
            // Holds the val after where x is supposed to go.
            Node temp2 = temp1.next;
        
            // Adds the new object x.
            temp1.next = new Node(x);
        
            // Links the rest of the list back together.
            temp1.next.next = temp2;
        }
        
    }
    
    /**
     * Deletes the item at the Nth index.
     * @param N 
     */
    public void delete(int N) {
        
        Node temp = head;
        
        // Incase a value lower than possible is typed.
        if (N <= 1) {
            
            head = temp.next;
        }
        // Gets to the index before to get deleted.
        for (int i = 1; i < (N - 1); i++) {
            
            temp = temp.next;
        }
        
        // Points to the Node after temp.next;
        temp.next = temp.next.next;
    }
    
    public void swap(int M, int N) {
        
        Node tempM; // Holds item before Mth term.
        Node tempN; // Holds item before Nth term.
        
        Node temp = head; // Holds value as iterating through list.
        
        // Swaps so that N is the lowest integer.
        if (N > M) {
            
            int tempValue = N;
            N = M;
            M = tempValue;
        }
        
        if (N == M) {
            
            // Do nothing.
            
        } else {
            
            // Before the Mth node.
            for (int i = 1; i < M; i++) {
            
                temp = temp.next;
            }
        
            tempM = temp;
        
            temp = head; // Resets the "counter."
        
            // Before the Nth node.
            for (int i = 1; i < N; i++) {
            
                temp = temp.next;
            }
        
            tempN = temp;
        
            delete(N);
            delete(M - 1); // Take into account the shortened list. 
        
            // Adds the new nodes to the list.
            add(N, tempM.type); 
            add(M, tempN.type);
        }
    }
    
    /**
     * Reverses the order of the list.
     */
    public void reverse() {
        
        // Holds value of the last node.
        Node lastNode = lastNode();
        Node temp = head;
        int counter = 2;
        
        // Sets up the  counter variable so that it stays ahead of lastNode.
        while (temp != lastNode) {
            
            temp = temp.next;
            counter++;
        }
        
        // Adds the head node after lastNode.
        while (head != lastNode) {
            
            add(counter, head.type);
            delete(0);
            counter--;
        }
    }

    /**
     * Make the list empty.
     */
    public void clear() {
        
        head = null;
    }

    /**
     * Return a String containing all the objects on the list
     * @return the list as a String
     */
    public String toString()
    {
        String out = "";
        Node temp = head; 		// start at head of list 
        while (temp != null)            // while more nodes on list...
        {
            out += temp.type + "  ";	// ...append current obj
            temp = temp.next;		// ...and move to next node
        }
        return out + "\n";
    }
    
}
