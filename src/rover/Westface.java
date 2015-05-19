package rover;

import util.Rover_State;

import util.Rover_position;

/**
 * 
 * @author AashayWaghmare
 * Westface implements Roverstate abstract functions ,this class is state of rover and
 * in that state how basic functions can be done by rover are implemented here.
 */
public class Westface implements Rover_State {

	Rover rov;


	public Westface(Rover rov) {

		this.rov = rov;
	}
	@Override
	public void turn_left() {
		rov.setCurr_face('S');
		Rover_State s=rov.getSouthface();
		rov.setState(s);

		
	}

	@Override
	public void turn_right() {
		rov.setCurr_face('N');
		Rover_State s=rov.getNorthface();
		rov.setState(s);

		
	}

	@Override
	public void move() {
	
		int x=rov.getCurr_x()-1;
	
		if(x>=0)
			rov.setCurr_x(x);
		else
		{
			System.err.println("West:Due to provided directions Rover is going out of plateau");
			System.exit(1);
		}
		
	}

}
