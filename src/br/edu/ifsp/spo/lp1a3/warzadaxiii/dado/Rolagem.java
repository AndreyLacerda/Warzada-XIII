package br.edu.ifsp.spo.lp1a3.warzadaxiii.dado;

import java.util.ArrayList;
import java.util.Random;

public abstract class Rolagem {
	
	private static ArrayList<Integer> rolagens = new ArrayList<Integer>();
	
	public static ArrayList<Integer> rolar(Dado dado, int qtd) {
		
		rolagens.clear();
		Random rand = new Random();
		Integer result = 0;
		
		for (int i = 0; i < qtd; i++){
			
			while (result.intValue() == 0 || result.intValue() > dado.getLados()) {
				result = rand.nextInt(dado.getLados()+1);
			}
			
			rolagens.add(result);
			
		}
		
		return rolagens;
		
	}

	
}
