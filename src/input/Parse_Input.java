package input;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import util.IFileoperation;
import util.IParseInput;
import util.Rover_position;;
/**
 * 
 * @author AashayWaghmare
 *This class takes input from specified file ,parse it into  Rover_postion object and offers all
 *input validations. 
 */
public class Parse_Input implements IFileoperation,IParseInput{
	String fname;
	BufferedReader br = null;
	List<Rover_position>commands =new ArrayList<Rover_position>();
	public Parse_Input(String fname) {
		this.fname=fname;


	}


	public List<Rover_position> GetPositions()
	{
		OpenFile();
		ReadFile();
		closeFile();

		return commands;
	}


	@Override
	public void OpenFile() {
		// TODO Auto-generated method stub
		try {
			br = new BufferedReader(new FileReader(fname));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Enter proper filename");
			System.exit(1);
		}
	}

	private int check_digit(String str)
	{
		
		
		if (!Character.isDigit(str.charAt(0)))
		{
			return 1;
		}
		

		return 0;
	}
	public void validate(String str[])
	{
		int spl_len=str.length;
		if(!(spl_len==2 ||spl_len==3))
		{
			System.err.println("please enter proper no of positions");
			System.exit(1);
		}
		
		
	}

	@Override
	public void ReadFile() {
		String Line;
		String split_string[];
		boolean flag=true;
		int count=0;
		
		try {
			while ((Line = br.readLine()) != null) {
				//System.out.println(Line);
				split_string=Line.split(" +");
				
				validate(split_string);
				
				
				Rover_position r=new Rover_position();
				//System.out.println(split_string[0]);
				if(flag)
				{
					if(check_digit(split_string[0])!=0)
					{
						System.err.println("Enter proper upper-right X position value");
						System.exit(1);
					}
					else if(check_digit(split_string[1])!=0)
					{
						System.err.println("Enter proper upper-right Y position value");
						System.exit(1);
					}
					
					Rover_position.setInitial_x(Integer.parseInt(split_string[0]));
					Rover_position.setInitial_y(Integer.parseInt(split_string[1]));
					flag=false;
				}
				else
				{
					
					if(check_digit(split_string[0])!=0)
					{
						System.err.println("Enter proper initial X position value");
						System.exit(1);
					}
					else if(check_digit(split_string[1])!=0)
					{
						System.err.println("Enter proper intial Y position value");
						System.exit(1);
					}
					
					r.setX(Integer.parseInt(split_string[0]));
					r.setY(Integer.parseInt(split_string[1]));
				
					if(check_digit(split_string[2])==0)
					{
						System.err.println("Enter  orientation Letter not number!!!");
						System.exit(1);	
					}
					r.setFace(split_string[2].charAt(0));
					if((Line = br.readLine())!= null)
					{
						r.setCommand(Line);
					}
					else
					{
						System.err.println("Please enter directions also!!! ");
						System.exit(1);
					}
					//System.out.println(r);
					commands.add(r);
				//	System.out.println("added "+commands.toString());
					count++;
				}
			

			}
		} catch (IOException e) {
			System.err.println("Error while reading file");
			System.exit(1);
		}
		if(count==0)
		{
			System.err.println("Please also enter rovers postions!!! ");
			System.exit(1);
		}

	}


	@Override
	public void closeFile() {
		// TODO Auto-generated method stub
		try {
			if (br != null)br.close();
		} catch (IOException ex) {
			System.err.println("Error closing file");
			System.exit(1);
		}
	}






}
