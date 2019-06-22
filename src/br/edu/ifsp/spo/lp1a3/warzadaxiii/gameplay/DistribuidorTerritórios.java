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
		ArrayList<Território> territóriosDistribuídos = new ArrayList<Território>();
		territóriosDistribuídos.clear();
		int qtdTerritórios = 42 / players.size();
		for (Player player : players) {
			int i = 0;
			while (i < qtdTerritórios) {
				Collections.shuffle(territórios);
				if (!territóriosDistribuídos.contains(territórios.get(i))) {
					player.adicionarDominio(territórios.get(i));
					player.addTropas(1);
					territórios.get(i).removeTropas(9);
					territóriosDistribuídos.add(territórios.get(i));
					i += 1;
				}
			}
		}
	}
}
