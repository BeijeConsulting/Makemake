package percorsoFile;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class PercorsoFile {
	
	    private static final String SPACES = "     ";
	    private static void printDirectory(String path, StringBuilder sb, int level) {
	        File file = new File(path);
	        File[] contents = file.listFiles();
	        for (File f :
	                contents) {
	            for (int i = 0; i < level; i++) {
	                sb.append(SPACES);
	            }
	            sb.append(f.getName());
	            sb.append("\n");
	            if (f.isDirectory())
	                printDirectory(f.getPath(), sb, level+1);
	        }
	    }
	    public static void printDirectory(String path) throws IOException {
	        StringBuilder sb = new StringBuilder();
	        printDirectory(path, sb, 0);
	        String outputPath = path + ".txt";
	        FileWriter fileWriter = new FileWriter(outputPath);
	        fileWriter.write(sb.toString());
	        fileWriter.close();
	    }
	    public static void main(String[] args) throws IOException {
	        printDirectory("C:\\Users\\jacopo\\Desktop\\laurea");
	    }
	}





