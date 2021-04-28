package excsvfile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import it.beije.makemake.rubrica.Contatto;

public class AlphaOrder {
	public static void main(String[] args) throws Exception {
		
		//definisco la lista contatti e il file Rubrica e il nuovo contatto
		
				List<Contatto> contatti = new ArrayList<Contatto>();
				String pathFile = new String("C:\\Users\\Padawan13\\Desktop\\rubrica1.csv");	
				
				// Salvo in un arrayList il contenuto della rubrica;
				BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
				while (bufferedReader.ready()) {
					String row = bufferedReader.readLine();
					String[] rowParts = row.split(";");
					Contatto contatto = new Contatto();
					contatto.setNome(rowParts[0]);
					contatto.setCognome(rowParts[1]);
					contatto.setTelefono(rowParts[2]);
					contatto.setEmail(rowParts[3]);
					contatti.add(contatto);
					System.out.println("nome : " + rowParts[0]);
					System.out.println("cognome : " + rowParts[1]);
					System.out.println("telefono : " + rowParts[2]);
					System.out.println("email : " + rowParts[3]);
					System.out.println("---------");
				}
				
				String[] names = new String[contatti.size()];
				String[] surnames = new String[contatti.size()];
				
				//estraggo nomi e cognomi
				names = nameextr(contatti, names);
				surnames = surnameextr(contatti, surnames);
				
				// Ordino gli array di stringhe;
				Arrays.sort(names);
				Arrays.sort(surnames);
				
				//ordino per nome
				appendInRubricacres(contatti, pathFile, names);
				appendInRubricacres(contatti, pathFile, surnames);
				
				//Stampo il contenuto del file in lettura
				System.out.println("-------------------\n");
				File f = new File("C:\\Users\\Padawan13\\Desktop\\rubrica1.csv");
				FileReader fileReader = new FileReader(f);
				int c = fileReader.read();
				while (c >= 0) {
					System.out.print((char) c);
					c = fileReader.read();
				}				
	}
			
	//  estrazione del nome
	public static String[] nameextr(List<Contatto> contatti, String[] names) {
		int i=0;
		for (Contatto contatto : contatti) {		
			names[i] = contatto.getNome();
			i++;
		}
		return names;
	}
	
	// estrazione del cognome
	public static String[] surnameextr(List<Contatto> contatti, String[] surnames) {
			int i=0;
			for (Contatto contatto : contatti) {		
				surnames[i] = contatto.getCognome();
				i++;
		}
		return surnames;		
	}
				
// Scrivo in sul file in base all'ordine dato!!
public static void appendInRubricacres(List<Contatto> contatti, String pathFile, String[] str_cntrl) throws Exception {
	FileWriter writer = new FileWriter(new File(pathFile), true);
	for (int i=0; i<str_cntrl.length; i++){
		for (Contatto contatto : contatti){
			if (str_cntrl[i].equals(contatto.getNome()) || str_cntrl[i].equals(contatto.getCognome())){
			writer.write(contatto.getCognome());
			writer.write(';');
			writer.write(contatto.getNome());
			writer.write(';');
			writer.write(contatto.getTelefono());
			writer.write(';');
			writer.write(contatto.getEmail());
			writer.write('\n');
			}
		}
	}
	
	writer.flush();
	writer.close();
}
}

