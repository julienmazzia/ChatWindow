package Server;

import java.util.ArrayList;
import java.util.List;

public class UserList {
	private static List<String> usersList = new ArrayList<String>();
	
	public synchronized static void addUser(String userName){
		usersList.add(userName);
	}
	
	public synchronized static void removeUser(String userName){
		usersList.remove(userName);
	}
	
	public synchronized static List<String> getUsersList(){
		return usersList;
	}
}
