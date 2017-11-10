package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CommunicationThread extends Thread{
	private PrintWriter out;
	private BufferedReader in;
	private Scanner sc = null;
	private String message;
	
	public CommunicationThread(PrintWriter out, BufferedReader in){
		this.out = out;
		this.in = in;
	}
	
	public void run(){
		while(true){
            try {
                
            message = in.readLine();
            System.out.println("Le serveur vous dit :" +message);
            
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
