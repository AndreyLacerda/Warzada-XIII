package br.edu.ifsp.spo.lp1a3.warzadaxiii.f�bricas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;

public class Territ�rioFactory {

	public static void buildarTerrit�rios() throws Exception {
		BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/Territ�rios.txt"));
		String nome;
		Set<Territ�rio> territ�rios = new HashSet<Territ�rio>();
		
		while(( nome = file.readLine())!=null) {
			Territ�rio territorio = new Territ�rio(nome);
			territ�rios.add(territorio);
		}
		
		file.close();
		
		ContinenteFactory.atribuirTerrit�rios(territ�rios);
		
	}
	
}
