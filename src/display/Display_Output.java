package display;

import java.util.List;

import rover.Rover;
import util.Rover_position;
/**
 * 
 * @author AashayWaghmare
 * This class displays final postion of rover
 */
public class Display_Output {
	private List<Rover_position>inputs;

	public Display_Output(List<Rover_position> inputs) {

		this.inputs = inputs;
	}


	public void Display()
	{


		for(Rover_position obj:inputs)
		{
			
			Rover r=new Rover(obj.getX(),obj.getY(),obj.getFace());	
		
			String command=obj.getCommand();
			int len=command.length();
			char cmd;
			for(int i=0;i<len;i++)
			{
				cmd=command.charAt(i);
				
				switch(cmd)
				{
				case 'L':
					r.turnleft();
					
					break;
				case 'R':
					
					r.turnright();
					
					break;
				case 'M':
					
					r.move();
					
					
					break;


				}
				

			}
			
			
			System.out.println(r.getCurr_x()+""+""+r.getCurr_y()+""+r.getCurr_face());
			

		}



	}



}
