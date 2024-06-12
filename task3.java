//ATM Interface

//Import libraries
import java.io.*;
import java.util.*;

//class for bankaaccount
class bankaccount
{
    //variable for balance
    public float balance; 
    
    //constructor of bankaaccount  
    public bankaccount()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nThankYou For Opening New Account In Our Bank !!");
        System.out.println("You Need To Deposit Some Money Now, Your Account Balance Can't Have Empty !!");
        System.out.println("\nEnter Amount : ");
        balance = sc.nextFloat();
    }    

    //function for withdraw
    public boolean withdraw(float amount)
    {
        if(amount>=100 && balance>=amount)
        {
            balance = balance - amount;
            System.out.println("Transaction Completed !!");
            System.out.println("Remaining Balance : "+balance);
            return true;
        }
        else
        {
            if(balance<amount)
            {
                System.out.println("Your Transaction Failed Due To Lower Balance Compare To Your Withdraw Amount Request !!");
                return false;
            }
            else if(amount<100 && amount>0)
            {
                System.out.println("Your Transaction Failed Due To Your Entered Amount Is Less Than 100. Minimum Withdraw Amount Is 100 !!");
                return false;
            }
            else
            {
                System.out.println("Your Transaction Failed Due To Your Entered Amount Is Not In Positive !!");
                return false;
            }
        }
    }

    //function for deposit
    public boolean deposit(float amount)
    {
        if(amount>100)
        {
            balance = balance + amount;
            System.out.println("Transaction Completed !!");
            System.out.println("New Balance : "+balance);
            return true;
        }
        else if(amount<100 && amount>0)
        {
            System.out.println("Your Transaction Failed Due To Your Entered Amount Is Less Than 100. Minimum Deposit Amount Is 100 !!");
            return false;
        }
        else
        {
            System.out.println("Your Transaction Failed Due To Your Entered Amount Is Not In Positive !!");
            return false;
        }
    }

    //function for checking the bank balance
    public float checkBalance()
    {
        return balance;
    }
}

//atm class (task3)
public class task3
{
    //define a variable of bankaccount class
    private bankaccount account;

    //constructor of atm(task3)
    task3(bankaccount account)
    {
        this.account = account;
    }

    //function of choice
    public void choices()
    {
        System.out.println("\n--- ATM INTERFACE ---");
        System.out.println("1 - Deposit");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Check Balance");
        System.out.println("4 - Exit");
    }

    //functin of atm interface
    public void atminterface()
    {
        choices();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Choice : ");
        int choice = sc.nextInt();

        while(choice!=4)
        {
            if(choice==1)
            {
                System.out.println("Enter Amount : ");
                int amount = sc.nextInt();
                account.deposit(amount);
            }
            else if(choice==2)
            {
                System.out.println("Enter Amount : ");
                int amount = sc.nextInt();
                account.withdraw(amount);
            }
            else if(choice==3)
            {
                System.out.println("Balance : "+account.checkBalance());
            }
            else if(choice==4)
            {
                break;
            }
            else
            {
                System.out.println("\nInvalid Choice!! Please Enter Again");
            }
            choices();
            System.out.println("\nEnter Choice : ");
            choice = sc.nextInt();
        }
    }

    //main class
    public static void main(String args[])
    {
        bankaccount account = new bankaccount();
        task3 t3 = new task3(account);
        t3.atminterface();
    }
}