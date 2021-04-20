package it.beije.makemake.terzaSettimana.lunedi;
import it.beije.makemake.rubrica.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Manager {
	public static void main(String[] arg) throws Exception{
		File file = new File("C:/Users/Padawan11/Desktop/rubrica1.csv");
		
		if( !(file.exists() || file.isFile()))
				System.out.println("Hai cannato qualcosa");
		
		//1 METODO PER LEGGERE DA FILE
		FileReader fileReader = new FileReader(file);
		
		int c = fileReader.read();
		
		while(c >= 0) {
			System.out.print((char) c);
			c = fileReader.read();
		}
		fileReader.close();
		System.out.println("-----------------------------");
		
		//2 METODO 
		fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		while(bufferedReader.ready()) {
			System.out.println(bufferedReader.readLine());
		}
		bufferedReader.close();
		
		System.out.println("--------------------------------");
		
		//COME SEMPARARE I VALORI DELLE RIGHE IN INGRESSO

		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<>();
		
		while(bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			String values[] = line.split(";");
			contatti.add(new Contatto(values[0], values[1], values[2], values[3]));
		}
		bufferedReader.close();
		
//		FileWriter fileWriter = new FileWriter(file, true);
//		fileWriter.write("\n");
//		for(Contatto cont : contatti) {
//			fileWriter.write(cont.getNome()+";"+cont.getCognome()+";"
//							+cont.getTelefono()+";"+cont.getEmail()+";\n");
//		}
//		fileWriter.close();
		
		contatti = convertRubricaToList(file);
		
		searchForDuplicates((ArrayList<Contatto>)contatti);
		
		
	}
	
	public static ArrayList<Contatto> convertRubricaToList(File file) throws Exception{
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Contatto> contatti = new ArrayList<>();
		
		while(bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			String values[] = line.split(";");
			contatti.add(new Contatto(values[0], values[1], values[2], values[3]));
		}
		bufferedReader.close();
		
		return contatti;
	}
	
	public static void searchForDuplicates(ArrayList<Contatto> list) {
		
		for(int i = 0; i< list.size(); i++) {
			for(int j= i+1; j <list.size(); j++ )
				if(list.get(i).equals(list.get(j)))
					System.out.println("Duplicato trovato : "+list.get(i).toString());
		}
	}

	public static void orderRubricaNome(File file) {
		ArrayList<Contatto> contatti = convertRubricaToList(file);
		
		ArrayList<String> nomi = 
	}
}
