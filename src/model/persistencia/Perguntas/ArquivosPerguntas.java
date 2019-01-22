package model.persistencia.Perguntas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import model.Pergunta;

public abstract class ArquivosPerguntas {
	
	protected ArrayList<Pergunta> faceis;	
	protected ArrayList<Pergunta> medias;	
	protected ArrayList<Pergunta> dificeis;	
	protected ArrayList<Pergunta> muitoDificeis;
	
	protected ArrayList<Pergunta> faceisSorteadas;
	protected ArrayList<Pergunta> mediasSorteadas;
	protected ArrayList<Pergunta> dificeisSorteadas;
	protected ArrayList<Pergunta> muitoDificeisSorteadas;
	
	public ArquivosPerguntas(String caminhoFaceis, String caminhoMedias, String caminhoDificeis, String caminhoMuitoDificeis) throws Exception{
		this.faceis = carregar(caminhoFaceis, 'f');
		this.medias = carregar(caminhoMedias, 'm');
		this.dificeis = carregar(caminhoDificeis, 'd');
		this.muitoDificeis = carregar(caminhoMuitoDificeis, 'x');
		this.faceisSorteadas = sortearPerguntas(faceis);
		this.mediasSorteadas = sortearPerguntas(medias);
		this.dificeisSorteadas = sortearPerguntas(dificeis);
		this.muitoDificeisSorteadas = sortearPerguntas(muitoDificeis);
	}
	
	private ArrayList<Pergunta> carregar(String caminho, char nivel) throws Exception{
		ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
		FileReader fr = new FileReader(caminho);
		BufferedReader in = new BufferedReader(fr);
		String linha = getNextLine(in);
		while(linha != null){
			String pergunta = linha;
//			System.out.println(pergunta);
			linha = getNextLine(in);
			if(linha == null){
				throw new Exception("Faltando Alternativa A");
			}
			String altA = linha;
			linha = getNextLine(in);
			if(linha == null){
				throw new Exception("Faltando Alternativa B");
			}
			String altB = linha;
			linha = getNextLine(in);
			if(linha == null){
				throw new Exception("Faltando Alternativa C");
			}
			String altC = linha;
			linha = getNextLine(in);
			if(linha == null){
				throw new Exception("Faltando Alternativa D");
			}
			String altD = linha;
			int pontuacao = 0;
			switch (nivel) {
				case 'f':
					pontuacao = 20;
					break;
	
				case 'm':
					pontuacao = 50;
					break;
	
				case 'd':
					pontuacao = 100;
					break;
	
				case 'x':
					pontuacao = 200;
					break;
			}
			Pergunta p = new Pergunta(pergunta, altA, altB, altC, altD, pontuacao);
//			System.out.println(p.toString());
			perguntas.add(p);
			linha = getNextLine(in);			
		}
		return perguntas;
	}
	
	private String getNextLine(BufferedReader lerArq) throws IOException{
		
		String linha;
		do{
			linha = lerArq.readLine(); // lê próxima linha
			if(linha == null){
				return null;
			}
		}while(linha.equals(""));
		return linha;
	}
	
	public ArrayList<Pergunta> getFaceis(){		
		return this.faceis;
	}

	public ArrayList<Pergunta> getMedias() {
		return this.medias;
	}

	public ArrayList<Pergunta> getDificeis() {
		return this.dificeis;
	}

	public ArrayList<Pergunta> getMuitoDificeis() {
		return this.muitoDificeis;
	}
	
	private ArrayList<Pergunta> sortearPerguntas(ArrayList<Pergunta> perguntas){
		int qte = perguntas.size();
		ArrayList<Pergunta> sorteadas = new ArrayList<Pergunta>();
		int indice1, indice2, indice3;
		Random gerador1 = new Random();
		
		do{		
			indice1 = gerador1.nextInt(qte);
			indice2 = gerador1.nextInt(qte);
			indice3 = gerador1.nextInt(qte);
		}while(indice1 == indice2 || indice1 == indice3 || indice2 == indice3);
		sorteadas.add(0, perguntas.get(indice1));
		sorteadas.add(1, perguntas.get(indice2));
		sorteadas.add(2, perguntas.get(indice3));
		int i;
		String auxiliar;
		Random gerador2 = new Random();
		for(i = 0; i < 3; i++){
			int alternativa_correta = gerador2.nextInt(4);
			switch(alternativa_correta){
				case 0:{
					sorteadas.get(i).setAlternativaCorreta('A');
					break;
				}
				case 1:{
					sorteadas.get(i).setAlternativaCorreta('B');
					auxiliar = sorteadas.get(i).getAlternativaA();
					sorteadas.get(i).setAlternativaA(sorteadas.get(i).getAlternativaB());
					sorteadas.get(i).setAlternativaB(auxiliar);
					break;
				}
				case 2:{
					sorteadas.get(i).setAlternativaCorreta('C');
					auxiliar = sorteadas.get(i).getAlternativaA();
					sorteadas.get(i).setAlternativaA(sorteadas.get(i).getAlternativaC());
					sorteadas.get(i).setAlternativaC(auxiliar);
					break;
				}
				case 3:{
					sorteadas.get(i).setAlternativaCorreta('D');
					auxiliar = sorteadas.get(i).getAlternativaA();
					sorteadas.get(i).setAlternativaA(sorteadas.get(i).getAlternativaD());
					sorteadas.get(i).setAlternativaD(auxiliar);
					break;
				}
			}
		}
		return sorteadas;
	}

	public ArrayList<Pergunta> getFaceisSorteadas() {
		return this.faceisSorteadas;
	}

	public ArrayList<Pergunta> getMediasSorteadas() {
		return this.mediasSorteadas;
	}

	public ArrayList<Pergunta> getDificeisSorteadas() {
		return this.dificeisSorteadas;
	}

	public ArrayList<Pergunta> getMuitoDificeisSorteadas() {
		return this.muitoDificeisSorteadas;
	}
	
	public Pergunta pullFacilSorteada(){
		if(faceisSorteadas.size() == 0){
			return null;
		}
		Pergunta p = faceisSorteadas.get(0);
		faceisSorteadas.remove(0);
		return p;
	}
	
	public Pergunta pullMediaSorteada(){
		if(mediasSorteadas.size() == 0){
			return null;
		}
		Pergunta p = mediasSorteadas.get(0);
		mediasSorteadas.remove(0);
		return p;
	}
	
	public Pergunta pullDificilSorteada(){
		if(dificeisSorteadas.size() == 0){
			return null;
		}
		Pergunta p = dificeisSorteadas.get(0);
		dificeisSorteadas.remove(0);
		return p;
	}
	
	public Pergunta pullMuitoDificilSorteada(){
		if(muitoDificeisSorteadas.size() == 0){
			return null;
		}
		Pergunta p = muitoDificeisSorteadas.get(0);
		muitoDificeisSorteadas.remove(0);
		return p;
	}

}
