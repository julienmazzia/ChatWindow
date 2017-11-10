package Server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSocketListener implements notifyNewUser{

	private List<notifyUserChange> list = new ArrayList<notifyUserChange>();
	
	public void addObserver(notifyUserChange obs){
		list.add(obs);
	}

	@Override
	public void NewUser(String userName, Socket socket) {
		ClientsPool client = new ClientsPool(this);
		for (notifyUserChange observer : list) {
			observer.CreateNewUser(userName, socket);
		}
		
	}

}
