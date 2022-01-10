import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

//updated file to store last name before student id
public class App 
{
//File text = new File("H:/CS2021/APCS2021/test.txt");
public static File text = new File("C:/Eclipse/Attend/test.txt");


	public static void main(String args[]) throws FileNotFoundException 
	{
		Scanner scnr = new Scanner(text);
		ArrayList<String> line = new ArrayList<String>();
		while(scnr.hasNextLine())
        {
        	line.add(scnr.nextLine());
        }
		
		java.util.Collections.sort(line);
		rewriteFile(line);
		display(line);
		
		scnr.close();
	}
	
	public static Student processStudentRecord(String line)
	{
		int x = line.indexOf("@");
        
        String name = line.substring(0,x);
        String last = name.substring(0,name.indexOf(",")).trim();
        String first = name.substring(name.indexOf(",")+1).trim();
        line = line.substring(x+1);

        x = line.indexOf("@");
        String id = line.substring(0,x);
        line = line.substring(x+1);
       
        x=line.indexOf("@");
        String dates = line.substring(0,x);
        line = line.substring(x+1);
        int absences = Integer.parseInt(line);
        
        return new Student(id,last,first,parseDates(dates),absences);
	}
	public static ArrayList<String> parseDates(String dates)
	{
		ArrayList<String> dateList = new ArrayList<String>();
        while(dates.indexOf(",")>=0)
        {
        	dateList.add(dates.substring(0,dates.indexOf(",")));
        	dates = dates.substring(dates.indexOf(",")+1);
        }
        dateList.add(dates);
		return dateList;
	}
	
	//interprets the array of lines from file 
	public static ArrayList<Student> display(ArrayList<String> line) 
	{
		//creates new array list every time it is called FIX!!!!!!!!
		ArrayList<Student> studentList = new ArrayList<Student>();
		for(int i = 0; i < line.size(); i++) {
			studentList.add(processStudentRecord(line.get(i)));
			System.out.println(studentList.get(i).toString() + "\n");
		}
		return studentList;
	}
	
	//this is used to update the file instead of editing it it rewrites the whole thing
	public static void rewriteFile(ArrayList<String> line) 
	{
		try {
			FileWriter writer = new FileWriter(text.getPath());
			for(int i = 0; i < line.size(); i++) {
				writer.write(line.get(i) + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//not implemented
	public static void addStudentToFile(ArrayList<String> l, String first, String last, String num) //note no absences because a new student can't have absences
	{
		l.add(last + "," + first +"@" + num +"@@0");
		java.util.Collections.sort(l);
		rewriteFile(l);
		display(l);
	}	
	
	//not implemented
	public static ArrayList<String> addAbsence(ArrayList<String> l, Student s, String date) //adds to end because time can't go backwards
	{

		for(int i = 0; i < l.size(); i++) {
			if(l.get(i).indexOf(s.getfullName())>=0) {
				String line = l.get(i);
				int x = line.indexOf("@");
		        
		        String n = line.substring(0,x);
		        line = line.substring(x+1);

		        x = line.indexOf("@");
		        String id = line.substring(0,x);
		        line = line.substring(x+1);
		       
		        x=line.indexOf("@");
		        String dates = line.substring(0,x);
		        
		        line = line.substring(x+1);
		        int absences = Integer.parseInt(line) + 1;
		        
		        l.remove(i);
		        l.add(i, n +"@"+ id +"@"+ dates +","+ date +"@"+ absences);
			}
		}
		
		java.util.Collections.sort(l);
		rewriteFile(l);
		display(l);
		return l;
	} 
		
}