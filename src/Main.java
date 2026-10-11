import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random gen = new Random();
        String continueYN = "";
        String nextRound = "";
        String playGame = "";
        boolean done = false;
        int crapsRoll;
        int die1;
        int die2;
        int roll2;

        System.out.println("Welcome to the game of Craps! \n Roll two dice to play. \n Rolling a sum of 2, 3, or 12 means you lose or 'crap out'. \n Rolling a sum of 7 or 11 is a natural and means you win! \n For any other roll, your sum is called 'the point' and you keep rolling unti you throw a 7 which means you lose or you make the point sum and win. \n Let's play -- and good luck!");

        while (!done) {
            System.out.print("Press Y to play or N to quit.");
            playGame = in.nextLine();
            if (playGame.equalsIgnoreCase("N")) {
                done = true;
                System.out.println("Thanks for playing Craps! Restart the program to play again.");
            } else if (playGame.equalsIgnoreCase("Y")) {
                die1 = gen.nextInt(6) + 1;
                die2 = gen.nextInt(6) + 1;
                crapsRoll = die1 + die2;
                if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                    System.out.printf("\nCraps! You lost! You rolled %d and %d to make %d\n", die1, die2, crapsRoll);
                } else if (crapsRoll == 7 || crapsRoll == 11) {
                    System.out.printf("\nNatural! You won! You rolled: %d and %d to make %d\n", die1, die2, crapsRoll);
                    done = true;
                } else { // For any other number (e.g. 8)
                    System.out.printf("\n You rolled: %d and %d to make %d\n", die1, die2, crapsRoll);
                    System.out.printf("The point is: %d\n", crapsRoll);
                    boolean continueGame = true;

                    while (continueGame) {
                        System.out.print("\n Press Y to roll again to match the point or Q to forfeit and quit the game: ");
                        nextRound = in.nextLine();
                        if (nextRound.equalsIgnoreCase("Y")) {
                            die1 = gen.nextInt(6) + 1;
                            die2 = gen.nextInt(6) + 1;
                            roll2 = die1 + die2;
                                if (roll2 == crapsRoll) {
                                    System.out.printf("\nYou made the point! You win! \n This time, you rolled: %d and %d to make the point %d\n", die1, die2, roll2);
                                    continueGame = false;
                                } else if (roll2 == 7) {
                                    System.out.printf("You lose, you rolled a 7! You rolled: %d and %d", die1, die2);
                                    continueGame = false;
                                } else {
                                    System.out.printf("\n You rolled %d and %d to make %d\n. Keep trying to get the %d!\n", die1, die2, roll2, crapsRoll);
                                }
                        } else if (nextRound.equalsIgnoreCase("N")) {
                            continueGame = false;
                                    System.out.println("Thanks for playing Craps! Restart the program to play again.");
                        } else {
                            System.out.println("Please select Y to continue or N to quit. You entered: " + nextRound);
                        }
                    }
                }
                do {
                    System.out.println("\n Would you like to play again? (y/n)");
                    continueYN = in.nextLine();
                    if (continueYN.equalsIgnoreCase("Y")) {
                        done = false;
                    } else if (continueYN.equalsIgnoreCase("N")) {
                        done = true;
                    } else {
                        System.out.println("Invalid. Enter Y or N to another game. You entered: " + playGame);
                    }
                } while (!continueYN.equalsIgnoreCase("Y") && !continueYN.equalsIgnoreCase("N"));
            } else {
                System.out.println("Invalid input. Please select Y or N. You entered: " + playGame);
            }
        }

    }
}
