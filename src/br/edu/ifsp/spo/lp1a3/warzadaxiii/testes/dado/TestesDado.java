package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.dado;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.dado.Dado;

public class TestesDado {
	
	@Test
	void devo_conseguir_criar_um_dado_de_n_lados() {
		//1. Configuração
		int lados = 6;
		
		//2. Execução
		Dado dado6 = new Dado(lados);
		
		//3. Validação / Asserção
		assertEquals(lados, dado6.getLados());
		
	}

}
