package lab8;
import static org.junit.Assert.*;

import org.junit.Test;
public class TestReplace
{

@Test    
    public void testReplace()
    {
        RecursiveStringReplace rs = new RecursiveStringReplace();
        String result;
        System.out.println("TESTING RECURSIVE STRING REPLACE");
        
        System.out.println("Testing with an empty string");
        result = rs.replace("", 'a', 'b');
        System.out.println(result);
        assertEquals(null,result);
        

        System.out.println("Testing a string of size one - no replacement");
        result = rs.replace("c", 'a', 'b');
        System.out.println(result);
        assertEquals("c",result);       


        System.out.println("Testing a string of size one -  replacement");
        result = rs.replace("a", 'a', 'b');
        System.out.println(result);
        assertEquals("b",result);      

        System.out.println("Testing a string with no replacement");
        result = rs.replace("ABC cdefgh", 'a', 'b');
        System.out.println(result);
        assertEquals("ABC cdefgh",result);
             

        System.out.println("Testing a string with replacement");
        result = rs.replace("ABC bcadefgah", 'a', 'b');
        System.out.println(result);
        assertEquals("ABC bcbdefgbh",result);
        System.out.println("Testing a string with replacement");
        result = rs.replace("dddddddddd", 'd', 'a');
        System.out.println(result);
        assertEquals("aaaaaaaaaa",result);
           

    }
    
    public static void main(String[] args){
            TestReplace T=new TestReplace();
            T.testReplace();
    }
}
  
