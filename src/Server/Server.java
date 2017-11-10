package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	

	 public static ServerSocket serverSocket = null;
	 public static Thread t;

	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(2009);
            System.out.println("Le serveur est à l'écoute du port "+serverSocket.getLocalPort());
            
            t = new Thread(new LoginThread(serverSocket));
            t.start();
            
        } catch (IOException e) {
        	System.err.println("Le port est déjà utilisé !");
        }

	}

}
