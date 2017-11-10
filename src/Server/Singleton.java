package Server;

public class Singleton {
	private static Singleton CONNECTION = new Singleton();
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		return CONNECTION;
	}
}
