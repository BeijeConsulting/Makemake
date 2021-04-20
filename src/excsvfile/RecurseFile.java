package excsvfile;
import java.io.*;

public class RecurseFile {
		
		/* È possibile utilizzare File#isDirectory()per verificare se il file (percorso) 
		 * specificato è una directory. In questo caso true, 
		 * basta chiamare nuovamente lo stesso metodo con il relativo
		 *  File#listFiles()risultato. Questo si chiama ricorsione. */

	public static void main(String... args) {
	    File[] files = new File("C:\\Users\\Padawan13\\Desktop\\Trial").listFiles();
	    showFiles(files);
	}

	public static void showFiles(File[] files) {
	    for (File file : files) {
	        if (file.isDirectory()) {
	            System.out.println("Directory: " + file.getName());      
	            showFiles(file.listFiles()); // Calls same method again.
	        } else {
	            System.out.println("File: " + file.getName());
	        }
	    }
	}
}