package lab8;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFactorial {

    
	@Test    
    public void testBasic()
    {
	RecursiveFactorial factorial = new RecursiveFactorial();
    long result;
    System.out.println("TESTING BASIC RECURSIVE FACTORIAL");
    
    System.out.println("Confirm we get a result for a negative value");
    result = factorial.basic(-5);
    System.out.println("    Passed - got result");
    
    System.out.println("Testing factorial(0)");
    result = factorial.basic(-5);
    assertEquals(1,result);
   
    
    System.out.println("Testing factorial(1)");
    result = factorial.basic(1);
    assertEquals(1,result);
    
    System.out.println("Testing factorial(3)");
    result = factorial.basic(3);
    assertEquals(6,result);
            
    System.out.println("Testing factorial(10)");
    result = factorial.basic(10);
    assertEquals(3628800,result);
     
}

@Test
public void testTailRecursive()
{
    RecursiveFactorial factorial = new RecursiveFactorial();
    long result;
    System.out.println("TESTING TAIL RECURSIVE FACTORIAL");
    
    System.out.println("Confirm we get a result for a negative value");
    result = factorial.tailRecursive(-5);
    System.out.println("    Passed - got result");
    
    System.out.println("Testing factorial(0)");
    result = factorial.tailRecursive(0);
    assertEquals(1,result);
    
    
    System.out.println("Testing factorial(1)");
    result = factorial.tailRecursive(1);
    assertEquals(1,result);
    
    
    System.out.println("Testing factorial(3)");
    result = factorial.tailRecursive(3);
    assertEquals(6,result);
            
    System.out.println("Testing factorial(10)");
    result = factorial.tailRecursive(10);
    assertEquals(3628800,result);
            
	}

public static void main(String[] args){
            TestFactorial T=new TestFactorial();
            T.testBasic();
    }

}
