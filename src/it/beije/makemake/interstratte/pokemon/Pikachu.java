package it.beije.makemake.interstratte.pokemon;
public class Pikachu extends Pichu{

	public Pikachu(String nome, int maxHP, int attacco) {
		super(nome, maxHP, attacco);
	}
	
	public Pikachu(Pichu pichu) {
		this(pichu.nome, pichu.maxHP + 30, pichu.attacco + 15);
	}
}
