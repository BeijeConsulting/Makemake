package it.andrea.esercitazione.directory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DirectoryManager {
	public static final String path = "C:/Users/Padawan10/git/Makemake/src";
	public static final String destPath = "C:/Users/Padawan10/Desktop/tree.txt";

	public static void printTree(File file, String indent, File destFile) throws Exception {
		FileWriter fileWriter = new FileWriter(destFile, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.append(indent + file.getName() + "\n");
		bufferedWriter.flush();
		if (file.isDirectory()) {
			for (File currentFile : file.listFiles()) {
				printTree(currentFile, indent + "\t", destFile);
			}
		}
		bufferedWriter.close();
	}

	public static void printTree(File file, File destFile) throws Exception {
		FileWriter fileWriter = new FileWriter(destFile);
		printTree(file, "", destFile);
	}

	public static void main(String[] args) throws Exception {
		File file = new File(path);
		File destFile = new File(destPath);
		printTree(file, destFile);
	}
}
