package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controler.Controladora;
import model.ClasseDeCaminhos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrimeiraJanela extends JFrame{

	//private JFrame frame;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 */
	public PrimeiraJanela() {
		this.setTitle("IFPErguntas");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 806, 520);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel primeiraTelaPanel = new JPanel();
		this.getContentPane().add(primeiraTelaPanel, BorderLayout.CENTER);
		primeiraTelaPanel.setLayout(null);
		
		JLabel jogarImg = new JLabel();
		jogarImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Controladora.getInstance().switchJanelaCadastro();
			}
		});
		jogarImg.setBounds(10, 148, 317, 115);
		primeiraTelaPanel.add(jogarImg);
		
		JLabel configuracoesImg = new JLabel();
		configuracoesImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Controladora.getInstance().switchJanelaSenha();
			}
		});
		configuracoesImg.setBounds(112, 259, 433, 115);
		primeiraTelaPanel.add(configuracoesImg);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		label.setBounds(211, 370, 268, 112);
		primeiraTelaPanel.add(label);
		
		JLabel telaFundoLabel = new JLabel("");
//		telaFundoLabel.setIcon(new ImageIcon("C:\\DIEGO\\workspace\\JogoPerguntas\\Arquivos\\Telas\\Tela Inicial.jpg"));
		telaFundoLabel.setIcon(new ImageIcon(ClasseDeCaminhos.getCaminhoTelaInicial()));
		telaFundoLabel.setBounds(0, 0, 790, 490);
		primeiraTelaPanel.add(telaFundoLabel);
	}
}
