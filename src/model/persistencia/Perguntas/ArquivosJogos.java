package model.persistencia.Perguntas;

import model.ClasseDeCaminhos;

public class ArquivosJogos extends ArquivosPerguntas{
	

	private static String caminhoFaceis = ClasseDeCaminhos.getCaminhoJogosFaceis();
	private static String caminhoMedias = ClasseDeCaminhos.getCaminhoJogosMedias();
	private static String caminhoDificeis = ClasseDeCaminhos.getCaminhoJogosDificeis();
	private static String caminhoMuitoDificeis = ClasseDeCaminhos.getCaminhoJogosMuitoDificeis();
	
	public ArquivosJogos() throws Exception{
		super(caminhoFaceis, caminhoMedias, caminhoDificeis, caminhoMuitoDificeis);		
	}

}
