package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class TestePlayer {
	
	@Test
	public void devo_conseguir_criar_player() {
		//1. Configura��o
		int player = 1;
		boolean ativo = true;
		int qtd_tropas = 10;
		
		//2. Execu��o
		Player player1 = new Player(player, ativo, qtd_tropas);
		
		//3. Valida��o / Asser��o
		assertEquals(player, player1.getNumero());
		assertEquals(qtd_tropas, player1.getQtd_tropas());
		assertTrue(player1.isAtivo());
	}
	
	@Test
	public void devo_conseguir_add_territ�rio_ao_player() {
		//1. Configura��o
		Player player = new Player(1, true, 10);
		Territ�rio brasil = new Territ�rio("Brasil", player, 10);
		
		//2. Execu��o
		player.adicionarDominio(brasil);
		
		//3. Valida��o / Asser��o
		assertTrue(player.dominaTerritorio(brasil));
		
	}
	
	@Test
	public void devo_conseguir_remover_territ�rio_ao_player() {
		//1. Configura��o
		Player player = new Player(1, true, 10);
		Territ�rio argentina = new Territ�rio("Argentina", player, 10);
		Territ�rio brasil = new Territ�rio("Brasil", player, 10);
		player.adicionarDominio(brasil);
		
		//2. Execu��o
		player.removerDominio(brasil);
		
		//3. Valida��o / Asser��o
		assertFalse(player.dominaTerritorio(brasil));
		
	}
	
}
