package br.com.farmaciasoft.view;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import br.com.farmaciasoft.core.entity.ClienteEntity;
import br.com.farmaciasoft.core.service.ClienteService;
import br.com.farmaciasoft.core.util.exception.BusinessException;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Tela_Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane_FarmaciaSoft;
	private JTextField textNome_Cliente;
	private JTextField textCPF_Cliente;
	private JTextField textIdade_Cliente;
	private JTextField textEndereco_Cliente;
	private JTextField textNumCasa_Cliente;
	private JTextField textCidade_Cliente;
	private JTextField textEstado_Cliente;
	private JTable table_Cliente;
	private List<ClienteEntity> clientes;
	private JTextField textID_Cliente;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private JTextField textNome_Funcionario;
	private JTextField textCPF_Funcionario;
	private JTextField textIdade_Funcionario;
	private JTextField textEndereco_Funcionario;
	private JTextField textNumCasa_Funcionario;
	private JTextField textCidade_Funcionario;
	private JTextField textEstado_Funcionario;
	private JTextField textID_Funcionario;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textCargo_Funcionario;
	private JTextField textLoja_Funcionario;
	private JTextField textSalario_Funcionario;
	private JTable table_Funcionario;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro frame = new Tela_Cadastro();
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
	public Tela_Cadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/main_icon.png")));
		setTitle("FarmaciaSoft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 695);
		contentPane_FarmaciaSoft = new JPanel();
		contentPane_FarmaciaSoft.setBackground(Color.BLACK);
		contentPane_FarmaciaSoft.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_FarmaciaSoft);
		
		JTabbedPane tabbedPane_FarmaciaSoft = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel painel_BoasVindas = new JPanel();
		painel_BoasVindas.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_BoasVindas.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Tela Inicial", null, painel_BoasVindas, null);
		
		JLabel lblFarmaciaSoft = new JLabel("FarmaciaSoft");
		lblFarmaciaSoft.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarmaciaSoft.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JTextPane txtpn_mensagemBV = new JTextPane();
		txtpn_mensagemBV.setBackground(Color.LIGHT_GRAY);
		txtpn_mensagemBV.setFont(new Font("Calibri", Font.BOLD, 16));
		txtpn_mensagemBV.setText("Seja Bem-vindo(a) ao projeto que estou realizando referente a cadastros!");
		GroupLayout gl_painel_BoasVindas = new GroupLayout(painel_BoasVindas);
		gl_painel_BoasVindas.setHorizontalGroup(
			gl_painel_BoasVindas.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painel_BoasVindas.createSequentialGroup()
					.addContainerGap(457, Short.MAX_VALUE)
					.addGroup(gl_painel_BoasVindas.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_painel_BoasVindas.createSequentialGroup()
							.addComponent(lblFarmaciaSoft, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(478))
						.addGroup(Alignment.TRAILING, gl_painel_BoasVindas.createSequentialGroup()
							.addComponent(txtpn_mensagemBV, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGap(454))))
		);
		gl_painel_BoasVindas.setVerticalGroup(
			gl_painel_BoasVindas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_BoasVindas.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFarmaciaSoft, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(164)
					.addComponent(txtpn_mensagemBV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(325))
		);
		painel_BoasVindas.setLayout(gl_painel_BoasVindas);
		
		JPanel painel_Cliente = new JPanel();
		painel_Cliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Cliente.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Cliente", null, painel_Cliente, null);
		
		JLabel lblCadastro_Cliente = new JLabel("Cadastro De Cliente");
		lblCadastro_Cliente.setVerticalAlignment(SwingConstants.TOP);
		lblCadastro_Cliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_Cliente.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JLabel lblNome_Cliente = new JLabel("Nome: ");
		lblNome_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCPF_Cliente = new JLabel("CPF:");
		lblCPF_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblCPF_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblIdade_Cliente = new JLabel("Idade:");
		lblIdade_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdade_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEndereco_Cliente = new JLabel("Endere\u00E7o:");
		lblEndereco_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereco_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNumCasa_Cliente = new JLabel("N\u00FAmero da casa:");
		lblNumCasa_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumCasa_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCidade_Cliente = new JLabel("Cidade:");
		lblCidade_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEstado_Cliente = new JLabel("Estado:");
		lblEstado_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JButton btnSalvar_Cliente = new JButton("Salvar Cadastro");
		btnSalvar_Cliente.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/floppy disk.png")));
		btnSalvar_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteEntity cliente = new ClienteEntity();
				cliente.setNome(textNome_Cliente.getText());
				cliente.setCpf(textCPF_Cliente.getText());
				cliente.setIdade(Integer.parseInt(textIdade_Cliente.getText()));
				cliente.setEndereco(textEndereco_Cliente.getText());
				cliente.setNum(Integer.parseInt(textNumCasa_Cliente.getText()));
				cliente.setCidade(textCidade_Cliente.getText());
				cliente.setEstado(textEstado_Cliente.getText());
				
				@SuppressWarnings("unused")
				String msg = null;
				try { 
					if(textID_Cliente.getText().equals("")) {
						msg = new ClienteService().salvarCliente(cliente);
						JOptionPane.showMessageDialog(null, "Cliente salvo!");
					}else {
						cliente.setCodigo(Long.parseLong(textID_Cliente.getText()));
						msg = new ClienteService().alterarCliente(cliente);
						JOptionPane.showMessageDialog(null, "Cliente Alterado");
					}
				} catch (BusinessException e1) {
					JOptionPane.showMessageDialog(null, e1.getErro());
				}
				}
		});
		btnSalvar_Cliente.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnLimpar_Cliente = new JButton("Limpar Formul\u00E1rio");
		btnLimpar_Cliente.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/clear.png")));
		btnLimpar_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome_Cliente.setText("");
				textCPF_Cliente.setText("");
				textIdade_Cliente.setText("");
				textEndereco_Cliente.setText("");
				textNumCasa_Cliente.setText("");
				textCidade_Cliente.setText("");
				textEstado_Cliente.setText("");
				textID_Cliente.setText("");
			}
		});
		btnLimpar_Cliente.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnAtualizar_Cliente = new JButton("Atualizar Tabela");
		btnAtualizar_Cliente.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/refresh.png")));
		btnAtualizar_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanciarTabela();
			}
		});
		btnAtualizar_Cliente.setFont(new Font("Calibri", Font.BOLD, 13));
		
		textNome_Cliente = new JTextField();
		textNome_Cliente.setEditable(false);
		textNome_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNome_Cliente.setColumns(10);
		
		textCPF_Cliente = new JTextField();
		textCPF_Cliente.setEditable(false);
		textCPF_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCPF_Cliente.setColumns(10);
		
		textIdade_Cliente = new JTextField();
		textIdade_Cliente.setEditable(false);
		textIdade_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textIdade_Cliente.setColumns(10);
		
		textEndereco_Cliente = new JTextField();
		textEndereco_Cliente.setEditable(false);
		textEndereco_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEndereco_Cliente.setColumns(10);
		
		textNumCasa_Cliente = new JTextField();
		textNumCasa_Cliente.setEditable(false);
		textNumCasa_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNumCasa_Cliente.setColumns(10);
		
		textCidade_Cliente = new JTextField();
		textCidade_Cliente.setEditable(false);
		textCidade_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCidade_Cliente.setColumns(10);
		
		textEstado_Cliente = new JTextField();
		textEstado_Cliente.setEditable(false);
		textEstado_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEstado_Cliente.setColumns(10);
		
		JButton btnDeletar_Cliente = new JButton("Deletar");
		btnDeletar_Cliente.setIcon(new ImageIcon("G:\\Curso Unisul\\FarmaciaSoft\\assets\\delete.png"));
		btnDeletar_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteEntity clienteSelecionado = clientes.get(table_Cliente.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o usuário de código " + clienteSelecionado.getCodigo()) == JOptionPane.OK_OPTION) {
					try {
						new ClienteService().excluirCliente(clienteSelecionado.getCodigo());
					} catch (BusinessException e1) {
						JOptionPane.showMessageDialog(null, e1.getErro());
					}
				}
			}
		});
		
		JButton btnNovo_Cliente = new JButton("Novo");
		btnNovo_Cliente.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/plus.png")));
		btnNovo_Cliente.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNovo_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome_Cliente.setEditable(true);
				textCPF_Cliente.setEditable(true);
				textIdade_Cliente.setEditable(true);
				textEndereco_Cliente.setEditable(true);
				textNumCasa_Cliente.setEditable(true);
				textCidade_Cliente.setEditable(true);
				textEstado_Cliente.setEditable(true);
			}
		});
		
		JButton btnCancelar_Cliente = new JButton("Cancelar");
		btnCancelar_Cliente.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/cancel.png")));
		btnCancelar_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome_Cliente.setEditable(false);
				textCPF_Cliente.setEditable(false);
				textIdade_Cliente.setEditable(false);
				textEndereco_Cliente.setEditable(false);
				textNumCasa_Cliente.setEditable(false);
				textCidade_Cliente.setEditable(false);
				textEstado_Cliente.setEditable(false);
				btnDeletar_Cliente.setEnabled(false);
			}
		});
		btnCancelar_Cliente.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JScrollPane scrollPane_Cliente = new JScrollPane();
		
		JLabel lblBuscar_Cliente = new JLabel("Procurar por ID:");
		lblBuscar_Cliente.setFont(new Font("Calibri", Font.BOLD, 14));
		
		btnDeletar_Cliente.setEnabled(false);
		btnDeletar_Cliente.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnBuscar_Cliente = new JButton("Ok");
		btnBuscar_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCliente(textID_Cliente.getText());
			}
		});
		btnBuscar_Cliente.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblID_Cliente = new JLabel("ID:");
		lblID_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblID_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textID_Cliente = new JTextField();
		textID_Cliente.setHorizontalAlignment(SwingConstants.CENTER);
		textID_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textID_Cliente.setColumns(10);
		
		JButton btnEditar_Cliente = new JButton("Editar");
		btnEditar_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome_Cliente.setEditable(true);
				textCPF_Cliente.setEditable(true);
				textIdade_Cliente.setEditable(true);
				textEndereco_Cliente.setEditable(true);
				textNumCasa_Cliente.setEditable(true);
				textCidade_Cliente.setEditable(true);
				textEstado_Cliente.setEditable(true);
			}
		});
		btnEditar_Cliente.setFont(new Font("Calibri", Font.PLAIN, 13));
		GroupLayout gl_painel_Cliente = new GroupLayout(painel_Cliente);
		gl_painel_Cliente.setHorizontalGroup(
			gl_painel_Cliente.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painel_Cliente.createSequentialGroup()
					.addContainerGap(450, Short.MAX_VALUE)
					.addComponent(lblCadastro_Cliente, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(448))
				.addGroup(gl_painel_Cliente.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addComponent(btnNovo_Cliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar_Cliente, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar_Cliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeletar_Cliente)
					.addGap(353))
				.addGroup(gl_painel_Cliente.createSequentialGroup()
					.addContainerGap(226, Short.MAX_VALUE)
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdade_Cliente)
						.addComponent(lblEndereco_Cliente)
						.addComponent(lblCPF_Cliente)
						.addComponent(lblNome_Cliente))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Cliente.createSequentialGroup()
							.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.TRAILING)
								.addComponent(textCPF_Cliente, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNome_Cliente, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCidade_Cliente)
								.addComponent(lblNumCasa_Cliente)))
						.addGroup(gl_painel_Cliente.createSequentialGroup()
							.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.TRAILING)
								.addComponent(textIdade_Cliente, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEndereco_Cliente, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.LEADING)
								.addComponent(lblID_Cliente, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEstado_Cliente))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.LEADING)
						.addComponent(textNumCasa_Cliente, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCidade_Cliente, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(textEstado_Cliente, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(textID_Cliente, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
					.addGap(224))
				.addGroup(Alignment.LEADING, gl_painel_Cliente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_Cliente, GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
						.addGroup(gl_painel_Cliente.createSequentialGroup()
							.addComponent(lblBuscar_Cliente)
							.addGap(10)
							.addComponent(btnBuscar_Cliente, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(161)
							.addComponent(btnSalvar_Cliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLimpar_Cliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAtualizar_Cliente)))
					.addContainerGap())
		);
		gl_painel_Cliente.setVerticalGroup(
			gl_painel_Cliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_Cliente.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_Cliente)
					.addGap(22)
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovo_Cliente)
						.addComponent(btnEditar_Cliente, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar_Cliente)
						.addComponent(btnDeletar_Cliente, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNome_Cliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumCasa_Cliente)
						.addComponent(textNumCasa_Cliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome_Cliente))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCidade_Cliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCPF_Cliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCPF_Cliente)
						.addComponent(lblCidade_Cliente))
					.addGap(6)
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(textIdade_Cliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textEstado_Cliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdade_Cliente)
						.addComponent(lblEstado_Cliente))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.LEADING)
						.addComponent(textID_Cliente, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.BASELINE)
							.addComponent(textEndereco_Cliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEndereco_Cliente)
							.addComponent(lblID_Cliente, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_painel_Cliente.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuscar_Cliente)
								.addComponent(lblBuscar_Cliente))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_painel_Cliente.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLimpar_Cliente)
								.addComponent(btnAtualizar_Cliente)
								.addComponent(btnSalvar_Cliente))
							.addGap(6)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_Cliente, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table_Cliente = new JTable();
		table_Cliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDeletar_Cliente.setEnabled(true);
			}
		});
		
		
		table_Cliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Idade", "Endere\u00E7o", "N\u00FAmero", "Cidade", "Estado"
			}
		));
		scrollPane_Cliente.setViewportView(table_Cliente);
		painel_Cliente.setLayout(gl_painel_Cliente);
		
		JPanel painel_Funcionario = new JPanel();
		painel_Funcionario.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Funcionario.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Funcionario", null, painel_Funcionario, null);
		
		JLabel lblCadastro_Funcionario = new JLabel("Cadastro de Funcion\u00E1rio");
		lblCadastro_Funcionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_Funcionario.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JButton btnNovo_Funcionario = new JButton("Novo");
		btnNovo_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnEditar_Funcionario = new JButton("Editar");
		btnEditar_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnCancelar_Funcionario = new JButton("Cancelar");
		btnCancelar_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnDeletar_Funcionario = new JButton("Deletar");
		btnDeletar_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JLabel lblNome_Funcionario = new JLabel("Nome:");
		lblNome_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCPF_Funcionario = new JLabel("CPF:");
		lblCPF_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblIdade_Funcionario = new JLabel("Idade:");
		lblIdade_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEndereco_Funcionario = new JLabel("Endere\u00E7o:");
		lblEndereco_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textNome_Funcionario = new JTextField();
		textNome_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNome_Funcionario.setEditable(false);
		textNome_Funcionario.setColumns(10);
		
		textCPF_Funcionario = new JTextField();
		textCPF_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCPF_Funcionario.setEditable(false);
		textCPF_Funcionario.setColumns(10);
		
		textIdade_Funcionario = new JTextField();
		textIdade_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textIdade_Funcionario.setEditable(false);
		textIdade_Funcionario.setColumns(10);
		
		textEndereco_Funcionario = new JTextField();
		textEndereco_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEndereco_Funcionario.setEditable(false);
		textEndereco_Funcionario.setColumns(10);
		
		JLabel lblNumCasa_Funcionario = new JLabel("N\u00FAmero da casa:");
		lblNumCasa_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCidade_Funcionario = new JLabel("Cidade:");
		lblCidade_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEstado_Funcionario = new JLabel("Estado:");
		lblEstado_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblID_Funcionario = new JLabel("ID:");
		lblID_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textNumCasa_Funcionario = new JTextField();
		textNumCasa_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNumCasa_Funcionario.setEditable(false);
		textNumCasa_Funcionario.setColumns(10);
		
		textCidade_Funcionario = new JTextField();
		textCidade_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCidade_Funcionario.setEditable(false);
		textCidade_Funcionario.setColumns(10);
		
		textEstado_Funcionario = new JTextField();
		textEstado_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEstado_Funcionario.setEditable(false);
		textEstado_Funcionario.setColumns(10);
		
		textID_Funcionario = new JTextField();
		textID_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textID_Funcionario.setEditable(false);
		textID_Funcionario.setColumns(10);
		
		JButton btnSalvar_Funcionario = new JButton("Salvar Cadastro");
		btnSalvar_Funcionario.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnLimpar_Funcionario = new JButton("Limpar Formul\u00E1rio");
		btnLimpar_Funcionario.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnAtualizar_Funcionario = new JButton("Atualizar Tabela");
		btnAtualizar_Funcionario.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JScrollPane scrollPane_Funcionario = new JScrollPane();
		
		JLabel lblCargo_Funcionario = new JLabel("Cargo:");
		lblCargo_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textCargo_Funcionario = new JTextField();
		textCargo_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCargo_Funcionario.setEditable(false);
		textCargo_Funcionario.setColumns(10);
		
		JLabel lblLoja_Funcionario = new JLabel("Loja:");
		lblLoja_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textLoja_Funcionario = new JTextField();
		textLoja_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textLoja_Funcionario.setEditable(false);
		textLoja_Funcionario.setColumns(10);
		
		JLabel lblSalario_Funcionario = new JLabel("Sal\u00E1rio:");
		lblSalario_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textSalario_Funcionario = new JTextField();
		textSalario_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textSalario_Funcionario.setEditable(false);
		textSalario_Funcionario.setColumns(10);
		
		JLabel lblBuscar_1 = new JLabel("Procurar por ID:");
		lblBuscar_1.setFont(new Font("Calibri", Font.BOLD, 14));
		GroupLayout gl_painel_Funcionario = new GroupLayout(painel_Funcionario);
		gl_painel_Funcionario.setHorizontalGroup(
			gl_painel_Funcionario.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painel_Funcionario.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_painel_Funcionario.createSequentialGroup()
										.addComponent(lblBuscar_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addGap(248)
										.addComponent(btnSalvar_Funcionario)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnLimpar_Funcionario)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnAtualizar_Funcionario)
										.addContainerGap(350, Short.MAX_VALUE))
									.addGroup(Alignment.TRAILING, gl_painel_Funcionario.createSequentialGroup()
										.addComponent(lblCadastro_Funcionario)
										.addGap(437)))
								.addGroup(Alignment.TRAILING, gl_painel_Funcionario.createSequentialGroup()
									.addComponent(btnNovo_Funcionario, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnEditar_Funcionario)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCancelar_Funcionario)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnDeletar_Funcionario)
									.addGap(391)))
							.addGroup(Alignment.TRAILING, gl_painel_Funcionario.createSequentialGroup()
								.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_painel_Funcionario.createSequentialGroup()
										.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
											.addComponent(lblCPF_Funcionario)
											.addComponent(lblNome_Funcionario)
											.addComponent(lblEndereco_Funcionario)
											.addComponent(lblIdade_Funcionario))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_painel_Funcionario.createSequentialGroup()
												.addComponent(textCPF_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblCidade_Funcionario))
											.addGroup(gl_painel_Funcionario.createSequentialGroup()
												.addComponent(textNome_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblNumCasa_Funcionario))
											.addGroup(gl_painel_Funcionario.createSequentialGroup()
												.addComponent(textIdade_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblEstado_Funcionario))
											.addGroup(gl_painel_Funcionario.createSequentialGroup()
												.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.TRAILING)
													.addComponent(textCargo_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
													.addComponent(textEndereco_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
													.addComponent(lblLoja_Funcionario, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblID_Funcionario)))))
									.addComponent(lblCargo_Funcionario))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
									.addComponent(textLoja_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
									.addComponent(textNumCasa_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
									.addComponent(textCidade_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
									.addComponent(textEstado_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
									.addComponent(textID_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
								.addGap(228)))
						.addGroup(Alignment.TRAILING, gl_painel_Funcionario.createSequentialGroup()
							.addComponent(lblSalario_Funcionario, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textSalario_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addGap(398))))
				.addGroup(gl_painel_Funcionario.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane_Funcionario, GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
					.addGap(9))
		);
		gl_painel_Funcionario.setVerticalGroup(
			gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_Funcionario.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_Funcionario)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovo_Funcionario)
						.addComponent(btnEditar_Funcionario)
						.addComponent(btnCancelar_Funcionario)
						.addComponent(btnDeletar_Funcionario))
					.addGap(18)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome_Funcionario)
								.addComponent(textNome_Funcionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumCasa_Funcionario))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCPF_Funcionario)
								.addComponent(textCPF_Funcionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCidade_Funcionario))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.BASELINE)
								.addComponent(textIdade_Funcionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEstado_Funcionario)
								.addComponent(lblIdade_Funcionario))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEndereco_Funcionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndereco_Funcionario)
								.addComponent(lblID_Funcionario)))
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addComponent(textNumCasa_Funcionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textCidade_Funcionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textEstado_Funcionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textID_Funcionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCargo_Funcionario)
							.addComponent(lblLoja_Funcionario, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addComponent(textCargo_Funcionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textLoja_Funcionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSalario_Funcionario, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textSalario_Funcionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar_Funcionario)
						.addComponent(btnLimpar_Funcionario)
						.addComponent(btnAtualizar_Funcionario)
						.addComponent(lblBuscar_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane_Funcionario, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table_Funcionario = new JTable();
		table_Funcionario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_Funcionario.setViewportView(table_Funcionario);
		painel_Funcionario.setLayout(gl_painel_Funcionario);
		
		JPanel painel_Fornecedor = new JPanel();
		painel_Fornecedor.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Fornecedor.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Fornecedor", null, painel_Fornecedor, null);
		
		JLabel lblCadastro_F = new JLabel("Cadastro de Fornecedor");
		lblCadastro_F.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_F.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Novo");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnNewButton_3 = new JButton("Deletar");
		btnNewButton_3.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("Nome da empresa:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("CNPJ:");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero:");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cidade:");
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("Estado:");
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_1 = new JLabel("ID:");
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Salvar Cadastro");
		btnNewButton_4.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnNewButton_4_1 = new JButton("Limpar Formul\u00E1rio");
		btnNewButton_4_1.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnNewButton_4_2 = new JButton("Atualizar Tabela");
		btnNewButton_4_2.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblBuscar_2 = new JLabel("Procurar por ID:");
		lblBuscar_2.setFont(new Font("Calibri", Font.BOLD, 14));
		GroupLayout gl_painel_Fornecedor = new GroupLayout(painel_Fornecedor);
		gl_painel_Fornecedor.setHorizontalGroup(
			gl_painel_Fornecedor.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_painel_Fornecedor.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBuscar_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(248)
					.addComponent(btnNewButton_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4_2)
					.addContainerGap(350, Short.MAX_VALUE))
				.addGroup(gl_painel_Fornecedor.createSequentialGroup()
					.addContainerGap(354, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(352))
				.addGroup(gl_painel_Fornecedor.createSequentialGroup()
					.addContainerGap(442, Short.MAX_VALUE)
					.addComponent(lblCadastro_F)
					.addGap(439))
				.addGroup(Alignment.LEADING, gl_painel_Fornecedor.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_painel_Fornecedor.createSequentialGroup()
					.addContainerGap(218, Short.MAX_VALUE)
					.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_1)
						.addComponent(lblNewLabel_1_1)
						.addComponent(lblNewLabel_4))
					.addGap(24)
					.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
					.addGap(215))
		);
		gl_painel_Fornecedor.setVerticalGroup(
			gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_Fornecedor.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_F)
					.addGap(18)
					.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(18)
					.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Fornecedor.createSequentialGroup()
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(6)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addGap(6)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(6)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)))
						.addGroup(gl_painel_Fornecedor.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4))
							.addGap(6)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1))
							.addGap(6)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1))))
					.addGap(11)
					.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_4_1)
						.addComponent(btnNewButton_4_2)
						.addComponent(lblBuscar_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		painel_Fornecedor.setLayout(gl_painel_Fornecedor);
		
		JPanel painel_Produtos = new JPanel();
		painel_Produtos.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Produtos.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Produtos", null, painel_Produtos, null);
		
		JLabel lblCadastro_P = new JLabel("Cadastro de Produtos");
		lblCadastro_P.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_P.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		
		JButton btnNewButton_5_1 = new JButton("Novo");
		btnNewButton_5_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnNewButton_6_1 = new JButton("Editar");
		btnNewButton_6_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnNewButton_7_1 = new JButton("Cancelar");
		btnNewButton_7_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnNewButton_8_1 = new JButton("Deletar");
		btnNewButton_8_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JLabel lblNewLabel_8_1 = new JLabel("Pre\u00E7o de venda:");
		lblNewLabel_8_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNewLabel_7_1 = new JLabel("Pre\u00E7o de custo:");
		lblNewLabel_7_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNewLabel_6_1 = new JLabel("C\u00F3digo de barras:");
		lblNewLabel_6_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNewLabel_5_1 = new JLabel("Produto:");
		lblNewLabel_5_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		
		JLabel lblNewLabel_9_4 = new JLabel("ID:");
		lblNewLabel_9_4.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		
		JButton btnNewButton_9_3 = new JButton("Salvar Cadastro");
		btnNewButton_9_3.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnNewButton_9_1_1 = new JButton("Limpar Formul\u00E1rio");
		btnNewButton_9_1_1.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnNewButton_9_2_1 = new JButton("Atualizar Tabela");
		btnNewButton_9_2_1.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JLabel lblBuscar_3 = new JLabel("Procurar por ID:");
		lblBuscar_3.setFont(new Font("Calibri", Font.BOLD, 14));
		GroupLayout gl_painel_Produtos = new GroupLayout(painel_Produtos);
		gl_painel_Produtos.setHorizontalGroup(
			gl_painel_Produtos.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painel_Produtos.createSequentialGroup()
					.addContainerGap(451, Short.MAX_VALUE)
					.addComponent(lblCadastro_P)
					.addGap(448))
				.addGroup(gl_painel_Produtos.createSequentialGroup()
					.addContainerGap(343, Short.MAX_VALUE)
					.addComponent(btnNewButton_5_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_6_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_7_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_8_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(341))
				.addGroup(gl_painel_Produtos.createSequentialGroup()
					.addContainerGap(201, Short.MAX_VALUE)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5_1)
						.addComponent(lblNewLabel_7_1)
						.addComponent(lblNewLabel_8_1))
					.addGap(26)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painel_Produtos.createSequentialGroup()
							.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6_1)
								.addComponent(lblNewLabel_9_4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))))
					.addGap(199))
				.addGroup(gl_painel_Produtos.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBuscar_3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
					.addComponent(btnNewButton_9_3)
					.addGap(6)
					.addComponent(btnNewButton_9_1_1)
					.addGap(6)
					.addComponent(btnNewButton_9_2_1)
					.addGap(350))
				.addGroup(Alignment.LEADING, gl_painel_Produtos.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane_1_1, GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_painel_Produtos.setVerticalGroup(
			gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_Produtos.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_P)
					.addGap(11)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_5_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_6_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_7_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_8_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5_1)
						.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6_1))
					.addGap(9)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8_1)
						.addComponent(lblNewLabel_9_4))
					.addGap(12)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7_1)
						.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_9_3)
							.addComponent(lblBuscar_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_9_1_1)
						.addComponent(btnNewButton_9_2_1))
					.addGap(42)
					.addComponent(scrollPane_1_1, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_1_1.setViewportView(table_2);
		painel_Produtos.setLayout(gl_painel_Produtos);
		GroupLayout gl_contentPane_FarmaciaSoft = new GroupLayout(contentPane_FarmaciaSoft);
		gl_contentPane_FarmaciaSoft.setHorizontalGroup(
			gl_contentPane_FarmaciaSoft.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_FarmaciaSoft, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane_FarmaciaSoft.setVerticalGroup(
			gl_contentPane_FarmaciaSoft.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_FarmaciaSoft, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		contentPane_FarmaciaSoft.setLayout(gl_contentPane_FarmaciaSoft);
			
		}
		private void instanciarTabela() {
			try {
				clientes = new ClienteService().listarCliente();
				DefaultTableModel model = (DefaultTableModel)table_Cliente.getModel();
				model.getDataVector().removeAllElements();
				
				for (ClienteEntity clienteEntity : clientes) {
					model.addRow(new Object[] {clienteEntity.getCodigo(), clienteEntity.getNome(), clienteEntity.getCpf(), clienteEntity.getIdade(), clienteEntity.getEndereco(), clienteEntity.getNum(), clienteEntity.getCidade(), clienteEntity.getEstado()});
				}
				
			} catch (BusinessException e) {
				JOptionPane.showMessageDialog(null, "Erro ao listar os Clientes.");
			}
		}
		
		public void carregarCliente(String nomeCliente) {
			try {
				ClienteEntity clienteEncontrado = new ClienteService().buscarPorNome(nomeCliente);
				
				if(clienteEncontrado == null) {
					JOptionPane.showMessageDialog(null, "O cliente não foi encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					textNome_Cliente.setText(clienteEncontrado.getNome());
					textCPF_Cliente.setText(clienteEncontrado.getCpf());
					textIdade_Cliente.setText(String.valueOf(clienteEncontrado.getIdade()));
					textEndereco_Cliente.setText(clienteEncontrado.getEndereco());
					textNumCasa_Cliente.setText(String.valueOf(clienteEncontrado.getNum()));
					textCidade_Cliente.setText(clienteEncontrado.getCidade());
					textEstado_Cliente.setText(clienteEncontrado.getEstado());
				}
				
			} catch (BusinessException e) {
				JOptionPane.showMessageDialog(null, e.getErro(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
		}
}
