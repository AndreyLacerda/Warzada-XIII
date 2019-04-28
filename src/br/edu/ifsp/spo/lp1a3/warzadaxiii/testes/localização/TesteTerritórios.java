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
		Player dominador;
		int	qtd_tropas;
		
		//2. Execu��o
		nome = "Brasil";
		dominador = null;
		qtd_tropas = 10;
		Territ�rio brasil = new Territ�rio(nome, dominador, qtd_tropas);
		
		//3. Valida��o / Asser��o
		assertEquals(nome, brasil.getNome());
		assertEquals(qtd_tropas, brasil.getTropas());
		assertEquals(dominador, brasil.getDominador());
		
	}
	
	@Test
	public void devo_conseguir_inserir_fronteiras() {
		//1. Configura��o
		String nome1 = "Brasil";
		String nome2 = "Argentina";
		Player dominador = null;
		int	qtd_tropas = 10;
		Set<Territ�rio> fronteira = new HashSet<Territ�rio>();
		
		Territ�rio brasil = new Territ�rio(nome1, dominador, qtd_tropas);
		
		//2. Execu��o
		Territ�rio argentina = new Territ�rio(nome2, dominador, qtd_tropas);
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
		Player dominador = null;
		int	qtd_tropas = 10;
		Set<Territ�rio> fronteira = new HashSet<Territ�rio>();
		
		Territ�rio brasil = new Territ�rio(nome1, dominador, qtd_tropas);
		
		//2. Execu��o
		Territ�rio argentina = new Territ�rio(nome2, dominador, qtd_tropas);
		argentina.addFronteira(brasil);
		
		//3. Valida��o / Asser��o
		assertEquals(true, argentina.vizinho(brasil));
		assertFalse(brasil.vizinho(argentina));
	
	}

}