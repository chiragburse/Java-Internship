//Number Game

//Import Libraries
import java.io.*;
import java.util.*;
public class task1
{
    //Add this round variable to calculate how many round won by user
    static int round=0;

    //function for game
    public void game()
    {
        //Generate random number between 0 to 100
        Random ran = new Random();
        int randomNumber = ran.nextInt(100);

        //Add attempt variable to limit user attempt
        int attempts = 0;

        //Add guess variable to compare is it a same number 
        boolean guess = false;
        //System.out.println(randomNumber);
    
        //Add scanner for taking input from user
        Scanner sc = new Scanner(System.in);

        //Take number from user
        System.out.println("\nGuess A Number In The Range Of 0 To 100 : ");
        int input = sc.nextInt();
            
        /*Compare the user's guess with the generated number and provide feedback on whether the guess 
        is correct, too high, or too low.*/
        while(!guess && attempts<5)
        {
            if(input>0 && input<100)
            {
                if(input>randomNumber)
                {
                    System.out.println("You Are On Higher Side!! Enter Low Values Than This Value.");
                    attempts++;
                    if(attempts<5)
                    {
                        System.out.println("\nGuess A Number In The Range Of 0 To 100 : ");
                        input = sc.nextInt();
                    }
                }
                else if(input<randomNumber)
                {
                    System.out.println("You Are On Lower Side!! Enter High Values Than This Value.");
                    attempts++;
                    if(attempts<5)
                    {
                        System.out.println("\nGuess A Number In The Range Of 0 To 100 : ");
                        input = sc.nextInt();
                    }
                }
                else
                {
                    System.out.println("\nYes,You Guessed Right Number Which Is : "+input);
                    guess = true;
                    round++;
                }
            }
            else
            {
                System.out.println("\nInvalid Input!! Enter Guessed Number In The Range Of 0 To 100 : ");
                input = sc.nextInt();
            }
        }

        //If user failed to guess show them correct number
        if(!guess)
        {
            System.out.println("\nYou Are Used All Your Attempts,So You Failed to Guess A Number!! The Number Is : "+randomNumber);
        }
    }

    //function for multiple round
    public void anotherround()
    {
        //Add scanner for taking input from user
        Scanner sc = new Scanner(System.in);

        //Ask choice of user for play another round
        System.out.println("\nYou Want To Another Round : ");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        int choice = sc.nextInt();
        
        //Add playagain variable to go into the loop
        boolean playagain = true;
        while(playagain)
        {
            if(choice==1)
            {
                game();
                System.out.println("\nYou Want To Another Round : ");
                System.out.println("1 - Yes");
                System.out.println("2 - No");
                choice = sc.nextInt();
            }
            else
            {
                System.out.println("\nThankYou For Playing.");
                playagain = false;      //change the value of playagain variable so that it can not go into infinite loop
            }
        }
    }

    //function for show the user score
    public void score()
    {
        System.out.println("Score Based On Round You Won : "+round);
    }

    public static void main(String args[])
    {
        //Execute all function by making variable of task1
        System.out.println("\nWelcome To Number Game");
        task1 t = new task1();
        t.game();
        t.anotherround();
        t.score();
    }
}
