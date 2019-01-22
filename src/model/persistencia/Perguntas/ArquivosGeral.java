package model.persistencia.Perguntas;

import model.ClasseDeCaminhos;

public class ArquivosGeral extends ArquivosPerguntas{
	

	private static String caminhoFaceis = ClasseDeCaminhos.getCaminhoGeraisFaceis();
	private static String caminhoMedias = ClasseDeCaminhos.getCaminhoGeraisMedias();
	private static String caminhoDificeis = ClasseDeCaminhos.getCaminhoGeraisDificeis();
	private static String caminhoMuitoDificeis = ClasseDeCaminhos.getCaminhoGeraisMuitoDificeis();
	
	public ArquivosGeral() throws Exception{
		super(caminhoFaceis, caminhoMedias, caminhoDificeis, caminhoMuitoDificeis);		
	}
	
}
