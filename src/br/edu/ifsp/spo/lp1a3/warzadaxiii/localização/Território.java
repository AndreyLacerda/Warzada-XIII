package br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o;


import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class Territ�rio {
	
	private String nome;
	private Player dominador;
	private int qtd_tropas;
	private Set<Territ�rio> fronteira = new HashSet<Territ�rio>();
	
	
	public Territ�rio (String nome, Player dominador, int qtd_tropas) {
		this.nome = nome;
		this.dominador = dominador;
		this.qtd_tropas = qtd_tropas;
	}


	public String getNome() {
		return nome;
	}


	public Player getDominador() {
		return dominador;
	}


	public int getTropas() {
		return qtd_tropas;
	}


	public Set<Territ�rio> getFronteira() {
		return fronteira;
	}
	
	public boolean vizinho(Territ�rio vizinho) {
		if (this.getFronteira().contains(vizinho)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void addFronteira(Territ�rio pa�s) {
		this.fronteira.add(pa�s);
		
	}
	
}
