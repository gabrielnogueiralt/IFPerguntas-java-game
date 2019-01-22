package model.persistencia.Perguntas;

import model.ClasseDeCaminhos;

public class ArquivosSeries extends ArquivosPerguntas{
	
	private static String caminhoFaceis = ClasseDeCaminhos.getCaminhoSeriesFaceis();
	private static String caminhoMedias = ClasseDeCaminhos.getCaminhoSeriesMedias();
	private static String caminhoDificeis = ClasseDeCaminhos.getCaminhoSeriesDificeis();
	private static String caminhoMuitoDificeis = ClasseDeCaminhos.getCaminhoSeriesMuitoDificeis();
	
	public ArquivosSeries() throws Exception{
		super(caminhoFaceis, caminhoMedias, caminhoDificeis, caminhoMuitoDificeis);		
	}

}
