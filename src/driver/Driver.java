package driver;
import java.util.List;



import display.Display_Output;
import util.IParseInput;
import util.Rover_position;
import input.Parse_Input;
/**
 * 
 * @author AashayWaghmare
 * Driver class has main function which takes input file name and provide for further process.
 * 
 */
public class Driver {

	public static void main(String[] args) {
		
		
	IParseInput input=new  Parse_Input(args[0]);
	List<Rover_position>inputs=	input.GetPositions();
	
	Display_Output dis=new Display_Output(inputs);
	dis.Display();	
	}

}
