package guii;

import java.util.*;
public class TASK1 {
    public static void main(String[] args) {
        System.out.println("Game Rules");
        System.out.println("You will have unlimited amount of rounds to guess the number \nbut have only 5 chances in each round to guess it correctly.\nAfter each round the generated number will change. ");
        Scanner sc = new Scanner(System.in);
        int min = 1, max = 100;
        int totalAttempts = 0;
        int totalRounds = 0;
        int totalWins = 0;

        boolean playAgain = true;
        while(playAgain) {
            int generated = min + (int)(Math.random() * (max - min + 1));
            //System.out.println(generated);
            int attempts = 0;
            totalRounds++;

            System.out.println("Round "+totalRounds);
            while(true) {

                System.out.print("Guess the number: ");
                int guess = sc.nextInt();
                attempts++;
                if (generated == guess) {
                    System.out.println("Congrats! You are Correct!!");
                    totalWins++;
                    totalAttempts += attempts;
                    break;
                } else if (generated < guess) {
                    System.out.println("Too High! Try Again.");
                } else {
                    System.out.println("Too Low! Try Again.");
                }
                if(attempts >= 5)
                {
                    System.out.println("You ran out of attempts. The correct answer was: "+generated);
                    totalAttempts+=attempts;
                    break;
                }
            }
            System.out.println("Do you wan to play again (yes/no): ");
            String playAgainInput = sc.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");

        }
        sc.close();
        System.out.println("Total Rounds: "+totalRounds);
        System.out.println("Total Attempts: "+totalAttempts);
        System.out.println("Total Wins: "+totalWins);
    }
}
