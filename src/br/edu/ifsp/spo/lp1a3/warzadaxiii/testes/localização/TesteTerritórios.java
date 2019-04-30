package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.localiza��o;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class TesteTerrit�rios {
	
	@Test
	public void devo_conseguir_criar_um_Territ�rio() {
		//1. Configura��o
		String nome;
		int	qtd_tropas = 10;
		
		//2. Execu��o
		nome = "Brasil";
		Territ�rio brasil = new Territ�rio(nome);
		
		//3. Valida��o / Asser��o
		assertEquals(nome, brasil.getNome());
		assertEquals(qtd_tropas, brasil.getTropas());
		assertEquals(null, brasil.getDominador());
		
	}
	
	@Test
	public void devo_conseguir_inserir_fronteiras() {
		//1. Configura��o
		String nome1 = "Brasil";
		String nome2 = "Argentina";
		Set<Territ�rio> fronteira = new HashSet<Territ�rio>();
		
		Territ�rio brasil = new Territ�rio(nome1);
		
		//2. Execu��o
		Territ�rio argentina = new Territ�rio(nome2);
		argentina.addFronteira(brasil);
		fronteira.add(brasil);
		
		//3. Valida��o / Asser��o
		assertEquals(fronteira, argentina.getFronteira());
		fronteira.clear();
		assertEquals(fronteira, brasil.getFronteira());
		
	}
	
	@Test
	public void devo_conseguir_saber_se_um_pais_faz_fronteira_com_outro() {
		//1. Configura��o
		String nome1 = "Brasil";
		String nome2 = "Argentina";
		
		Territ�rio brasil = new Territ�rio(nome1);
		
		//2. Execu��o
		Territ�rio argentina = new Territ�rio(nome2);
		argentina.addFronteira(brasil);
		
		//3. Valida��o / Asser��o
		assertEquals(true, argentina.vizinho(brasil));
		assertFalse(brasil.vizinho(argentina));
	
	}

	@Test
	public void devo_conseguir_adicionar_tropas() {
		//1. Configura��o
		String nome1 = "Brasil";
		int	qtd = 10;
		
		Territ�rio brasil = new Territ�rio(nome1);
		
		//2. Execu��o
		brasil.addTropas(qtd);
		
		//3. Valida��o / Asser��o
		assertEquals(qtd*2, brasil.getTropas());
	}
	
	@Test
	public void devo_conseguir_remover_tropas() {
		//1. Configura��o
		String nome1 = "Brasil";
		int	qtd = 10;
		
		Territ�rio brasil = new Territ�rio(nome1);
		
		//2. Execu��o
		brasil.removeTropas(qtd/2);
		
		//3. Valida��o / Asser��o
		assertEquals(qtd-qtd/2, brasil.getTropas());
	}
	
	@Test
	public void devo_conseguir_atualizar_dominador_territ�rio() {
		//1. Configura��o
		String nome1 = "Brasil";
		Player dominador = new Player(1, true, 10);
		
		Territ�rio brasil = new Territ�rio(nome1);
		
		//2. Execu��o
		brasil.updateDominador(dominador);
		
		//3. Valida��o / Asser��o
		assertEquals(dominador, brasil.getDominador());
		
	}
	
}