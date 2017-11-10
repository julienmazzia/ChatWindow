package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private static Socket socket;

	public static void main(String[] args) {
		try {
			socket = new Socket("127.0.0.1",2009);
			Thread t1 = new Thread(new Connexion(socket));
		} catch (UnknownHostException e) {
			System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
