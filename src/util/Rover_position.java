package util;
/**
 * 
 * @author AashayWaghmare
 * Rover_position provides basic data struct for rover.
 */
public class Rover_position {
	static  int initial_x;
	static int initial_y;
	int x;
	int y;
	char face;
	String command;
	public static int getInitial_x() {
		return initial_x;
	}
	public static void setInitial_x(int initial_x) {
		Rover_position.initial_x = initial_x;
	}
	public static int getInitial_y() {
		return initial_y;
	}
	public static void setInitial_y(int initial_y) {
		Rover_position.initial_y = initial_y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		if(x>=0 && x<=initial_x)
		this.x = x;
		else
		{
			System.err.println("x position is out of platue ");
			System.exit(1);
		}
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		if(y>=0 && y<=initial_y)
		this.y = y;
		else
		{
			System.err.println("y position is out of platue ");
			System.exit(1);
		}
	}
	public char getFace() {
		return face;
	}
	public void setFace(char face) {
		if(!(face=='N'||face=='S'||face=='W'||face=='E'))
		{
			System.err.println("Enter sides with only N/S/E/W letters");
			System.exit(1);
		}
		this.face = face;
	}
	@Override
	public String toString() {
		return "Rover_position [x=" + x + ", y=" + y + ", face=" + face
				+ ", command=" + command + "]";
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		for(int i=0;i<command.length();i++)
		{
			char c=command.charAt(i);
			if(!(c=='R'||c=='M'||c=='L'))
			{
				System.err.println("Enter command with only M/R/L letters");
				System.exit(1);
			}
		}
		this.command = command;
	}
	

}
