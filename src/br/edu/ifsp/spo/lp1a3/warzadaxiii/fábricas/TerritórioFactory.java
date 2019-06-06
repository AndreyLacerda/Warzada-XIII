package br.edu.ifsp.spo.lp1a3.warzadaxiii.fábricas;

import java.io.BufferedReader;
import java.io.FileReader;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.TerritórioRepository;

public class TerritórioFactory {

	public static void buildarTerritórios(){
		try {
			TerritórioRepository.getTerritórios().clear();
			BufferedReader file = new BufferedReader(new FileReader("Txt's/Territórios.txt"));
			String nome;
			
			while(( nome = file.readLine())!=null) {
				Território territorio = new Território(nome);
				TerritórioRepository.addTerritório(territorio);
			}
			
			file.close();
			addFronteiras();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void addFronteiras(){
		try {
			BufferedReader file = new BufferedReader(new FileReader("Txt's/Fronteiras.txt"));
			String nome;
			
			for(Território território : TerritórioRepository.getTerritórios()) {
				while((nome = file.readLine())!= null) {
					Território país = TerritórioRepository.pegarTerritório(nome);
					território.addFronteira(país);
				}
			}
			file.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
