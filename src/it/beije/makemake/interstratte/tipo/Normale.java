package it.beije.makemake.interstratte.tipo;

import it.beije.makemake.interstratte.Pokemon;

public interface Normale {
	public default void azione(int attacco, Pokemon pokemon) {
		pokemon.hp -= attacco + 5;
	}

	public default void ripresa(Pokemon pokemon) {
		pokemon.hp = (pokemon.hp + 30) < pokemon.maxHP ? pokemon.hp + 30 : pokemon.maxHP;
	}
}
