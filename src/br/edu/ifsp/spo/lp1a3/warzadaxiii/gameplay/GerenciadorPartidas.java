package br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.dado.Dado;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.f�bricas.ContinenteFactory;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.ContinenteRepository;

public abstract class GerenciadorPartidas {

	private static Set<Player> players = new HashSet<Player>();
	private static ArrayList<Player> playersArray = new ArrayList<Player>();
	private static int turnos;
	private static Player playerAtual;
	private static boolean rodando;
	private static int index;
	

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
		index = 0;
		setPlayerAtual();
	}
	
	public static void setPlayerAtual(){
		playerAtual = playersArray.get(index);
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
		DistribuidorTerrit�rios.distribuir(players);
		playersArray.addAll(players);
		setRodando(true);
	}

	public static int receberTropas(Player player) {
		int tropasNovas = player.getTerritorios().size() / 2;
		for (Continente continente : ContinenteRepository.getContinentes()) {
			if (continente.getDominador() != null && continente.getDominador().getNumero() == player.getNumero()) {
				if (continente.getNome().equals("Am�rica do Sul")) {
					tropasNovas += 2;
				} else if (continente.getNome().equals("Am�rica do Norte")) {
					tropasNovas += 5;
				} else if (continente.getNome().equals("Europa")) {
					tropasNovas += 5;
				} else if (continente.getNome().equals("�frica")) {
					tropasNovas += 3;
				} else if (continente.getNome().equals("�sia")) {
					tropasNovas += 7;
				} else if (continente.getNome().equals("Oceania")) {
					tropasNovas += 2;
				}
			}
		}
		if (tropasNovas == 0) {
			tropasNovas = 1;
		}
		player.addTropas(tropasNovas);
		return tropasNovas;
	}

	public static void distribuirTropasNovas(Player player, String terr, int qtd) {
		for (Territ�rio territorio : player.getTerritorios()) {
			if (territorio.getNome().equals(terr)) {
				territorio.addTropas(qtd);
			}
		}

	}
	
	public static void moverTropas(Territ�rio origem, Territ�rio destino, int qtd) {
		origem.removeTropas(qtd);
		destino.addTropas(qtd);
	}
	
	public static void passarVez() {
		index += 1;
		if (index >= players.size())
			index = 0;
		if (playersArray.get(index).getQtd_tropas() == 0)
			index += 1;
		if (index >= players.size())
			index = 0;
		if (index == 0) {
			turnos += 1;
		}
		setPlayerAtual();
	}
	
	public static void ataqueDefesa(Territ�rio atacante, Territ�rio defensor, int qtdAtaque, int qtdDefesa) {
		Dado dado = new Dado(6);
		atacante.getDominador().rolarDado(qtdAtaque, dado);
		defensor.getDominador().rolarDado(qtdDefesa, dado);
	}

}
