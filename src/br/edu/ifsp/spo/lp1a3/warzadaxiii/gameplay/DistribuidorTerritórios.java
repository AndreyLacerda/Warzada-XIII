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
			if (territórios.size() == 7 && qtdTerritórios == 7) {
				int j = 0;
				while (j < 7) {
					player.adicionarDominio(territórios.get(j));
					j += 1;
				}
			} else {
				for (int i = 0; i < qtdTerritórios; i++) {
					Collections.shuffle(territórios);
					player.adicionarDominio(territórios.get(i));
					territórios.remove(i);
				}
			}
		}
	}
}
