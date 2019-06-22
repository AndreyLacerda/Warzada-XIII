package br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.fábricas.ContinenteFactory;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.ContinenteRepository;

public abstract class GerenciadorPartidas {

	private static Set<Player> players = new HashSet<Player>();
	private static ArrayList<Player> playersArray = new ArrayList<Player>();
	private static int turnos;
	private static Player playerAtual;
	private static boolean rodando;

	public static Set<Player> getPlayers() {
		return players;
	}

	public static int getTurnos() {
		return turnos;
	}

	public static Player getPlayerAtual() {
		return playerAtual;
	}

	public static void setRodando(boolean rodando) {
		GerenciadorPartidas.rodando = rodando;
		setTurno(1);
		setPlayerAtual(0);
	}
	
	public static void setPlayerAtual(int player){
		playerAtual = playersArray.get(player);
	}
	
	public static void setTurno(int turno) {
		turnos += turno;
	}
	

	public static boolean isRodando() {
		return rodando;
	}

	public static void setarPlayer(int qtd) {
		ContinenteFactory.buildarContinentes();
		players.clear();
		for (int i = 1; i <= qtd; i++) {
			Player player = new Player(i, true, 0);
			players.add(player);
		}
		DistribuidorTerritórios.distribuir(players);
		playersArray.addAll(players);
		setRodando(true);
	}

	public static int receberTropas(Player player) {
		int tropasNovas = player.getTerritorios().size() / 2;
		for (Continente continente : ContinenteRepository.getContinentes()) {
			if (continente.getDominador() != null && continente.getDominador().getNumero() == player.getNumero()) {
				if (continente.getNome().equals("América do Sul")) {
					tropasNovas += 2;
				} else if (continente.getNome().equals("América do Norte")) {
					tropasNovas += 5;
				} else if (continente.getNome().equals("Europa")) {
					tropasNovas += 5;
				} else if (continente.getNome().equals("África")) {
					tropasNovas += 3;
				} else if (continente.getNome().equals("Ásia")) {
					tropasNovas += 7;
				} else if (continente.getNome().equals("Oceania")) {
					tropasNovas += 2;
				}
			}
		}
		player.addTropas(tropasNovas);
		return tropasNovas;
	}

	public static void distribuirTropasNovas(Player player, String terr, int qtd) {
		for (Território territorio : player.getTerritorios()) {
			if (territorio.getNome().equals(terr)) {
				territorio.addTropas(qtd);
			}
		}

	}

}
