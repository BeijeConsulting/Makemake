package samuele.affuso.esDirectory;

import java.io.File;

public class StampaContenutoDirectory {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\Padawan07\\Desktop\\rubrica");

		mostraContenuto(f);
	}

	public static void mostraContenuto(File f) {
		File[] nomi = f.listFiles();
		

		for (int i = 0; i < nomi.length; i++) {
			
			if (nomi[i].isDirectory()) {

				System.out.println(nomi[i].getName() + "(dir)");
				mostraContenuto(nomi[i]);

			} else
				
				System.out.println(nomi[i].getName());

		}

	}
}
