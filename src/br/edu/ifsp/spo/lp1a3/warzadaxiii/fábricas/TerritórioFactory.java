package br.edu.ifsp.spo.lp1a3.warzadaxiii.f�bricas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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
			
			ArrayList<Territ�rio> territ�rios = new ArrayList<Territ�rio>();
			territ�rios.addAll(Territ�rioRepository.getTerrit�rios());
			int index = 0;
			while((nome = file.readLine())!= null) {
				if (!nome.equals("/")) {
					Territ�rio pa�s = Territ�rioRepository.pegarTerrit�rio(nome);
					territ�rios.get(index).addFronteira(pa�s);
				} else {
					index += 1; 
				}
			}
			file.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
