package br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.dado.Dado;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class GerenciadorPartidas {
	private static Set<Player> players = new HashSet<Player>();
	private static int ordem[];
	private static Dado dado = new Dado(6);
	
	public static Set<Player> getPlayers() {
		return players;
	}

	public static int[] getOrdem() {
		return ordem;
	}

	public static void setarPlayer (int qtd) {
		for(int i = 1; i <= qtd; i++) {
			Player player = new Player(i, true, 0);
			players.add(player);
		}
	}
	
	public static void definirOrdem() {
		
		for(Player player : getPlayers()) {
			ordem.put(player, player.rolarDado(1, dado);
		}
	}
	
}
