package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.repositorios;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.TerritórioRepository;

public class TesteTerritórioRepository {
	
	@Test
	public void devo_conseguir_add_um_território() {
		//1. Configuração
		Território brasil = new Território("Brasil");
		
		//2. Execução
		TerritórioRepository.addTerritório(brasil);
		
		//3. Validação / Asserção
		assertEquals(1, TerritórioRepository.getTerritórios().size());
	}
	
	@Test
	public void devo_conseguir_pegar_território_pelo_nome() {
		//1. Configuração
		String nome = "brasil";
		String nome2 = "argentina";
		Território brasil = new Território(nome);
		TerritórioRepository.addTerritório(brasil);
		
		//2. Execução
		Território assercao = TerritórioRepository.pegarTerritório(nome);
		Território assercao2 = TerritórioRepository.pegarTerritório(nome2);
		
		//3. Validação / Asserção
		assertEquals(assercao.getNome(), brasil.getNome());
		assertEquals(null, assercao2);
	
	}

}
