package Server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Singleton {
	private static Singleton SINGLETON = new Singleton();
	private static File file = new File("log.txt");
	private static FileWriter fileWriter;
	
	private Singleton(){
		
	}
	
	public static synchronized Singleton getInstance(){
		if(SINGLETON == null){
			SINGLETON = new Singleton();
		}
		return SINGLETON;
	}
	
	protected void createFile() throws IOException{
		
		if (!file.exists()){
			System.out.println("create");
			file.createNewFile(); 
	      }
		if(fileWriter==null){
			fileWriter = new FileWriter(file);
		}
	}
	
	protected void writeData(String data) throws IOException{
		fileWriter.write(data);
		fileWriter.flush();
	}
}
