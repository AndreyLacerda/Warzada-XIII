package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.dado;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.dado.Dado;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.dado.Rolagem;

public class TesteRolagem {
	
	@Test
	public void devo_conseguir_rolar_um_dado_de_n_lados_n_vezes() {
		//1. Configuração
		int lados = 6;
		int qtd = 10;
		Dado dado6 = new Dado(lados);
		
		//2. Execução
		ArrayList<Integer> result = Rolagem.rolar(dado6, qtd);
		
		//3. Validação / Asserção
		assertFalse(result.contains(dado6.getLados()+1));
		assertFalse(result.contains(0));
		
	}

}
