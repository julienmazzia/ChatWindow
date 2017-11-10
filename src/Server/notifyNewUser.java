package Server;

import java.net.Socket;

public interface notifyNewUser {
	public void NewUser(String userName, Socket socket);
}
