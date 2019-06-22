package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import java.io.IOException;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AtaqueController {
	
	@FXML
	public Label playerLabel;
	
	@FXML
	public ComboBox<String> atacantes, atacados;
	
	@FXML
	public ComboBox<Integer> qtd;
	
	@FXML
	public Button atacar, passar;
	
	@FXML
	public void initialize() {
		playerLabel.setText("Player "+GerenciadorPartidas.getPlayerAtual().getNumero());
		setarAtacados();
	}
	
	private void setarAtacados() {
		for (Território pais : GerenciadorPartidas.getPlayerAtual().getTerritorios()) {
			for (Território vizinho : pais.getFronteira()) {
				atacados.getItems().add(vizinho.getNome());
			}
		}
	}
	
	
	public void atacar(ActionEvent event) {
		
	}
	
	public void passar(ActionEvent event) throws IOException {
		Stage stage = (Stage) passar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("Move.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
