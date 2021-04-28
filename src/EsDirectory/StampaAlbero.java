package EsDirectory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class StampaAlbero {
	public static void main(String[] args) {
		String riga;

		String percorsoFile = "C:\\Users\\Padawan05\\Desktop\\FileJava\\testEsercizio";
		String fileDaLeggere = "";
		String fileDaScrivere = "";
		try {

			// BufferedReader lettore = new BufferedReader(new FileReader(percorsoFile +
			// fileDaLeggere));
			// PrintStream scrittore = new PrintStream(new FileOutputStream(percorsoFile +
			// fileDaScrivere));

			System.out.println(Albero(percorsoFile));
			System.out.println("fatto");
			// chiusura
			// lettore.close();
			// scrittore.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String Albero(String percorso) {

		File f = new File(percorso);
		String albero = "";
		File[] lista = f.listFiles();

		for (int i = 0; i < lista.length; i++) {

			if (lista[i].isDirectory()) {

				albero += "\t" + lista[i].getName() + " (Dir) \n";

				albero +="\t\t"+ Albero(lista[i].getPath());
				

			} else if (lista[i].isFile()) {

				albero += "\t" + lista[i].getName()+"\n";

			}
		}
		
		return albero;
	}
}
