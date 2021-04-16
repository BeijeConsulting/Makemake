package it.beije.makemake.cicliUtil;

public class StampaInteriPari {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<=20; i++) {
			if(i%2 == 0) {
				System.out.print(i + " ");
			}
			else
				continue;
		}
	}

}
