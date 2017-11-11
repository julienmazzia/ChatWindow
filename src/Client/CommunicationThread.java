package Client;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class CommunicationThread extends Thread{
	private PrintWriter out;
	private BufferedReader in;
	private Scanner sc = null;
	private String message;
	private String[] users;
	private ClientGUI frame;
	private String userName;
	
	public CommunicationThread(PrintWriter out, BufferedReader in, String userName){
		this.out = out;
		this.in = in;
		this.userName = userName;
		frame = new ClientGUI(this, userName);
		frame.setVisible(true);
		//Thread t4 = new Thread(new consoleListener(this));
		//t4.start();
	}
	
	public void run(){
		while(true){
            try {
                
            message = in.readLine();
            
            if(message.indexOf("Users")==0){
            	users = message.split(":");
            	users = users[1].split(";");
            	int count = 0;
            	for(String user : users){
            		if(userName.equals(user)){
            			users[count]=null;
            		}
            		count++;
            	}
            	frame.FillList(users);
            }else{
            	frame.writeMessage(message);
            }
            
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }
        
	}
	
	public synchronized void sendMessage(String message){
		out.println(message);
        out.flush();
	}
}
