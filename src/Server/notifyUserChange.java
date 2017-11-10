package Server;

import java.net.Socket;

public interface notifyUserChange {
	public void CreateNewUser(String userName, Socket socket);
}
