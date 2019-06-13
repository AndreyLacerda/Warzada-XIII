package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.gameplay;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

import org.junit.jupiter.api.Test;

public class TesteGerenciadorPartida {

	@Test
	public void devo_conseguir_criar_qtd_player() {
		//1. Configura��o
		int qtd = 6;
		Set<Player> players = new LinkedHashSet<Player>();

		// 2. Execu��o
		GerenciadorPartidas.setarPlayer(qtd);
		players = GerenciadorPartidas.getPlayers();
		System.out.println(players.size());

		//3. Valida��o / Asser��o
		assertEquals(qtd, players.size());
	}

//	@Test
//	public void devo_conseguir_gerenciar_turnos() {
//		//1. Configura��o
//		GerenciadorPartidas.setarPlayer(6);
//		ArrayList<Player> players = new ArrayList<Player>();
//		players.addAll(GerenciadorPartidas.getPlayers());
//		Player player = players.get(0);
//		
//		//2. Execu��o
//		
//		//3. Valida��o / Asser��o
//		assertEquals(player, GerenciadorPartidas.getPlayerAtual());
//		assertEquals(1,GerenciadorPartidas.getTurnos());
//		
//	}
	
}