//Quiz Application

//Import Libraries
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

//Class for task4
public class task4 
{
    //declare variables
    private static int score = 0;
    private static int questionIndex = 0;
    private static String[][] questions = {
            {"What is the capital of France?", "A. London", "B. Paris", "C. Berlin", "B"},
            {"Which planet is known as the Red Planet?", "A. Venus", "B. Mars", "C. Jupiter", "B"},
            {"What is the powerhouse of the cell?", "A. Nucleus", "B. Mitochondria", "C. Ribosome", "B"}
    };

    //main class
    public static void main(String[] args) 
    {
        displayNextQuestion();
        displayResult();
    }

    //function for timer 
    private static void startTimer()
    {
        Timer timer = new Timer();
        int timeLimit = 10; // Time limit for each question in seconds

        TimerTask task = new TimerTask() {
            public void run() 
            {
                System.out.println("Time's up!");
                questionIndex++;
                displayNextQuestion();
            }
        };

        timer.schedule(task, timeLimit * 1000);
    }

    //function which display question
    private static void displayNextQuestion() 
    {
        if (questionIndex < questions.length) 
        {
            startTimer();
            String[] currentQuestion = questions[questionIndex];
            System.out.println(currentQuestion[0]);
            for (int i = 1; i < currentQuestion.length - 1; i++) 
            {
                System.out.println(currentQuestion[i]);
            }

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Answer : ");
            String userAnswer = scanner.nextLine().toUpperCase();

            if (userAnswer.equals(currentQuestion[currentQuestion.length - 1])) 
            {
                score++;
            }
            
            questionIndex++;
            displayNextQuestion();
        } 
    }

    //function to display result of quiz
    private static void displayResult() 
    {
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.length);
        System.exit(0);
    }
}