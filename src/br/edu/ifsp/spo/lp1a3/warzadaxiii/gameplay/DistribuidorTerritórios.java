package br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.TerritórioRepository;

public abstract class DistribuidorTerritórios {

	private static ArrayList<Território> territórios = new ArrayList<Território>();

	public static void distribuir(Set<Player> players) {
		territórios.addAll(TerritórioRepository.getTerritórios());

		int qtdTerritórios = 42 / players.size();

		for (Player player : players) {
			for (int i = 0; i < qtdTerritórios; i++) {
				if (territórios.size() <= i) {
					for (Território pais : territórios) {
						player.addTropas(1);
						player.adicionarDominio(pais);
						pais.removeTropas(9);
					}
					break;
				} else {
					Collections.shuffle(territórios);
					player.adicionarDominio(territórios.get(i));
					player.addTropas(1);
					territórios.get(i).removeTropas(9);
					territórios.remove(i);
				}
			}
		}
	}
}
