package it.beije.makemake.Try;

import java.util.Arrays;

import java.util.Scanner;
public class ArrayTry {

	public static void main(String[] args) {
		Scanner tastiera=new Scanner(System.in);
		System.out.println("Quanti valori ha il vettore");
		int num=tastiera.nextInt();
		int[] vett= new int [num];
		for(int i=0;i<num;i++) {
			vett[i]=tastiera.nextInt();			
		}
		//for(int i=0;i<vett.length;i++)
			//System.out.println(vett[i]);
		/*int max=myMax(vett);
		System.out.println(max);
		int min=myMin(vett);
		System.out.println(min);
		System.out.println("Che valore intendi cercare nel vettore ");
		int confronto=tastiera.nextInt();	
		boolean ret=contains(confronto,vett);
		boolean ret1=isCrescente(vett);
		System.out.println(ret1);*/
		//int i= mostRecurrent(vett);
		//System.out.println(i);
		//float media=MediaMultipliTre(vett);
		//System.out.println(media);
		StampaZigZag(vett);
	}
	
	
	public static int myMax(int[] vett) {
		int max=0;
		int indice=0;
		for(int i=0;i<vett.length;i++) {
			if(vett[i]>max) {
				max=vett[i];
				indice=i;
			}
		}
		System.out.println("L'indice del massimo e' "+ indice);
		return max;
	}
	
	public static int myMin(int [] vett) {
		int min=100000000;
		int indice=0;
		for(int i=0;i<vett.length;i++) {
			if(vett[i]<min) {
				min=vett[i];
				indice=i;
			}
		}
		System.out.println("L'indice del minimo e' "+ indice);
		return min;
	}
	
	public static boolean contains(int e, int [] vett) {
		boolean ret=false;
		int indice=0;
		for(int i =0; i<vett.length;i++) {
			if(vett[i]==e) {
				ret=true;
				indice=i;
			}
		}
		if(ret==true)
			System.out.println("L'elemento e' presente nel vettore in posizione : "+ indice);
		else
			System.out.println("L'elemento non e' presente nel vettore");
		return ret;
	}
	
	public static boolean isCrescente(int[] vett) {
		boolean ret=true;
		
		for(int i=0;i<vett.length-1;i++) {
			if(vett[i]>vett[i+1])
				ret=false;
		}
		return ret;
	}
	
	public static int mostRecurrent(int [] vett) {
		int max=0;
		int [] tmp=new int[vett.length];
		
		for(int i=0;i<vett.length;i++) {
			for(int j=0;j<vett.length;j++) {
				if(vett[i]==vett[j])
					tmp[i]++;
			}
		}
		return max;
	}
	
	public static float MediaMultipliTre(int[] vett) {
		int somma=0;
		int count=0;
		float media=0.f;
		for(int i=0 ; i<vett.length;i++) {
			if(vett[i] % 3==0) {
				somma+=vett[i];
				count++;
				
			}
		}
		
		media=(somma/count) ;
		return media;
	
	}
	
	public static void StampaZigZag(int[]vett) {
		int max=vett.length;
		for(int i=0;i<(vett.length/2)
				;i++) {
			System.out.println(""+ vett[i] );
			System.out.println("" + vett[max-i-1]);
		}
		
		if(max%2!=0) {
			System.out.println(""+ vett[(max/2)]);
		}
	}
	
	
}
