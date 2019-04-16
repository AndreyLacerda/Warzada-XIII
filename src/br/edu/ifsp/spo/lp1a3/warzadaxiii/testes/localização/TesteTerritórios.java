package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.localização;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class TesteTerritórios {
	
	@Test
	public void devo_conseguir_criar_um_Território() {
		//1. Configuração
		String nome;
		Player dominador;
		int	qtd_tropas;
		List<Território> fronteira = new ArrayList<Território>();
		
		//2. Execução
		nome = "Brasil";
		dominador = null;
		qtd_tropas = 10;
		Território brasil = new Território(nome, dominador, qtd_tropas, fronteira);
		
		//3. Validação / Asserção
		assertEquals(nome, brasil.getNome());
		assertEquals(qtd_tropas, brasil.getTropas());
		assertEquals(dominador, brasil.getDominador());
		
	}
	
	@Test
	public void devo_conseguir_inserir_fronteiras() {
		//1. Configuração
		String nome1 = "Brasil";
		String nome2 = "Argentina";
		Player dominador = null;
		int	qtd_tropas = 10;
		List<Território> fronteira = new ArrayList<Território>();
		
		Território brasil = new Território(nome1, dominador, qtd_tropas, fronteira);
		
		//2. Execução
		Território argentina = new Território(nome2, dominador, qtd_tropas, fronteira);
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
		Player dominador = null;
		int	qtd_tropas = 10;
		List<Território> fronteira = new ArrayList<Território>();
		
		Território brasil = new Território(nome1, dominador, qtd_tropas, fronteira);
		
		//2. Execução
		Território argentina = new Território(nome2, dominador, qtd_tropas, fronteira);
		argentina.addFronteira(brasil);
		
		//3. Validação / Asserção
		assertEquals(true, argentina.vizinho(brasil));
		assertFalse(brasil.vizinho(argentina));
	
	}

}