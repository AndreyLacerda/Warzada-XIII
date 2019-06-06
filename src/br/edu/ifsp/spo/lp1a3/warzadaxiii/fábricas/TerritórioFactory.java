package br.edu.ifsp.spo.lp1a3.warzadaxiii.f�bricas;

import java.io.BufferedReader;
import java.io.FileReader;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.Territ�rioRepository;

public class Territ�rioFactory {

	public static void buildarTerrit�rios(){
		try {
			Territ�rioRepository.getTerrit�rios().clear();
			BufferedReader file = new BufferedReader(new FileReader("Txt's/Territ�rios.txt"));
			String nome;
			
			while(( nome = file.readLine())!=null) {
				Territ�rio territorio = new Territ�rio(nome);
				Territ�rioRepository.addTerrit�rio(territorio);
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
			
			for(Territ�rio territ�rio : Territ�rioRepository.getTerrit�rios()) {
				while((nome = file.readLine())!= null) {
					Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
					territ�rio.addFronteira(pa�s);
				}
			}
			file.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
