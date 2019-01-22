package model;

public class Pergunta {
	
	private String pergunta;
	private String alternativaA;
	private String alternativaB;
	private String alternativaC;
	private String alternativaD;
	private int pontuacao;
	private char alternativaCorreta;
	
	
	public Pergunta(String pergunta, String altA, String altB, String altC, String altD, int pontuacao){
//		if(pergunta.length() >= 100){
//			String lineSeparator = System.getProperty("line.separator");
//			pergunta = lineSeparator + lineSeparator + pergunta;
//		}
		this.pergunta = pergunta;
		this.alternativaA = altA;
		this.alternativaB = altB;
		this.alternativaC = altC;
		this.alternativaD = altD;
		this.pontuacao = pontuacao;
		this.alternativaCorreta = 'a';
	}
	
	public Pergunta(String pergunta, String altA, String altB, String altC, String altD, int pontuacao, char altCorreta){
		this.pergunta = pergunta;
		this.alternativaA = altA;
		this.alternativaB = altB;
		this.alternativaC = altC;
		this.alternativaD = altD;
		this.pontuacao = pontuacao;
		this.alternativaCorreta = altCorreta;
	}
	
	public String getPergunta() {
		return pergunta;
	}

	public String getAlternativaA() {
		return alternativaA;
	}
	
	public void setAlternativaA(String alternativa) {
		this.alternativaA = alternativa;
	}

	public String getAlternativaB() {
		return alternativaB;
	}
	
	public void setAlternativaB(String alternativa) {
		this.alternativaB = alternativa;
	}
	
	public String getAlternativaC() {
		return alternativaC;
	}
	
	public void setAlternativaC(String alternativa) {
		this.alternativaC = alternativa;
	}

	public String getAlternativaD() {
		return alternativaD;
	}
	
	public void setAlternativaD(String alternativa) {
		this.alternativaD = alternativa;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public char getAlternativaCorreta() {
		return alternativaCorreta;
	}
	
	public void setAlternativaCorreta(char alternativa) {
		this.alternativaCorreta = alternativa;
	}
	
	public boolean acertou(char alternativaEscolhida){
		return alternativaEscolhida == alternativaCorreta;
	}
	
	@Override
	public String toString(){
		String saida = "";
		saida += "Pergunta: " + this.pergunta + "\n";
		saida += "Alternativa A: " + this.alternativaA + "\n";
		saida += "Alternativa B: " + this.alternativaB + "\n";
		saida += "Alternativa C: " + this.alternativaC + "\n";
		saida += "Alternativa D: " + this.alternativaD + "\n";
		saida += "Pontuação: " + this.pontuacao + "\n";
		saida += "Alternativa Correta: " + this.alternativaCorreta + "\n";
		return saida;
	}
	

}
