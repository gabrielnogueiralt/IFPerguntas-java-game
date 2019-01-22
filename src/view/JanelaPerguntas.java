package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import controler.Controladora;
import excecoes.JogadorCadastradoException;
import model.ClasseDeCaminhos;
import model.Pergunta;

public class JanelaPerguntas extends JFrame{
	

	//private JFrame frame;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel primeiraTelaPanel;
	private JLabel perguntaLabel;
	private JLabel altALabel;
	private JLabel altBLabel;
	private JLabel altCLabel;
	private JLabel altDLabel;
	private JLabel tempoLabel;
	private JRadioButton altARadioButton;
	private JRadioButton altBRadioButton;
	private JRadioButton altCRadioButton;
	private JRadioButton altDRadioButton;
	private JButton responderButton;
	private JLabel pontosLabel;
	private Pergunta pergunta;
	private boolean perguntou;
	private boolean executando;
	private int segundos;
	private int decimosSegundos;
	private JTextArea perguntaTextArea;
	private JTextArea AltATextArea;
	private JTextArea AltBTextArea;
	private JTextArea AltCTextArea;
	private JTextArea AltDTextArea;
	private JLabel telaFundoLabel;

	/**
	 * Create the application.
	 */
	public JanelaPerguntas() {
		this.setTitle("IFPErguntas");
//		continuarPerguntas = true;
		perguntou = false;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 799, 523);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		primeiraTelaPanel = new JPanel();
		this.getContentPane().add(primeiraTelaPanel, BorderLayout.CENTER);
		primeiraTelaPanel.setLayout(null);
		
		perguntaLabel = new JLabel("Pergunta:");
		perguntaLabel.setFont(perguntaLabel.getFont().deriveFont(perguntaLabel.getFont().getStyle() | Font.BOLD));
		perguntaLabel.setBounds(52, 148, 58, 14);
		primeiraTelaPanel.add(perguntaLabel);
		
		altALabel = new JLabel("A)");
		altALabel.setBounds(89, 204, 21, 14);
		primeiraTelaPanel.add(altALabel);
		
		altBLabel = new JLabel("B)");
		altBLabel.setBounds(89, 249, 21, 14);
		primeiraTelaPanel.add(altBLabel);
		
		altCLabel = new JLabel("C)");
		altCLabel.setBounds(89, 295, 21, 14);
		primeiraTelaPanel.add(altCLabel);
		
		altDLabel = new JLabel("D)");
		altDLabel.setBounds(89, 342, 21, 14);
		primeiraTelaPanel.add(altDLabel);
		
		altARadioButton = new JRadioButton();
		altARadioButton.setBackground(Color.LIGHT_GRAY);
		altARadioButton.setBounds(115, 204, 21, 14);
		primeiraTelaPanel.add(altARadioButton);
		
		altBRadioButton = new JRadioButton();
		altBRadioButton.setBackground(Color.LIGHT_GRAY);
		altBRadioButton.setBounds(115, 249, 21, 14);
		primeiraTelaPanel.add(altBRadioButton);
		
		altCRadioButton = new JRadioButton();
		altCRadioButton.setBackground(Color.LIGHT_GRAY);
		altCRadioButton.setBounds(115, 295, 21, 14);
		primeiraTelaPanel.add(altCRadioButton);
		
		altDRadioButton = new JRadioButton();
		altDRadioButton.setBackground(Color.LIGHT_GRAY);
		altDRadioButton.setBounds(115, 342, 21, 14);
		primeiraTelaPanel.add(altDRadioButton);
		
		criarRadioButtons();		
		
		responderButton.setBounds(644, 433, 129, 23);
		primeiraTelaPanel.add(responderButton);
		
		pontosLabel = new JLabel("Pontos: 0");
		pontosLabel.setForeground(Color.WHITE);
		pontosLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		pontosLabel.setBounds(52, 433, 306, 52);
		primeiraTelaPanel.add(pontosLabel);
		
		tempoLabel = new JLabel("Tempo: 0,0 segundos");
		tempoLabel.setForeground(Color.WHITE);
		tempoLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		tempoLabel.setBounds(243, 437, 370, 44);
		primeiraTelaPanel.add(tempoLabel);
		
		perguntaTextArea = new JTextArea();
		perguntaTextArea.setBackground(Color.LIGHT_GRAY);
		perguntaTextArea.setLineWrap(true);
		perguntaTextArea.setEditable(false);
		perguntaTextArea.setBounds(115, 148, 600, 49);
		primeiraTelaPanel.add(perguntaTextArea);
		
		AltATextArea = new JTextArea();
		AltATextArea.setEditable(false);
		AltATextArea.setBackground(Color.LIGHT_GRAY);
		AltATextArea.setBounds(142, 204, 573, 37);
		primeiraTelaPanel.add(AltATextArea);
		
		AltBTextArea = new JTextArea();
		AltBTextArea.setEditable(false);
		AltBTextArea.setBackground(Color.LIGHT_GRAY);
		AltBTextArea.setBounds(142, 249, 573, 37);
		primeiraTelaPanel.add(AltBTextArea);
		
