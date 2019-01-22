package model;

import java.io.Serializable;

public class Jogador implements Serializable, Comparable<Jogador>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String telefone;
	private String escola;
	private String serie;
	private int pontuacao;
	private float tempo;
	
	public Jogador(String nome, String telefone, String escola, String serie){
		this.nome = nome;
		this.telefone = telefone;
		this.escola = escola;
		this.serie = serie;
		this.pontuacao = 0;
		this.tempo = 0;		
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEscola() {
		return escola;
	}

	public String getSerie() {
		return serie;
	}

	public int getPontuacao() {
		return pontuacao;
	}
	
	public void somarPontuacao(int pontuacao){
		this.pontuacao+=pontuacao;
	}
	
	public void subtrairPontuacao(int pontuacao){
		int p = this.pontuacao - pontuacao;
		if(p > 0){
			this.pontuacao = p;
		}else{
			this.pontuacao = 0;
		}
	}

	public float getTempo() {
		return tempo;
	}
	
	public void setTempo(float tempo){
		this.tempo = tempo;
	}
	
	public String toString(){
		String saida = "";
		saida += "Nome: " + nome + "\n";
		saida += "Telefone: " + telefone + "\n";
		saida += "Escola: " + escola + "\n";
		saida += "Série: " + serie + "\n";
		saida += "Pontuação: " + pontuacao + "\n";
		saida += "Tempo: " + tempo + "\n";
		return saida;
	}
	
	public boolean equals(Jogador jogador){
		if(this.nome.equals(jogador.getNome())){
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Jogador jogador) {
		if(this.pontuacao > jogador.getPontuacao()){
			return -1;
		}
		if(this.pontuacao < jogador.getPontuacao()){
			return 1;
		}
		if(this.tempo < jogador.getTempo()){
			return -1;
		}
		if(this.tempo > jogador.getTempo()){
			return 1;
		}
		return 0;
	}

}

