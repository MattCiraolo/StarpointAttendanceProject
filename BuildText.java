import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Desktop;

public class BuildText {
	public static void main(String[] args)
	{
		File text = new File("H:/AP Computer Science/APCS 2021-2022/Student Roster March 2022.txt");
		//Desktop.getDesktop().open(new File("c:\\"));
		
		
		ArrayList<String> line=new ArrayList<String>();
		try
		{
			Scanner scnr = new Scanner(text);
			
			String header = scnr.nextLine();  //header line
			
					//Bird,Andy@012239564@02/12/2021,03/14/2021,05/17/2021@3
			
			
			while(scnr.hasNextLine())
			{
				String eschoolTextLine = scnr.nextLine();
				String ID = eschoolTextLine.substring(0,9);
				eschoolTextLine = eschoolTextLine.substring(9).trim();
				String Last = eschoolTextLine.substring(0,eschoolTextLine.indexOf(9));
				eschoolTextLine = eschoolTextLine.substring(eschoolTextLine.indexOf(9)).trim();
				String First = eschoolTextLine.substring(0,eschoolTextLine.indexOf(9));
				line.add(Last+","+First+"@"+ID+"@"+"@"+0);
				
				App a = new App(line);
				a.rewriteFile();
			}
		
			
			scnr.close();
			
		}
		catch(FileNotFoundException e)
		{
			//This would have to be a pop up window later
			System.out.println("file not found");
		}
	}
}

//Bird,Andy@012239564@02/12/2021,03/14/2021,05/17/2021@3
