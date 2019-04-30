package br.edu.ifsp.spo.lp1a3.warzadaxiii.fábricas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;

public class ContinenteFactory {
	
	private static Set<Território> territórios = new HashSet<Território>();
	private static Set<Continente> continentes = new HashSet<Continente>();
	
	private static void buildarContinentes() throws Exception {
		String nome;
		BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/Continente.txt"));
		
		while(( nome = file.readLine())!=null) {
			Continente continente = new Continente(nome);
			continentes.add(continente);
		}
		
		file.close();
	}
	
	public static void atribuirTerritórios(Set<Território> territórios1) throws Exception {
		ContinenteFactory.buildarContinentes();
		territórios = territórios1;
		
		
	}
	
}
