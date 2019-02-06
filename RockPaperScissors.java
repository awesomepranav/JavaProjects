
/**
 * Write a description of class RockPaperScissors here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Random;
public class RockPaperScissors
{
    public static void main(String [] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Please choose either rock, paper or scissors:         ");
        String userChoice = console.next();
        int computerChoice;
        Random rand = new Random();
        computerChoice = rand.nextInt(3) + 1;
        System.out.println(computerChoice);
        String updatedComputerChoice = "";
        if(computerChoice == 1)
        {
            updatedComputerChoice = "rock";
            System.out.print(updatedComputerChoice);
        }
        else if (computerChoice == 2)
        {
            updatedComputerChoice = "paper";
            System.out.print(updatedComputerChoice);
        }
        else 
        {
            updatedComputerChoice = "scissors";
            System.out.print(updatedComputerChoice);
        }
        if((updatedComputerChoice.equals("rock")) && (userChoice.equals("rock")))
        {
            System.out.println("It was a tie");
        }
        if ((updatedComputerChoice.equals("rock")) && (userChoice .equals ("paper")))
        {
            System.out.println("You won!");
        }
        if ((updatedComputerChoice .equals("rock")) && (userChoice .equals("scissors")))
        {
            System.out.println("You lost");
        }
        if((updatedComputerChoice .equals("paper")) && (userChoice .equals("rock")))
        {
            System.out.println("You lost");
        }
        if ((updatedComputerChoice.equals ("paper")) && (userChoice.equals("paper")))
        {
            System.out.println("It was a tie");
        }
        if ((updatedComputerChoice.equals ("paper")) && (userChoice.equals ("scissors")))
        {
            System.out.println("You won");
        }
        if((updatedComputerChoice.equals("scissors")) && (userChoice.equals("rock")))
        {
            System.out.println("You won");
        }
        if ((updatedComputerChoice.equals ("scissors")) && (userChoice.equals ("paper")))
        {
            System.out.println("You lost");
        }
        if ((updatedComputerChoice.equals ("scissors")) && (userChoice .equals("scissors")))
        {
            System.out.println("It was a tie");
        }
    }
}
