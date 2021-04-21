package it.beije.makemake.interstratte.pokemon;
import java.util.Random;

import it.beije.makemake.interstratte.Evolvibile;
import it.beije.makemake.interstratte.Pokemon;
import it.beije.makemake.interstratte.tipo.Elettro;
import it.beije.makemake.interstratte.tipo.Normale;

public class Pichu extends Evolvibile implements Elettro, Normale {
	public Pichu() {

	}

	public Pichu(String nome, int maxHP, int attacco) {
		this.nome = nome;
		this.maxHP = maxHP;
		this.hp = maxHP;
		this.attacco = attacco;
	}

	@Override
	public Pokemon evolvi() {
		this.setEvoluzione(new Pikachu(this));
		return this.getEvoluzione();
	}

	@Override
	public void attacca(Pokemon pokemon) {
		switch (new Random().nextInt(3)) {
		case 0:
			this.fulmine(this.attacco, pokemon);
			System.out.println(this.nome + " usa fulmine!");
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
