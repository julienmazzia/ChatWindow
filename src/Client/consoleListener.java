package Client;

import java.util.Scanner;

public class consoleListener extends Thread{
	private Scanner sc = null;
	private String message;
	private CommunicationThread ct;
	
	public consoleListener(CommunicationThread ct){
		this.ct = ct;
		sc = new Scanner(System.in);
	}
	
	public void run(){
		while(true){
			message = sc.nextLine();
			ct.sendMessage(message);
			
		}
	}
}
