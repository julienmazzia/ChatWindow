package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientThread extends Thread{
	private notifyNewMessage notify = new LogWriter();
	private BufferedReader in;
	private PrintWriter out;
	private PrintWriter BrodcastOut;
	private String userName;
	private String message="";
	private String address;
	private boolean FirstMessage=true;
	private List<String> usersList = new ArrayList<String>();
    private List<PrintWriter> outList = new ArrayList<PrintWriter>();
	
	
	public ClientThread(String userName, BufferedReader in, PrintWriter out, String address){
		this.userName = userName;
		this.in = in;
		this.out = out;
		this.address = address;
	}
	
	public void run(){
		
		if(FirstMessage){
			FirstMessage = false;
			boolean first = true;
			usersList = UserList.getUsersList();
			for(Iterator<String> i = usersList.iterator(); i.hasNext();){
	        	String item = i.next();
		        	if(first==true){
		        		first=false;
			        	message = message + item;
		        	}else{
		        		message = message + ";" + item;
		        	}
	        }
			sendMessage("Users:" + message);
		}
		
		while(true){
            try {   
            message = in.readLine();
            
            if(message.indexOf("DiscUser")==0){
            	boolean first = true;
            	UserList.removeUser(userName);
            	UserList.removeOut(out);
            	usersList = UserList.getUsersList();
            	
            	message = "Users:";
            	for(Iterator<String> i = usersList.iterator(); i.hasNext();){
    	        	String item = i.next();
    		        	if(first==true){
    		        		first=false;
    			        	message = message + item;
    		        	}else{
    		        		message = message + ";" + item;
    		        	}
    	        }
            	
    			sendMessage(message);
    			String data = userName + " disconnected("+address+")";
    			System.out.println(data);
    			
            	sendMessage(userName + " disconnected");
            	notify.NewMessage(data);
            	
            }else{
            	String data = "Message de " + userName + "(" + address + ")";
                System.out.println(data);
                sendMessage(userName + " : " + message);
            	notify.NewMessage(data);
            	
            }
            
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }
	}
	
	public synchronized void sendMessage(String message){
        usersList = UserList.getUsersList();
        outList = UserList.getOutList();
        for(Iterator<PrintWriter> i = outList.iterator(); i.hasNext();){
        	BrodcastOut = i.next();
        	BrodcastOut.println(message);
			BrodcastOut.flush();
            //executor.execute(sender);
        }
        
        
       
        
	}
	
	

}
