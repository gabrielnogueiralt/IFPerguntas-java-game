package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Jogador;

public class JanelaDadosJogador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane = new JPanel();

	/**
	 * Create the dialog.
	 */
	public JanelaDadosJogador(Jogador jogador) {
		this.setTitle("IFPErguntas");
		
		setBounds(100, 100, 377, 212);
//		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeLabel = new JLabel("Nome: " + jogador.getNome());
		nomeLabel.setBounds(10, 11, 316, 14);
		contentPane.add(nomeLabel);
		
		JLabel telefoneLabel = new JLabel("Telefone: " + jogador.getTelefone());
		telefoneLabel.setBounds(10, 36, 316, 14);
		contentPane.add(telefoneLabel);
		
		JLabel escolaLabel = new JLabel("Escola: " + jogador.getEscola());
		escolaLabel.setBounds(10, 61, 316, 14);
		contentPane.add(escolaLabel);
		
		JLabel lblSrie = new JLabel("S\u00E9rie: " + jogador.getSerie());
		lblSrie.setBounds(10, 86, 316, 14);
		contentPane.add(lblSrie);
		
		JLabel pontuacaoLabel = new JLabel("Pontua\u00E7\u00E3o: " + jogador.getPontuacao());
		pontuacaoLabel.setBounds(10, 111, 316, 14);
		contentPane.add(pontuacaoLabel);
		
		JLabel lblTempo = new JLabel("Tempo: " + jogador.getTempo());
		lblTempo.setBounds(10, 136, 316, 14);
		contentPane.add(lblTempo);
		
		JButton voltarButton = new JButton("Voltar");
		voltarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		voltarButton.setBounds(262, 140, 89, 23);
		contentPane.add(voltarButton);
		
	}

}
