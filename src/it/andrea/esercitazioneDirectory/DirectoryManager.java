package it.andrea.esercitazioneDirectory;

import java.io.File;

public class DirectoryManager {
	public static final String path = "C:/Users/Padawan10/git/Makemake/src";

	public static void printTree(File file, String indent) {
		System.out.println(indent + file.getName());
		if (file.isDirectory()) {
			for (File currentFile : file.listFiles()) {
				printTree(currentFile, indent + "\t");
			}
		}
	}

	public static void printTree(File file) {
		printTree(file, "");
	}

	public static void main(String[] args) {
		File file = new File(path);
		printTree(file);
	}
}
