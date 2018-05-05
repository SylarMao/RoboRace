package RoboRace;

import COSC3P40.xml.*;

public interface Tile extends XMLObject {
	
	void effect(EventCounter counter, EventList events, Robot robot, Board board);
	
}
