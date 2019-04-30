package br.edu.ifsp.spo.lp1a3.warzadaxiii.player;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;

public class Player {
	
	private int numero;
	private boolean ativo;
	private int qtd_tropas;
	private Set<Territ�rio> territorios = new HashSet<Territ�rio>();
	
	public Player(int numero, boolean ativo, int qtd_tropas) {
		super();
		this.numero = numero;
		this.qtd_tropas = qtd_tropas;
		this.ativo = ativo;
	}

	public int getNumero() {
		return numero;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public int getQtd_tropas() {
		return qtd_tropas;
	}
	
	
	public Set<Territ�rio> getTerritorios() {
		return territorios;
	}
	
	public boolean dominaTerritorio(Territ�rio pais) {
		if (this.getTerritorios().contains(pais))
			return true;
		else
			return false;
	}
	
	public void adicionarDominio(Territ�rio pais) {
		this.getTerritorios().add(pais);
		pais.updateDominador(this);
	}
	
	public void removerDominio(Territ�rio pais) {
		this.getTerritorios().remove(pais);
	}

	private void setAtivo() {
		if(this.getQtd_tropas() == 0) {
			this.ativo = false;
			System.out.println("Player Eliminado!");
		}
		else {
			this.ativo = true;
			System.out.println("Player ainda est� no jogo!");
		}
	}

	public void addTropas(int qtd) {
		this.qtd_tropas += qtd;
	}
	
	public void removeTropas(int qtd) {
		this.qtd_tropas -= qtd;
		this.setAtivo();
	}
	
}
