package it.andrea.esercitazione.interstratte.tipo;

import it.andrea.esercitazione.interstratte.Pokemon;

public interface Normale {
	public default void azione(int attacco, Pokemon pokemon) {
		pokemon.hp -= attacco + 5;
	}

	public default void ripresa(Pokemon pokemon) {
		pokemon.hp = (pokemon.hp + 30) < pokemon.maxHP ? pokemon.hp + 30 : pokemon.maxHP;
	}
}
