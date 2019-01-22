package model.persistencia.Perguntas;

import model.ClasseDeCaminhos;

public class ArquivosEsportes extends ArquivosPerguntas{
	
	private static String caminhoFaceis = ClasseDeCaminhos.getCaminhoEsporteFaceis();
	private static String caminhoMedias = ClasseDeCaminhos.getCaminhoEsporteMedias();
	private static String caminhoDificeis = ClasseDeCaminhos.getCaminhoEsporteDificeis();
	private static String caminhoMuitoDificeis = ClasseDeCaminhos.getCaminhoEsporteMuitoDificeis();
	
	public ArquivosEsportes() throws Exception{
		super(caminhoFaceis, caminhoMedias, caminhoDificeis, caminhoMuitoDificeis);
		
		
	}


}
