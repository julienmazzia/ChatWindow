package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread{
	private BufferedReader in;
	private PrintWriter out;
	private notifyNewMessage notify;
	private Socket socket;
	private String userName;
	private String message;
	
	
	public ClientThread(String userName, Socket socket, BufferedReader in, PrintWriter out){
		this.socket = socket;
		this.userName = userName;
		this.in = in;
		this.out = out;
	}
	
	public void run(){
		
		
		while(true){
            try {
                
            message = in.readLine();
            System.out.println(userName+" : "+message);
            
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
