package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainScreenController extends Application{
	
	@FXML
	private javafx.scene.control.Button sair;
	
	@FXML
	private javafx.scene.control.Button iniciar;
	
	public static void main (String args[]) {
		launch();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML
	public void close(ActionEvent event) {
		Stage stage = (Stage) sair.getScene().getWindow();
	    stage.close();
	}
	
	@FXML public void iniciar(ActionEvent event) throws IOException {
		Stage stage = (Stage) iniciar.getScene().getWindow();
		Pane tela = FXMLLoader.load(getClass().getResource("SetPlayers.fxml"));
		Scene scene = new Scene(tela);
		stage.setScene(scene);
	}
	
}
