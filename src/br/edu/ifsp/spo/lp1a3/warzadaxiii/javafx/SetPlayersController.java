package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class SetPlayersController implements Initializable{
	
	@FXML
	private ChoiceBox<Integer> players;
	
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadData();
		players.setValue(3);
	}
	
	public void startar(ActionEvent event) {
		
	}
		
}
