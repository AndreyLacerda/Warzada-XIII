package br.edu.ifsp.spo.lp1a3.warzadaxiii.f�bricas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;

public class ContinenteFactory {
	
	private static Set<Territ�rio> territ�rios = new HashSet<Territ�rio>();
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
	
	public static void atribuirTerrit�rios(Set<Territ�rio> territ�rios1) throws Exception {
		ContinenteFactory.buildarContinentes();
		territ�rios = territ�rios1;
		
		
	}
	
}
