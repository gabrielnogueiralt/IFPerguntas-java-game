package model.persistencia.Perguntas;

import model.ClasseDeCaminhos;

public class ArquivosFilmes extends ArquivosPerguntas{
	
	private static String caminhoFaceis = ClasseDeCaminhos.getCaminhoFilmesFaceis();
	private static String caminhoMedias = ClasseDeCaminhos.getCaminhoFilmesMedias();
	private static String caminhoDificeis = ClasseDeCaminhos.getCaminhoFilmesDificeis();
	private static String caminhoMuitoDificeis = ClasseDeCaminhos.getCaminhoFilmesMuitoDificeis();
	
	public ArquivosFilmes() throws Exception{
		super(caminhoFaceis, caminhoMedias, caminhoDificeis, caminhoMuitoDificeis);		
	}


}
