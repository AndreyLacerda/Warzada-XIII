package br.edu.ifsp.spo.lp1a3.warzadaxiii.dado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Rolagem {
	
	private static Collection<Integer> rolagens = new ArrayList<Integer>();
	
	public static Collection<Integer> rolar(Dado dado, int qtd) {
		
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
