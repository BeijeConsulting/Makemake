package it.beije.makemake.interstratte.tipo;
import it.beije.makemake.interstratte.Pokemon;

public interface Elettro {
	public default void fulmine(int attacco, Pokemon pokemon) {
		if (pokemon instanceof Acqua) {
			pokemon.hp -= attacco * 2;
		} else {
			pokemon.hp -= attacco;
		}
	}

}
