package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginThread extends Thread{
	private ServerSocket serverSocket;
	private Socket socket;
	private Thread t2;
	
	public LoginThread(ServerSocket serverSocket){
		this.serverSocket = serverSocket;
	}
	
	public void run(){
		try {
            while(true){
                
            socket = serverSocket.accept();
            System.out.println("New client connected");
            
            t2 = new Thread(new Authentification(socket));
            t2.start();
            
            }
        } catch (IOException e) {
            
            System.err.println("Server error");
        }
	}
}