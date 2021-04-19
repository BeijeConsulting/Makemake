package excsvfile;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import it.beije.makemake.rubrica.Contatto;

public class CaricoCont {
	public static void main(String[] args) throws Exception {
		//definisco la lista contatti e il file Rubrica e il nuovo contatto
		List<Contatto> contatti = new ArrayList<Contatto>();
		String pathFile = new String("C:\\Users\\Padawan13\\Desktop\\rubrica1.csv");	
		Contatto nuovo = new Contatto("Andrea", "Zippo", "2835579", "bfybu@cazzi.com");
		//aggiungo il nuovo contatto
		contatti.add(nuovo);
		appendInRubrica(contatti, pathFile);
		
		File f = new File("C:\\Users\\Padawan13\\Desktop\\rubrica1.csv");
		System.out.println("-------------------\n");
		
		FileReader fileReader = new FileReader(f);
		int c = fileReader.read();
		while (c >= 0) {
			System.out.print((char) c);
			c = fileReader.read();
		}
	}
	

	public static void appendInRubrica(List<Contatto> contatti, String pathFile) throws Exception {
		FileWriter writer = new FileWriter(new File(pathFile), true);
		for (Contatto contatto : contatti) {
				writer.write(contatto.getCognome());
				writer.write(';');
				writer.write(contatto.getNome());
				writer.write(';');
				writer.write(contatto.getTelefono());
				writer.write(';');
				writer.write(contatto.getEmail());
				writer.write('\n');
		}
			
			writer.flush();
			writer.close();
		}

}
