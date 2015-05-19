package rover;
import util.Rover_State;
public class Rover {
	Rover_State northface;
	Rover_State southface;
	Rover_State eastface;
	Rover_State westface;

	Rover_State curr_state;
	int curr_x,curr_y;
	char curr_face;

	public Rover(int x,int y,char face) {

		curr_x=x;
		curr_y=y;
		curr_face=face;
		northface=new Northface(this);
		southface=new Southface(this);
		westface=new Westface(this);
		eastface=new Eastface(this);

		
		if(curr_face=='N')
		{
			curr_state=northface;
			
		}
		else if(curr_face=='S')
		{
			curr_state=southface;
		}

		else if(curr_face=='E')
		{
			curr_state=eastface;
		}
		else if(curr_face=='W')
		{
			curr_state=westface;
		}
		else
		{
			System.err.println("No provieded with proper orientation");
			System.exit(1);
		}


	}
	
	public void turnleft()
	{
		
		curr_state.turn_left();
	}
	
	public void turnright()
	{
		curr_state.turn_right();
	}
	
	public void move()
	{
		
		curr_state.move();
	}
	
	
	
	
	public void setCurr_x(int curr_x) {
		this.curr_x = curr_x;
	}

	public void setCurr_y(int curr_y) {
		this.curr_y = curr_y;
	}

	public void setCurr_face(char curr_face) {
		this.curr_face = curr_face;
	}

	public void setState(Rover_State st)
	{
	
		curr_state=st;
		
	}

	public Rover_State getNorthface() {
		return northface;
	}

	public Rover_State getSouthface() {
		return southface;
	}

	public Rover_State getEastface() {
		return eastface;
	}

	public Rover_State getWestface() {
		return westface;
	}

	public Rover_State getCurr_state() {
		return curr_state;
	}

	public int getCurr_x() {
	
	
		return curr_x;
	}

	public int getCurr_y() {
		return curr_y;
	}

	public char getCurr_face() {
		return curr_face;
	}

}
