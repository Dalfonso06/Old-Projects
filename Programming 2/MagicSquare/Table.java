/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicsquare;

/**
 *
 * @author danielalfonso
 */
public class Table {
    
    // Creates the double array magicSquare
    private int[][] magicSquare;
    
    /**
     * Defines the double array with a size of N by N.
     * @param N Passed by the user to define double array.
     */
    Table(int N) {
        
        magicSquare = new int[N][N];
        
    }
    
    /**
     * Fills the table with numbers in their proper location.
     */
    public void fill() {
        
        int N = magicSquare.length; // The max number of times to add a number.
        int counter = 1; // The actual number being added to the table.
        
        /* 
         * These will be used to add the number and keep track of the index
         * with which the number is being added to.
         */
        int row = N - 1;
        int column = (magicSquare.length / 2); // To add the first number.
        
        // Adds the first number to the first row, middle column. (rule a)
        magicSquare[row][column] = counter;
        row++;
        column++;
        counter++;
        
        /* 
         * Adds card N^2 number of times to the table. This fills the rest of
         * the table.
         */
        while (counter <= (N * N)) {
            
            
            // If the index is out of a row and column. (rule b)
            if (row == N && column == N) {
                row = row - 2;
                column--;
            }
            
            if (row < 0 || row >= N) {
                row = 0;
                
                if (magicSquare[row][column] != 0) {
                    column--;
                }
            }
            
            if (column < 0 || column >= N) {
                column = 0;
            }
            
            // Check if spot is empty.
            boolean empty = magicSquare[row][column] == 0;
            
            // If the index is in a position that is already taken. (rule e)
            if (!empty) {
                row = row - 2;
                column--;
                continue;  
            }
            
            /* 
             * Adds the counter integer to the 2d array at the row and column
             * index. Moves the next position bottom right.
             */
            magicSquare[row][column] = counter;
            row++;
            column++;
            counter++;
            
        }
        
    }
    
    public boolean isMagic() {
        
        int firstRow = 0;
        
        for (int column = 0; column < magicSquare[0].length; column++) {
            
            int sum = magicSquare[0][column];
            firstRow += sum;
        }
        
        for (int row = 1; row < magicSquare.length; row++) {
            
            int sumOfRow = 0;
            
            for (int column = 0; column < magicSquare[0].length; column++) {
                
                sumOfRow += magicSquare[row][column];
            }
            
            if (sumOfRow != firstRow) {
                
                return false;
            }
        }
        
        for (int column = 0; column < magicSquare[0].length; column++) {
            
            int sumOfColumn = 0;
            
            for(int row = 0; row < magicSquare.length; row++) {
                
                
            }
        }
        
        return false;
    }
    
    /**
     * A method to return the class object as a String to return.
     * @return finalString that is made from the 2d array.
     */
    public String toString() {
        
        // To separate the final String with "|".
        String finalString = " \n| ";
        
        // To grab every element of the array and add it to finalString.
        for (int i = 0; i < magicSquare.length; i++) {
            for (int u = 0; u < magicSquare[i].length; u++) {
                finalString = finalString + magicSquare[i][u] + " | ";
            }
            finalString = finalString + " \n| ";
        }
        
        return finalString;
    }
    
    
}
