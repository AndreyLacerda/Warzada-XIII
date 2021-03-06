package br.edu.ifsp.spo.lp1a3.warzadaxiii.f�bricas;

import java.io.BufferedReader;
import java.io.FileReader;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.ContinenteRepository;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.Territ�rioRepository;

public class ContinenteFactory {
	
	public static void buildarContinentes() {
		try {
			ContinenteRepository.getContinentes().clear();
			String nome;
			BufferedReader file = new BufferedReader(new FileReader("Txt's/Continentes.txt"));
			
			while(( nome = file.readLine())!=null) {
				Continente continente = new Continente(nome);
				ContinenteRepository.addContinente(continente);
			}		
			file.close();
			Territ�rioFactory.buildarTerrit�rios();
			addPaises();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void addPaises() throws Exception {
		try {
			String nome;
			for (Continente continente : ContinenteRepository.getContinentes()) {
				if (continente.getNome().equals("�frica")) {
					BufferedReader file = new BufferedReader(new FileReader("Txt's/Continente�frica.txt"));
					
					while((nome = file.readLine()) != null) {
						Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
						continente.addPa�s(pa�s);
					}
					file.close();
				}else {
					if (continente.getNome().equals("�sia")) {
						BufferedReader file = new BufferedReader(new FileReader("Txt's/Continente�sia.txt"));
						
						while((nome = file.readLine()) != null) {
							Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
							continente.addPa�s(pa�s);
						}
						file.close();
					}else {
						if (continente.getNome().equals("Am�rica do SUl")) {
							BufferedReader file = new BufferedReader(new FileReader("Txt's/ContinenteAm�ricaDoSul.txt"));
							
							while((nome = file.readLine()) != null) {
								Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
								continente.addPa�s(pa�s);
							}
							file.close();
						}else {
							if (continente.getNome().equals("Am�rica do Norte")) {
								BufferedReader file = new BufferedReader(new FileReader("Txt's/ContinenteAm�ricaDoNorte.txt"));
								
								while((nome = file.readLine()) != null) {
									Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
									continente.addPa�s(pa�s);
								}
								file.close();
							}else {
								if (continente.getNome().equals("Europa")) {
									BufferedReader file = new BufferedReader(new FileReader("Txt's/ContinenteEuropa.txt"));
									
									while((nome = file.readLine()) != null) {
										Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
										continente.addPa�s(pa�s);
									}
									file.close();
								}else {
									if (continente.getNome().equals("Oceania")) {
										BufferedReader file = new BufferedReader(new FileReader("Txt's/ContinenteOceania.txt"));
										
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
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}