//Student Grade Calculator

//Import Libraries
import java.io.*;
import java.util.*;
public class task2
{
    //Add this variable to take input from user for number of subject
    static int no_of_subject;
    //Add this variable for calculation of grade and take name of student from user 
    static String grade,name;
    //Add this variable for calculation of average percentage and total
    float avg_per,total=0;
    //Add this variable to take input of student marks per subject from user 
    float marks[] = new float[no_of_subject];
    //Add this to take input
    static Scanner sc = new Scanner(System.in);
  
    //function of take and verify name
    public void input()
    {
        System.out.println("\nEnter Student Name : ");
        name = sc.next();

        //Create pattern for user enter only alphabets
        String pattern = "[a-zA-Z]+";
        boolean check = name.matches(pattern);      

        while(!check)
        {
            System.out.println("Please Enter Only Alphabets!! Enter Student Name : ");
            name = sc.next();
            check = name.matches(pattern);
        }
    }

    //function of take mark,calculate total and percentage
    public void mark_total_per()
    {
        for(int i=0;i<no_of_subject;i++)
        {
            System.out.println("\nEnter Marks For Subject "+(i+1)+" : ");
            marks[i] = sc.nextFloat();

            //Create a loop so that it only take input in the range of 0 to 100
            while(marks[i]<0 || marks[i]>100)
            {
                System.out.println("\nPlease Enter Marks For Subject "+(i+1)+" In The Range Of 0 To 100 : ");
                marks[i] = sc.nextFloat();
            }
            total = total+marks[i];     //Calculate total
        }
        avg_per = total/no_of_subject;  //Calculate Average
    }

    //function of assign grade 
    public void grade()
    {
        if(avg_per>=90 && avg_per<100)
        {
            grade = "A+";
        }
        else if(avg_per>=80 && avg_per<90)
        {
            grade = "A";
        }
        else if(avg_per>=70 && avg_per<80)
        {
            grade = "B";
        }
        else if(avg_per>=60 && avg_per<70)
        {
            grade = "C";
        }
        else if(avg_per>=50 && avg_per<60)
        {
            grade = "D";
        }
        else
        {
            grade = "Fail";
        }
    }

    //function of display the output to user
    public void display()
    {
        System.out.println("\n--- Student Grade Calculator ---");
        System.out.println("\nStudent Name : "+name);
        for(int i=0;i<no_of_subject;i++)
        {
            System.out.println("Mark Of Subject "+(i+1)+" : "+marks[i]);
        }
        System.out.println("Total : "+total);
        System.out.println("Average : "+avg_per);
        System.out.println("Grade : "+grade+"\n");
    }

    //Main Class
    public static void main(String args[])
    {
        //Take input from user of how many subject they consider for result calculation
        System.out.println("\nEnter Number Of Subject : "); 
        no_of_subject = sc.nextInt();

        //create a variable of class and execute all function by using it
        task2 t2 = new task2();
        t2.input();
        t2.mark_total_per();
        t2.grade();
        t2.display();
    }
}