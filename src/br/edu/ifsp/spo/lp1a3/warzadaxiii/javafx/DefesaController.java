package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import java.io.IOException;
import java.util.ArrayList;

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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DefesaController {
	
	private Território defensor;
	private Território atacante;
	private Integer qtdAtaque;
	
	@FXML
	public Label playerLabel, mensagem, error, ataque;
	
	@FXML
	public ComboBox<Integer> qtd;
	
	@FXML
	public Button defender;
	
	public void setLabels(Território defensor, Território atacante, Integer qtd) throws IOException {
		this.qtdAtaque = qtd;
		this.atacante = atacante;
		this.defensor = defensor;
		if (defensor.getDominador() != null) {
			playerLabel.setText("O Player "+defensor.getDominador().getNumero()+" está sobre ataque");
			mensagem.setText("Defender "+defensor.getNome()+" usando quantas tropas?");
			ataque.setText("(O ataque está usando "+qtd+" tropas)");
			setQtd();
		}
	}
	
	private void setQtd() {
		int qtdUsavel = 1;
		while (qtdUsavel <= 3 && qtdUsavel <= defensor.getTropas()) {
			qtd.getItems().add(qtdUsavel);
			qtdUsavel += 1;
		}
	}
	
	public void defender(ActionEvent event) throws IOException {
		if (qtd.getValue() == null) {
			error.setText("Por favor selecione com quantas tropas irá defender");
			error.setTextFill(Color.web("#d61010"));
		} else {
			error.setText("");
			ArrayList <Integer> resultado = GerenciadorPartidas.ataqueDefesa(atacante, defensor, qtdAtaque, qtd.getValue());
			Stage stage = (Stage) defender.getScene().getWindow();
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
