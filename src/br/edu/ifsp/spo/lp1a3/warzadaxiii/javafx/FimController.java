package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.player.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FimController {
	
	@FXML
	public Label congratulacoes;
	
	@FXML
	public Button sair;
	
	@FXML
	public void initialize() {
		for (Player player : GerenciadorPartidas.getPlayers()) {
			if (player.isAtivo() == true)
				congratulacoes.setText("Parabéns Player"+player.getNumero()+", você venceu!!");
		}
	}
	
	public void sair(ActionEvent event) {
		System.exit(0);
	}
}
