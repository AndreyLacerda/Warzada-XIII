package br.edu.ifsp.spo.lp1a3.warzadaxiii.testes.fábricas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.fábricas.TerritórioFactory;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.TerritórioRepository;

public class TesteTerritórioFactory {

	@Test
	public void devo_conseguir_criar_os_territórios_pelo_txt() throws Exception {
		//1. Configuração
		Território brasil = new Território("Brasil");
		
		//2. Execução
		TerritórioFactory.buildarTerritórios();
		
		//3. Validação / Asserção
		assertEquals(brasil, TerritórioRepository.pegarTerritório("Brasil"));
	}
	
}
