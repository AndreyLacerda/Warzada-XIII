package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.dado;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.dado.Dado;

public class TestesDado {
	
	@Test
	void devo_conseguir_criar_um_dado_de_n_lados() {
		//1. Configura��o
		int lados = 6;
		
		//2. Execu��o
		Dado dado6 = new Dado(lados);
		
		//3. Valida��o / Asser��o
		assertEquals(lados, dado6.getLados());
		
	}

}
