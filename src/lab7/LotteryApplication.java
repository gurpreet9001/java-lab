package lab7;
import java.util.*;

class lotterySimulation
  {
    private int []lotteryNumber=new int[5];
    /*
     * constructor to intialize random lottery numbers
     */
    lotterySimulation()
    {
             Random generator;
            for(int i=0;i<5;i++)
            {
                    generator= new Random();
                    lotteryNumber[i]=i+generator.nextInt(10-i);
            }
         }
    /*
     * to compare both array of lottery numbers
     */
    int compare(int [] userLotteryNumber)
    {
    int count=0;
    for(int i=0;i<5;i++)
     if(lotteryNumber[i]==userLotteryNumber[i])
                    count++;
     return count;
    }
     void display()
    {
         System.out.print("Lottery Number is: ");
            for(int i=0;i<5;i++)
                    System.out.print(lotteryNumber[i]);
	   }
  }
public class LotteryApplication {

public static void main(String[] args) {
        Scanner input;
           /*
            * to hold user lottery number in array of integer
            */
          int[] userLotteryNumber=new int[5];
          int number;
          lotterySimulation lott =new lotterySimulation();

          System.out.println("\nEnter your Lottery number one by one:\t");
         for(int i=0;i<5;i++)
          {
                  input=new Scanner(System.in);
               number=input.nextInt();
                  userLotteryNumber[i]=number;
         }

    if( lott.compare(userLotteryNumber)==5)
        {
        System.out.println("\tCongratulation You Won lottery!!!");
        lott.display();
        }
        else
        System.out.println("Sorry only "+lott.compare(userLotteryNumber)+" numbers matched");

	}

}
