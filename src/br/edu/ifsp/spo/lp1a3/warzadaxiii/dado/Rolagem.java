package br.edu.ifsp.spo.lp1a3.warzadaxiii.dado;

import java.util.ArrayList;
import java.util.Random;

public abstract class Rolagem {
	
	public static ArrayList<Integer> rolar(Dado dado, int qtd) {
		
		ArrayList<Integer> rolagens = new ArrayList<Integer>();
		rolagens.clear();
		Random rand = new Random();
		
		for (int i = 0; i < qtd; i++){
			Integer result = 0;
			
			while (result.intValue() == 0 || result.intValue() > dado.getLados()) {
				result = rand.nextInt(dado.getLados()+1);
			}
			
			rolagens.add(result);
			
		}
		
		return rolagens;
		
	}

	
}
