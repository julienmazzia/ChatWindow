package Server;

import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogWriter implements notifyNewMessage, notifyUserChange{
	
	private static Singleton FILE;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private Date date = null;
	
	public LogWriter(ServerSocketListener serverS) {
		serverS.addObserver(this);
		FILE = Singleton.getInstance();
		try {
			FILE.createFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LogWriter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized void NewMessage(String data){
		date = new Date();
		try {
			FILE.writeData(dateFormat.format(date)+"->"+data+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public synchronized void CreateNewUser(String userName, Socket socket) {
		date = new Date();
		try {
			FILE.writeData(dateFormat.format(date)+"-> New connection from " + socket.getInetAddress().getHostAddress() +"("  + userName+ ")\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
