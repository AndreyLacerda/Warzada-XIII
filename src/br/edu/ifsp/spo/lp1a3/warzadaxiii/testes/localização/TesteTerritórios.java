package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.localização;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class TesteTerritórios {
	
	@Test
	public void devo_conseguir_criar_um_Território() {
		//1. Configuração
		String nome;
		int	qtd_tropas = 10;
		
		//2. Execução
		nome = "Brasil";
		Território brasil = new Território(nome);
		
		//3. Validação / Asserção
		assertEquals(nome, brasil.getNome());
		assertEquals(qtd_tropas, brasil.getTropas());
		assertEquals(null, brasil.getDominador());
		
	}
	
	@Test
	public void devo_conseguir_inserir_fronteiras() {
		//1. Configuração
		String nome1 = "Brasil";
		String nome2 = "Argentina";
		Set<Território> fronteira = new HashSet<Território>();
		
		Território brasil = new Território(nome1);
		
		//2. Execução
		Território argentina = new Território(nome2);
		argentina.addFronteira(brasil);
		fronteira.add(brasil);
		
		//3. Validação / Asserção
		assertEquals(fronteira, argentina.getFronteira());
		fronteira.clear();
		assertEquals(fronteira, brasil.getFronteira());
		
	}
	
	@Test
	public void devo_conseguir_saber_se_um_pais_faz_fronteira_com_outro() {
		//1. Configuração
		String nome1 = "Brasil";
		String nome2 = "Argentina";
		
		Território brasil = new Território(nome1);
		
		//2. Execução
		Território argentina = new Território(nome2);
		argentina.addFronteira(brasil);
		
		//3. Validação / Asserção
		assertEquals(true, argentina.vizinho(brasil));
		assertFalse(brasil.vizinho(argentina));
	
	}

	@Test
	public void devo_conseguir_adicionar_tropas() {
		//1. Configuração
		String nome1 = "Brasil";
		int	qtd = 10;
		
		Território brasil = new Território(nome1);
		
		//2. Execução
		brasil.addTropas(qtd);
		
		//3. Validação / Asserção
		assertEquals(qtd*2, brasil.getTropas());
	}
	
	@Test
	public void devo_conseguir_remover_tropas() {
		//1. Configuração
		String nome1 = "Brasil";
		int	qtd = 10;
		
		Território brasil = new Território(nome1);
		
		//2. Execução
		brasil.removeTropas(qtd/2);
		
		//3. Validação / Asserção
		assertEquals(qtd-qtd/2, brasil.getTropas());
	}
	
	@Test
	public void devo_conseguir_atualizar_dominador_território() {
		//1. Configuração
		String nome1 = "Brasil";
		Player dominador = new Player(1, true, 10);
		
		Território brasil = new Território(nome1);
		
		//2. Execução
		brasil.updateDominador(dominador);
		
		//3. Validação / Asserção
		assertEquals(dominador, brasil.getDominador());
		
	}
	
}