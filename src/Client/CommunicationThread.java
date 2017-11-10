package Client;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CommunicationThread extends Thread{
	private PrintWriter out;
	private BufferedReader in;
	private Scanner sc = null;
	private String message;
	private String[] Users;
	
	public CommunicationThread(PrintWriter out, BufferedReader in){
		this.out = out;
		this.in = in;
		Thread t4 = new Thread(new consoleListener(this));
		t4.start();
	}
	
	public void run(){
		while(true){
            try {
                
            message = in.readLine();
            
            System.out.println("Message : " + message);
            
            if(message.indexOf("Users")==0){
            	Users = message.split(";");
            }
            
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }
        
	}
	
	public void sendMessage(String message){
		out.println(message);
        out.flush();
		
	}
}
