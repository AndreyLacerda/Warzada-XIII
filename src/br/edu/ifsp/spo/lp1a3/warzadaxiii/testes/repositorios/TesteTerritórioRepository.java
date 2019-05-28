package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.repositorios;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.Territ�rioRepository;

public class TesteTerrit�rioRepository {
	
	@Test
	public void devo_conseguir_add_um_territ�rio() {
		//1. Configura��o
		Territ�rio brasil = new Territ�rio("Brasil");
		
		//2. Execu��o
		Territ�rioRepository.addTerrit�rio(brasil);
		
		//3. Valida��o / Asser��o
		assertEquals(1, Territ�rioRepository.getTerrit�rios().size());
	}
	
	@Test
	public void devo_conseguir_pegar_territ�rio_pelo_nome() {
		//1. Configura��o
		String nome = "brasil";
		String nome2 = "argentina";
		Territ�rio brasil = new Territ�rio(nome);
		Territ�rioRepository.addTerrit�rio(brasil);
		
		//2. Execu��o
		Territ�rio assercao = Territ�rioRepository.pegarTerrit�rio(nome);
		Territ�rio assercao2 = Territ�rioRepository.pegarTerrit�rio(nome2);
		
		//3. Valida��o / Asser��o
		assertEquals(assercao.getNome(), brasil.getNome());
		assertEquals(null, assercao2);
	
	}

}
