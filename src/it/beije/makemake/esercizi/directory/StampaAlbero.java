package it.beije.makemake.esercizi.directory;

import java.io.File;

public class StampaAlbero {
	public static void main(String[] args) {
		File f = new File ("C:\\temp");
		
		stampaContenuto(f);
			
	}
 
public static void stampaContenuto(File f) {
	
	String[] nomi = f.list();
//	int conta=0;
//	int sub=0;
	
	for (int i = 0; i < nomi.length; i++) {
		
		if ( new File(f.getPath() + "\\" + nomi[i]).isDirectory()) {
//			while(conta!=sub) { 
//				System.out.print("\t");
//				
//				conta++;
//			}
				System.out.println( nomi[i]+ "(Dir)");
				System.out.print("\t");
				
				String percorso = f.getPath() + "\\" + nomi[i];
				
				stampaContenuto(new File(percorso));
				
			
			
		}else {
//			while(spazio > 0)
//				System.out.println("   ");
			System.out.println(nomi[i]);
			
		}
			
}
//sub++;
}
}