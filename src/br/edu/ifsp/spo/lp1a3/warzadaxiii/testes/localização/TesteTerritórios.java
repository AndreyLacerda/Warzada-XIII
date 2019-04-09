package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.localização;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;

public class TesteTerritórios {
	
	@Test
	void devo_conseguir_criar_um_Território() {
		//1. Configuração
		String nome;
		
		//2. Execução
		nome = "Brasil";
		Território brasil = new Território(nome);
		
		//3. Validação / Asserção
		assertEquals(nome, brasil.getNome());
	}
	
	@Test
	void devo_conseguir_inserir_fronteiras() {
		
	}

}