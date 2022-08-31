package br.com.farmaciasoft.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.farmaciasoft.core.entity.ClienteEntity;
import br.com.farmaciasoft.core.service.ClienteService;
import br.com.farmaciasoft.core.util.exception.BusinessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Tela_Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Login frame = new Tela_Login();
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
	public Tela_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLogin = new JLabel("Tela de Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Calibri", Font.BOLD, 24));
		lblLogin.setBounds(222, 11, 139, 30);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Calibri", Font.BOLD, 22));
		lblUsuario.setBounds(159, 170, 86, 28);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Calibri", Font.BOLD, 22));
		lblSenha.setBounds(159, 209, 86, 28);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Calibri", Font.BOLD, 14));
		textUsuario.setBounds(285, 169, 150, 28);
		textUsuario.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblUsuario);
		contentPane.add(textUsuario);
		contentPane.add(lblSenha);
		contentPane.add(lblLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteEntity autenticado = new ClienteService().autenticar(textUsuario.getText(), new String(passwordUsuario.getPassword()));
					
					if (autenticado != null) {
						Tela_Cadastro tc = new Tela_Cadastro();
						tc.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Erro ao logar!");
					}
					
				} catch (BusinessException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(147, 281, 139, 23);
		contentPane.add(btnLogin);
		
		JLabel lblDica = new JLabel("");
		lblDica.setForeground(Color.WHITE);
		lblDica.setHorizontalAlignment(SwingConstants.CENTER);
		lblDica.setBounds(222, 248, 150, 14);
		contentPane.add(lblDica);
		
		JButton btnEsqueci = new JButton("Esqueci a senha");
		btnEsqueci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDica.setText("Dica é Dev-TI!");
			}
		});
		btnEsqueci.setBounds(296, 281, 139, 23);
		contentPane.add(btnEsqueci);
		
		passwordUsuario = new JPasswordField();
		passwordUsuario.setFont(new Font("Calibri", Font.BOLD, 14));
		passwordUsuario.setBounds(285, 208, 150, 28);
		contentPane.add(passwordUsuario);
	}
}
