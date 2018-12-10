package lab;

public class Lab_ForeignStockHolding extends Lab6_StockHolding
{
    float conversionRate;

    Lab_ForeignStockHolding(float a){
       conversionRate=a;
    }

    @Override
    float costInDollars()
    {
            return conversionRate*(super.costInDollars());
    }
    @Override
    float valueInDollars()
    {
            return conversionRate*(super.valueInDollars());
    }	
}