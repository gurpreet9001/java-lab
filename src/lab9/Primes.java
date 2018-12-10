package lab9;

import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
  * @version 4.0
 */

    
public class Primes
{

    public static void main(String args[])
    {

        int max;
        
        System.out.println("Enter max size of list to construct Primes and Composites");
        max = getInt("Value should be integer & greater than or equal to 2.");
        
        ListInterface<Integer> candidates = new AList<Integer>();
        for(int i = 2; i <= max; i++)
        	candidates.add(i);
         System.out.println("Candidate list is : "+candidates);
        
        ListInterface<Integer> primes = new AList<Integer>();
        ListInterface<Integer> composites = new AList<Integer>();
        while(!candidates.isEmpty()) {
        	int currPrime = candidates.getEntry(1);
        	candidates.remove(1);
        	primes.add(currPrime);
        	getComposites(candidates,composites,currPrime);
        }
        
       
        System.out.println("Prime list is : "+primes);
        System.out.println("Composite list is : "+composites);
        
    }
    
    
    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
    {
    	int i = 1;
        while(i <= candidates.getLength()) {
    		if(candidates.getEntry(i)%prime == 0 ) {
    			composites.add(candidates.getEntry(i));
    			candidates.remove(i);
    		}
    		else
    			i++;
    	}
    }
    
    
    
    
    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }    
    
}
