package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import java.io.IOException;
import java.util.ArrayList;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localização.Território;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ResultadoBatalhaController {

	@FXML
	public AnchorPane tela;
	
	@FXML
	public Label atacanteLabel, defensorLabel, mensagem;
	
	@FXML
	public Button voltar;
	
	private ArrayList<Integer> resultados;
	
	public void setLabels(Território atacante, Território defensor, ArrayList<Integer> resultados) {
		atacanteLabel.setText("Player "+atacante.getDominador().getNumero());
		defensorLabel.setText("Player "+defensor.getDominador().getNumero());
		this.resultados = resultados;
		setarResults();
		String consolidacao = GerenciadorPartidas.consolidarBatalha(atacante, defensor, resultados);
		mensagem.setText(consolidacao);
	}
	
	private void setarResults() {
		double posYAtacante = 119;
		double posYDefensor = 119; 
		for (int i = 0; i < resultados.size(); i++) {
			if (resultados.get(i) != 0) {
				if (i < 3) {
					Label result = new Label("Tirou "+resultados.get(i));
					result.setLayoutX(111);
					result.setLayoutY(posYAtacante);
					posYAtacante += 23;
					tela.getChildren().add(result);
				} else {
					Label result = new Label("Tirou "+resultados.get(i));
					result.setLayoutX(324);
					result.setLayoutY(posYDefensor);
					posYAtacante += 23;
					tela.getChildren().add(result);
				}
			}
		}
	}
	
	public void voltar(ActionEvent event) throws IOException {
		if (GerenciadorPartidas.isRodando() == false) {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("Fim.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} else {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("AtaqueCont.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		}
	}
}