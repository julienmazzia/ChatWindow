package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientsPool implements notifyUserChange{
	Thread t3;

	@Override
	public void CreateNewUser(String userName, Socket socket) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			t3 = new Thread(new ClientThread(userName, socket, in, out));
			t3.run();
	        } catch (IOException e) {
	            System.err.println(userName + "C'est déconnecté ");
	        }
		
	}
}
