package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import java.io.IOException;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.TerritórioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
	public Label mensagem, tropasAtuais;
	
	private int tropasNovas;
	
	@FXML
	public void initialize() {
		tropasAtuais.setText("");
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
	
	public void distribuirAction(ActionEvent event) throws IOException {
		if (paises.getValue() == null || qtd.getValue() == null) {
			mensagem.setText("Por favor selecione uma quantidade e um país!");
			mensagem.setTextFill(Color.web("#d61010"));
		} else {
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
				mensagem.setTextFill(Color.web("#108d22"));
				Território pais = TerritórioRepository.pegarTerritório(paises.getValue());
				tropasAtuais.setText("Possui "+pais.getTropas()+" tropa(as) no momento");
			} else {
				mensagem.setText("");
				Stage stage = (Stage) distribuir.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("Ataque.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			}
		}
	}
	
	public void cleanMensagem(ActionEvent event) {
		mensagem.setText("");
	}
	
	public void setTropasAtuais(ActionEvent event) {
		Território pais = TerritórioRepository.pegarTerritório(paises.getValue());
		tropasAtuais.setText("Possui "+pais.getTropas()+" tropa(as) no momento");
	}
}
