package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.repositorios;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.ContinenteRepository;

public class TesteContinenteRepository {
	
	@Test
	public void devo_conseguir_add_um_continente() {
		//1. Configuração
		Continente europa = new Continente("Europa");
		
		//2. Execução
		ContinenteRepository.addContinente(europa);
		
		//3. Validação / Asserção
		assertEquals(1, ContinenteRepository.getContinentes().size());
	}
	
	@Test
	public void devo_conseguir_pegar_continente_pelo_nome() {
		//1. Configuração
		String nome = "europa";
		String nome2 = "Ásia";
		Continente europa = new Continente(nome);
		ContinenteRepository.addContinente(europa);
		
		//2. Execução
		Continente assercao = ContinenteRepository.pegarContinente(nome);
		Continente assercao2 = ContinenteRepository.pegarContinente(nome2);
		
		//3. Validação / Asserção
		assertEquals(assercao.getNome(), europa.getNome());
		assertEquals(null, assercao2);
	
	}

}
