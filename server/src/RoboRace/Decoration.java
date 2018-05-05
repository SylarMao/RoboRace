package RoboRace;

import COSC3P40.xml.*;

public interface Decoration extends XMLObject {
	
	void effect(EventCounter counter, EventList events, int phase, Robot robot, Board board);
	
}