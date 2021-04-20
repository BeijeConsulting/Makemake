package it.beije.makemake.esercizi;

import java.util.ArrayList;

public class Esercizi2 {

	private int counter = 0;

	public void max(int... a) {
		for (int i = 0; i < a.length; i++) {
			if (counter < a[i]) {
				counter = a[i];
				System.out.println("max value:" + counter);
				System.out.println("index of max value:" + i);
			}
		}
	}

	public boolean contains(int e, int... array) {
		ArrayList<Integer> arraylist =new ArrayList<Integer>();
		for(int i=0;i<array.length;i++) {
			if(e==array[i]) {
				arraylist.add(e);
			}
		}
		System.out.println(arraylist);

		return false;
	}

}
