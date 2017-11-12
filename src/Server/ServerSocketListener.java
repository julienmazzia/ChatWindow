package Server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServerSocketListener implements notifyNewUser{

	private List<notifyUserChange> list = new ArrayList<notifyUserChange>();
	
	public void addObserver(notifyUserChange obs){
		list.add(obs);
	}

	@Override
	public void NewUser(String userName, Socket socket) {
		LogWriter log = new LogWriter(this);
		ClientsPool client = new ClientsPool(this);
		for(Iterator<notifyUserChange> i = list.iterator(); i.hasNext(); ) {
			notifyUserChange observer = i.next();
			observer.CreateNewUser(userName, socket);
		}
		
	}

}
