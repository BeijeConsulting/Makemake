package it.beije.makemake;

public class SetStr2Var {
	
	public static void main(String[] args) {
		
		String s = args[0];
		
		String get_name = new String("get");
		String set_name = new String("set");
		
		get_name = get_name + s.toUpperCase().substring(0,1) + s.substring(1,s.length());
		set_name = set_name + s.toUpperCase().substring(0,1) + s.substring(1,s.length());
		
		System.out.println("GET: "+get_name);
		System.out.println("SET: "+get_name);
	}	
}
