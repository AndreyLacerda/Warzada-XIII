package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.repositorios;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.ContinenteRepository;

public class TesteContinenteRepository {
	
	@Test
	public void devo_conseguir_add_um_continente() {
		//1. Configura��o
		Continente europa = new Continente("Europa");
		
		//2. Execu��o
		ContinenteRepository.addContinente(europa);
		
		//3. Valida��o / Asser��o
		assertEquals(1, ContinenteRepository.getContinentes().size());
	}
	
	@Test
	public void devo_conseguir_pegar_continente_pelo_nome() {
		//1. Configura��o
		String nome = "europa";
		String nome2 = "�sia";
		Continente europa = new Continente(nome);
		ContinenteRepository.addContinente(europa);
		
		//2. Execu��o
		Continente assercao = ContinenteRepository.pegarContinente(nome);
		Continente assercao2 = ContinenteRepository.pegarContinente(nome2);
		
		//3. Valida��o / Asser��o
		assertEquals(assercao.getNome(), europa.getNome());
		assertEquals(null, assercao2);
	
	}

}
