/*
 * Daniel Alfonso
 * 6096462
 * Professor Shaw
 */
package nin;
import java.util.Scanner;

/**
 * Tester class for the Nim program.
 * @author danielalfonso
 */
public class Nin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        // Gives user a name.
        System.out.println("Enter your name human:");
        String humanName = scan.nextLine();
        Player human1 = new User(humanName);
        Player secondPlayer;
        
        System.out.println("\nWho would you like to play?" + "\n" +
                           "(\"1\" for Below Average Computer, " +
                           "\"2\" for Smart Computer, " + 
                           "\"3\" for another Human player)");
        int choice = scan.nextInt();
        
        // Initiates player according to what the user chose.
        if (choice == 1) {
            
            secondPlayer = new BelowAverageComputer();
            
        } else if (choice == 2) {
            
            secondPlayer = new SmartComputer();
            
        } else {
            
            System.out.println("Enter you name human 2:");
            String human2Name = scan.nextLine();
            secondPlayer = new User(human2Name);
            
        }
        
        System.out.println("Who goes first, \"1\" for player 1 " +
                           "\"2\" for player 2: ");
        int goesFirst = scan.nextInt();
        
        Player player1 = human1;
        Player player2 = secondPlayer;
        
        // Decides who goes first for the play method.
        if (goesFirst ==  1) {
            
            player1 = human1;
            player2 = secondPlayer;
            
        } else if (goesFirst == 2) {
            
            player1 = secondPlayer;
            player2 = human1;
            
        } else {
            
            player1 = human1;
            player2 = secondPlayer;
            
        }
        
        Nim game = new Nim();
        game.play(player1, player2);
        
        
    }
    
}
