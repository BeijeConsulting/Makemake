package it.andrea.esercitazione.interstratte.pokemon;

import java.util.Random;

import it.andrea.esercitazione.interstratte.NonEvolvibile;
import it.andrea.esercitazione.interstratte.Pokemon;
import it.andrea.esercitazione.interstratte.tipo.Acqua;
import it.andrea.esercitazione.interstratte.tipo.Normale;

public class Lapras extends NonEvolvibile implements Acqua, Normale {
	
	public Lapras(String nome, int maxHP, int attacco) {
		this.nome = nome;
		this.maxHP = maxHP;
		this.hp = maxHP;
		this.attacco = attacco;
	}

	@Override
	public void attacca(Pokemon pokemon) {
		switch (new Random().nextInt(3)) {
		case 0:
			this.idropompa(this.attacco, pokemon);
			System.out.println(this.nome + " usa idropompa!");
			break;
		case 1:
			this.azione(this.attacco, pokemon);
			System.out.println(this.nome + " usa azione!");
			break;
		case 2:
			this.ripresa(this);
			System.out.println(this.nome + " usa ripresa!");
			break;
		}
	}
}
