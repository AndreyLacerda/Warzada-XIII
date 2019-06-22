package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SetPlayersController{
	
	@FXML
	private ChoiceBox<Integer> players;
	
	@FXML
	private Button startar;
	
	ObservableList<Integer> list = FXCollections.observableArrayList();
	
	private void loadData() {
		list.removeAll(list);
		Integer a = 3;
		Integer b = 4;
		Integer c = 5;
		Integer d = 6;
		list.addAll(a, b, c, d);
		players.getItems().addAll(list);
	}
	
	@FXML
	public void initialize() {
		loadData();
		players.setValue(3);
	}
	
	public void startar(ActionEvent event) throws IOException {
		GerenciadorPartidas.setarPlayer(players.getValue());

		Stage stage = (Stage) startar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("TelaInfoPartida.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
		
}
