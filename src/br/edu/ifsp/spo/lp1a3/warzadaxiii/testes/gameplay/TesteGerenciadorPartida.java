package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.gameplay;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import java.util.LinkedHashSet;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

import org.junit.jupiter.api.Test;

public class TesteGerenciadorPartida {

	@Test
	public void devo_conseguir_criar_qtd_player() {
		//1. Configura��o
		int qtd = 6;
		Set<Player> players = new LinkedHashSet<Player>();
		
		//2. Execu��o
		GerenciadorPartida.setarPlayer(qtd);
		players = GerenciadorPartida.getPlayers();
		
		//3. Valida��o / Asser��o
		assertEquals(qtd, players.size());
	}
	
	@Test
	public void devo_conseguir_definir_ordem_de_jogo() {
		//1. Configura��o
		int qtd = 3;
		GerenciadorPartida.setarPlayer(qtd);
		
		//2. Execu��o
		GerenciadorPartida.definirOrdem();
		
		//3. Valida��o / Asser��o
		
	}
}