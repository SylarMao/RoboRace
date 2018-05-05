package RoboRace;

import java.awt.Point;
import java.io.File;


public class BumpEvent extends GameEvent {
	
	private Direction direction;
	
	public BumpEvent(EventCounter counter, int x, int y, Direction direction) {
		super(counter,x,y);
		this.direction = direction;
	}
	
	public BumpEvent(EventCounter counter, Point p, Direction direction) {
		this(counter,p.x,p.y,direction);
	}
	
	public void execute(Board board) 
        {
            PlaySound.playBump();
	}
	
	public String toXMLString() {
		return "<bump " + attrXMLString() + " direction=\"" + direction + "\"/>";
	}
	
}