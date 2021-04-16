package it.beije.makemake;

public class TriangleRet {
	public static void main(String[] args) {		
		char ch = '*';
		char[][] point = new char[10][10];
		
		for (int i=0; i<point.length; i++) {
			for(int j=0; j<point[i].length; j++)
			point[i][j-i] = ch;
		}
		System.out.println("Triangolo Rettangolo: "+point);
	}
}

//Problema da correggere??
