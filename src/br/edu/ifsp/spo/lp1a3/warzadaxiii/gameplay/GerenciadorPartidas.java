package br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public abstract class GerenciadorPartidas {
	private static Set<Player> players = new HashSet<Player>();
	
	public static Set<Player> getPlayers() {
		return players;
	}

	public static void setarPlayer (int qtd) {
		players.clear();
		for(int i = 1; i <= qtd; i++) {
			Player player = new Player(i, true, 0);
			players.add(player);
		}
	}
}
