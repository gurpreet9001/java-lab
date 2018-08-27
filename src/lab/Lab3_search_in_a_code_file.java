package lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
                          BufferedReader bufferedReader0 = new BufferedReader(new FileReader(new File("HW3-unsorted-keywords.txt")));
			
			String line0;int Size=0,count=0;
		// count no of keywords	
                        while ((line0 = bufferedReader0.readLine()) != null) {   
				count++;
			}
                       
                        
                        String[] keywordStr = new String[count];
                        
                        bufferedReader0.close();
                 // reintialize bufferreader to beginning of file       
                        bufferedReader0 = new BufferedReader(new FileReader(new File("HW3-unsorted-keywords.txt")));

                        // read file line by line
                        while ((line0 = bufferedReader0.readLine()) != null) {   
				keywordStr[Size++]=line0;
			}
                        Size--;
                       
                        Selection_Sort(keywordStr,Size);
                        
               
		/*Using FileReader and BufferedReader to open the file HW3-input-code.cpp 
		 * which is to be searched for keywords*/
		File filecpp=new File("HW3-input-code.cpp");
		BufferedReader buffercpp=new BufferedReader(new FileReader(filecpp));
		
		//Creating output file HW3-output.txt
		FileWriter writeoutputfile=new FileWriter("HW3-output.txt"); 
		
		/*lineno gives the number of line in which the
		 * keyword is found*/
		int lineno=0;
        int keywordsfound = 0;
		/*Reading the .cpp file and searching for the keywords if found the line 
		 * and position of the found keyword is inserted into output file*/
		while((line0=buffercpp.readLine())!=null)
		{
			/*position gives the position of each word in a line
			 * printline is used to determine when to print lineno
			 * and printnextline to determine when to print next line*/
			int position=0,printline=1,printnextline=0;
			lineno++;
			/*split() is used to split each line and the words are
			 * then stored in String object words*/
			String[] words=line0.split("[\\s|\\(|* ]");
			/*Searching for keywords*/
			for(int i=0;i<words.length;i++)
			{
			
				for(int j=0;j<keywordStr.length;j++)
				{
					if(words[i].compareTo(keywordStr[j])==0)
					{
						keywordsfound++;
						if(printline==1)
						{
							writeoutputfile.write("Line "+lineno+":");
                                                        //writeoutputfile.write(System.getProperty( "line.separator" ));
							printline=0;
						}
						printnextline=1;
						writeoutputfile.write(keywordStr[j]+"("+position+") ");
                                                //writeoutputfile.write(System.getProperty( "line.separator" ));
						break;
					}
				}
				position+=words[i].length()+1;
			}
			if(printnextline==1)
				writeoutputfile.write(System.getProperty( "line.separator" ));
			printnextline=0;
		}
		writeoutputfile.write("Number of keywords found="+keywordsfound);
		buffercpp.close();
		writeoutputfile.close();
		}
		//Handling exception if file being read is not found
		
}

