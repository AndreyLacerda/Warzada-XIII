package br.edu.ifsp.spo.lp1a3.warzadaxiii.f�bricas;

import java.io.BufferedReader;
import java.io.FileReader;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.ContinenteRepository;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.Territ�rioRepository;

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
			if (continente.getNome().equals("�frica")) {
				BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/Continente�frica.txt"));
				
				while((nome = file.readLine()) != null) {
					Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
					continente.addPa�s(pa�s);
				}
				file.close();
			}else {
				if (continente.getNome().equals("�sia")) {
					BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/Continente�sia.txt"));
					
					while((nome = file.readLine()) != null) {
						Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
						continente.addPa�s(pa�s);
					}
					file.close();
				}else {
					if (continente.getNome().equals("Am�rica Do Sul")) {
						BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/ContinenteAm�ricaDoSul.txt"));
						
						while((nome = file.readLine()) != null) {
							Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
							continente.addPa�s(pa�s);
						}
						file.close();
					}else {
						if (continente.getNome().equals("Am�rica Do Norte")) {
							BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/ContinenteAm�ricaDoNorte.txt"));
							
							while((nome = file.readLine()) != null) {
								Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
								continente.addPa�s(pa�s);
							}
							file.close();
						}else {
							if (continente.getNome().equals("Europa")) {
								BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/ContinenteEuropa.txt"));
								
								while((nome = file.readLine()) != null) {
									Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
									continente.addPa�s(pa�s);
								}
								file.close();
							}else {
								if (continente.getNome().equals("Oceania")) {
									BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/ContinenteOceania.txt"));
									
									while((nome = file.readLine()) != null) {
										Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
										continente.addPa�s(pa�s);
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