package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class LogWriter implements notifyNewMessage{
	
	BufferedReader in;
	BufferedWriter out;
	FileReader fileReader;
	FileWriter fileWriter;

	@Override
	public void NewMessage(String userName, String message) {
		// TODO Auto-generated method stub
		
	}
}
