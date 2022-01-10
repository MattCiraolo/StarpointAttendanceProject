import java.util.ArrayList;

public class Student {
	//dont make static
	private  String id;
	private  String firstName;
	private  String lastName;
	private  ArrayList<String> dates = new ArrayList<String>();
	private  int numAbsences;
	
	public Student(String i, String l, String f, ArrayList<String> d,int numAb) 
	{
		id=i;
		firstName = f;
		lastName = l;
		dates = d;
		numAbsences = numAb;
	}

	@Override
	public String toString()
	{
		String str =  "ID: "+id+"\n"+lastName+", "+firstName+ "\nAbsences: "+numAbsences+"\n"+ "Dates Absent: "; //last, first
		//String str =  "ID: "+id+"\n"+firstName+" "+lastName+ "\nAbsences: "+numAbsences+"\n"+ "Dates Absent: "; //first last
		for (String x: dates )
			str += x + "\t";
		
		return str;
	}
	
	public String getFirst() {
		return firstName;
	}
	public String getLast() {
		return lastName;
	}
	public String getfullName() {
		return lastName +","+ firstName;
	}
	public int getNumAbs() {
		return numAbsences;
	}
}