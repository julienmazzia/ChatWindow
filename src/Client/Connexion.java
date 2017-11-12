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
	private String login;
	private LoginWindow win;
	
	public Connexion(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		try {
			out = new PrintWriter(socket.getOutputStream());
	        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    
			win = new LoginWindow(this);
			win.setVisible(true);
	        
	        /*System.out.println("Tapez votre pseudo : ");
	        login = sc.nextLine();
	        sendMessage(login);*/
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message){
		if(message.indexOf("Lost")==0){
        	System.out.println("connexion lost");
        	return;
        }
		this.login = message;
		out.println(message);
        out.flush();
        createCom();
	}
	
	public void createCom(){
		win.setVisible(false);
		t2 = new Thread(new CommunicationThread(out, in, login));
        t2.start();
	}
}
