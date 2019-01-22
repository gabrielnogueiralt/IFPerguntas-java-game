package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.Controladora;
import excecoes.JogadorCadastradoException;
import model.ClasseDeCaminhos;

public class JanelaConfiguracoes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public JanelaConfiguracoes() {
		this.setTitle("IFPErguntas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel rankingAtualLabel = new JLabel("");
		rankingAtualLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Controladora.getInstance().switchJanelaRankingAtual(false);
			}
		});
		rankingAtualLabel.setBounds(92, 167, 371, 67);
		contentPane.add(rankingAtualLabel);
		
		JLabel rankingGeralLabel = new JLabel("");
		rankingGeralLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controladora.getInstance().switchJanelaRankingGeral();
			}
		});
		rankingGeralLabel.setBounds(26, 245, 352, 58);
		contentPane.add(rankingGeralLabel);
		
		JLabel iniciarNovaRodadaLabel = new JLabel("");
		iniciarNovaRodadaLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String message = "Deseja realmente iniciar uma nova partida?";
					String title = "Confirmação";
					int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
					  if (reply == JOptionPane.YES_OPTION) {
						  Controladora.getInstance().iniciarNovaPartida();	
						  JOptionPane.showMessageDialog(null, "Nova partida iniciada com sucesso!!!");
					  }
				} catch (JogadorCadastradoException e1) {
					JOptionPane.showMessageDialog(null, "ERRO: " + e1.getMessage());
				}
			}
		});
		iniciarNovaRodadaLabel.setBounds(47, 327, 488, 55);
		contentPane.add(iniciarNovaRodadaLabel);
		
		JLabel voltarLabel = new JLabel("");
		voltarLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controladora.getInstance().switchPrimeiraJanela();
			}
		});
		voltarLabel.setBounds(153, 390, 180, 48);
		contentPane.add(voltarLabel);
		
		JLabel telaFundoLabel = new JLabel("");
//		telaFundoLabel.setIcon(new ImageIcon("C:\\DIEGO\\workspace\\JogoPerguntas\\Arquivos\\Telas\\Tela de configuracoes.jpg"));
		telaFundoLabel.setIcon(new ImageIcon(ClasseDeCaminhos.getCaminhoTelaDeConfiguracoes()));
		telaFundoLabel.setBounds(0, 0, 790, 490);
		contentPane.add(telaFundoLabel);
	}
}
