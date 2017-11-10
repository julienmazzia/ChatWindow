package Server;

import java.util.List;

public class UserList {
	static List<String> usersList;
	
	public static void addUser(String userName){
		usersList.add(userName);
	}
	
	public static void removeUser(String userName){
		usersList.remove(userName);
	}
	
	public static List<String> getUsersList(){
		return usersList;
	}
}
