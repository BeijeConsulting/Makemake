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
			// chiusura
			// lettore.close();
			// scrittore.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String Albero(String percorso) {

		System.out.println("metodo");
		File f = new File(percorso);
		String albero = "";
		String[] lista = f.list();
		
		for (int i = 0; i < lista.length; i++) {
			System.out.println("for");
			System.out.println(f.getPath());
			System.out.println(lista[i]);
			if (new File(f.getPath() + "\\" + lista[i]).isDirectory()) {
				System.out.println("kladlbjcdjbkad");
				String[] nome = lista[i].split("\\");
				albero += "\t" + nome[nome.length - 1] + " (Dir) \n";
				System.out.println(nome[nome.length - 1]);
				albero += Albero(f.getPath() + "\\" + lista[i]);

			} else if (new File(f.getPath() + "\\" + lista[i]).isFile()) {

				
				//albero += "\t\t" + nome[nome.length - 1];
			}
		}

		return albero;
	}
}
