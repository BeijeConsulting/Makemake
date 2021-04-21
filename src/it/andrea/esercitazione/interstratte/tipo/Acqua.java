package it.andrea.esercitazione.interstratte.tipo;

import it.andrea.esercitazione.interstratte.Pokemon;

public interface Acqua {
	public default void idropompa(int attacco, Pokemon pokemon) {
		if (pokemon instanceof Terra) {
			pokemon.hp -= attacco * 2;
		} else {
			pokemon.hp -= attacco;
		}
	}
}
