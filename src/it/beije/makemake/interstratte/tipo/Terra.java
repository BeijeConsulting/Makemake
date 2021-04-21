package it.beije.makemake.interstratte.tipo;
import it.beije.makemake.interstratte.Pokemon;

public interface Terra {
	public default void terremoto(int attacco, Pokemon pokemon) {
		if (pokemon instanceof Elettro) {
			pokemon.hp -= attacco * 2;
		} else {
			pokemon.hp -= attacco;
		}
	}
}
