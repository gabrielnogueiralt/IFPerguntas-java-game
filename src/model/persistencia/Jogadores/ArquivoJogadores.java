package model.persistencia.Jogadores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import model.Jogador;
import excecoes.JogadorCadastradoException;

public abstract class ArquivoJogadores {
	
	protected ArrayList<Jogador> jogadores;
	protected String caminhoArquivo;
	
	public ArquivoJogadores(String caminho){
		this.caminhoArquivo = caminho;
		carregar();
		
	}

	@SuppressWarnings("unchecked")
	private void carregar() {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(caminhoArquivo));
		} catch (FileNotFoundException e) {
			criarArquivo();				
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
    	try {
    		if(in == null){
    			criarArquivo();
    		}else{
    			jogadores = (ArrayList<Jogador>) in.readObject();
    			in.close();
    		}			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}	
	}
	
	private void criarArquivo(){
		jogadores = new ArrayList<Jogador>();
		salvarNoHD();
	}

	
	public void apagarTodosJogadores() {
		jogadores.clear();
		salvarNoHD();
		
	}
	
	private void salvarNoHD(){
		ObjectOutputStream out = null;
	    try {
	      try {
	    	
	    	File file = new File(caminhoArquivo);
	    	if(!file.exists()){	    		
	    		file.createNewFile();	    		
	    	}
	    	FileOutputStream fout = new FileOutputStream(caminhoArquivo);
	    	
	        out = new ObjectOutputStream(fout);
	        } catch( FileNotFoundException e ) {
	        	JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
	        }
	      out.writeObject(jogadores);
	      out.close();
	    } catch(IOException e) {
	    	JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
	    }
	}
	
	public void cadastrarJogadores(ArrayList<Jogador> jogadores) throws JogadorCadastradoException{
		for (Jogador j : jogadores) {
			if(this.jogadores.contains(j)){
				throw new JogadorCadastradoException();
			}
		}
		for (Jogador j : jogadores) {
			this.jogadores.add(j);
		}
		Collections.sort(this.jogadores);
		salvarNoHD();
	}

	public void cadastrarJogador(Jogador jogador) throws JogadorCadastradoException{
		for (Jogador j : jogadores) {
			if(j.equals(jogador)){
				throw new JogadorCadastradoException();
			}
		}		
		jogadores.add(jogador);
		Collections.sort(jogadores);
		salvarNoHD();
	}
	
	public boolean jogadorCadastrado(String nome){
		for (Jogador jogador : jogadores) {
			if(jogador.getNome().equals(nome)){
				return true;
			}
		}
		return false;
	}
	
	public Jogador getJogador(String nome){
		for (Jogador jogador : jogadores) {
			if(jogador.getNome().equals(nome)){
				return jogador;
			}
		}
		return null;
	}
	
	public ArrayList<Jogador> getJogadores(){
		return this.jogadores;
	}


}
