package br.edu.ifsp.spo.lp1a3.warzadaxiii.localização;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class Continente {
	
	private String nome;
	private	Set<Território> países = new HashSet<Território>();
	private	Player dominador;
	
	public Continente(String nome) {
		this.nome = nome;
		this.dominador = null;
	}

	public String getNome() {
		return nome;
	}

	public Set<Território> getPaíses() {
		return países;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Continente other = (Continente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
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
	
	public void updateDominador(Player dominador) {
		this.dominador = dominador;
		System.out.println("Player " + dominador.getNumero() + " dominou o(a) " + this.getNome() + "!");
	}
	
}