package br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o;

import java.util.List;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class Continente {
	
	private String nome;
	private	List<Territ�rio> pa�ses;
	private	Player dominador;
	
	public Continente(String nome, List<Territ�rio> pa�ses, Player dominador) {
		this.nome = nome;
		this.pa�ses = pa�ses;
		this.dominador = dominador;
	}

	public String getNome() {
		return nome;
	}

	public List<Territ�rio> getPa�ses() {
		return pa�ses;
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
}
