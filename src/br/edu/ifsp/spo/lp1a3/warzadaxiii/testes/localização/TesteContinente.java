package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.localização;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;

public class TesteContinente {
	
	@Test
	public void devo_conseguir_criar_continente() {
		//1. Configuração
		String nome = "Europa";
		List<Território> países = new ArrayList<Território>();
		Player dominador = null;
		
		//2. Execução
		Continente europa = new Continente(nome, países, dominador);
		
		//3. Validação / Asserção 
		assertEquals(nome, europa.getNome());
		assertEquals(países, europa.getPaíses());
		assertEquals(dominador, europa.getDominador());
		
	}
	
	@Test
	public void devo_conseguir_add_país() {
		//1. Configuração
		String nomePaís = "Brasil";
		Player dominador = null;
		int	qtd_tropas = 10;
		List<Território> fronteira = new ArrayList<Território>();
		
		Território brasil = new Território(nomePaís, dominador, qtd_tropas, fronteira);
		
		List<Território> países = new ArrayList<Território>();
		String nome = "Europa";

		//2. Execução
		Continente europa = new Continente(nome, países, dominador);

		europa.addPaís(brasil);
		países.add(brasil);
		
		//3. Validação / Asserção
		assertEquals(países, europa.getPaíses());
		
	}
	
	@Test
	public void devo_conseguir_checar_se_um_país_faz_parte_do_continente() {
		String nomePaís2 = "Argentina";
		String nomePaís = "Brasil";
		Player dominador = null;
		int	qtd_tropas = 10;
		List<Território> fronteira = new ArrayList<Território>();
		
		Território brasil = new Território(nomePaís, dominador, qtd_tropas, fronteira);
		Território argentina = new Território(nomePaís2, dominador, qtd_tropas, fronteira);
		
		List<Território> países = new ArrayList<Território>();
		String nome = "Europa";

		//2. Execução
		Continente europa = new Continente(nome, países, dominador);

		europa.addPaís(brasil);
		
		//3. Validação / Asserção
		assertEquals(true, europa.checarPaís(brasil));
		assertFalse(europa.checarPaís(argentina));
		
	}
	
	
	

}
