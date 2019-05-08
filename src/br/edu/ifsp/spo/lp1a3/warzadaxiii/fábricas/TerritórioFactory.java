package br.edu.ifsp.spo.lp1a3.warzadaxiii.fábricas;

import java.io.BufferedReader;
import java.io.FileReader;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.TerritórioRepository;

public class TerritórioFactory {

	public static void buildarTerritórios() throws Exception {
		BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/Territórios.txt"));
		String nome;
		
		while(( nome = file.readLine())!=null) {
			Território territorio = new Território(nome);
			TerritórioRepository.addTerritório(territorio);
		}
		
		file.close();
		
	}
	
	private static void addFronteiras(){
		
	}
	
}
