package it.beije.makemake.cicliUtil;

public class Cancelletti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len = 6;
		for(int i=0; i<=6; i++) {
			for(int j=len-i; j>0; j--) {
				System.out.print("#");
			}
			//len--;
			System.out.println();
		}
	}
}
