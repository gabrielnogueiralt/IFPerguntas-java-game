package controler;

import java.awt.EventQueue;
import java.util.ArrayList;

import model.Jogador;
import model.Pergunta;
import model.persistencia.Jogadores.ArquivoJogadoresGeral;
import model.persistencia.Jogadores.ArquivoJogadoresPartidaAtual;
import model.persistencia.Perguntas.ArquivosEsportes;
import model.persistencia.Perguntas.ArquivosFilmes;
import model.persistencia.Perguntas.ArquivosGeral;
import model.persistencia.Perguntas.ArquivosJogos;
import model.persistencia.Perguntas.ArquivosPerguntas;
import model.persistencia.Perguntas.ArquivosSeries;
import view.JanelaCadastro;
import view.JanelaConfiguracoes;
import view.JanelaPerguntas;
import view.JanelaRanking;
import view.JanelaRankingAtual;
import view.JanelaSenha;
import view.JanelaTemas;
import view.PrimeiraJanela;
import excecoes.JogadorCadastradoException;

public final class Controladora {
	
	private static Controladora unicaControladora;
	
	private PrimeiraJanela pt;
	private JanelaTemas jt;
	private JanelaPerguntas jp;
	private JanelaRankingAtual jra;
	private JanelaRanking jr;
	private JanelaCadastro jc;
	private JanelaConfiguracoes jConfg;
	private JanelaSenha js;
	
	private ArquivosPerguntas perguntas;
	private ArquivoJogadoresPartidaAtual jogadoresRankingAtual;
	private ArquivoJogadoresGeral jogadoresRankingGeral;
	private Jogador jogador;
	
	private Controladora() {
		pt = new PrimeiraJanela();
		jt = new JanelaTemas();
		jp = new JanelaPerguntas();
		jra = new JanelaRankingAtual();
		jr = new JanelaRanking();
		jc = new JanelaCadastro();
		jConfg = new JanelaConfiguracoes();
		js = new JanelaSenha();
		
		jogadoresRankingAtual = new ArquivoJogadoresPartidaAtual();
		jogadoresRankingGeral = new ArquivoJogadoresGeral();		
	}
	
	public static synchronized Controladora getInstance() {
		if (unicaControladora == null)
			unicaControladora = new Controladora();

		return unicaControladora;
	}
	
	public void iniciarNovaPartida() throws JogadorCadastradoException{
		ArrayList<Jogador> jogadoresPartidaAtual = jogadoresRankingAtual.getJogadores();
		jogadoresRankingGeral.cadastrarJogadores(jogadoresPartidaAtual);
		jogadoresRankingAtual.apagarTodosJogadores();
	}
	
	private void fecharTodasJanelas(){
		pt.setVisible(false);
		jt.setVisible(false);
		jp.setVisible(false);
		jra.setVisible(false);
		jr.setVisible(false);
		jc.setVisible(false);
		jConfg.setVisible(false);
		js.setVisible(false);
	}
	
	public void switchPrimeiraJanela(){
		fecharTodasJanelas();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pt.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public void switchJanelaConfiguracoes(){
		fecharTodasJanelas();
		jConfg.setVisible(true);
	}
	
	public void switchJanelaSenha(){
		fecharTodasJanelas();
		js.setVisible(true);		
	}
	
	public void switchJanelaTemas(){
		fecharTodasJanelas();
		jt.setVisible(true);
	}
	
	public void switchJanelaPerguntas(){
		fecharTodasJanelas();
		jp.iniciarCronometro();
		jp.setVisible(true);
	}
	
	public void switchJanelaRankingAtual(boolean fimDePerguntas){
		fecharTodasJanelas();
		if(fimDePerguntas){
			jra.setDados("Ranking Atual", jogadoresRankingAtual.getJogadores());
			jra.setVisible(true);
		}else{
			jr.setDados("Ranking Atual", jogadoresRankingAtual.getJogadores());
			jr.setVisible(true);
		}
		
	}
	
	public void switchJanelaRankingGeral(){
		fecharTodasJanelas();
		jr.setDados("Ranking Geral", jogadoresRankingGeral.getJogadores());
		jr.setVisible(true);
	}
	
	public void switchJanelaCadastro(){
		fecharTodasJanelas();
		jc.zerarTextFields();
		jc.setVisible(true);
	}
	
	public boolean proximaMuitoDificil(){
		int qteFaceis = perguntas.getFaceisSorteadas().size();
		int qteMedias = perguntas.getMediasSorteadas().size();
		int qteDificeis = perguntas.getDificeisSorteadas().size();
		if(qteFaceis == 0 && qteMedias == 0 && qteDificeis == 0){
			return true;
		}
		return false;
	}	
	
	public void proximaPergunta() throws NullPointerException{
		Pergunta p = perguntas.pullFacilSorteada();
		if(p == null){
			p = perguntas.pullMediaSorteada();			
			if(p == null){
				p = perguntas.pullDificilSorteada();
				if(p == null){
					p = perguntas.pullMuitoDificilSorteada();
				}
			}
		}
		if(p == null){
			throw new NullPointerException();
		}
		jp.atualizarPergunta(p);
		
	}
	
	public void jogar(String tema) throws Exception{
		if(tema.equals("series")){
			perguntas = new ArquivosSeries();
			
		}else if(tema.equals("filmes")){
			perguntas = new ArquivosFilmes();
			
		}else if(tema.equals("geral")){
			perguntas = new ArquivosGeral();
			
		}else if(tema.equals("esportes")){
			perguntas = new ArquivosEsportes();
			
		}else if(tema.equals("jogos")){
			perguntas = new ArquivosJogos();
			
		}
		proximaPergunta();
		switchJanelaPerguntas();
	}
	
	public void instanciarJogador(String nome, String telefone, String escola, String serie) throws JogadorCadastradoException{
		if(jogadoresRankingGeral.jogadorCadastrado(nome) == true){
			throw new JogadorCadastradoException();
		}
		if(jogadoresRankingAtual.jogadorCadastrado(nome) == true){
			throw new JogadorCadastradoException();
		}
		this.jogador = new Jogador(nome, telefone, escola, serie);
		
	}
	
	public void cadastrarJogador() throws JogadorCadastradoException{
		if(jogadoresRankingGeral.jogadorCadastrado(jogador.getNome())){
			throw new JogadorCadastradoException();
		}
		jogadoresRankingAtual.cadastrarJogador(jogador);
	}
	
	public int getPontuacaoJogador(){
		return jogador.getPontuacao();
	}
	
	public Jogador getJogador(String nome){
		Jogador j = jogadoresRankingAtual.getJogador(nome);
		if(j != null){
			return j;
		}
		j = jogadoresRankingGeral.getJogador(nome);
		return j;
	}
	
	public void somarPontuacaoJogador(int pontuacao){
		jogador.somarPontuacao(pontuacao);
	}
	
	public void sobtrairPontuacaoJogador(int pontuacao){
		jogador.subtrairPontuacao(pontuacao);
	}
	
	public void setTempoJogador(float tempo){
		this.jogador.setTempo(tempo);
	}

}
