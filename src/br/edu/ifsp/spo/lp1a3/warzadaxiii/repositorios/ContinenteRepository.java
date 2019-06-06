package br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Continente;

public abstract class ContinenteRepository {
	
	private static Set<Continente> continentes = new HashSet<Continente>();
	
	
	
	public static Set<Continente> getContinentes() {
		return continentes;
	}

	public static void addContinente(Continente continente){
		getContinentes().add(continente);
	}
	
	public static Continente pegarContinente(String nomeContinente) {
		for(Continente continente : continentes) {
			if(continente.getNome().equals(nomeContinente)){
				return continente;
			}
		}
		return null;
	}

}
