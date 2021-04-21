package it.beije.makemake.interstratte.pokemon;

import java.util.Random;

import it.beije.makemake.interstratte.NonEvolvibile;
import it.beije.makemake.interstratte.Pokemon;
import it.beije.makemake.interstratte.tipo.Acqua;
import it.beije.makemake.interstratte.tipo.Normale;

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
