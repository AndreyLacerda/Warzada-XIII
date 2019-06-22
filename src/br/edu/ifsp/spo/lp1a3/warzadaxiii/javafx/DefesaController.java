package br.edu.ifsp.spo.lp1a3.warzadaxiii.javafx;

import br.edu.ifsp.spo.lp1a3.warzadaxiii.gameplay.GerenciadorPartidas;
import br.edu.ifsp.spo.lp1a3.warzadaxiii.localiza��o.Territ�rio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class DefesaController {
	
	private Territ�rio defensor;
	private Territ�rio atacante;
	private Integer qtdAtaque;
	
	@FXML
	public Label playerLabel, mensagem, error, ataque;
	
	@FXML
	public ComboBox<Integer> qtd;
	
	@FXML
	public Button defender;
	
	public void setLabels(Territ�rio defensor, Territ�rio atacante, Integer qtd) {
		this.qtdAtaque = qtd;
		this.atacante = atacante;
		this.defensor = defensor;
		playerLabel.setText("O Player "+defensor.getDominador().getNumero()+" est� sobre ataque");
		mensagem.setText("Defender "+defensor.getNome()+" usando quantas tropas?");
		ataque.setText("(O ataque est� usando "+qtd+" tropas)");
		setQtd();
	}
	
	private void setQtd() {
		int qtdUsavel = 1;
		while (qtdUsavel <= 3 && qtdUsavel <= defensor.getTropas()) {
			qtd.getItems().add(qtdUsavel);
			qtdUsavel += 1;
		}
	}
	
	public void defender(ActionEvent event) {
		if (qtd.getValue() == null) {
			error.setText("Por favor selecione com quantas tropas ir� defender");
			error.setTextFill(Color.web("#d61010"));
		} else {
			error.setText("");
			GerenciadorPartidas.ataqueDefesa(atacante, defensor, qtdAtaque, qtd.getValue());
		}
	}
	
}
