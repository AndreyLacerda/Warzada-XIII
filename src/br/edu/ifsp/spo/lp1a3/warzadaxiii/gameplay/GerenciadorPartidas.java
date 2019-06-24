package br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.dado.Dado;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.dado.Rolagem;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.fábricas.ContinenteFactory;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.ContinenteRepository;

public abstract class GerenciadorPartidas {

	private static Set<Player> players = new HashSet<Player>();
	private static ArrayList<Player> playersArray = new ArrayList<Player>();
	private static Map<Player, Integer> recompensas = new HashMap<Player, Integer>();
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
		if (rodando == true) {
			setTurno(1);
			index = 0;
			setPlayerAtual();
		}
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
		if (tropasNovas == 0) {
			tropasNovas = 1;
		}
		
		if (recompensas.containsKey(playerAtual)) {
			tropasNovas = tropasNovas + recompensas.get(playerAtual);
			recompensas.remove(playerAtual);
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
	
	public static void moverTropas(Território origem, Território destino, int qtd) {
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
	
	public static ArrayList<Integer> ataqueDefesa(Território atacante, Território defensor, int qtdAtaque, int qtdDefesa) {
		Dado dado = new Dado(6);
		ArrayList<Integer> resultAtaque = atacante.getDominador().rolarDado(qtdAtaque, dado);
		ArrayList<Integer> resultDefesa;
		if (defensor.getDominador() != null)
			resultDefesa = defensor.getDominador().rolarDado(qtdDefesa, dado);
		else
			resultDefesa = Rolagem.rolar(dado, qtdDefesa);	
		int maiorDefesa = resultDefesa.get(0);
		int menorDefesa = resultDefesa.get(0);
		int meioDefesa = 0;
		
		int maiorAtaque = resultAtaque.get(0);
		int menorAtaque = resultAtaque.get(0);
		int meioAtaque = 0;
		
		if (qtdAtaque == 3) {
			int i = 0;
			while (i < resultAtaque.size()) {
				if (resultAtaque.get(i) > maiorAtaque)
					maiorAtaque = resultAtaque.get(i);
				else
					if (resultAtaque.get(i) < menorAtaque)
						menorDefesa = resultAtaque.get(i);
					else
						meioAtaque = resultAtaque.get(i);
				i += 1;
			}
		} else {
			if (qtdAtaque == 2) {
				if (resultAtaque.get(0) >= resultAtaque.get(1)) {
					maiorAtaque = resultAtaque.get(0);
					menorAtaque = resultAtaque.get(1);
				} else {
					maiorAtaque = resultAtaque.get(1);
					menorAtaque = resultAtaque.get(0);
				}
			} else {
				menorAtaque = 0;
			}
		}
		
		if (qtdDefesa == 3) {
			int i = 0;
			while (i < resultDefesa.size()) {
				if (resultDefesa.get(i) > maiorDefesa)
					maiorDefesa = resultDefesa.get(i);
				else
					if (resultDefesa.get(i) < menorDefesa)
						menorDefesa = resultDefesa.get(i);
					else
						meioDefesa = resultDefesa.get(i);
				i += 1;
			}
		} else {
			if (qtdDefesa == 2) {
				if (resultDefesa.get(0) >= resultDefesa.get(1)) {
					maiorDefesa = resultDefesa.get(0);
					menorDefesa = resultDefesa.get(1);
				} else {
					maiorDefesa = resultDefesa.get(1);
					menorDefesa = resultDefesa.get(0);
				}
			} else {
				menorDefesa = 0;
			}
		}
		resultAtaque.clear();
		resultDefesa.clear();
		resultAtaque.add(maiorAtaque);
		resultAtaque.add(meioAtaque);
		resultAtaque.add(menorAtaque);
		
		resultDefesa.add(maiorDefesa);
		resultDefesa.add(meioDefesa);
		resultDefesa.add(menorDefesa);
		
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		resultado.addAll(resultAtaque);
		resultado.addAll(resultDefesa);
		return resultado;
	}
	
	public static String consolidarBatalha(Território atacante, Território defensor, ArrayList<Integer> resultados) {
		int tropasPerdidasAtacante = 0;
		int tropasPerdidasDefensor = 0;
		boolean dominou = false;
		
		
		if (!resultados.contains(0)) {
			if (resultados.get(0) > resultados.get(3)) {
				defensor.removeTropas(1);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(1);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 1;
			} else {
				atacante.removeTropas(1);
				atacante.getDominador().removeTropas(1);
				tropasPerdidasAtacante += 1;
			}
			
			if (resultados.get(1) > resultados.get(4)) {
				defensor.removeTropas(1);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(1);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 1;
			} else {
				atacante.removeTropas(1);
				atacante.getDominador().removeTropas(1);
				tropasPerdidasAtacante += 1;
			}
			
			if (resultados.get(2) > resultados.get(5)) {
				defensor.removeTropas(1);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(1);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 1;
			} else {
				atacante.removeTropas(1);
				atacante.getDominador().removeTropas(1);
				tropasPerdidasAtacante += 1;
			}
		}
		
		if (resultados.get(2) != 0 && resultados.get(1) == 0 && resultados.get(4) == 0 && resultados.get(5) != 0) {
			if (resultados.get(0) > resultados.get(3)) {
				defensor.removeTropas(1);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(1);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 1;
			} else {
				atacante.removeTropas(1);
				atacante.getDominador().removeTropas(1);
				tropasPerdidasAtacante += 1;
			}
			
			if (resultados.get(2) > resultados.get(5)) {
				defensor.removeTropas(1);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(1);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 1;
			} else {
				atacante.removeTropas(1);
				atacante.getDominador().removeTropas(1);
				tropasPerdidasAtacante += 1;
			}
		}
		
		if (resultados.get(2) == 0 && resultados.get(1) == 0 && resultados.get(4) == 0 && resultados.get(5) == 0) {
			if (resultados.get(0) > resultados.get(3)) {
				defensor.removeTropas(1);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(1);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 1;
			} else {
				atacante.removeTropas(1);
				atacante.getDominador().removeTropas(1);
				tropasPerdidasAtacante += 1;
			}
		}
		
		if (resultados.get(1) == 0 && resultados.get(2) != 0 && resultados.get(4) == 0 && resultados.get(5) == 0) {
			if (resultados.get(0) > resultados.get(3)) {
				defensor.removeTropas(1);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(1);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 1;
			} else {
				atacante.removeTropas(2);
				atacante.getDominador().removeTropas(2);
				tropasPerdidasAtacante += 2;
			}
		}
		
		if (resultados.get(1) != 0 && resultados.get(2) != 0 && resultados.get(4) == 0 && resultados.get(5) == 0) {
			if (resultados.get(0) > resultados.get(3)) {
				defensor.removeTropas(1);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(1);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 1;
			} else {
				atacante.removeTropas(3);
				atacante.getDominador().removeTropas(3);
				tropasPerdidasAtacante += 3;
			}
		}
		
		if (resultados.get(1) == 0 && resultados.get(2) != 0 && resultados.get(4) != 0 && resultados.get(5) != 0) {
			if (resultados.get(0) > resultados.get(3)) {
				defensor.removeTropas(2);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(2);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 2;
			} else {
				atacante.removeTropas(1);
				atacante.getDominador().removeTropas(1);
				tropasPerdidasAtacante += 1;
			}
			
			if (resultados.get(2) > resultados.get(5)) {
				defensor.removeTropas(1);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(1);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 1;
			} else {
				atacante.removeTropas(1);
				atacante.getDominador().removeTropas(1);
				tropasPerdidasAtacante += 1;
			}
		}
		
		if (resultados.get(1) != 0 && resultados.get(4) == 0 && resultados.get(5) != 0) {
			if (resultados.get(0) > resultados.get(3)) {
				defensor.removeTropas(1);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(1);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 1;
			} else {
				atacante.removeTropas(2);
				atacante.getDominador().removeTropas(2);
				tropasPerdidasAtacante += 2;
			}
			
			if (resultados.get(2) > resultados.get(5)) {
				defensor.removeTropas(1);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(1);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 1;
			} else {
				atacante.removeTropas(1);
				atacante.getDominador().removeTropas(1);
				tropasPerdidasAtacante += 1;
			}
		}
		
		if (resultados.get(1) == 0 && resultados.get(2) == 0 && resultados.get(4) != 0 && resultados.get(5) != 0) {
			if (resultados.get(0) > resultados.get(3)) {
				defensor.removeTropas(3);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(3);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 3;
			} else {
				atacante.removeTropas(1);
				atacante.getDominador().removeTropas(1);
				tropasPerdidasAtacante += 1;
			}
		}
		
		if (resultados.get(1) == 0 && resultados.get(2) == 0 && resultados.get(4) == 0 && resultados.get(5) != 0) {
			if (resultados.get(0) > resultados.get(3)) {
				defensor.removeTropas(2);
				if (defensor.getDominador() != null)
					defensor.getDominador().removeTropas(2);
				if (defensor.getTropas() == 0) {
					defensor.updateDominador(atacante.getDominador());
					defensor.addTropas(1);
					atacante.removeTropas(1);
					dominou = true;
				}
				tropasPerdidasDefensor += 2;
			} else {
				atacante.removeTropas(1);
				atacante.getDominador().removeTropas(1);
				tropasPerdidasAtacante += 1;
			}
		}
		
		checharPartida();
		
		if (defensor.getTropas() == 0) {
			recompensas.put(atacante.getDominador(), getTurnos());
		}
		
		if (dominou == true) {
			if (defensor.getDominador() != null) {
				return "Resultado: Player "+atacante.getDominador().getNumero()+
						" perdeu "+tropasPerdidasAtacante+ " tropas e dominou "+defensor.getNome()+
						" do Player "+defensor.getDominador().getNumero();
			} else {
				return "Resultado: Player "+atacante.getDominador().getNumero()+
						" perdeu "+tropasPerdidasAtacante+ " tropas e dominou "+defensor.getNome();
			}
			
		} else {
			if (defensor.getDominador() != null) {
				return "Resultado: Player "+atacante.getDominador().getNumero()+
						" perdeu "+tropasPerdidasAtacante+ " tropas. Enquanto o Player "+
				defensor.getDominador().getNumero()+" perdeu "+tropasPerdidasDefensor+" tropas!";
			} else {
				return "Resultado: Player "+atacante.getDominador().getNumero()+
						" perdeu "+tropasPerdidasAtacante+ " tropas. Enquanto o Território perdeu "+tropasPerdidasDefensor+" tropas!";
			}
		}
	}
	
	private static void checharPartida() {
		int playersAtivos = 0;
		for(Player player : players) {
			if (player.isAtivo() == true) {
				playersAtivos+=1;
			}
		}
		if (playersAtivos == 1) {
			setRodando(false);
		}
	}
}