package br.edu.ifsp.spo.lp1a3.warzadaxiii.fábricas;

import java.io.BufferedReader;
import java.io.FileReader;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.ContinenteRepository;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.TerritórioRepository;

public class ContinenteFactory {
	
	public static void buildarContinentes() throws Exception {
		String nome;
		BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/Continente.txt"));
		
		while(( nome = file.readLine())!=null) {
			Continente continente = new Continente(nome);
			ContinenteRepository.addContinente(continente);
		}		
		file.close();
		addPaises();
	}
	
	private static void addPaises() throws Exception {
		String nome;
		for (Continente continente : ContinenteRepository.getContinentes()) {
			if (continente.getNome().equals("África")) {
				BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/ContinenteÁfrica.txt"));
				
				while((nome = file.readLine()) != null) {
					Território país = TerritórioRepository.pegarTerritório(nome);
					continente.addPaís(país);
				}
				file.close();
			}else {
				if (continente.getNome().equals("Ásia")) {
					BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/ContinenteÁsia.txt"));
					
					while((nome = file.readLine()) != null) {
						Território país = TerritórioRepository.pegarTerritório(nome);
						continente.addPaís(país);
					}
					file.close();
				}else {
					if (continente.getNome().equals("América Do Sul")) {
						BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/ContinenteAméricaDoSul.txt"));
						
						while((nome = file.readLine()) != null) {
							Território país = TerritórioRepository.pegarTerritório(nome);
							continente.addPaís(país);
						}
						file.close();
					}else {
						if (continente.getNome().equals("América Do Norte")) {
							BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/ContinenteAméricaDoNorte.txt"));
							
							while((nome = file.readLine()) != null) {
								Território país = TerritórioRepository.pegarTerritório(nome);
								continente.addPaís(país);
							}
							file.close();
						}else {
							if (continente.getNome().equals("Europa")) {
								BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/ContinenteEuropa.txt"));
								
								while((nome = file.readLine()) != null) {
									Território país = TerritórioRepository.pegarTerritório(nome);
									continente.addPaís(país);
								}
								file.close();
							}else {
								if (continente.getNome().equals("Oceania")) {
									BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/ContinenteOceania.txt"));
									
									while((nome = file.readLine()) != null) {
										Território país = TerritórioRepository.pegarTerritório(nome);
										continente.addPaís(país);
									}
									file.close();
								}
							}
						}
					}
				}
			}
		}
		
	}
	
}