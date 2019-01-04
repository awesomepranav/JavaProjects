
/**
 * Write a description of class wordCount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class wordCount
{
    public static void main(String [] args)
    {
       Scanner console = new Scanner(System.in);
       System.out.println("Please enter your words:        ");
       String sentence = console.nextLine();
       int words = 1;
       for(int i = 0; i<sentence.length(); i++)
       {
           if(sentence.charAt(i) == ' ')
           {
               words++;
           }
       }
       System.out.println("This phrase has " + words + "words");
    }
}
