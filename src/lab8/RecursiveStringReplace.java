package lab8;
/**
 * A class that has a method to recursively replaces characters in a String.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class RecursiveStringReplace
{

    /**
     * replace - Replace all instances of one character by another.
     * 
     * @param  s   The string to do the replacement on.
     * @param  from   The character to be replaced.
     * @param  to   the character to change to.
     * @return     A new string with the appropriate characters replaced.
     */
    public String replace(String s, char from, char to)
    {
       // for null string simply return 
       if(s.length()<1)     
           return null;   
       
       //replace the character if it matches
        char firstCharacter= ( from == s.charAt(0) ) ? to :s.charAt(0);     
        
        //for string of length 1
        if(s.length()==1)   
            return Character.toString(firstCharacter);    
        
        //recurse further by passing substring by excluding first charater
        return firstCharacter + replace(s.substring(1), from, to);
        
        
    }


}
