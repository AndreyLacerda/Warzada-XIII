package br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.Territ�rioRepository;

public abstract class DistribuidorTerrit�rios {

	private static ArrayList<Territ�rio> territ�rios = new ArrayList<Territ�rio>();

	public static void distribuir(Set<Player> players) {
		territ�rios.addAll(Territ�rioRepository.getTerrit�rios());

		int qtdTerrit�rios = 42 / players.size();

		for (Player player : players) {
			for (int i = 0; i < qtdTerrit�rios; i++) {
				if (territ�rios.size() <= i) {
					for (Territ�rio pais : territ�rios) {
						player.addTropas(1);
						player.adicionarDominio(pais);
						pais.removeTropas(9);
					}
					break;
				} else {
					Collections.shuffle(territ�rios);
					player.adicionarDominio(territ�rios.get(i));
					player.addTropas(1);
					territ�rios.get(i).removeTropas(9);
					territ�rios.remove(i);
				}
			}
		}
	}
}
