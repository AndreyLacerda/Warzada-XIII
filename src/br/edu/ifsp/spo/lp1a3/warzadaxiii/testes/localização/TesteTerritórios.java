package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.localiza��o;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;

public class TesteTerrit�rios {
	
	@Test
	void devo_conseguir_criar_um_Territ�rio() {
		//1. Configura��o
		String nome;
		
		//2. Execu��o
		nome = "Brasil";
		Territ�rio brasil = new Territ�rio(nome);
		
		//3. Valida��o / Asser��o
		assertEquals(nome, brasil.getNome());
	}
	
	@Test
	void devo_conseguir_inserir_fronteiras() {
		
	}

}