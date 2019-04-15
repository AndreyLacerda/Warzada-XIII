package br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class Territ�rio {
	
	private String nome;
	private Player dominador;
	private int qtd_tropas;
	private List<Territ�rio> fronteira = new ArrayList<Territ�rio>();
	
	
	public Territ�rio (String nome, Player dominador, int qtd_tropas, List<Territ�rio> fronteira) {
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


	public List<Territ�rio> getFronteira() {
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
