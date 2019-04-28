package br.edu.ifsp.spo.lp1a3.warzadaxiii.player;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;

public class Player {
	
	int numero;
	boolean ativo;
	int qtd_tropas;
	Set<Território> territorios = new HashSet<Território>();
	
	public Player(int numero, boolean ativo, int qtd_tropas) {
		super();
		this.numero = numero;
		this.ativo = ativo;
		this.qtd_tropas = qtd_tropas;
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
	
	public Set<Território> getTerritorios() {
		return territorios;
	}
	
	public boolean dominaTerritorio(Território pais) {
		if (this.getTerritorios().contains(pais))
			return true;
		else
			return false;
	}
	
	public void adicionarDominio(Território pais) {
		this.getTerritorios().add(pais);
	}
	
	public void removerDominio(Território pais) {
		this.getTerritorios().remove(pais);
	}
	
}
