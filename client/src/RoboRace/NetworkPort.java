/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoboRace;

import com.sun.security.ntlm.Client;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ym14tm
 */
public class NetworkPort implements Port
{
    static BufferedReader reader;
    static OutputStream outStream;
    private PrintWriter out;
    Client client;
    private BufferedReader in;
    
    public NetworkPort(Socket client) 
    {
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            } catch (IOException ex) {
                //Logger.getLogger(NetworkPort.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public synchronized void send(String name)
    {
        if(out!=null)
        {
            out.println(name);
            out.println("\0");
            out.flush();
        }
    }

    public String recieve() 
    {
        String returnString="";
        try{
        while(true)
        {
            String a=in.readLine();
            if(a.contains("\0"))
            {
                break;
            }
            returnString=returnString+a;
        }}
        catch(Exception e)
        {
            
        }
        return returnString;
    }

    public void close() {
    }    
}
