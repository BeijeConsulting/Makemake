package it.beije.makemake.interstratte;

public abstract class Evolvibile extends Pokemon{
	private Pokemon evoluzione;

	public Pokemon getEvoluzione() {
		return evoluzione;
	}

	public void setEvoluzione(Pokemon evoluzione) {
		this.evoluzione = evoluzione;
	}
	
	public abstract Pokemon evolvi();
}
