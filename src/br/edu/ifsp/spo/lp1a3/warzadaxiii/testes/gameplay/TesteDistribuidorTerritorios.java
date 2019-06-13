package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.gameplay;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.f�bricas.ContinenteFactory;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.DistribuidorTerrit�rios;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class TesteDistribuidorTerritorios {

	@Test
	public void devo_conseguir_distribuir_territorios_para_cada_player() {
		//1. Configura��o
		//2. Execu��o
		GerenciadorPartidas.setarPlayer(6);
		
		//3. Valida��o / Asser��o
		for (Player player : GerenciadorPartidas.getPlayers()) {
			assertEquals (player.getTerritorios().size(), 7);
		}
	}
}
