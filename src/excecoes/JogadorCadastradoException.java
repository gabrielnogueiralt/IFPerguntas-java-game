package excecoes;

public class JogadorCadastradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JogadorCadastradoException(){
		super("Jogador já cadastrado");
	}

}
