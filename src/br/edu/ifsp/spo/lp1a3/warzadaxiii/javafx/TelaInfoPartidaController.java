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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaInfoPartidaController {
	
	@FXML
	public AnchorPane opcoes;
	
	@FXML
	public Button comecar;
	
	@FXML
	public Label turno;
	
	@FXML
	public void initialize() {
		comecar.setText("Começar");
		turno.setText("Turno "+GerenciadorPartidas.getTurnos());
		showPlayerPaises();
	}
	
	private void showPlayerPaises() {
		
		for (Player player : GerenciadorPartidas.getPlayers()) {
			double posLabel = 170;
			double posChoice = 190;
			posLabel += 80*(player.getNumero()-1);
			posChoice += 80*(player.getNumero()-1);
			Label playerLabel = new Label("Player "+player.getNumero());
			playerLabel.setLayoutX(165);
			playerLabel.setLayoutY(posLabel);
			ChoiceBox paises = new ChoiceBox();
			paises.setLayoutX(80);
			paises.setLayoutY(posChoice);
			paises.setPrefWidth(212);
			paises.setPrefHeight(25);
			for (Território pais : player.getTerritorios()) {
				paises.getItems().add((pais.getNome()+" - "+pais.getTropas()+" Tropas"));
			}
			opcoes.getChildren().addAll(playerLabel, paises);
		}
		Label neutrosLabel = new Label ("Neutros:");
		neutrosLabel.setLayoutX(165);
		neutrosLabel.setLayoutY(170+80*(GerenciadorPartidas.getPlayers().size()));
		ChoiceBox neutros = new ChoiceBox();
		neutros.setLayoutX(80);
		neutros.setLayoutY(190+80*(GerenciadorPartidas.getPlayers().size()));
		neutros.setPrefWidth(212);
		neutros.setPrefHeight(25);
		for (Território pais : TerritórioRepository.getTerritórios()) {
			if (pais.getDominador() == null) {
				neutros.getItems().add((pais.getNome()+" - "+pais.getTropas()+" Tropas"));
			}
		}
		opcoes.getChildren().addAll(neutrosLabel, neutros);
		comecar.setLayoutX(155);
		comecar.setLayoutY(170+80*(GerenciadorPartidas.getPlayers().size()+1));
	}
	
	public void comecarMethod(ActionEvent event) throws IOException {
		Stage stage = (Stage) comecar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("NovosTerritorios.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}