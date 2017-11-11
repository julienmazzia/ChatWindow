package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientsPool implements notifyUserChange{
	private Thread t3;
	private String message;
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	public ClientsPool(ServerSocketListener serverS){
		serverS.addObserver(this);
	}
	
	public ClientsPool(){
		
	}

	@Override
	public synchronized void CreateNewUser(String userName, Socket socket) {
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			UserList.addUser(userName);
			UserList.addOut(out);
			System.out.println("Nouveau client "+ userName +" créé");
			t3 = new Thread(new ClientThread(userName, in, out));
			t3.run();
	        } catch (IOException e) {
	            System.err.println(userName + "C'est déconnecté ");
	        }
		
	}
}
