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
		ArrayList<Territ�rio> territ�riosDistribu�dos = new ArrayList<Territ�rio>();
		territ�riosDistribu�dos.clear();
		int qtdTerrit�rios = 42 / players.size();
		for (Player player : players) {
			int i = 0;
			while (i < qtdTerrit�rios) {
				Collections.shuffle(territ�rios);
				if (!territ�riosDistribu�dos.contains(territ�rios.get(i))) {
					player.adicionarDominio(territ�rios.get(i));
					player.addTropas(1);
					territ�rios.get(i).removeTropas(9);
					territ�riosDistribu�dos.add(territ�rios.get(i));
					i += 1;
				}
			}
		}
	}
}
