package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class NovosTerritoriosController {
	@FXML
	public AnchorPane opcoes;
	
	@FXML
	public Label playerLabel;
	
	@FXML
	public Button distribuir;
	
	@FXML
	public ComboBox<Integer> qtd;
	
	@FXML
	public ComboBox<String> paises;
	
	@FXML
	public Label mensagem;
	
	private int tropasNovas;
	
	@FXML
	public void initialize() {
		distribuirNovosTerritorios();
	}
	
	private void distribuirNovosTerritorios() {
		
			Player player = GerenciadorPartidas.getPlayerAtual();
			playerLabel.setText("Player "+player.getNumero());
			tropasNovas = GerenciadorPartidas.receberTropas(player);
			int qtdDistribuida = 1;
			
			while(qtdDistribuida <= tropasNovas) {
				qtd.getItems().add(qtdDistribuida);
				qtdDistribuida += 1;
			}
			
			for (Território pais : player.getTerritorios()) {
				paises.getItems().add(pais.getNome());
			}
	}
	
	public void distribuirAction(ActionEvent event) {
		if (paises.getValue() == null || qtd.getValue() == null) {
			mensagem.setText("Por favor selecione uma quantidade e um país!");
			mensagem.setTextFill(Color.web("#d61010"));
		}
		GerenciadorPartidas.distribuirTropasNovas(GerenciadorPartidas.getPlayerAtual(), paises.getValue(),qtd.getValue());
		tropasNovas -= qtd.getValue();
		if (tropasNovas != 0) {
			int qtdDistribuida = 1;
			qtd.getItems().clear();
			while(qtdDistribuida <= tropasNovas) {
				qtd.getItems().add(qtdDistribuida);
				qtdDistribuida += 1;
			}
			mensagem.setText("Você ainda possui tropas para distribuir. Continue distruibuindo entre seus países!");
		} else {
			mensagem.setText("");
		}
	}
	
	public void cleanMensagem(ActionEvent event) {
		mensagem.setText("");
	}
}
