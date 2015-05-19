package rover;

import util.Rover_State;

import util.Rover_position;
/**
 * 
 * @author AashayWaghmare
 * Northface implements Roverstate abstract functions ,this class is state of rover and
 * in that state how basic functions can be done by rover are implemented here.
 */
public class Northface implements Rover_State{
	Rover rov;


	public Northface(Rover rov) {

		this.rov = rov;
	}

	@Override
	public void turn_left() {
		rov.setCurr_face('W');
		Rover_State s=rov.getWestface();
		
		rov.setState(s);
	

	}

	@Override
	public void turn_right() {
		rov.setCurr_face('E');
		Rover_State s=rov.getEastface();
		rov.setState(s);

	}

	@Override
	public void move() {
		
		int y=rov.getCurr_y()+1;
		
		if(y<=Rover_position.getInitial_y())
			rov.setCurr_y(y);
		else
		{
			System.err.println("North:Due to provided directions Rover is going out of plateau");
			System.exit(1);
		}
		
	}

}
