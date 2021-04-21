package it.andrea.esercitazione.interstratte.tipo;

import it.andrea.esercitazione.interstratte.Pokemon;

public interface Elettro {
	public default void fulmine(int attacco, Pokemon pokemon) {
		if (pokemon instanceof Acqua) {
			pokemon.hp -= attacco * 2;
		} else {
			pokemon.hp -= attacco;
		}
	}

}
