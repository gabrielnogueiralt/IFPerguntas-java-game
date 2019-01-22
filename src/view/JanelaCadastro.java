package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controler.Controladora;
import excecoes.JogadorCadastradoException;
import model.ClasseDeCaminhos;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField telefoneTextField;
	private JTextField escolaTextField;
	private JTextField serieTextField;


	/**
	 * Create the frame.
	 */
	public JanelaCadastro() {
		this.setTitle("IFPErguntas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nomeTextField = new JTextField();
		nomeTextField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nomeTextField.setBounds(216, 205, 405, 47);
		contentPane.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		telefoneTextField = new JTextField();
		telefoneTextField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		telefoneTextField.setBounds(216, 263, 225, 45);
		contentPane.add(telefoneTextField);
		telefoneTextField.setColumns(10);
		
		escolaTextField = new JTextField();
		escolaTextField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		escolaTextField.setBounds(216, 319, 405, 47);
		contentPane.add(escolaTextField);
		escolaTextField.setColumns(10);
		
		serieTextField = new JTextField();
		serieTextField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		serieTextField.setBounds(216, 377, 225, 45);
		contentPane.add(serieTextField);
		serieTextField.setColumns(10);
		
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cadastrarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				String nome = nomeTextField.getText();
				String telefone = telefoneTextField.getText();
				String escola = escolaTextField.getText();
				String serie = serieTextField.getText();
				if(nome.equals("") || telefone.equals("") || escola.equals("") || serie.equals("")){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!");
				}else if(nome == null || telefone == null || escola == null || serie == null){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!");
				}else{
					try {
						Controladora.getInstance().instanciarJogador(nome, telefone, escola, serie);
						Controladora.getInstance().switchJanelaTemas();
					} catch (JogadorCadastradoException e) {
						JOptionPane.showMessageDialog(null, "Jogador já cadastrado!!!");
					}
					
				}
				
			}
		});
		cadastrarButton.setBounds(582, 426, 172, 45);
		contentPane.add(cadastrarButton);
		
		JLabel telaFundoLabel = new JLabel("");
//		telaFundoLabel.setIcon(new ImageIcon("C:\\DIEGO\\workspace\\JogoPerguntas\\Arquivos\\Telas\\Tela de Cadastro.jpg"));
		telaFundoLabel.setIcon(new ImageIcon(ClasseDeCaminhos.getCaminhoTelaDeCadastro()));
		telaFundoLabel.setBounds(0, 0, 790, 490);
		contentPane.add(telaFundoLabel);
	}


	public void zerarTextFields() {
		nomeTextField.setText("");
		telefoneTextField.setText("");
		escolaTextField.setText("");
		serieTextField.setText("");
		
	}
}
