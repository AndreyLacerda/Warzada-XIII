package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.localização;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class TesteContinente {
	
	@Test
	public void devo_conseguir_criar_continente() {
		//1. Configuração
		String nome = "Europa";
		
		//2. Execução
		Continente europa = new Continente(nome);
		
		//3. Validação / Asserção 
		assertEquals(nome, europa.getNome());
		assertEquals(null, europa.getDominador());
		
	}
	
	@Test
	public void devo_conseguir_add_país() {
		//1. Configuração
		String nomePaís = "Brasil";
		
		Território brasil = new Território(nomePaís);
		
		Set<Território> países = new HashSet<Território>();
		String nome = "Europa";

		//2. Execução
		Continente europa = new Continente(nome);

		europa.addPaís(brasil);
		países.add(brasil);
		
		//3. Validação / Asserção
		assertEquals(países, europa.getPaíses());
		
	}
	
	@Test
	public void devo_conseguir_checar_se_um_país_faz_parte_do_continente() {
		String nomePaís2 = "Argentina";
		String nomePaís = "Brasil";
		
		Território brasil = new Território(nomePaís);
		Território argentina = new Território(nomePaís2);
		
		String nome = "Europa";

		//2. Execução
		Continente europa = new Continente(nome);

		europa.addPaís(brasil);
		
		//3. Validação / Asserção
		assertEquals(true, europa.checarPaís(brasil));
		assertFalse(europa.checarPaís(argentina));
		
	}

	
	@Test
	public void devo_conseguir_atualizar_dominador_continente() {
		//1. Configuração
		String nome1 = "Europa";
		Player dominador = new Player(1, true, 10);
		
		Continente europa = new Continente(nome1);
		
		//2. Execução
		europa.updateDominador(dominador);
		
		//3. Validação / Asserção
		assertEquals(dominador, europa.getDominador());
		
	}
}
