package teste;

import java.util.ArrayList;

import model.Jogador;
import model.Pergunta;
import model.persistencia.Jogadores.ArquivoJogadoresPartidaAtual;
import model.persistencia.Perguntas.ArquivosEsportes;
import model.persistencia.Perguntas.ArquivosFilmes;
import model.persistencia.Perguntas.ArquivosGeral;
import model.persistencia.Perguntas.ArquivosJogos;
import model.persistencia.Perguntas.ArquivosPerguntas;
import model.persistencia.Perguntas.ArquivosSeries;
import excecoes.JogadorCadastradoException;

public class TesteArquivos {
	
	private static void exibir(ArquivosPerguntas arq) {

		System.out.println("Perguntas Fáceis");
		ArrayList<Pergunta> perguntas = arq.getFaceis();
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta.toString());
		}
		System.out.println("Perguntas Médias");
		perguntas = arq.getMedias();
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta.toString());
		}
		System.out.println("Perguntas Difíceis");
		perguntas = arq.getDificeis();
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta.toString());
		}
		System.out.println("Perguntas Muito Difíceis");
		perguntas = arq.getMuitoDificeis();
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta.toString());
		}

	}
	
	private static void exibirSorteadas(ArquivosPerguntas arq){
		ArrayList<Pergunta> perguntas = arq.getFaceisSorteadas();
		System.out.println("Perguntas Fáceis Sorteadas");
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta.toString());
		}
		perguntas = arq.getMediasSorteadas();
		System.out.println("Perguntas Médias Sorteadas");
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta.toString());
		}
		perguntas = arq.getDificeisSorteadas();
		System.out.println("Perguntas Difíceis Sorteadas");
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta.toString());
		}
		perguntas = arq.getMuitoDificeisSorteadas();
		System.out.println("Perguntas Muito Difíceis Sorteadas");
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta.toString());
		}
	}
	
	private static void exibirPerguntas(ArquivosPerguntas arquivos){
		try {			
//			exibirPerguntas(ae);
			exibirSorteadas(arquivos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void exibirPerguntasEsportes(){
		ArquivosPerguntas ae;
		try {
			ae = new ArquivosEsportes();
			exibirPerguntas(ae);
			exibirSorteadas(ae);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void exibirPerguntasFilmes(){
		ArquivosPerguntas ae;
		try {
			ae = new ArquivosFilmes();
			exibirPerguntas(ae);
//			exibirSorteadas(ae);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void exibirPerguntasGerais(){
		ArquivosPerguntas ae;
		try {
			ae = new ArquivosGeral();
			exibirPerguntas(ae);
			exibirSorteadas(ae);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void exibirPerguntasJogos(){
		ArquivosPerguntas ae;
		try {
			ae = new ArquivosJogos();
			exibirPerguntas(ae);
			exibirSorteadas(ae);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void exibirPerguntasSeries(){
		ArquivosPerguntas ae;
		try {
			ae = new ArquivosSeries();
			exibirPerguntas(ae);
			exibirSorteadas(ae);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void cadastrarJogadorRankingAtual() {		
		ArquivoJogadoresPartidaAtual ajp = new ArquivoJogadoresPartidaAtual();
		ajp.apagarTodosJogadores();
		Jogador jogador1 = new Jogador("Fulano", "Telefone Fulano", "Escola Fulano", "Série Fulano");
		Jogador jogador2 = new Jogador("Beltrano", "Telefone Beltrano", "Escola Beltrano", "Série Beltrano");
		try {
			ajp.cadastrarJogador(jogador1);
			ajp.cadastrarJogador(jogador2);
		} catch (JogadorCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void recuperarJogadoresRankingAtualCadastrados() {
		ArquivoJogadoresPartidaAtual ajp = new ArquivoJogadoresPartidaAtual();
		ArrayList<Jogador> jogadores = ajp.getJogadores();
		for (Jogador jogador : jogadores) {
			System.out.println(jogador.toString());			
		}
		
	}

	public static void main(String[] args) {		
//		exibirPerguntasEsportes();
		exibirPerguntasFilmes();
//		exibirPerguntasJogos();
//		exibirPerguntasGerais();
//		exibirPerguntasSeries();
//		cadastrarJogadorRankingAtual();
//		recuperarJogadoresRankingAtualCadastrados();

	}

	

	

}
