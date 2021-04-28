package it.beije.makemake.db;


public class MySingleton {

	private MySingleton() {}
	
	private static MySingleton instance;
	
	public static MySingleton getInstance() {
		
		if (instance == null) instance = new MySingleton();
		
		return instance;
	}
	
}

