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
	private BufferedReader in;
	private PrintWriter out;
	private String userName;
	private String message;
	private List<String> usersList = new ArrayList<String>();
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	
	public ClientThread(String userName, BufferedReader in, PrintWriter out){
		this.userName = userName;
		this.in = in;
		this.out = out;
	}
	
	public void run(){
		
		while(true){
            try {   
            message = in.readLine();
            sendMessage(message);
            //System.out.println(userName+" : "+message);
            
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }
	}
	
	public void sendMessage(String message){
        Thread sender = new Thread(new Runnable(){
    		public void run(){
    			out.println(userName + " : " + message);
    	        out.flush();
    		}
    	});
        usersList = UserList.getUsersList();
        for(Iterator<String> i = usersList.iterator(); i.hasNext();){
        	String item = i.next();
        	if(item != userName){
            	executor.execute(sender);	
        	}
        }
        
	}
	
	

}
