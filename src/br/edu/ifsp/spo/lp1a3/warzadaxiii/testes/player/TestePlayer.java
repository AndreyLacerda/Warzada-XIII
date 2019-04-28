package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class TestePlayer {
	
	@Test
	public void devo_conseguir_criar_player() {
		//1. Configuração
		int player = 1;
		boolean ativo = true;
		int qtd_tropas = 10;
		
		//2. Execução
		Player player1 = new Player(player, ativo, qtd_tropas);
		
		//3. Validação / Asserção
		assertEquals(player, player1.getNumero());
		assertEquals(qtd_tropas, player1.getQtd_tropas());
		assertTrue(player1.isAtivo());
	}
	
	@Test
	public void devo_conseguir_add_território_ao_player() {
		//1. Configuração
		Player player = new Player(1, true, 10);
		Território brasil = new Território("Brasil", player, 10);
		
		//2. Execução
		player.adicionarDominio(brasil);
		
		//3. Validação / Asserção
		assertTrue(player.dominaTerritorio(brasil));
		
	}
	
	@Test
	public void devo_conseguir_remover_território_ao_player() {
		//1. Configuração
		Player player = new Player(1, true, 10);
		Território argentina = new Território("Argentina", player, 10);
		Território brasil = new Território("Brasil", player, 10);
		player.adicionarDominio(brasil);
		
		//2. Execução
		player.removerDominio(brasil);
		
		//3. Validação / Asserção
		assertFalse(player.dominaTerritorio(brasil));
		
	}
	
}
