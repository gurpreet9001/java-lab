package lab;
import java.io.*;
public class Lab2_dictionary_sort_search {

   public static int binarySearch(String[] a, String x,
           int Size,FileWriter fw) throws IOException {
    int low = 0;
    int high = Size - 1;
    int mid;

    while (low <= high) {
        mid = (low + high) / 2;

        if (a[mid].compareTo(x) < 0) {
            low = mid + 1;
        } else if (a[mid].compareTo(x) > 0) {
            high = mid - 1;
        } else {
            return 0;
        }
    }
 fw.write("Keyword not found: "+x+"\n"); 
       
      return 1;
}
    
    static void Selection_Sort(String[] arrStr0,int Size0){
for (int i=0; i<Size0; i++) 
    {
        for (int j=i+1; j<Size0; j++) 
        {
           if (arrStr0[i].compareTo(arrStr0[j]) > 0) 
           {
            String temp=arrStr0[j]; arrStr0[j]=arrStr0[i]; 
            arrStr0[i]=temp;
           }
        }
    }
}
    
public static void main(String[] args) {
       try {
    // Dictionary file read
        File file0 = new File("HW2-dictionary.txt");
        FileReader fileReader0 = new FileReader(file0);
        BufferedReader bufferedReader0 = new BufferedReader(fileReader0);
        String[] arrStr0 = new String[16000];
        String line0;int Size0=0;

        // read file line by line
        while ((line0 = bufferedReader0.readLine()) != null) {   
                arrStr0[Size0++]=line0;
        }
        Size0--;
        fileReader0.close();

        Selection_Sort(arrStr0,Size0);
// Keywords file read   
        File file = new File("HW2-keywords.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] arrStr = new String[100];
        String line;int Size=0;

        // read line by line 
        while ((line = bufferedReader.readLine()) != null) {
                arrStr[Size++]=line;
        }
        Size--;

        fileReader.close();
        Selection_Sort(arrStr,Size);
        int count=0;

    //File file2 = new File("HW2-output");

     FileWriter fw=new FileWriter("HW2-output.txt"); 

        // search keywords in dictionary
        for(int i=0;i<Size;i++){  
            count+=binarySearch(arrStr0,arrStr[i],Size0,fw);  
        }   
        System.out.println("No. of keywords not found = "+count);

      fw.write("No. of keywords not found = "+count+"\n"); 
     fw.close(); 
             } catch (IOException e) {
             }
    }   
}
