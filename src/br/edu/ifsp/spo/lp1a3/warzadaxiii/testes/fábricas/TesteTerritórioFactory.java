package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.f�bricas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.f�bricas.Territ�rioFactory;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.Territ�rioRepository;

public class TesteTerrit�rioFactory {

	@Test
	public void devo_conseguir_criar_os_territ�rios_pelo_txt() throws Exception {
		//1. Configura��o
		Territ�rio brasil = new Territ�rio("Brasil");
		
		//2. Execu��o
		Territ�rioFactory.buildarTerrit�rios();
		
		//3. Valida��o / Asser��o
		assertEquals(brasil, Territ�rioRepository.pegarTerrit�rio("Brasil"));
	}
	
}
