package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import java.io.IOException;
import java.util.ArrayList;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.repositorios.Territ�rioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MoveController {

	@FXML
	public Label playerLabel, mensagem;
	
	@FXML
	public ComboBox<String> origem, destino;
	
	@FXML
	public ComboBox<Integer> qtd;
	
	@FXML
	public Button mover, passar;
	
	private ArrayList<String> paisMovidos = new ArrayList<String>();
	
	@FXML
	public void initialize() {
		setarOrigem();
	}
	
	private void setarOrigem() {
		playerLabel.setText("Player "+GerenciadorPartidas.getPlayerAtual().getNumero());
		origem.getItems().clear();
		destino.getItems().clear();
		qtd.getItems().clear();
		
		for(Territ�rio pais : GerenciadorPartidas.getPlayerAtual().getTerritorios()) {
			if (pais.getTropas() > 1 && !paisMovidos.contains(pais.getNome())) {
				origem.getItems().add(pais.getNome());
			}
		}
	}
	
	public void setarDestinoQtd(ActionEvent event) {
		int qtdUsavel = 1;
		qtd.getItems().clear();
		destino.getItems().clear();
		Territ�rio paisCerto = null;
		for (Territ�rio pais : GerenciadorPartidas.getPlayerAtual().getTerritorios()) {
			if (pais.getNome().equals(origem.getValue())) {
				paisCerto = pais;
				break;
			}
		}
		if (paisCerto != null) {
			for (Territ�rio vizinho : paisCerto.getFronteira()) {
				if (vizinho.getDominador() == GerenciadorPartidas.getPlayerAtual())
					destino.getItems().add(vizinho.getNome());
			}
			while (qtdUsavel < paisCerto.getTropas()) {
				qtd.getItems().add(qtdUsavel);
				qtdUsavel += 1;
			}
		}
	}
	
	public void mover(ActionEvent event) throws IOException {
		Territ�rio OrigemTerr = Territ�rioRepository.pegarTerrit�rio(origem.getValue());
		Territ�rio destinoTerr = Territ�rioRepository.pegarTerrit�rio(destino.getValue());
		GerenciadorPartidas.moverTropas(OrigemTerr, destinoTerr, qtd.getValue());
		mensagem.setText("Voc� moveu "+qtd.getValue()+" de "+origem.getValue()+
				" para "+destino.getValue()+"! Continue a mover tropas, ou passe sua vez");
		paisMovidos.add(destino.getValue());
		setarOrigem();
	}
	
	public void passar(ActionEvent event) throws IOException {
		paisMovidos.clear();
		GerenciadorPartidas.passarVez();
		Stage stage = (Stage) passar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("TelaInfoPartida.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
