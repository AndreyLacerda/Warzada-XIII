package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.localiza��o;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class TesteContinente {
	
	@Test
	public void devo_conseguir_criar_continente() {
		//1. Configura��o
		String nome = "Europa";
		
		//2. Execu��o
		Continente europa = new Continente(nome);
		
		//3. Valida��o / Asser��o 
		assertEquals(nome, europa.getNome());
		assertEquals(null, europa.getDominador());
		
	}
	
	@Test
	public void devo_conseguir_add_pa�s() {
		//1. Configura��o
		String nomePa�s = "Brasil";
		
		Territ�rio brasil = new Territ�rio(nomePa�s);
		
		Set<Territ�rio> pa�ses = new HashSet<Territ�rio>();
		String nome = "Europa";

		//2. Execu��o
		Continente europa = new Continente(nome);

		europa.addPa�s(brasil);
		pa�ses.add(brasil);
		
		//3. Valida��o / Asser��o
		assertEquals(pa�ses, europa.getPa�ses());
		
	}
	
	@Test
	public void devo_conseguir_checar_se_um_pa�s_faz_parte_do_continente() {
		String nomePa�s2 = "Argentina";
		String nomePa�s = "Brasil";
		
		Territ�rio brasil = new Territ�rio(nomePa�s);
		Territ�rio argentina = new Territ�rio(nomePa�s2);
		
		String nome = "Europa";

		//2. Execu��o
		Continente europa = new Continente(nome);

		europa.addPa�s(brasil);
		
		//3. Valida��o / Asser��o
		assertEquals(true, europa.checarPa�s(brasil));
		assertFalse(europa.checarPa�s(argentina));
		
	}

	
	@Test
	public void devo_conseguir_atualizar_dominador_continente() {
		//1. Configura��o
		String nome1 = "Europa";
		Player dominador = new Player(1, true, 10);
		
		Continente europa = new Continente(nome1);
		
		//2. Execu��o
		europa.updateDominador(dominador);
		
		//3. Valida��o / Asser��o
		assertEquals(dominador, europa.getDominador());
		
	}
}
