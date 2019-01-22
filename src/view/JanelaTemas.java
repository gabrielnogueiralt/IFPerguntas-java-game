package view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controler.Controladora;
import model.ClasseDeCaminhos;

public class JanelaTemas extends JFrame{

	//private JFrame frame;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 */
	public JanelaTemas() {
		this.setTitle("IFPErguntas");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 800, 497);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel temaTelaPanel = new JPanel();
		this.getContentPane().add(temaTelaPanel, BorderLayout.CENTER);
		temaTelaPanel.setLayout(null);
		
		JLabel esportesLabel = new JLabel("");
		esportesLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Controladora.getInstance().jogar("esportes");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ocorreu um Erro!!! " + e.getMessage());
				}
			}
		});
		esportesLabel.setBounds(202, 271, 172, 49);
		temaTelaPanel.add(esportesLabel);
		
		JLabel filmesLabel = new JLabel("");
		filmesLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Controladora.getInstance().jogar("filmes");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Ocorreu um Erro!!! " + e1.getMessage());
				}
			}
		});
		filmesLabel.setBounds(512, 195, 177, 49);
		temaTelaPanel.add(filmesLabel);
		
		JLabel geralLabel = new JLabel("");
		geralLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Controladora.getInstance().jogar("geral");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ocorreu um Erro!!! " + e.getMessage());
				}
			}
		});
		geralLabel.setBounds(304, 350, 172, 49);
		temaTelaPanel.add(geralLabel);
		
		JLabel jogosLabel = new JLabel("");
		jogosLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Controladora.getInstance().jogar("jogos");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Ocorreu um Erro!!! " + e1.getMessage());
				}
			}
		});
		jogosLabel.setBounds(434, 271, 172, 49);
		temaTelaPanel.add(jogosLabel);
		
		JLabel seriesLabel = new JLabel("");
		seriesLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Controladora.getInstance().jogar("series");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ocorreu um Erro!!! " + e.getMessage());
				}
			}
		});
		seriesLabel.setBounds(89, 195, 172, 49);
		temaTelaPanel.add(seriesLabel);
		
		JLabel telaFundoLabel = new JLabel("");
//		telaFundoLabel.setIcon(new ImageIcon("C:\\DIEGO\\workspace\\JogoPerguntas\\Arquivos\\Telas\\Tela de Temas.jpg"));
		telaFundoLabel.setIcon(new ImageIcon(ClasseDeCaminhos.getCaminhoTelaDeTemas()));
		telaFundoLabel.setBounds(0, 0, 790, 467);
		temaTelaPanel.add(telaFundoLabel);
	}
}
