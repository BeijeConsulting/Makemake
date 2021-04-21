package it.beije.makemake.interstratte;

public abstract class Pokemon {
	private String id;
	public String nome;
	public int maxHP;
	public int hp;
	public int attacco;
	
	public abstract void attacca(Pokemon pokemon);

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nome=" + nome + ", maxHP=" + maxHP + ", hp=" + hp + ", attacco=" + attacco
				+ "]";
	}
}
