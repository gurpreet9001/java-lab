package lab7;

import java.util.Scanner;

//User defined Exception for Invalid Pin
class InvalidPin extends Exception
{
	public InvalidPin() {}
	public InvalidPin(String s) {
		super(s);
	}
}

//when Amount is not a multiple of 100, 500 or 2000
class NoteException extends Exception
{

	public NoteException() {}
	public NoteException(String s) {
		super(s);
	}
}

//Entering the amount is exceed 10000 or less than 100
class InvalidAmount extends Exception
{

	public InvalidAmount() {}
	public InvalidAmount(String s) {
		super(s);
	}
}

//There is insufficient balance in the user account
class BalanceShort extends Exception
{

	public BalanceShort() {}
	public BalanceShort(String s) {
		super(s);
	}
}

//When there is shortage of cash in atm
class AtmBalanceShort extends Exception
{

	public AtmBalanceShort() {}
	public AtmBalanceShort(String s) {
		super(s);
	}
}

//When User press wrong option
class InvalidOption extends Exception
{

	public InvalidOption() {}
	public InvalidOption(String s) {
		super(s);
	}
}



public class Atm {
//Storing the user Balance
 int  userBalance;
 //Storing the user Pin
 int userPIN;
 //storing the amount available in ATM 
 static int atmBalance=10000;

 //Initialize data of 5 users .......
 public Atm()
 {
         userPIN=16103025;
         userBalance=10000;

 }
 //When User choose withdraw option
 public void withdraw(int withdraw)
 {
try
{   
//When Amount is either less than 100 or exceed 10000
if(withdraw<=100 || withdraw>=10000) throw new InvalidAmount("Invalid Amount");

//when Amount is not a multiple of 100, 500 or 2000
if(withdraw%100!=0) throw new NoteException
        ("Amount is not a multiple of 100, 500 or 2000");

//When Atm has Shortage of cash
if(atmBalance-withdraw<0)  throw new AtmBalanceShort
        ("ATM hasn`t have Entered amount");

//When User Balance is insufficient
if(this.userBalance-withdraw<0) throw new BalanceShort
        ("User  Balance is less than the Entered Balance");

//Set the User balance when Amount is Withdraw
this.userBalance-=withdraw;

//Set the Atm Balance when amount is deposited
atmBalance-=withdraw;
}

//Catch Exceptions
        catch(NoteException e)
        {
                System.out.println(e.getMessage());	
        }
        catch(BalanceShort e)
        {
                System.out.println(e.getMessage());	
        }
        catch(AtmBalanceShort e)
        {
                System.out.println(e.getMessage());	
        }
        catch(InvalidAmount e)
        {
                System.out.println(e.getMessage());	
        }

 }

 //When User press Deposit option
 public void deposit(int deposit)
 {
try
{   //When deposited amount is not a multiple of 100,500 or 2000
        if(deposit%100!=0) throw new NoteException
        
        ("Amount is not a multiple of 100, 500 or 2000");

//set user balance when amount is Deposited
        this.userBalance+=deposit;
        //set the Atm amount when the amount is deposited
        System.out.println(this.userBalance);
        atmBalance+=deposit;
}

//Catch Exception
catch(NoteException e)
{
        System.out.println(e.getMessage());

}
}
         
        
public static void main(String[] args) {
    Atm obj=new Atm();
    Scanner input=new Scanner(System.in);

    int pin;

    //Loop for getting the Pin Number
    while(true)
{
        try
    {
        System.out.println("Enter Pin:");
        pin=input.nextInt();

        //throws the exception when the entered pin is wrong
        if(pin!=obj.userPIN) throw new InvalidPin("Invalid Pin try again::");
                      break;
        }

//Catch Exception
        catch( InvalidPin e)
        {
          System.out.println(e.getMessage());
        }
    }

    //that handles the loop for option menu
    boolean loop=true;

    //it stores the choice of user
    int choice=0;

    while(loop)
    {  
    //Print the valid Option to the screen
    System.out.println("Enter your Choice:\n1.Withdraw"
                    +"\n2.Deposit\n3.Check Balanace"
                    + "\n4.Exit");
    choice=input.nextInt();

    //Handle the cases via switch statement
    switch(choice)
    {

    case 1:
    {
            int withdraw;
            System.out.println("Enter Withdraw Amount :");
            //getting the amount that to be withdraw
            withdraw=input.nextInt();

            //calling the Withdraw method
        obj.withdraw(withdraw);
            break;

    }
    case 2:
    {
            int deposit;
            System.out.println("Enter deposit Amount :");

            //Getting the amount that to be deposited
            deposit=input.nextInt();

            //calling the Deposit method 
            obj.deposit(deposit);
            break;

    }
    case 3:
    {
            //Print the Remaining balance of the user
            System.out.println("Balance:"+obj.userBalance);
            break;
    }
    case 4:
    {
            //Exiting from the ATM
            System.out.println("Exiting...........");
            loop=false;
            break;
    }
    default :
    {  //For Invalid Option

            try {

                    //throw the Invalid option Exception
            throw new InvalidOption("Invalid Option..Choose right one");}
            catch(InvalidOption e)
            {
                    System.out.println(e.getMessage());
                    break;
            }

    }

    }

    }
    input.close();

	}

}

