package lab;
import java.io.*;
import java.util.*;

class part1 {
	int total=0,ex,minor,fin,cl,pts,pct;
	int[] assignments;
	char grade;
	String s;
        long studentid;
       
	public int roundof(double x) {
		int y =(int) Math.round(x);
		return y;
	}
	public void init(String s){

		s = s.replaceAll("  "," ");
		String[] tokens=s.split(" ");
		studentid = Long.parseLong(tokens[0]);
		ex = Integer.valueOf(tokens[1]);
		assignments = new int[10];

		for(int i=2;i<12;i++)
		{
			assignments[i-2] = Integer.valueOf(tokens[i]);
			total += assignments[i-2];
		}
		minor = Integer.valueOf(tokens[12]);
		fin = Integer.valueOf(tokens[13]);
		cl = Integer.valueOf(tokens[14]);
		pts = ex + total + minor + fin + cl;
		double temp = ((double)pts*100)/420;
		//System.out.println(temp);
		pct = roundof(temp);
		if(pct>=90)
                    grade = 'A';
		else if(pct <= 89 && pct >= 78)
                    grade ='B';
		else if(pct <= 77 && pct >= 62)
                    grade ='C';
		else if(pct <= 61 && pct >= 46)
                    grade ='D';
		else if(pct <= 45)
                    grade ='F';
		
	}

}


class part2 {
	  public String IntToString(int x,int y)
	  {
		  if(y - Integer.toString(x).length() == 0)
		  {
			  return Integer.toString(x);
		  }
		  else if(y - Integer.toString(x).length() == 1)
		  {
			  return " "+Integer.toString(x);
		  }
		  else 
		  {
			  return "  "+Integer.toString(x);
		  }
	  }
	  public void init(List <part1> students)
	  {
		  	String s;
			try{    
		           FileWriter fw=new FileWriter("HW1-output-16103025.txt",true);
		           s = "Stdnt Id  Ex  ------- Assignments ---------  Tot  Mi  Fin  CL  Pts  Pct  Gr\n";
		           fw.write(s);
		           s = "--------  --  -----------------------------  ---  --  ---  --  ---  ---  --\n";
		           fw.write(s);
		           Double avg = 0.0;
		           int counta=0,countb=0,countc=0,countd=0,countf=0;
		           int maxPts =0;
		           for(part1 s1:students)
					{
						if( (Long.toString(s1.studentid)).length() ==7)
						{
							s = "0"+Long.toString(s1.studentid);
						}
						else
						{
							s = Long.toString(s1.studentid);
						}
						s +="  "+ IntToString(s1.ex,2)+" ";	
						for(int i=0;i<10;i++)
						{
							s += " "+IntToString(s1.assignments[i],2);
						}
						s += "  "+IntToString(s1.total,3);
						s += "  "+IntToString(s1.minor,2);
						s += "   "+IntToString(s1.fin,2);
						s += "  "+IntToString(s1.cl,2);
						s += "  "+IntToString(s1.pts,3);
						s += "   "+IntToString(s1.pct,2);
						s += "   "+s1.grade+" \n";
						avg += s1.pct;
						switch (s1.grade)
						{
						case 'A':counta++;break;
						case 'B':countb++;break;
						case 'C':countc++;break;
						case 'D':countd++;break;
						case 'F':countf++;break;
						}
						if(maxPts < s1.pts)
						{
							maxPts = s1.pts;
						}
						fw.write(s);
					}
		           fw.write("\n\n");
		           s = "Average total point percent of all students: ";
		           s += Double.toString(Math.round(avg/students.size())) + "\n";
		           fw.write(s);
		           fw.write("Number of A's = " + Integer.toString(counta)+"\n");
		           fw.write("Number of B's = " + Integer.toString(countb)+"\n");
		           fw.write("Number of C's = " + Integer.toString(countc)+"\n");
		           fw.write("Number of D's = " + Integer.toString(countd)+"\n");
		           fw.write("Number of F's = " + Integer.toString(countf)+"\n\n");
		           fw.write("Maximum points =" + Integer.toString(maxPts)+"\n");
		           fw.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	  }

}


public class CSX_358_HW1_16103025 {
	public static void main(String[] args)throws FileNotFoundException{
		File file = new File("HW1-data.txt");
		Scanner scan = new Scanner(file);

                ArrayList <part1> students = new ArrayList<part1>();
		
                part1 student;
                String s;
		while(scan.hasNextLine())
		{
			student = new part1();
			s = scan.nextLine();
			student.init(s);
			students.add(student);
		}
		scan.close();
		part2 fw = new part2();
		fw.init(students);
		System.out.println("DONE");
	}
}
