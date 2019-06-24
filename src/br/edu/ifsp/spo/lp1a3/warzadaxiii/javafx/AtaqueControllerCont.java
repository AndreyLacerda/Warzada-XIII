package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import java.io.IOException;
import java.util.ArrayList;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.TerritórioRepository;
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

public class AtaqueControllerCont {
	
	@FXML
	public Label playerLabel, mensagem, error;
	
	@FXML
	public ComboBox<String> atacantes, atacados;
	
	@FXML
	public ComboBox<Integer> qtd;
	
	@FXML
	public Button atacar, passar;
	
	@FXML
	public void initialize() {
		playerLabel.setText("Player "+GerenciadorPartidas.getPlayerAtual().getNumero());
		atacantes.getItems().clear();
		qtd.getItems().clear();
		atacados.getItems().clear();
		error.setText("Você já atacou, e agora pode atacar de novo ou passar para a etapa de movimentação de tropas!");
		error.setTextFill(Color.web("#108d22"));
		setarAtacados();
	}
	
	private void setarAtacados() {
		atacantes.getItems().clear();
		qtd.getItems().clear();
		for (Território pais : GerenciadorPartidas.getPlayerAtual().getTerritorios()) {
			if (pais.getTropas() > 1) {
				for (Território vizinho : pais.getFronteira()) {
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
		Território pais = TerritórioRepository.pegarTerritório(atacados.getValue());
		mensagem.setText("Possui "+pais.getTropas()+" tropa(as) no momento");
		
		for (Território vizinho : pais.getFronteira()) {
			if (vizinho.getDominador() == GerenciadorPartidas.getPlayerAtual() && vizinho.getTropas() > 1) {
				atacantes.getItems().add(vizinho.getNome());
			}
		}
	}
	
	public void setarQtd(ActionEvent event) {
		if (atacantes.getValue() != null) {
			qtd.getItems().clear();
			Território pais = TerritórioRepository.pegarTerritório(atacantes.getValue());
			Integer qtdUsavel = 1;
			while (qtdUsavel < pais.getTropas() && qtdUsavel <= 3) {
				qtd.getItems().add(qtdUsavel);
				qtdUsavel += 1;
			}
		}
	}
	
	
	public void atacar(ActionEvent event) throws IOException {
		if (atacantes.getValue() == null || atacados.getValue() == null || qtd.getValue() == null) {
			error.setText("Por favor selecione um país atacado, um atacante, e as tropas");
			error.setTextFill(Color.web("#d61010"));
		} else {
			error.setText("");
			Território atacante = TerritórioRepository.pegarTerritório(atacantes.getValue());
			Território defensor = TerritórioRepository.pegarTerritório(atacados.getValue());
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