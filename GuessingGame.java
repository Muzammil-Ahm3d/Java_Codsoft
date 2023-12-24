/*the final part of our previous code is to just add maximum number of attempts and final score */
import java.util.Scanner;
import java.util.Random;
public class GuessingGame{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int maxAttempts=5;
        int rounds=0;
        int totalAttempts=0;
        int roundsWon=0;
        System.out.println("WELCOME TO THE GUESSING GAME :");
        while(true){
            int randomNumber= random.nextInt(100)+1;
            int attempts=0;
            rounds++;
            System.out.println("\nRound"+rounds+":Guess the random number between 1 and 100.You have " +maxAttempts+ " attempts");
            while(attempts<maxAttempts){
                attempts++;
                totalAttempts++;
                System.out.println("Attempt" +attempts+":Enter your guess:");
                int yourGuess=scanner.nextInt();
                if(yourGuess==randomNumber){
                    System.out.println("CONGRATULATIONS YOUR GUESS IS CORRECT. The number was:"+randomNumber);
                    roundsWon++;
                    break;
                }else if(yourGuess<randomNumber){
                    System.out.println("TRY A HIGHER NUMBER");
                }else{
                    System.out.println("TRY A LOWER NUMBER");

                }
                if (attempts==maxAttempts){
                    System.out.println("SORRY you ran out of attempts.The number was:"+randomNumber);

                }
            }
            System.out.println("Do you want to play again?(yes/no):");
            String playAgain=scanner.next();
            if(!playAgain.equalsIgnoreCase("yes")){
                break;
            }
        }
        double averageAttempts=(double) totalAttempts/rounds;
        System.out.println("GAME OVER");
        System.out.println("Rounds Played:"+rounds);
        System.out.println("Rounds Won:"+roundsWon);
        System.out.printf("Average attempts per round:%.2f",averageAttempts);
        scanner.close();
    }
}