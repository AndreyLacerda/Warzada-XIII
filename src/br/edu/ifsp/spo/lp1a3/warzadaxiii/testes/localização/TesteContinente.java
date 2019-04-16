package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.localiza��o;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class TesteContinente {
	
	@Test
	public void devo_conseguir_criar_continente() {
		//1. Configura��o
		String nome = "Europa";
		List<Territ�rio> pa�ses = new ArrayList<Territ�rio>();
		Player dominador = null;
		
		//2. Execu��o
		Continente europa = new Continente(nome, pa�ses, dominador);
		
		//3. Valida��o / Asser��o 
		assertEquals(nome, europa.getNome());
		assertEquals(pa�ses, europa.getPa�ses());
		assertEquals(dominador, europa.getDominador());
		
	}
	
	@Test
	public void devo_conseguir_add_pa�s() {
		//1. Configura��o
		String nomePa�s = "Brasil";
		Player dominador = null;
		int	qtd_tropas = 10;
		List<Territ�rio> fronteira = new ArrayList<Territ�rio>();
		
		Territ�rio brasil = new Territ�rio(nomePa�s, dominador, qtd_tropas, fronteira);
		
		List<Territ�rio> pa�ses = new ArrayList<Territ�rio>();
		String nome = "Europa";

		//2. Execu��o
		Continente europa = new Continente(nome, pa�ses, dominador);

		europa.addPa�s(brasil);
		pa�ses.add(brasil);
		
		//3. Valida��o / Asser��o
		assertEquals(pa�ses, europa.getPa�ses());
		
	}
	
	@Test
	public void devo_conseguir_checar_se_um_pa�s_faz_parte_do_continente() {
		String nomePa�s2 = "Argentina";
		String nomePa�s = "Brasil";
		Player dominador = null;
		int	qtd_tropas = 10;
		List<Territ�rio> fronteira = new ArrayList<Territ�rio>();
		
		Territ�rio brasil = new Territ�rio(nomePa�s, dominador, qtd_tropas, fronteira);
		Territ�rio argentina = new Territ�rio(nomePa�s2, dominador, qtd_tropas, fronteira);
		
		List<Territ�rio> pa�ses = new ArrayList<Territ�rio>();
		String nome = "Europa";

		//2. Execu��o
		Continente europa = new Continente(nome, pa�ses, dominador);

		europa.addPa�s(brasil);
		
		//3. Valida��o / Asser��o
		assertEquals(true, europa.checarPa�s(brasil));
		assertFalse(europa.checarPa�s(argentina));
		
	}
	
	
	

}
