package br.edu.ifsp.spo.lp1a3.warzadaxiii.localização;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class Continente {
	
	private String nome;
	private	Set<Território> países = new HashSet<Território>();
	private	Player dominador;
	
	public Continente(String nome, Player dominador) {
		this.nome = nome;
		this.dominador = dominador;
	}

	public String getNome() {
		return nome;
	}

	public Set<Território> getPaíses() {
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
