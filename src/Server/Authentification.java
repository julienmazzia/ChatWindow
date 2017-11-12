package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Authentification extends Thread{
	private BufferedReader in;
	private PrintWriter out;
	private notifyNewUser notify = new ServerSocketListener();
	private Socket socket;
	private String login;
	private boolean getLogin=false;
	
	public Authentification(Socket socket) {
		this.socket = socket;
	}

	public void run(){
		try {
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            login = in.readLine();
            
            if(login.indexOf("Lost")==0){
            	System.out.println("connexion lost");
            	return;
            }
            
            out.println("Welcome " + login + " !");
            out.flush();
            //UserList.addUser(login);
            notify.NewUser(login, socket);
            
        } catch (IOException e) {
            
            System.err.println(login+" no answer");
        }
	}
}
