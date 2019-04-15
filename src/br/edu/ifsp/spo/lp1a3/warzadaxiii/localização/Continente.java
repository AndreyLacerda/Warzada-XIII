package br.edu.ifsp.spo.lp1a3.warzadaxiii.localização;

import java.util.List;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class Continente {
	
	private String nome;
	private	List<Território> países;
	private	Player dominador;
	
	public Continente(String nome, List<Território> países, Player dominador) {
		this.nome = nome;
		this.países = países;
		this.dominador = dominador;
	}

	public String getNome() {
		return nome;
	}

	public List<Território> getPaíses() {
		return países;
	}

	public Player getDominador() {
		return dominador;
	}
	
	public void addPaís(Território país) {
		this.países.add(país);
	}
	
	public boolean checarPaís(Território país) {
		if (this.países.contains(país)) {
			return true;
		}else {
			return false;
		}
	}
}
