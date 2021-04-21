package it.andrea.esercitazione.interstratte;

import it.andrea.esercitazione.interstratte.pokemon.Lapras;
import it.andrea.esercitazione.interstratte.pokemon.Pichu;
import it.andrea.esercitazione.interstratte.pokemon.Pikachu;

public class Battle {
	public static void battaglia(Pokemon pokeA, Pokemon pokeB) {
		while (pokeA.hp > 0 && pokeB.hp > 0) {
			pokeA.attacca(pokeB);
			pokeB.attacca(pokeA);
			System.out.println(pokeA.nome + " ha " + pokeA.hp + " rimanenti");
			System.out.println(pokeB.nome + " ha " + pokeB.hp + " rimanenti");
		}
		if (pokeA.hp <= 0) {
			System.out.println("Ha vinto " + pokeB.nome);
		} else {
			System.out.println("Ha vinto " + pokeA.nome);
		}
	}

	public static void main(String[] args) {
		Pichu pichu = new Pichu("Franco", 100, 20);
		System.out.println(pichu);
		Pikachu pikachu = (Pikachu)pichu.evolvi();
		System.out.println(pikachu);
		Lapras lapras = new Lapras("Gianni", 150, 35);
		System.out.println(lapras);
		battaglia(pikachu, lapras);
	}

}
