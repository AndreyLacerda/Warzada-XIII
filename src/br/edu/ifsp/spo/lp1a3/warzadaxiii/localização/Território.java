package br.edu.ifsp.spo.lp1a3.warzadaxiii.localização;


import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class Território {
	
	private String nome;
	private Player dominador;
	private int qtd_tropas;
	private Set<Território> fronteira = new HashSet<Território>();
	
	
	public Território (String nome) {
		this.nome = nome;
		this.dominador = null;
		this.qtd_tropas = 10;
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
		Território other = (Território) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
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
	
	public void addTropas(int qtd) {
		this.qtd_tropas += qtd;
	}
	
	public void removeTropas(int qtd) {
		this.qtd_tropas -= qtd;
	}
	
	public void updateDominador(Player dominador) {
		this.dominador = dominador;
		System.out.println("Player " + dominador.getNumero() + " dominou o(a) " + this.getNome() + "!");
	}
	
}
