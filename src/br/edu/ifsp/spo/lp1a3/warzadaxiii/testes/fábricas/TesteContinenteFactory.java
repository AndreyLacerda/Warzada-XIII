package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.f�bricas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.f�bricas.ContinenteFactory;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.ContinenteRepository;

public class TesteContinenteFactory {
	
	@Test
	public void devo_conseguir_crir_continente_pelo_txt() {
		//1. Configura��o
		Continente europa = new Continente("Europa");
		
		//2. Execu��o
		ContinenteFactory.buildarContinentes();
				
		//3. Valida��o / Asser��o
		assertEquals(europa, ContinenteRepository.pegarContinente("Europa"));
		
	}

}
