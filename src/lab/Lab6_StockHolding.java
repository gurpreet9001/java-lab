package lab;

public class Lab6_StockHolding{
    //instance variables
    private int numberOfShares;
    private String companyName;
    private float purchaseSharePrice,currentSharePrice;
    private float cost,value;

    //default constructor
    void StockHolding(){
        numberOfShares=0;
        companyName="";
        purchaseSharePrice=0;
        currentSharePrice=0;
    }
    // accessor fuctions
    void setCompanyName(String companyName)
    {this.companyName=companyName;}
    String getCompanyName(){return companyName;}

    void setNumberOfShares(int numberOfShares)
    {this.numberOfShares=numberOfShares;}
    float getNumberOfShares(){return numberOfShares;}

    void setPurchaseSharePrice(float purchaseSharePrice)
    {this.purchaseSharePrice=purchaseSharePrice; }
    float getPurchaseSharePrice(){return purchaseSharePrice;}

    void setCurrentSharePrice(float currentSharePrice)
    {this.currentSharePrice=currentSharePrice;  }
    float getCurrentSharePrice(){return currentSharePrice; }

     float costInDollars()
     {cost=purchaseSharePrice*numberOfShares;return cost;}
     float valueInDollars()
     {value=currentSharePrice*numberOfShares; return value;} 

    void show(){
       System.out.println();
      System.out.println(getCompanyName().toUpperCase());
      System.out.println("Current price:" + getCurrentSharePrice());
      System.out.println("Purchase price:" + getPurchaseSharePrice());
      System.out.println("Number of shares:" + getNumberOfShares());
      System.out.println("Cost in dollars:" + costInDollars());
      System.out.println("Value in dollars:" + valueInDollars()); 
    }

    // compare according to company name for sort function
    public static int comparecname(Lab6_StockHolding a , Lab6_StockHolding b)
    {
       return a.companyName.compareTo(b.companyName);
    }

    // compare according to company name for sort function
    public static int comparevalue(Lab6_StockHolding a , Lab6_StockHolding b)
    { 
        if(a.value<b.value)
            return 1;
        else return -1;
    }

    // compare according to company name for sort function
    public static int compareprofit(Lab6_StockHolding a , Lab6_StockHolding b)
    {
        if((a.value-a.cost)<(b.value-b.cost))
            return 1;
        else return -1;
    }

  }
    