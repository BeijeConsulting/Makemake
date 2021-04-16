package it.beije.makemake.cicliUtil;

public class Asterischi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len = 0;
		for(int i=1; i<=6; i++) {
			for(int j=0; j<i+len; j++) {
				System.out.print("*");
			}
			len++;
			System.out.println();
		}
	}
}
