package Server;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserList {
	private static List<String> usersList = new ArrayList<String>();
	private static List<PrintWriter> outList = new ArrayList<PrintWriter>();
	
	public synchronized static void addUser(String userName){
		usersList.add(userName);
	}
	
	public synchronized static void removeUser(String userName){
		usersList.remove(userName);
	}
	
	public synchronized static List<String> getUsersList(){
		return usersList;
	}
	
	public synchronized static void addOut(PrintWriter out){
		outList.add(out);
	}
	
	public synchronized static void removeOut(PrintWriter out){
		outList.remove(out);
	}
	
	public synchronized static List<PrintWriter> getOutList(){
		return outList;
	}
}
