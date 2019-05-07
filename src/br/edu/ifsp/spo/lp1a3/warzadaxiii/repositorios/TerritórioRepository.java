package br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;

public class Territ�rioRepository {
	
	private static Set<Territ�rio> territ�rios = new HashSet<Territ�rio>();

	public static Set<Territ�rio> getTerrit�rios() {
		return territ�rios;
	}
	
	public static void addTerrit�rio(Territ�rio territ�rio) {
		getTerrit�rios().add(territ�rio);
	}
	
	public static Territ�rio pegarTerrit�rio(String nome) {
		for(Territ�rio territ�rio : territ�rios) {
			if(territ�rio.getNome().equals(nome)) {
				return territ�rio;
			}
		}
		return null;
	}

}
