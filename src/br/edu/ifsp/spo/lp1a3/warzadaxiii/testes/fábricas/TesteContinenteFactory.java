package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.fábricas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.fábricas.ContinenteFactory;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Continente;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.ContinenteRepository;

public class TesteContinenteFactory {
	
	@Test
	public void devo_conseguir_crir_continente_pelo_txt() {
		//1. Configuração
		Continente europa = new Continente("Europa");
		
		//2. Execução
		ContinenteFactory.buildarContinentes();
				
		//3. Validação / Asserção
		assertEquals(europa, ContinenteRepository.pegarContinente("Europa"));
		
	}

}
