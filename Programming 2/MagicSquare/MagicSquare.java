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
public class MagicSquare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Table magicTest = new Table(5);
        
        magicTest.fill();
        
        System.out.println(magicTest);
        
        
    }
    
}
