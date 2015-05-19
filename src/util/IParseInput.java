package util;

import java.util.List;
/**
 * 
 * @author AashayWaghmare
 * This interface is implemeneted by Parse_inout class to provide list of
 * positions of different rovers.
 * 
 */

public interface IParseInput {
	public List<Rover_position> GetPositions();
}
