package br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;

public class TerritórioRepository {
	
	private static Set<Território> territórios = new HashSet<Território>();

	public static Set<Território> getTerritórios() {
		return territórios;
	}
	
	public static void addTerritório(Território território) {
		getTerritórios().add(território);
	}
	
	public static Território pegarTerritório(String nome) {
		for(Território território : territórios) {
			if(território.getNome().equals(nome)) {
				return território;
			}
		}
		return null;
	}

}
