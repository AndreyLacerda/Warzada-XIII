package br.edu.ifsp.spo.lp1a3.warzadaxiii.fábricas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;

public class TerritórioFactory {

	public static void buildarTerritórios() throws Exception {
		BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/Territórios.txt"));
		String nome;
		Set<Território> territórios = new HashSet<Território>();
		
		while(( nome = file.readLine())!=null) {
			Território territorio = new Território(nome);
			territórios.add(territorio);
		}
		
		file.close();
		
		ContinenteFactory.atribuirTerritórios(territórios);
		
	}
	
}
