package lab;

import java.io.*;

public class Lab3_search_in_a_code_file {
    
 static void Selection_Sort(String[] arrStr0,int Size0){
    for (int i=0; i<Size0; i++) 
    {
    for (int j=i+1; j<Size0; j++) 
    {
       if (arrStr0[i].compareTo(arrStr0[j]) > 0) 
       {
          String temp=arrStr0[j]; arrStr0[j]=arrStr0[i]; arrStr0[i]=temp;
       }
    }
    }
}

    public static void main(String[] args) throws IOException {
// Unsorted Keyword file read
        BufferedReader bufferedReader = 
                new BufferedReader(new FileReader
        (new File("HW3-unsorted-keywords.txt")));

        String line;int Size=0,count=0;
// count no of keywords	
        while ((line = bufferedReader.readLine()) != null)   
                count++;

        String[] keywordStr = new String[count];

        bufferedReader.close();
 // reintialize bufferreader to beginning of file       
        bufferedReader = new BufferedReader
        (new FileReader(new File("HW3-unsorted-keywords.txt")));

 // read file line by line
        while ((line = bufferedReader.readLine()) != null) {   
                keywordStr[Size++]=line;
        }
        Size--;

        Selection_Sort(keywordStr,Size);


// Using FileReader and BufferedReader to open the file HW3-input-code.cpp 

    File filecpp=new File("HW3-input-code.cpp");
    BufferedReader cppCodeBufferReader
            =new BufferedReader(new FileReader(filecpp));

//Creating output file HW3-output.txt
    FileWriter outputFile=new FileWriter("HW3-output.txt"); 

/*lineNo gives the number of line in which the
 * keyword is found*/
    int lineNo=0;
    int keywordsFound = 0;

/*Reading the .cpp file and searching for the keywords if found the line 
 * and position of the found keyword is inserted into output file*/

    while((line=cppCodeBufferReader.readLine())!=null)
        {
/*position gives the position of each word in a line
 * printLine is used to determine when to print lineNo
 * and flagPrintNextLine to determine when to print next line*/
        int position=0,printLine=1,flagPrintNextLine=0;
        lineNo++;

/*split() is used to split each line and the words are
 * then stored in String object words*/
        String[] words=line.split("[ |*|(|)|#|;|<|>|{|}|, ]");
/*Searching for keywords*/
        for(int i=0;i<words.length;i++)
        {
            //to ignore the keywords in comments
            if(words[i].compareTo("//")==0)
                {
                    break;
                }

        for(int j=0;j<keywordStr.length;j++)
        {
            if(words[i].compareTo(keywordStr[j])==0)
        {
                keywordsFound++;
                if(printLine==1)
                {
                        outputFile.write("Line "+lineNo+":");                                  
                        printLine=0;
                }
                flagPrintNextLine=1;
                outputFile.write(keywordStr[j]+"("+position+") ");
                break;
                }
        }
                position+=words[i].length()+1;
        }
        if(flagPrintNextLine==1)
        outputFile.write(System.getProperty( "line.separator" ));
        flagPrintNextLine=0;

        }

        outputFile.write("Number of keywords found="+keywordsFound);
        cppCodeBufferReader.close();
        outputFile.close();		
    }
		
}

