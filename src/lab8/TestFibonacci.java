package lab8;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestFibonacci
{

@Test
    public void testBetter()
    {
        RecursiveFibonacci fibonacci = new RecursiveFibonacci();
        long result;
        System.out.println("TESTING BETTER RECURSIVE FIBONACCI");
        
        System.out.println("Confirm we get a result for a negative value");
        result = fibonacci.better(-5);
        System.out.println("    Passed - got result");
        
        System.out.println("Testing fibonacci(0)");
        result = fibonacci.better(0);
        assertEquals(0,result);
        
        
        System.out.println("Testing fibonacci(1)");
        result = fibonacci.better(1);
        assertEquals(1,result);
        
        
        System.out.println("Testing fibonacci(3)");
        result = fibonacci.better(3);
        assertEquals(2,result);
                
        System.out.println("Testing fibonacci(9)");
        result = fibonacci.better(9);
        assertEquals(34,result);
        
        
        System.out.println("Testing fibonacci(10)");
        result = fibonacci.better(10);
        assertEquals(55,result);
                
        System.out.println("Testing fibonacci(48)");
        result = fibonacci.better(48);
        assertEquals(4807526976l,result);

                
        System.out.println("Testing fibonacci(49)");
        result = fibonacci.better(49);
        assertEquals(7778742049l,result);
       
                

        System.out.println("Testing fibonacci(50)");
        result = fibonacci.better(50);
        assertEquals(4807526976l+7778742049l,result);
                        

    }
  
  
  
  
  
  @Test
    public void testTailRecursive()
    {
        RecursiveFibonacci fibonacci = new RecursiveFibonacci();
        long result;
        System.out.println("TESTING TAIL RECURSIVE FIBONACCI");
        
    System.out.println("Confirm we get a result for a negative value");
        result = fibonacci.tailRecursive(-5);
        System.out.println("    Passed - got result");
        
        System.out.println("Testing fibonacci(0)");
        result = fibonacci.tailRecursive(0);
        assertEquals(0,result);
        
        
        System.out.println("Testing fibonacci(1)");
        result = fibonacci.tailRecursive(1);
        assertEquals(1,result);
        
        
        System.out.println("Testing fibonacci(3)");
        result = fibonacci.tailRecursive(3);
        assertEquals(2,result);
                
        System.out.println("Testing fibonacci(9)");
        result = fibonacci.tailRecursive(9);
        assertEquals(34,result);
        
        
        System.out.println("Testing fibonacci(10)");
        result = fibonacci.tailRecursive(10);
        assertEquals(55,result);
                
        System.out.println("Testing fibonacci(48)");
        result = fibonacci.tailRecursive(48);
        assertEquals(4807526976l,result);
      
                
        System.out.println("Testing fibonacci(49)");
        result = fibonacci.tailRecursive(49);
        assertEquals(7778742049l,result);
                      

        System.out.println("Testing fibonacci(50)");
        result = fibonacci.tailRecursive(50);
        assertEquals(4807526976l+7778742049l,result);
                
    }
    
    public static void main(String[] args){
            TestFibonacci T=new TestFibonacci();
            T.testBetter();
    }
    
}
