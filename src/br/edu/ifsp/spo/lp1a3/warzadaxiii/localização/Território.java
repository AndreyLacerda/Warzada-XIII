package br.edu.ifsp.spo.lp1a3.warzadaxiii.localização;


import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class Território {
	
	private String nome;
	private Player dominador;
	private int qtd_tropas;
	private Set<Território> fronteira = new HashSet<Território>();
	
	
	public Território (String nome, Player dominador, int qtd_tropas) {
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


	public Set<Território> getFronteira() {
		return fronteira;
	}
	
	public boolean vizinho(Território vizinho) {
		if (this.getFronteira().contains(vizinho)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void addFronteira(Território país) {
		this.fronteira.add(país);
		
	}
	
}
