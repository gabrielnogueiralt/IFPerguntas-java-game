package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controler.Controladora;

public class JanelaSenha extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane = new JPanel();
	private JPasswordField senhaTextField;
	private int tentativasSenha;

	/**
	 * Create the dialog.
	 */
	public JanelaSenha() {
		this.setTitle("IFPErguntas");
		tentativasSenha = 0;
		
		setBounds(100, 100, 278, 157);
//		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel senhaLabel = new JLabel("Senha: ");
		senhaLabel.setBounds(10, 11, 64, 14);
		contentPane.add(senhaLabel);
		
		JButton okButton = new JButton("OK");
		okButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(senhaTextField.getText().toString().equalsIgnoreCase("snct2015")){					
					tentativasSenha = 0;
					Controladora.getInstance().switchJanelaConfiguracoes();
				}else{
					JOptionPane.showMessageDialog(null, "Senha incorreta!!!");
					tentativasSenha++;
					if(tentativasSenha == 3){
						tentativasSenha = 0;
						JOptionPane.showMessageDialog(null, "Seu limite de tentativas se esgotou!!!");
						Controladora.getInstance().switchPrimeiraJanela();
					}
					
				}
				senhaTextField.setText("");
			}
		});
		okButton.setBounds(167, 85, 89, 23);
		contentPane.add(okButton);
		
		senhaTextField = new JPasswordField();
		senhaTextField.setBounds(84, 8, 172, 20);
		contentPane.add(senhaTextField);
		senhaTextField.setColumns(10);
		
	}
}
