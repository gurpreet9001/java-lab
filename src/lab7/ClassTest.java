package lab7;

import java.util.Scanner;

class Students
{     // String array to store names 
      private String[] NameOfStudents =new String[5];
      //possible grades
      private char[] Grade= {'A','B','C','D','E'};
      //five arrays of four doubles to store scores of four subjects of five students
      private double [] detailOfStu1=new double[4];
      private double [] detailOfStu2=new double[4];
      private double [] detailOfStu3=new double[4];
      private double [] detailOfStu4=new double[4];
      private double [] detailOfStu5=new double[4];
      
      //accessor functions
	public String[] getNameOfStudents() {
		return NameOfStudents;
	}
	public void setNameOfStudents(String[] nameOfStudents) {
		NameOfStudents = nameOfStudents;
	}
	public double[] getDetailOfStu5() {
		return detailOfStu5;
	}
	public void setDetailOfStu5(double[] detailOfStu5) {
		this.detailOfStu5 = detailOfStu5;
	}
	public double[] getDetailOfStu1() {
		return detailOfStu1;
	}
	public void setDetailOfStu1(double[] detailOfStu1) {
		this.detailOfStu1 = detailOfStu1;
	}
	public double[] getDetailOfStu2() {
		return detailOfStu2;
	}
	public void setDetailOfStu2(double[] detailOfStu2) {
		this.detailOfStu2 = detailOfStu2;
	}
	public double[] getDetailOfStu3() {
		return detailOfStu3;
	}
	public void setDetailOfStu3(double[] detailOfStu3) {
		this.detailOfStu3 = detailOfStu3;
	}
	public double[] getDetailOfStu4() {
		return detailOfStu4;
	}
	public void setDetailOfStu4(double[] detailOfStu4) {
		this.detailOfStu4 = detailOfStu4;
	}
        
        
        // To return average score of the test
	double calculation(double[] scores)
	{
		double average;
		  average=(scores[0]+scores[1]+scores[2]+scores[3])/4;
		return average;
	}
        
        // To display name of student , average , grade
	void dataOfStudent()
	{
		
		System.out.println("Required details are :");
		for(int i=0;i<5;i++) 
		{
			System.out.println("\n"+(i+1)+"."+NameOfStudents[i]);
			double avg;
			if(i==0)
			 avg=calculation(detailOfStu1);
			else if(i==2)
				avg=calculation(detailOfStu2);
			else if(i==3)
				avg=calculation(detailOfStu3);
			else if(i==4)
				avg=calculation(detailOfStu4);
			else
					avg=calculation(detailOfStu5);
			  System.out.println("Average: "+avg);
			      if(avg>=90 && avg<=100 )
			    	  System.out.println("Grade: "+Grade[0]);
			      else if(avg>=80 && avg<90 )
			    	  System.out.println("Grade: "+Grade[1]);
			      else  if(avg>=70 && avg<80 )
			    	  System.out.println("Grade: "+Grade[2]);
			      else if(avg>=60 && avg<70 )
			    	  System.out.println("Grade: "+Grade[3]);
			      else
			    	  System.out.println("Grade: "+Grade[4]);
		}
	}
      
}



public class ClassTest {
    
    static double[] getScores(double[] scores)
	{ 
		Scanner getint;
		System.out.println("Enter score of each Test(Score must be >=0 and <=100)");
		for(int i=0;i<4;i++)
			{ 
			System.out.print("Test["+(i+1)+"]:");
			getint=new Scanner(System.in);
			do {
			scores[i]=getint.nextDouble();
			 if(scores[i]<0 || scores[i]>100)
				 System.out.println("Invalid Number. Try Again");
		    	}while(scores[i]<0 || scores[i]>100);
			}
	   return scores;	
	}


	public static void main(String[] args) {
            
		//studentName array for name of students
		String[] studentsName =new String[5];
                
		//scores array as to hold each test score of each student
		double[] scores;
                
		// creating instance of class Students
                Students DetailOfStudent =new Students();
                
	    Scanner getName =new Scanner(System.in);
            
        try {
	    	System.out.println("Enter The Name of Student 1:\t");
             studentsName[0]=getName.nextLine();
             scores =new double[4];
             DetailOfStudent.setDetailOfStu1(getScores(scores));

             System.out.println("Enter The Name of Student 2:\t");
             studentsName[1]=getName.nextLine();
             scores =new double[4];
             DetailOfStudent.setDetailOfStu2(getScores(scores));
             
             System.out.println("Enter The Name of Student 3:\t");
             studentsName[2]=getName.nextLine();
             scores =new double[4];
             DetailOfStudent.setDetailOfStu3(getScores(scores));
             
             System.out.println("Enter The Name of Student 4:\t");
             studentsName[3]=getName.nextLine();
             scores =new double[4];
             DetailOfStudent.setDetailOfStu4(getScores(scores));
             
             System.out.println("Enter The Name of Student 5:\t");
             studentsName[4]=getName.nextLine();
             scores =new double[4];
             DetailOfStudent.setDetailOfStu5(getScores(scores));
           } 
        finally {getName.close();}
        
             DetailOfStudent.setNameOfStudents(studentsName);
             DetailOfStudent.dataOfStudent();
	  }
 
	
	
}
 