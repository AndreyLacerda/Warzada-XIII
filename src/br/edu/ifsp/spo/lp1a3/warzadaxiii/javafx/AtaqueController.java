package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import java.io.IOException;
import java.util.ArrayList;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.Territ�rioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AtaqueController {
	
	@FXML
	public Label playerLabel, mensagem, error;
	
	@FXML
	public ComboBox<String> atacantes, atacados;
	
	@FXML
	public ComboBox<Integer> qtd;
	
	@FXML
	public Button atacar;
	
	@FXML
	public void initialize() {
		playerLabel.setText("Player "+GerenciadorPartidas.getPlayerAtual().getNumero());
		atacantes.getItems().clear();
		qtd.getItems().clear();
		atacados.getItems().clear();
		setarAtacados();
	}
	
	private void setarAtacados() {
		atacantes.getItems().clear();
		qtd.getItems().clear();
		for (Territ�rio pais : GerenciadorPartidas.getPlayerAtual().getTerritorios()) {
			if (pais.getTropas() > 1) {
				for (Territ�rio vizinho : pais.getFronteira()) {
					if (vizinho .getDominador() == null) {
						if (!atacados.getItems().contains(vizinho.getNome())) {
							atacados.getItems().add(vizinho.getNome());
						}
					} else {
						if (vizinho.getDominador() != GerenciadorPartidas.getPlayerAtual()) {
							if (!atacados.getItems().contains(vizinho.getNome())) {
								atacados.getItems().add(vizinho.getNome());
							}
						}
					}
				}
			}
		}
	}
	
	public void setarAtacantesMensagem(ActionEvent event) {
		atacantes.getItems().clear();
		qtd.getItems().clear();
		Territ�rio pais = Territ�rioRepository.pegarTerrit�rio(atacados.getValue());
		mensagem.setText("Possui "+pais.getTropas()+" tropa(as) no momento");
		
		for (Territ�rio vizinho : pais.getFronteira()) {
			if (vizinho.getDominador() == GerenciadorPartidas.getPlayerAtual() && vizinho.getTropas() > 1) {
				atacantes.getItems().add(vizinho.getNome());
			}
		}
	}
	
	public void setarQtd(ActionEvent event) {
		if (atacantes.getValue() != null) {
			qtd.getItems().clear();
			Territ�rio pais = Territ�rioRepository.pegarTerrit�rio(atacantes.getValue());
			Integer qtdUsavel = 1;
			while (qtdUsavel < pais.getTropas() && qtdUsavel <= 3) {
				qtd.getItems().add(qtdUsavel);
				qtdUsavel += 1;
			}
		}
	}
	
	
	public void atacar(ActionEvent event) throws IOException {
		if (atacantes.getValue() == null || atacados.getValue() == null || qtd.getValue() == null) {
			error.setText("Por favor selecione um pa�s atacado, um atacante, e as tropas");
			error.setTextFill(Color.web("#d61010"));
		} else {
			error.setText("");
			Territ�rio atacante = Territ�rioRepository.pegarTerrit�rio(atacantes.getValue());
			Territ�rio defensor = Territ�rioRepository.pegarTerrit�rio(atacados.getValue());
			if (defensor.getDominador() != null) {
				((Node)event.getSource()).getScene().getWindow().hide();
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("Defesa.fxml").openStream());
				DefesaController defesa = (DefesaController)loader.getController();
				defesa.setLabels(defensor, atacante, qtd.getValue());
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			} else {
				ArrayList <Integer> resultado = GerenciadorPartidas.ataqueDefesa(atacante, defensor, qtd.getValue(), 1);
				((Node)event.getSource()).getScene().getWindow().hide();
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("ResultadoBatalha.fxml").openStream());
				ResultadoBatalhaController resultController = (ResultadoBatalhaController)loader.getController();
				resultController.setLabels(atacante, defensor, resultado);
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			}
		}
	}
}