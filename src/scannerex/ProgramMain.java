package scannerex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.makemake.rubrica.Contatto;

public class ProgramMain {

	public static void main(String[] args) throws Exception{
		Scanner x = new Scanner(System.in);
		boolean exit_pool = true;
	CICLO: while(exit_pool) {		
		System.out.println("Benvenuto!"
				+ " Scegli un file rubrica che vuoi modificare e/o creare: ");
		
		File f = new File(x.nextLine());
		if(f.exists() == false) {
			System.out.println("Il file selezionato è inesistente,"
					+ " vuoi crearne un altro? Y/N");
			if(x.nextLine().equals("Y")) {
				//creo nuovo file;
				FileWriter fileWriter = new FileWriter(f);
				fileWriter.append("");
				fileWriter.flush();
				fileWriter.close();
			}
			else {
				exit_pool = false;
				System.out.println("Che c**** mi hai chiamato a fare?");
				break CICLO;
			}
		}
		System.out.println("Scegli un'opzione dal nostro menù "
				+ "o digita 'fanculo' per uscire");
		System.out.println("-----------Menù----------");
		System.out.println("Digita '1' per aggiungere un nuovo contatto");
		System.out.println("Digita '2' per rimuovere un contatto       ");
		System.out.println("Digita '3' per fare che c**** ti pare      ");
		System.out.println("Digita 'exit' per uscire                   ");
			
		switch(x.nextLine()) {
		
		case "1":
			System.out.println("Così hai scelto MORTE! (cit. Saruman)");
			
			Contatto nuovo = new Contatto();
			System.out.println("Inserisci Cognome");
			nuovo.setCognome(x.nextLine());
			System.out.println("Inserisci Nome");
			nuovo.setNome(x.nextLine());
			System.out.println("Inserisci Telefono");
			nuovo.setTelefono(x.nextLine());
			System.out.println("Inserisci Email");
			nuovo.setEmail(x.nextLine());
			
			boolean ext = search4Duple(nuovo, f);
			if(ext) {
				System.out.println("Il contatto è gia presente, "
						+ "vuoi sovrascriverlo? y/n");
				if(x.next().equals("y")) {				
					sovrascrivi(nuovo, f);
				}
				else 			appendInRubrica(nuovo, f);
			
			}
			exit_pool = false;
			break;
			
		case "2":
			System.out.println("Uno stregone non è mai in ritardo nè in"
					+ "anticipo! (cit Gandalf)");
			
			System.out.println("Inserisci Nome e Cognome del contatto da eliminare:");
			Scanner src1 = new Scanner(System.in);
			Scanner src2 = new Scanner(System.in);
			String namessrc = src1.next()+src2.next();
			
			search4Del(namessrc, f);
			break;
		case "exit":
			System.out.println("Uscito!");
			exit_pool = false;
			break;
		}
	}			
}

//appendi in rubrica il nuovo contatto!
	public static void appendInRubrica(Contatto contatto, File pathFile) throws Exception {
		FileWriter writer = new FileWriter(pathFile, true);
		writer.write(contatto.getCognome());
		writer.write(';');
		writer.write(contatto.getNome());
		writer.write(';');
		writer.write(contatto.getTelefono());
		writer.write(';');
		writer.write(contatto.getEmail());
		writer.write('\n');

		writer.flush();
		writer.close();
	}
	
//cerca duplicati
	public static boolean search4Duple(Contatto nuovo, File f) throws Exception{
		boolean flg = false;
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		// Salvo in un arrayList il contenuto della rubrica;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();
			String[] rowParts = row.split(";");
			Contatto contatto = new Contatto();
			contatto.setNome(rowParts[1]);
			contatto.setCognome(rowParts[0]);
			contatto.setTelefono(rowParts[2]);
			contatto.setEmail(rowParts[3]);
			contatti.add(contatto);
			System.out.println("nome : " + rowParts[1]);
			System.out.println("cognome : " + rowParts[0]);
			System.out.println("telefono : " + rowParts[2]);
			System.out.println("email : " + rowParts[3]);
			System.out.println("---------");
		}
		
		String[] names = new String[contatti.size()];
		String nms = new String (nuovo.getCognome()+nuovo.getNome());
		
		//estraggo nomi e cognomi
		names = nameextr(contatti, names);
		
		
		for (int i=0; i<names.length; i++){
				if(names[i].equals(nms)) {
					flg = true;
				}
		}
		
	return flg;	
	}
		
//  estrazione del nome
	public static String[] nameextr(List<Contatto> contatti, String[] names) {
		int i=0;
		for (Contatto contatto : contatti) {		
			names[i] = contatto.getNome()+contatto.getCognome();
			i++;
		}
		return names;
	}

//  sovrascrivi
	public static void sovrascrivi(Contatto nuovo, File f) throws Exception {
		int idx = 0;
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		// Salvo in un arrayList il contenuto della rubrica;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();
			String[] rowParts = row.split(";");
			Contatto contatto = new Contatto();
			contatto.setNome(rowParts[1]);
			contatto.setCognome(rowParts[0]);
			contatto.setTelefono(rowParts[2]);
			contatto.setEmail(rowParts[3]);
			contatti.add(contatto);
			System.out.println("nome : " + rowParts[1]);
			System.out.println("cognome : " + rowParts[0]);
			System.out.println("telefono : " + rowParts[2]);
			System.out.println("email : " + rowParts[3]);
			System.out.println("---------");
		}
		
		String[] names = new String[contatti.size()];
		
		//estraggo nomi e cognomi
		names = nameextr(contatti, names);
		
		for (int i=0; i<names.length; i++) {
			for (int j=i+1; j<names.length; j++) {
				if(names[i].equals(names[j])) {
					idx = i;
				}			
			}
		}
		
		//sostituisco
		contatti.set(idx, nuovo);
	}

// search to delate
	public static void search4Del(String namessrc, File f) throws Exception{
		int idx=0;
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		// Salvo in un arrayList il contenuto della rubrica;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();
			String[] rowParts = row.split(";");
			Contatto contatto = new Contatto();
			contatto.setNome(rowParts[1]);
			contatto.setCognome(rowParts[0]);
			contatto.setTelefono(rowParts[2]);
			contatto.setEmail(rowParts[3]);
			contatti.add(contatto);
			System.out.println("nome : " + rowParts[1]);
			System.out.println("cognome : " + rowParts[0]);
			System.out.println("telefono : " + rowParts[2]);
			System.out.println("email : " + rowParts[3]);
			System.out.println("---------");
		}
		
		String[] names = new String[contatti.size()];
		
		//estraggo nomi e cognomi
		names = nameextr(contatti, names);
		
		for (int i=0; i<names.length; i++) {
				if(names[i].equals(namessrc)) {
					idx = i;
				}			
		}
		
		//elimino
		contatti.remove(idx);	
	}
}

