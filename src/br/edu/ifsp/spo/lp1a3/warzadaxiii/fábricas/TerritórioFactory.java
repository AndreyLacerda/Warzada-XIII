package br.edu.ifsp.spo.lp1a3.warzadaxiii.f�bricas;

import java.io.BufferedReader;
import java.io.FileReader;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.Territ�rioRepository;

public class Territ�rioFactory {

	public static void buildarTerrit�rios() throws Exception {
		BufferedReader file = new BufferedReader(new FileReader("/Warzada-XIII/Txt's/Territ�rios.txt"));
		String nome;
		
		while(( nome = file.readLine())!=null) {
			Territ�rio territorio = new Territ�rio(nome);
			Territ�rioRepository.addTerrit�rio(territorio);
		}
		
		file.close();
		
	}
	
	private static void addFronteiras(){
		
	}
	
}
