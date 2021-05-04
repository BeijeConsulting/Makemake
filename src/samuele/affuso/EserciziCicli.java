package samuele.affuso;

public class EserciziCicli {

	public static void main(String[] args) {
		//Primi 10 numeri interi
		for(int i = 1; i <= 10; i++)
			System.out.print(i + ", ");
		System.out.println();
		//Primi numeri pari interi al contrario fino a 20 
		for(int i = 20; i >= 2; i-=2)
			System.out.print(i + ", ");
		//tabelline
		System.out.println();
		System.out.println("stampa tabellina");
		tabellina(2);
		
		System.out.println();

		
		
		//asterisci decrescenti
		System.out.println();

		for(int i = 6;i >= 0;i--) {
			int j=0;
			while(j<i) {
				j++;
				System.out.print("*");}
			System.out.println();
			}
		// cancelletti crescenti
		for(int i = 0;i <= 6;i++) {
			int j=0;
			while(j<i) {
				j++;
				System.out.print("#");}
			System.out.println();
			}
		
		
		
		
		//es6
		stampaFiguraNumeri();
	}
		public static void tabellina(int n) {
			for(int i = 0; i <= 10;i++)
				System.out.print(n*i +", ");
		}
		
		public static void stampaFiguraNumeri() {
		        for (int i = 0; i < 6; i++) {
		            for (int j = 0; j < i + 1; j++) {
		                System.out.print(j+1);
		            }
		            System.out.print("     ");
		            for (int j = 6-i; j >= 1; j--) {
		                System.out.print(j);
		            }
		            System.out.println();
		        }
		    }

}