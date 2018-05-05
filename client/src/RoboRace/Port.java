package RoboRace;

import java.io.Closeable;

public interface Port extends Closeable {
	
	void send(String message);
	
	String recieve() ;
	
}