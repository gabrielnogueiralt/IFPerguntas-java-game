package model.persistencia.Jogadores;

import model.ClasseDeCaminhos;

public class ArquivoJogadoresGeral extends ArquivoJogadores{

	public ArquivoJogadoresGeral() {
		super(ClasseDeCaminhos.getCaminhoRankingGeral());
	}

}
