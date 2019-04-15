package br.edu.ifsp.spo.lp1a3.warzadaxiii.localização;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class Território {
	
	private String nome;
	private Player dominador;
	private int qtd_tropas;
	private List<Território> fronteira = new ArrayList<Território>();
	
	
	public Território (String nome, Player dominador, int qtd_tropas, List<Território> fronteira) {
		this.nome = nome;
		this.dominador = dominador;
		this.qtd_tropas = qtd_tropas;
		this.fronteira = fronteira;
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


	public List<Território> getFronteira() {
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
