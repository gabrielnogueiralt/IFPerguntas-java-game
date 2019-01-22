package model.persistencia.Jogadores;

import model.ClasseDeCaminhos;

public class ArquivoJogadoresPartidaAtual extends ArquivoJogadores{

	public ArquivoJogadoresPartidaAtual() {
		super(ClasseDeCaminhos.getCaminhoRankingAtual());
	}

}
