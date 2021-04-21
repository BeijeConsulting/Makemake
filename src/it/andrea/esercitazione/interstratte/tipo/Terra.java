package it.andrea.esercitazione.interstratte.tipo;

import it.andrea.esercitazione.interstratte.Pokemon;

public interface Terra {
	public default void terremoto(int attacco, Pokemon pokemon) {
		if (pokemon instanceof Elettro) {
			pokemon.hp -= attacco * 2;
		} else {
			pokemon.hp -= attacco;
		}
	}
}
