package model;

public class ClasseDeCaminhos {
	
	private static String caminhoRelativo = System.getProperty("user.dir") +  "\\" + "Arquivos\\";
	
	private static String pastaRankings = "Rankings\\";
	private static String caminhoPartidaGeral = caminhoRelativo + pastaRankings + "jogadores_partida_geral.arq";	
	private static String caminhoPartidaAtual = caminhoRelativo + pastaRankings + "jogadores_partida_atual.arq";
	
	private static String pastaPerguntas = "Perguntas\\";
	private static String caminhoEsporteFaceis = caminhoRelativo + pastaPerguntas + "esportes_faceis.txt";
	private static String caminhoEsporteMedias = caminhoRelativo + pastaPerguntas + "esportes_medias.txt";
	private static String caminhoEsporteDificeis = caminhoRelativo + pastaPerguntas + "esportes_dificeis.txt";
	private static String caminhoEsporteMuitoDificeis = caminhoRelativo + pastaPerguntas + "esportes_muito_dificeis.txt";
	
	private static String caminhoFilmesFaceis = caminhoRelativo + pastaPerguntas + "filmes_faceis.txt";
	private static String caminhoFilmesMedias = caminhoRelativo + pastaPerguntas + "filmes_medias.txt";
	private static String caminhoFilmesDificeis = caminhoRelativo + pastaPerguntas + "filmes_dificeis.txt";
	private static String caminhoFilmesMuitoDificeis = caminhoRelativo + pastaPerguntas + "filmes_muito_dificeis.txt";
	
	private static String caminhoGeraisFaceis = caminhoRelativo + pastaPerguntas + "gerais_faceis.txt";
	private static String caminhoGeraisMedias = caminhoRelativo + pastaPerguntas + "gerais_medias.txt";
	private static String caminhoGeraisDificeis = caminhoRelativo + pastaPerguntas + "gerais_dificeis.txt";
	private static String caminhoGeraisMuitoDificeis = caminhoRelativo + pastaPerguntas + "gerais_muito_dificeis.txt";
	
	private static String caminhoJogosFaceis = caminhoRelativo + pastaPerguntas + "jogos_faceis.txt";
	private static String caminhoJogosMedias = caminhoRelativo + pastaPerguntas + "jogos_medias.txt";
	private static String caminhoJogosDificeis = caminhoRelativo + pastaPerguntas + "jogos_dificeis.txt";
	private static String caminhoJogosMuitoDificeis = caminhoRelativo + pastaPerguntas + "jogos_muito_dificeis.txt";
	
	private static String caminhoSeriesFaceis = caminhoRelativo + pastaPerguntas + "series_faceis.txt";
	private static String caminhoSeriesMedias = caminhoRelativo + pastaPerguntas + "series_medias.txt";
	private static String caminhoSeriesDificeis = caminhoRelativo + pastaPerguntas + "series_dificeis.txt";
	private static String caminhoSeriesMuitoDificeis = caminhoRelativo + pastaPerguntas + "series_muito_dificeis.txt";
	
	private static String pastaTelas = "Telas\\";
	private static String caminhoTelaDeCadastro = caminhoRelativo + pastaTelas + "Tela de Cadastro.jpg";
	private static String caminhoTelaDeConfiguracoes = caminhoRelativo + pastaTelas + "Tela de configuracoes.jpg";
	private static String caminhoTelaDePerguntas = caminhoRelativo + pastaTelas + "Tela de Perguntas.jpg";
	private static String caminhoTelaDeTemas = caminhoRelativo + pastaTelas + "Tela de Temas.jpg";
	private static String caminhoTelaInicial = caminhoRelativo + pastaTelas + "Tela Inicial.jpg";
	private static String caminhoBotaoFechar = caminhoRelativo + pastaTelas + "Fechar.png";
	
	public static String getCaminhoRankingGeral(){
		return caminhoPartidaGeral;
	}
	
	public static String getCaminhoRankingAtual(){
		return caminhoPartidaAtual;
	}
	
	public static String getCaminhoEsporteFaceis(){
		return caminhoEsporteFaceis;
	}
	
	public static String getCaminhoEsporteMedias(){
		return caminhoEsporteMedias;
	}
	
	public static String getCaminhoEsporteDificeis(){
		return caminhoEsporteDificeis;
	}
	
	public static String getCaminhoEsporteMuitoDificeis(){
		return caminhoEsporteMuitoDificeis;
	}

	public static String getCaminhoFilmesFaceis() {
		return caminhoFilmesFaceis;
	}

	public static String getCaminhoFilmesMedias() {
		return caminhoFilmesMedias;
	}
	
	public static String getCaminhoFilmesDificeis() {
		return caminhoFilmesDificeis;
	}
	
	public static String getCaminhoFilmesMuitoDificeis() {
		return caminhoFilmesMuitoDificeis;
	}

	public static String getCaminhoGeraisFaceis() {
		return caminhoGeraisFaceis;
	}

	public static String getCaminhoGeraisMedias() {
		return caminhoGeraisMedias;
	}

	public static String getCaminhoGeraisDificeis() {
		return caminhoGeraisDificeis;
	}

	public static String getCaminhoGeraisMuitoDificeis() {
		return caminhoGeraisMuitoDificeis;
	}

	public static String getCaminhoJogosFaceis() {
		return caminhoJogosFaceis;
	}

	public static String getCaminhoJogosMedias() {
		return caminhoJogosMedias;
	}

	public static String getCaminhoJogosDificeis() {
		return caminhoJogosDificeis;
	}

	public static String getCaminhoJogosMuitoDificeis() {
		return caminhoJogosMuitoDificeis;
	}

	public static String getCaminhoSeriesFaceis() {
		return caminhoSeriesFaceis;
	}

	public static String getCaminhoSeriesMedias() {
		return caminhoSeriesMedias;
	}

	public static String getCaminhoSeriesDificeis() {
		return caminhoSeriesDificeis;
	}

	public static String getCaminhoSeriesMuitoDificeis() {
		return caminhoSeriesMuitoDificeis;
	}

	public static String getCaminhoTelaDeCadastro() {
		return caminhoTelaDeCadastro;
	}

	public static String getCaminhoTelaDeConfiguracoes() {
		return caminhoTelaDeConfiguracoes;
	}

	public static String getCaminhoTelaDePerguntas() {
		return caminhoTelaDePerguntas;
	}

	public static String getCaminhoTelaDeTemas() {
		return caminhoTelaDeTemas;
	}

	public static String getCaminhoTelaInicial() {
		return caminhoTelaInicial;
	}

	public static String getCaminhoBotaoFechar() {
		return caminhoBotaoFechar;
	}

}
