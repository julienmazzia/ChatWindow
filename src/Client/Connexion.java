package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connexion extends Thread{
	private Socket socket;
	private Thread t2;
	private PrintWriter out = null;
    private BufferedReader in = null;
	private Scanner sc = null;
	private String login;
	
	public Connexion(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		try {
			out = new PrintWriter(socket.getOutputStream());
	        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    
	        sc = new Scanner(System.in);
	        
	        System.out.println("Tapez votre pseudo : ");
	        login = sc.nextLine();
	        sendMessage(login);
	        
	        t2 = new Thread(new CommunicationThread(out, in));
	        t2.start();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message){
		out.println(message);
        out.flush();
	}
}
