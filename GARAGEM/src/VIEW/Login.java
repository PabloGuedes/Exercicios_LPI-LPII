package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Usuario;
	private JLabel lblNewLabel_1;
	private JPasswordField Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 310);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(12, 12, 416, 248);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(23, 75, 70, 15);
		panel.add(lblNewLabel);
		
		Usuario = new JTextField();
		Usuario.setBounds(111, 67, 200, 25);
		panel.add(Usuario);
		Usuario.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(23, 150, 70, 15);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(149, 211, 117, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Criptografia criptografia = new Criptografia("123456", Criptografia.MD5);
				System.out.println(criptografia.criptografar());
				if(Usuario.getText() != null && !Usuario.getText().isEmpty() && Senha.getText() != null && !Senha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnNewButton, "Informações válidas!");
					dispose();
					Principal principal = new Principal();
					principal.setLocationRelativeTo(null);
					principal.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Informações inválidas!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Tela de Login");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(135, 12, 142, 15);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		Senha = new JPasswordField();
		Senha.setBounds(111, 148, 200, 25);
		panel.add(Senha);
	}
}
