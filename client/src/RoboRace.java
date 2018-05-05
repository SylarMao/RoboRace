import RoboRace.*;
import javax.swing.*;
import COSC3P40.graphics.*;
import COSC3P40.xml.*;
import java.net.Socket;
import javax.sound.sampled.AudioFormat;

public class RoboRace {
    
    public static void main(String[] args) {
    	JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
	    ImageManager.getInstance().setImagePath("./Images/");
	    XMLReader.setXMLPath("./");
	    XMLReader.setXSDPath("./XSD/");
        NetworkPort port;
        String name = GameDialogs.showInputDialog("Your Name Please","Please enter your name: ");
        Socket socket;
        try
        {
            socket = new Socket("192.168.1.127",10997);
            port = new NetworkPort(socket);
            port.send(name);
            new Player(name,port);
            PlaySound playSound= new PlaySound(new AudioFormat(8000,8,1,false,false));
            playSound.playBGM();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }	   
}