		AltCTextArea = new JTextArea();
		AltCTextArea.setEditable(false);
		AltCTextArea.setBackground(Color.LIGHT_GRAY);
		AltCTextArea.setBounds(142, 297, 573, 35);
		primeiraTelaPanel.add(AltCTextArea);
		
		AltDTextArea = new JTextArea();
		AltDTextArea.setEditable(false);
		AltDTextArea.setBackground(Color.LIGHT_GRAY);
		AltDTextArea.setBounds(142, 342, 573, 37);
		primeiraTelaPanel.add(AltDTextArea);
		
		telaFundoLabel = new JLabel("");
		telaFundoLabel.setIcon(new ImageIcon(ClasseDeCaminhos.getCaminhoTelaDePerguntas()));
//		telaFundoLabel.setIcon(new ImageIcon("C:\\Users\\CCTI\\Dropbox\\IFPE\\workspace\\JogoPerguntas\\Arquivos\\Telas\\Tela de Perguntas.jpg"));
		telaFundoLabel.setBounds(0, 0, 783, 495);
		primeiraTelaPanel.add(telaFundoLabel);
		
	}
	
	public void iniciarCronometro() {		
		
		new Thread() {

			@Override
			public void run() {
				pontosLabel.setText("Pontos: " + Controladora.getInstance().getPontuacaoJogador());
				segundos = 0;
				decimosSegundos = 0;
				executando = true;
				while(executando){
					try {
						Thread.sleep(100);//Para por um décimo de segundo
						decimosSegundos++;
						if(decimosSegundos == 10){
							segundos++;
							decimosSegundos = 0;
						}
						tempoLabel.setText("Tempo: " + segundos + "," + decimosSegundos + " segundos");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}.start();

	}
	
	private void criarRadioButtons(){
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(altARadioButton);
		grupo.add(altBRadioButton);
		grupo.add(altCRadioButton);
		grupo.add(altDRadioButton);
		
		responderButton = new JButton("Responder");
		responderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!altARadioButton.isSelected() && !altBRadioButton.isSelected() && !altCRadioButton.isSelected() && !altDRadioButton.isSelected()){
					JOptionPane.showMessageDialog(null, "Escolha uma alternativa.");
				}else{
					boolean acertou = false;
					if((pergunta.getAlternativaCorreta() == 'a' || pergunta.getAlternativaCorreta() == 'A') && altARadioButton.isSelected()){
						acertou = true;
					}else if((pergunta.getAlternativaCorreta() == 'b' || pergunta.getAlternativaCorreta() == 'B') && altBRadioButton.isSelected()){
						acertou = true;
					}else if((pergunta.getAlternativaCorreta() == 'c' || pergunta.getAlternativaCorreta() == 'C') && altCRadioButton.isSelected()){
						acertou = true;
					}else if((pergunta.getAlternativaCorreta() == 'd' || pergunta.getAlternativaCorreta() == 'D') && altDRadioButton.isSelected()){
						acertou = true;
					}
					if(acertou){
						JOptionPane.showMessageDialog(null, "Você acertou!!!");
						Controladora.getInstance().somarPontuacaoJogador(pergunta.getPontuacao());
					}else{
						if(perguntou){
							Controladora.getInstance().sobtrairPontuacaoJogador(pergunta.getPontuacao());
						}
						JOptionPane.showMessageDialog(null, "Você errou!!!");
					}
					pontosLabel.setText("Pontos: " + Controladora.getInstance().getPontuacaoJogador());
					boolean proximaMuitoDificil = Controladora.getInstance().proximaMuitoDificil();
					if(proximaMuitoDificil && !perguntou){
						perguntou = true;
						String message = "As próximas perguntas são muito difíceis. Se acertar ganhará 200 pontos. Se errar perderá 200 pontos. Deseja Continuar?";
						String title = "Confirmação";
						int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
						  if (reply == JOptionPane.NO_OPTION) {
							  perguntou = false;
							  executando = false;
						  }
					}
					try {
						Controladora.getInstance().proximaPergunta();
					} catch (Exception e) {
						perguntou = false;
						executando = false;
					}					
				}
				if(executando == false){
					try {
						float tempo = decimosSegundos;
						tempo /= 10;
						tempo += segundos;
						Controladora.getInstance().setTempoJogador(tempo);
						Controladora.getInstance().cadastrarJogador();
						Controladora.getInstance().switchJanelaRankingAtual(true);
					} catch (JogadorCadastradoException e) {
						JOptionPane.showMessageDialog(null, "Erro: Jogador já cadastrado!!!");
					}
				}
				
			}
		});
	}
	
	public void atualizarPergunta(Pergunta pergunta){
		this.pergunta = pergunta;
		
		perguntaTextArea.setText(pergunta.getPergunta());
		criarRadioButtons();
		altARadioButton.setSelected(false);
		altBRadioButton.setSelected(false);
		altCRadioButton.setSelected(false);
		altDRadioButton.setSelected(false);
		
		AltATextArea.setText(pergunta.getAlternativaA());
		AltBTextArea.setText(pergunta.getAlternativaB());
		AltCTextArea.setText(pergunta.getAlternativaC());
		AltDTextArea.setText(pergunta.getAlternativaD());
	}
}
