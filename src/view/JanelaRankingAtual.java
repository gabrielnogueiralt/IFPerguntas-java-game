package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.ClasseDeCaminhos;
import model.Jogador;
import controler.Controladora;

public class JanelaRankingAtual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable rankingTable;
	private JLabel voltarInicioLabel;
	private JLabel rankingLabel;
	private DefaultTableModel model;

	/**
	 * Create the frame.
	 */
	public JanelaRankingAtual() {
		this.setTitle("IFPErguntas");
		model = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		rankingLabel = new JLabel("Ranking");
		rankingLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rankingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(rankingLabel, BorderLayout.NORTH);
		
		rankingTable = new JTable();		
		rankingTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int linhaSelecionada = rankingTable.getSelectedRow();				
				String nome = (String) model.getValueAt(linhaSelecionada, 0);
				Jogador j = Controladora.getInstance().getJogador(nome);
				JanelaDadosJogador jdj = new JanelaDadosJogador(j);
				jdj.setVisible(true);
			}
		});
		contentPane.add(rankingTable, BorderLayout.CENTER);
		
		voltarInicioLabel = new JLabel("");
//		voltarInicioLabel.setIcon(new ImageIcon("C:\\DIEGO\\workspace\\JogoPerguntas\\Arquivos\\Telas\\Fechar.png"));
		voltarInicioLabel.setIcon(new ImageIcon(ClasseDeCaminhos.getCaminhoBotaoFechar()));
		voltarInicioLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Controladora.getInstance().switchPrimeiraJanela();
			}
		});
		voltarInicioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(voltarInicioLabel, BorderLayout.SOUTH);
	}
	
	private String[][] getDadosJogadores(ArrayList<Jogador> jogadores){
		String[][] dados = new String[jogadores.size()][3];		
		int i = 0;
		for (Jogador jogador : jogadores) {
			dados[i][0] = jogador.getNome();
			dados[i][1] = Integer.toString((jogador.getPontuacao()));
			dados[i][2] = Float.toString((jogador.getTempo()));
			i++;
		}
		return dados;
	}
	
	private void removerDados() {
		int qte = model.getRowCount();
		for (int i = 0; i < qte; i++) {
			model.removeRow(0);
		}
		
	}
	
	private void inserirNovosDados(String[][] dados) {
		for (String[] s : dados) {
			model.addRow(s);
		}
		
	}
	
	public void setDados(String label, ArrayList<Jogador> jogadores){
		rankingLabel.setText(label);	
		
		String[][] dados = getDadosJogadores(jogadores);
		if(model == null){
			String[] colunas = new String[]{"Nome","Pontuação","Tempo"};			
			model = new DefaultTableModel(dados , colunas );
			rankingTable.setModel(model);
//			rankingTable.setEnabled(false);
//			rankingTable.setColumnSelectionAllowed(true);
			rankingTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			rankingTable.setColumnSelectionAllowed(false);
			rankingTable.setRowSelectionAllowed(true);
//			rankingTable.setEnabled(false);
			JScrollPane scroll = new JScrollPane();
			scroll.setViewportView(rankingTable);
			getContentPane().add(scroll);
			
		}else{
			removerDados();
			inserirNovosDados(dados);
		}	
		
	}

	

	

}
