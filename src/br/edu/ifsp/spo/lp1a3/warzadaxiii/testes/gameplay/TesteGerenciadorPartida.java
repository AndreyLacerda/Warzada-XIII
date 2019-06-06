package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.gameplay;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import java.util.LinkedHashSet;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

import org.junit.jupiter.api.Test;

public class TesteGerenciadorPartida {

	@Test
	public void devo_conseguir_criar_qtd_player() {
		//1. Configura��o
		int qtd = 6;
		Set<Player> players = new LinkedHashSet<Player>();
		
		//2. Execu��o
		GerenciadorPartidas.setarPlayer(qtd);
		players = GerenciadorPartidas.getPlayers();
		System.out.println(players.size());
		
		//3. Valida��o / Asser��o
		assertEquals(qtd, players.size());
	}
}