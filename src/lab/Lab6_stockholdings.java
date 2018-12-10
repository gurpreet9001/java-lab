package lab;
import java.util.Arrays;
import java.util.Scanner;

public class Lab6_stockholdings {

public static void main(String[] args) {
    int noOfStockInstances=0;
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter number of instances for StockHoldings:");
    noOfStockInstances=scan.nextInt();

    // declaring array of objects
    Lab6_StockHolding obj[]=new Lab6_StockHolding[noOfStockInstances];
    int type;

    //console input
    for(int i=0;i<noOfStockInstances;i++){

    System.out.println("Values in 0:Regular currency  1:Foreign currency ");
    type=scan.nextInt();

    // Allocating memory to each object
   if(type==0)
    obj[i]=new Lab6_StockHolding();       
   else{
       System.out.println("Enter conversion rate");
     obj[i]=new Lab_ForeignStockHolding(scan.nextFloat()); 
   } 
   System.out.println("Enter company name:");
   obj[i].setCompanyName(scan.next()+scan.nextLine());
   System.out.println("Enter current price:");
   obj[i].setCurrentSharePrice(scan.nextFloat());
   System.out.println("Enter purchase price:");
   obj[i].setPurchaseSharePrice(scan.nextFloat());
   System.out.println("Enter no. of shares:");            
   obj[i].setNumberOfShares(scan.nextInt());
   obj[i].costInDollars();
   obj[i].valueInDollars();
    }
        System.out.println
    ("1)Display stock information with the lowest value\n" +
    "2)	Display stock with the highest value\n" +
    "3)	Display the most profitable stock\n" +
    "4)	Display the least profitable stock\n" +
    "5)	List all stocks sorted by company name (A-Z)\n" +
    "6)	List all stocks sorted \n" +
    "7)	Exit");  

int flag=1;
        
    do{
    switch(scan.nextInt()){
        case 1:Arrays.sort(obj,Lab6_StockHolding::comparevalue);
                        obj[obj.length-1].show();   
                break;
        case 2:Arrays.sort(obj,Lab6_StockHolding::comparevalue);
                        obj[0].show();   
                break;
        case 3:Arrays.sort(obj,Lab6_StockHolding::compareprofit);
                        obj[obj.length-1].show(); 
                break;
        case 4:Arrays.sort(obj,Lab6_StockHolding::compareprofit);
                        obj[0].show();   
                break;
        case 5:
                 //sort array of objects on the basis of company names
                Arrays.sort(obj,Lab6_StockHolding::comparecname);
                for(int i=0;i<noOfStockInstances;i++)
                    {  
                        obj[i].show();
                    }
                break;
        case 6://sort array of objects on the basis of highest values
                Arrays.sort(obj,Lab6_StockHolding::comparevalue);
                for(int i=0;i<noOfStockInstances;i++)
                    {  
                        obj[i].show();
                    }
                break;
        case 7: flag=0;
            break;

        default:System.out.println("Enter correct choice");
    }
    }while(flag==1);

    }
    
}
