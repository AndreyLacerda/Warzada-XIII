package br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class Continente {
	
	private String nome;
	private	Set<Territ�rio> pa�ses = new HashSet<Territ�rio>();
	private	Player dominador;
	
	public Continente(String nome) {
		this.nome = nome;
		this.dominador = null;
	}

	public String getNome() {
		return nome;
	}

	public Set<Territ�rio> getPa�ses() {
		return pa�ses;
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
	
	public void addPa�s(Territ�rio pa�s) {
		this.pa�ses.add(pa�s);
	}
	
	public boolean checarPa�s(Territ�rio pa�s) {
		if (this.pa�ses.contains(pa�s)) {
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