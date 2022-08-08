package br.com.farmaciasoft.view;

/* Importação das bibliotecas usadas */
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
import br.com.farmaciasoft.core.entity.FornecedorEntity;
import br.com.farmaciasoft.core.entity.FuncionarioEntity;
import br.com.farmaciasoft.core.entity.ProdutoEntity;
import br.com.farmaciasoft.core.service.ClienteService;
import br.com.farmaciasoft.core.service.FornecedorService;
import br.com.farmaciasoft.core.service.FuncionarioService;
import br.com.farmaciasoft.core.service.ProdutoService;
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

	/* Váriaveis da aplicação */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane_FarmaciaSoft;
	private List<ClienteEntity> clientes;
	private List<FornecedorEntity> fornecedores;
	private List<FuncionarioEntity> funcionarios;
	private List<ProdutoEntity> produtos;
	private JTable table_Cliente, table_Fornecedor, table_Funcionario, table_Produto;
	private JTextField textNome_Cliente, textCPF_Cliente, textIdade_Cliente, textEndereco_Cliente, textNumCasa_Cliente, textCidade_Cliente, textEstado_Cliente;
	private JTextField textID_Cliente, textEmpresa_Fornecedor, textCNPJ_Fornecedor, textEndereco_Fornecedor, textNum_Fornecedor, textID_Fornecedor, 
	textEstado_Fornecedor, textCidade_Fornecedor;
	private JTextField textNome_Funcionario, textCPF_Funcionario, textIdade_Funcionario, textEndereco_Funcionario, 
	textNumCasa_Funcionario, textCidade_Funcionario, textEstado_Funcionario, textID_Funcionario;
	private JTextField textID_Produto, textCusto_Produto, textVenda_Produto, textProduto_Produto, textCodigo_Produto, 
	textCargo_Funcionario, textLoja_Funcionario, textSalario_Funcionario;


	/* Lançar Aplicação */
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

	/* Criação do frame */
	public Tela_Cadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/main_icon.png")));
		setTitle("FarmaciaSoft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1230, 695);
		contentPane_FarmaciaSoft = new JPanel();
		contentPane_FarmaciaSoft.setBackground(Color.BLACK);
		contentPane_FarmaciaSoft.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_FarmaciaSoft);
		
		JTabbedPane tabbedPane_FarmaciaSoft = new JTabbedPane(JTabbedPane.TOP);
		
		/* Inicio da tela de Boas Vindas */
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
			gl_painel_BoasVindas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_BoasVindas.createSequentialGroup()
					.addGroup(gl_painel_BoasVindas.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_painel_BoasVindas.createSequentialGroup()
							.addComponent(lblFarmaciaSoft, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(24))
						.addGroup(gl_painel_BoasVindas.createSequentialGroup()
							.addContainerGap(517, Short.MAX_VALUE)
							.addComponent(txtpn_mensagemBV, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
					.addGap(515))
		);
		gl_painel_BoasVindas.setVerticalGroup(
			gl_painel_BoasVindas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_BoasVindas.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFarmaciaSoft, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(164)
					.addComponent(txtpn_mensagemBV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(332, Short.MAX_VALUE))
		);
		painel_BoasVindas.setLayout(gl_painel_BoasVindas);
		/* Fim da tela de Boas Vindas */
		
		/* Inicio da tela do Cliente */
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
		btnSalvar_Cliente.setBackground(Color.WHITE);
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
		btnLimpar_Cliente.setBackground(Color.WHITE);
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
		btnAtualizar_Cliente.setBackground(Color.WHITE);
		btnAtualizar_Cliente.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/refresh.png")));
		btnAtualizar_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanciarTabelaCli();
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
		btnDeletar_Cliente.setBackground(Color.WHITE);
		btnDeletar_Cliente.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/delete.png")));
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
		btnNovo_Cliente.setBackground(Color.WHITE);
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
		btnCancelar_Cliente.setBackground(Color.WHITE);
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
		btnBuscar_Cliente.setBackground(Color.WHITE);
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
		btnEditar_Cliente.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/Gear.png")));
		btnEditar_Cliente.setBackground(Color.WHITE);
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
			gl_painel_Cliente.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_painel_Cliente.createSequentialGroup()
					.addContainerGap(510, Short.MAX_VALUE)
					.addComponent(lblCadastro_Cliente, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(509))
				.addGroup(Alignment.TRAILING, gl_painel_Cliente.createSequentialGroup()
					.addContainerGap(408, Short.MAX_VALUE)
					.addComponent(btnNovo_Cliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar_Cliente, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar_Cliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeletar_Cliente)
					.addGap(407))
				.addGroup(Alignment.TRAILING, gl_painel_Cliente.createSequentialGroup()
					.addContainerGap(286, Short.MAX_VALUE)
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
					.addGap(285))
				.addGroup(gl_painel_Cliente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Cliente.createSequentialGroup()
							.addComponent(scrollPane_Cliente, GroupLayout.PREFERRED_SIZE, 1183, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_painel_Cliente.createSequentialGroup()
							.addComponent(lblBuscar_Cliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscar_Cliente, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSalvar_Cliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLimpar_Cliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAtualizar_Cliente)
							.addGap(381))))
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
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBuscar_Cliente)
							.addComponent(btnBuscar_Cliente))
						.addGroup(gl_painel_Cliente.createSequentialGroup()
							.addGroup(gl_painel_Cliente.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLimpar_Cliente)
								.addComponent(btnAtualizar_Cliente)
								.addComponent(btnSalvar_Cliente))
							.addGap(6)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_Cliente, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
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
		/* Fim da tela do Cliente */
		
		/* Inicio da tela do Fornecedor */
		JPanel painel_Fornecedor = new JPanel();
		painel_Fornecedor.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Fornecedor.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Fornecedor", null, painel_Fornecedor, null);
		
		JLabel lblCadastro_Fornecedor = new JLabel("Cadastro de Fornecedor");
		lblCadastro_Fornecedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_Fornecedor.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JButton btnNovo_Fornecedor = new JButton("Novo");
		btnNovo_Fornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textEmpresa_Fornecedor.setEditable(true);
				textCidade_Fornecedor.setEditable(true);
				textCNPJ_Fornecedor.setEditable(true);
				textEndereco_Fornecedor.setEditable(true);
				textEstado_Fornecedor.setEditable(true);
				textNum_Fornecedor.setEditable(true);
			}
		});
		btnNovo_Fornecedor.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/plus.png")));
		btnNovo_Fornecedor.setBackground(Color.WHITE);
		btnNovo_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnEditar_Fornecedor = new JButton("Editar");
		btnEditar_Fornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textEmpresa_Fornecedor.setEditable(true);
				textCidade_Fornecedor.setEditable(true);
				textCNPJ_Fornecedor.setEditable(true);
				textEndereco_Fornecedor.setEditable(true);
				textEstado_Fornecedor.setEditable(true);
				textNum_Fornecedor.setEditable(true);
			}
		});
		btnEditar_Fornecedor.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/Gear.png")));
		btnEditar_Fornecedor.setBackground(Color.WHITE);
		btnEditar_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnDeletar_Fornecedor = new JButton("Deletar");
		btnDeletar_Fornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorEntity fornecedorSelecionado = fornecedores.get(table_Fornecedor.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o fornecedor de código " + fornecedorSelecionado.getCodigo()) == JOptionPane.OK_OPTION) {
					try {
						new FornecedorService().excluirFornecedor(fornecedorSelecionado.getCodigo());
					} catch (BusinessException e1) {
						JOptionPane.showMessageDialog(null, e1.getErro());
					}
				}
			}
		});
		
		btnDeletar_Fornecedor.setEnabled(false);
		btnDeletar_Fornecedor.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/delete.png")));
		btnDeletar_Fornecedor.setBackground(Color.WHITE);
		btnDeletar_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnCancelar_Fornecedor = new JButton("Cancelar");
		btnCancelar_Fornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textEmpresa_Fornecedor.setEditable(false);
				textCidade_Fornecedor.setEditable(false);
				textCNPJ_Fornecedor.setEditable(false);
				textEndereco_Fornecedor.setEditable(false);
				textEstado_Fornecedor.setEditable(false);
				textNum_Fornecedor.setEditable(false);
				btnDeletar_Fornecedor.setEnabled(false);
			}
		});
		btnCancelar_Fornecedor.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/cancel.png")));
		btnCancelar_Fornecedor.setBackground(Color.WHITE);
		btnCancelar_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JLabel lblEmpresa_Fornecedor = new JLabel("Nome da empresa:");
		lblEmpresa_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCNPJ_Fornecedor = new JLabel("CNPJ:");
		lblCNPJ_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEndereco_Fornecedor = new JLabel("Endere\u00E7o:");
		lblEndereco_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNum_Fornecedor = new JLabel("N\u00FAmero:");
		lblNum_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textEmpresa_Fornecedor = new JTextField();
		textEmpresa_Fornecedor.setEditable(false);
		textEmpresa_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEmpresa_Fornecedor.setColumns(10);
		
		textCNPJ_Fornecedor = new JTextField();
		textCNPJ_Fornecedor.setEditable(false);
		textCNPJ_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCNPJ_Fornecedor.setColumns(10);
		
		textEndereco_Fornecedor = new JTextField();
		textEndereco_Fornecedor.setEditable(false);
		textEndereco_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEndereco_Fornecedor.setColumns(10);
		
		textNum_Fornecedor = new JTextField();
		textNum_Fornecedor.setEditable(false);
		textNum_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNum_Fornecedor.setColumns(10);
		
		JLabel lblCidade_Fornecedor = new JLabel("Cidade:");
		lblCidade_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEstado_Fornecedor = new JLabel("Estado:");
		lblEstado_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblID_Fornecedor = new JLabel("ID:");
		lblID_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textID_Fornecedor = new JTextField();
		textID_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textID_Fornecedor.setColumns(10);
		
		textEstado_Fornecedor = new JTextField();
		textEstado_Fornecedor.setEditable(false);
		textEstado_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEstado_Fornecedor.setColumns(10);
		
		textCidade_Fornecedor = new JTextField();
		textCidade_Fornecedor.setEditable(false);
		textCidade_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCidade_Fornecedor.setColumns(10);
		
		JButton btnSalvar_Fornecedor = new JButton("Salvar Cadastro");
		btnSalvar_Fornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorEntity fornecedor = new FornecedorEntity();
				fornecedor.setNome(textEmpresa_Fornecedor.getText());
				fornecedor.setCnpj(textCNPJ_Fornecedor.getText());
				fornecedor.setNum(Integer.parseInt(textNum_Fornecedor.getText()));
				fornecedor.setEndereco(textEndereco_Fornecedor.getText());
				fornecedor.setCidade(textCidade_Fornecedor.getText());
				fornecedor.setEstado(textEstado_Fornecedor.getText());
				
				@SuppressWarnings("unused")
				String msg = null;
				try { 
					if(textID_Fornecedor.getText().equals("")) {
						msg = new FornecedorService().salvarFornecedor(fornecedor);
						JOptionPane.showMessageDialog(null, "Fornecedor salvo!");
					}else {
						fornecedor.setCodigo(Long.parseLong(textID_Fornecedor.getText()));
						msg = new FornecedorService().alterarFornecedor(fornecedor);
						JOptionPane.showMessageDialog(null, "Fornecedor Alterado!");
					}
				} catch (BusinessException e1) {
					JOptionPane.showMessageDialog(null, e1.getErro());
				}
			}
		});
		btnSalvar_Fornecedor.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/floppy disk.png")));
		btnSalvar_Fornecedor.setBackground(Color.WHITE);
		btnSalvar_Fornecedor.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnLimpar_Fornecedor = new JButton("Limpar Formul\u00E1rio");
		btnLimpar_Fornecedor.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/clear.png")));
		btnLimpar_Fornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCidade_Fornecedor.setText("");
				textCNPJ_Fornecedor.setText("");
				textEmpresa_Fornecedor.setText("");
				textEndereco_Fornecedor.setText("");
				textEstado_Fornecedor.setText("");
				textID_Fornecedor.setText("");
				textNum_Fornecedor.setText("");
			}
		});
		btnLimpar_Fornecedor.setBackground(Color.WHITE);
		btnLimpar_Fornecedor.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnAtualizar_Fornecedor = new JButton("Atualizar Tabela");
		btnAtualizar_Fornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanciarTabelaForne();
			}
		});
		btnAtualizar_Fornecedor.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/refresh.png")));
		btnAtualizar_Fornecedor.setBackground(Color.WHITE);
		btnAtualizar_Fornecedor.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JScrollPane scrollPane_Fornecedor = new JScrollPane();
		
		JLabel lblBuscar_Fornecedor = new JLabel("Procurar por ID:");
		lblBuscar_Fornecedor.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btnOk_Fornecedor = new JButton("Ok");
		btnOk_Fornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarFornecedor(textID_Fornecedor.getText());
			}
		});
		btnOk_Fornecedor.setBackground(Color.WHITE);
		GroupLayout gl_painel_Fornecedor = new GroupLayout(painel_Fornecedor);
		gl_painel_Fornecedor.setHorizontalGroup(
			gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_Fornecedor.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_painel_Fornecedor.createSequentialGroup()
								.addComponent(lblBuscar_Fornecedor, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnOk_Fornecedor)
								.addGap(229)
								.addComponent(btnSalvar_Fornecedor)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnLimpar_Fornecedor)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnAtualizar_Fornecedor)
								.addContainerGap(381, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_painel_Fornecedor.createSequentialGroup()
								.addComponent(lblCadastro_Fornecedor)
								.addGap(500))
							.addGroup(Alignment.TRAILING, gl_painel_Fornecedor.createSequentialGroup()
								.addComponent(btnNovo_Fornecedor, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnEditar_Fornecedor, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnCancelar_Fornecedor)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnDeletar_Fornecedor)
								.addGap(401))
							.addGroup(gl_painel_Fornecedor.createSequentialGroup()
								.addComponent(scrollPane_Fornecedor, GroupLayout.DEFAULT_SIZE, 1183, Short.MAX_VALUE)
								.addContainerGap()))
						.addGroup(Alignment.TRAILING, gl_painel_Fornecedor.createSequentialGroup()
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNum_Fornecedor)
								.addComponent(lblEndereco_Fornecedor)
								.addComponent(lblCNPJ_Fornecedor)
								.addComponent(lblEmpresa_Fornecedor))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
								.addComponent(textEmpresa_Fornecedor, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNum_Fornecedor, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEndereco_Fornecedor, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCNPJ_Fornecedor, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
								.addComponent(lblID_Fornecedor)
								.addComponent(lblEstado_Fornecedor)
								.addComponent(lblCidade_Fornecedor))
							.addGap(24)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
								.addComponent(textCidade_Fornecedor, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEstado_Fornecedor, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textID_Fornecedor, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
							.addGap(276))))
		);
		gl_painel_Fornecedor.setVerticalGroup(
			gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_Fornecedor.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_Fornecedor)
					.addGap(28)
					.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovo_Fornecedor)
						.addComponent(btnEditar_Fornecedor)
						.addComponent(btnCancelar_Fornecedor)
						.addComponent(btnDeletar_Fornecedor))
					.addGap(11)
					.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Fornecedor.createSequentialGroup()
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEmpresa_Fornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmpresa_Fornecedor))
							.addGap(6)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCNPJ_Fornecedor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCNPJ_Fornecedor))
							.addGap(6)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEndereco_Fornecedor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndereco_Fornecedor))
							.addGap(6)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textNum_Fornecedor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNum_Fornecedor)))
						.addGroup(gl_painel_Fornecedor.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCidade_Fornecedor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCidade_Fornecedor))
							.addGap(6)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEstado_Fornecedor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEstado_Fornecedor))
							.addGap(6)
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(textID_Fornecedor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblID_Fornecedor))))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_painel_Fornecedor.createSequentialGroup()
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBuscar_Fornecedor, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOk_Fornecedor))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_painel_Fornecedor.createSequentialGroup()
							.addGroup(gl_painel_Fornecedor.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSalvar_Fornecedor)
								.addComponent(btnLimpar_Fornecedor)
								.addComponent(btnAtualizar_Fornecedor))
							.addGap(6)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_Fornecedor, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table_Fornecedor = new JTable();
		table_Fornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDeletar_Fornecedor.setEnabled(true);
			}
		});
		table_Fornecedor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Empresa", "CNPJ", "Endere\u00E7o", "N\u00FAmero", "Cidade", "Estado"
			}
		));
		scrollPane_Fornecedor.setViewportView(table_Fornecedor);
		painel_Fornecedor.setLayout(gl_painel_Fornecedor);
		/* Fim da tela do Fornecedor */
		
		/* Inicio da tela do Funcionario */
		JPanel painel_Funcionario = new JPanel();
		painel_Funcionario.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Funcionario.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Funcionario", null, painel_Funcionario, null);
		
		JLabel lblCadastro_Funcionario = new JLabel("Cadastro de Funcion\u00E1rio");
		lblCadastro_Funcionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_Funcionario.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JButton btnNovo_Funcionario = new JButton("Novo");
		btnNovo_Funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCargo_Funcionario.setEditable(true);
				textCidade_Funcionario.setEditable(true);
				textCPF_Funcionario.setEditable(true);
				textEndereco_Funcionario.setEditable(true);
				textEstado_Funcionario.setEditable(true);
				textIdade_Funcionario.setEditable(true);
				textLoja_Funcionario.setEditable(true);
				textNome_Funcionario.setEditable(true);
				textNumCasa_Funcionario.setEditable(true);
				textSalario_Funcionario.setEditable(true);
			}
		});
		btnNovo_Funcionario.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/plus.png")));
		btnNovo_Funcionario.setBackground(Color.WHITE);
		btnNovo_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnEditar_Funcionario = new JButton("Editar");
		btnEditar_Funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCargo_Funcionario.setEditable(true);
				textCidade_Funcionario.setEditable(true);
				textCPF_Funcionario.setEditable(true);
				textEndereco_Funcionario.setEditable(true);
				textEstado_Funcionario.setEditable(true);
				textIdade_Funcionario.setEditable(true);
				textLoja_Funcionario.setEditable(true);
				textNome_Funcionario.setEditable(true);
				textNumCasa_Funcionario.setEditable(true);
				textSalario_Funcionario.setEditable(true);
			}
		});
		btnEditar_Funcionario.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/Gear.png")));
		btnEditar_Funcionario.setBackground(Color.WHITE);
		btnEditar_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnDeletar_Funcionario = new JButton("Deletar");
		btnDeletar_Funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioEntity funcionarioSelecionado = funcionarios.get(table_Funcionario.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o funcionario de código " + funcionarioSelecionado.getCodigo()) == JOptionPane.OK_OPTION) {
					try {
						new FuncionarioService().excluirFuncionario(funcionarioSelecionado.getCodigo());
					} catch (BusinessException e1) {
						JOptionPane.showMessageDialog(null, e1.getErro());
					}
				}
			}
		});
		btnDeletar_Funcionario.setEnabled(false);
		btnDeletar_Funcionario.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/delete.png")));
		btnDeletar_Funcionario.setBackground(Color.WHITE);
		btnDeletar_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnCancelar_Funcionario = new JButton("Cancelar");
		btnCancelar_Funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCargo_Funcionario.setEditable(false);
				textCidade_Funcionario.setEditable(false);
				textCPF_Funcionario.setEditable(false);
				textEndereco_Funcionario.setEditable(false);
				textEstado_Funcionario.setEditable(false);
				textIdade_Funcionario.setEditable(false);
				textLoja_Funcionario.setEditable(false);
				textNome_Funcionario.setEditable(false);
				textNumCasa_Funcionario.setEditable(false);
				textSalario_Funcionario.setEditable(false);
				btnDeletar_Funcionario.setEnabled(false);
			}
		});
		btnCancelar_Funcionario.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/cancel.png")));
		btnCancelar_Funcionario.setBackground(Color.WHITE);
		btnCancelar_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 13));
		
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
		textID_Funcionario.setColumns(10);
		
		JButton btnSalvar_Funcionario = new JButton("Salvar Cadastro");
		btnSalvar_Funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioEntity funcionario = new FuncionarioEntity();
				funcionario.setNome(textNome_Funcionario.getText());
				funcionario.setCpf(textCPF_Funcionario.getText());
				funcionario.setIdade(Integer.parseInt(textIdade_Funcionario.getText()));
				funcionario.setEndereco(textEndereco_Funcionario.getText());
				funcionario.setCargo(textCargo_Funcionario.getText());
				funcionario.setNum(Integer.parseInt(textNumCasa_Funcionario.getText()));
				funcionario.setCidade(textCidade_Funcionario.getText());
				funcionario.setEstado(textEstado_Funcionario.getText());
				funcionario.setLoja(Integer.valueOf(textLoja_Funcionario.getText()));
				funcionario.setSalario(Double.valueOf(textSalario_Funcionario.getText()));
				
				@SuppressWarnings("unused")
				String msg = null;
				try { 
					if(textID_Funcionario.getText().equals("")) {
						msg = new FuncionarioService().salvarFuncionario(funcionario);
						JOptionPane.showMessageDialog(null, "Funcionario salvo!");
					}else {
						funcionario.setCodigo(Long.parseLong(textID_Funcionario.getText()));
						msg = new FuncionarioService().alterarFuncionario(funcionario);
						JOptionPane.showMessageDialog(null, "Funcionario Alterado");
					}
				} catch (BusinessException e1) {
					JOptionPane.showMessageDialog(null, e1.getErro());
				}
			}
		});
		btnSalvar_Funcionario.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/floppy disk.png")));
		btnSalvar_Funcionario.setBackground(Color.WHITE);
		btnSalvar_Funcionario.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnLimpar_Funcionario = new JButton("Limpar Formul\u00E1rio");
		btnLimpar_Funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCargo_Funcionario.setText("");
				textCidade_Funcionario.setText("");
				textCPF_Funcionario.setText("");
				textEndereco_Funcionario.setText("");
				textEstado_Funcionario.setText("");
				textID_Funcionario.setText("");
				textIdade_Funcionario.setText("");
				textLoja_Funcionario.setText("");
				textNome_Funcionario.setText("");
				textNumCasa_Funcionario.setText("");
				textSalario_Funcionario.setText("");
			}
		});
		btnLimpar_Funcionario.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/clear.png")));
		btnLimpar_Funcionario.setBackground(Color.WHITE);
		btnLimpar_Funcionario.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnAtualizar_Funcionario = new JButton("Atualizar Tabela");
		btnAtualizar_Funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanciarTabelaFuncio();
			}
		});
		btnAtualizar_Funcionario.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/refresh.png")));
		btnAtualizar_Funcionario.setBackground(Color.WHITE);
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
		
		JLabel lblBuscar_Funcionario = new JLabel("Procurar por ID:");
		lblBuscar_Funcionario.setFont(new Font("Calibri", Font.BOLD, 14));
		
		table_Funcionario = new JTable();
		table_Funcionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDeletar_Funcionario.setEnabled(true);
			}
		});
		table_Funcionario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Idade", "Endere\u00E7o", "N\u00FAmero Casa", "Cidade", "Estado", "Cargo", "Loja", "Sal\u00E1rio"
			}
		));
		scrollPane_Funcionario.setViewportView(table_Funcionario);
		
		JButton btnOk_Funcionario = new JButton("Ok");
		btnOk_Funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarFuncionario(textID_Funcionario.getText());
			}
		});
		btnOk_Funcionario.setBackground(Color.WHITE);
		GroupLayout gl_painel_Funcionario = new GroupLayout(painel_Funcionario);
		gl_painel_Funcionario.setHorizontalGroup(
			gl_painel_Funcionario.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painel_Funcionario.createSequentialGroup()
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBuscar_Funcionario)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOk_Funcionario)
							.addGap(229)
							.addComponent(btnSalvar_Funcionario)
							.addGap(6)
							.addComponent(btnLimpar_Funcionario)
							.addGap(6)
							.addComponent(btnAtualizar_Funcionario))
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(11)
							.addComponent(scrollPane_Funcionario, GroupLayout.DEFAULT_SIZE, 1182, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_painel_Funcionario.createSequentialGroup()
					.addContainerGap(500, Short.MAX_VALUE)
					.addComponent(lblCadastro_Funcionario)
					.addGap(498))
				.addGroup(gl_painel_Funcionario.createSequentialGroup()
					.addContainerGap(413, Short.MAX_VALUE)
					.addComponent(btnNovo_Funcionario)
					.addGap(6)
					.addComponent(btnEditar_Funcionario)
					.addGap(6)
					.addComponent(btnCancelar_Funcionario)
					.addGap(6)
					.addComponent(btnDeletar_Funcionario)
					.addGap(412))
				.addGroup(gl_painel_Funcionario.createSequentialGroup()
					.addContainerGap(290, Short.MAX_VALUE)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addComponent(lblNome_Funcionario)
							.addGap(23)
							.addComponent(textNome_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNumCasa_Funcionario)
							.addGap(10)
							.addComponent(textNumCasa_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addComponent(lblCPF_Funcionario)
							.addGap(37)
							.addComponent(textCPF_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblCidade_Funcionario)
							.addGap(63)
							.addComponent(textCidade_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addComponent(lblIdade_Funcionario)
							.addGap(25)
							.addComponent(textIdade_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblEstado_Funcionario)
							.addGap(63)
							.addComponent(textEstado_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addComponent(lblEndereco_Funcionario)
							.addGap(4)
							.addComponent(textEndereco_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblID_Funcionario)
							.addGap(88)
							.addComponent(textID_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addComponent(lblCargo_Funcionario)
							.addGap(24)
							.addComponent(textCargo_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblLoja_Funcionario, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(textLoja_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)))
					.addGap(289))
				.addGroup(gl_painel_Funcionario.createSequentialGroup()
					.addContainerGap(460, Short.MAX_VALUE)
					.addComponent(lblSalario_Funcionario, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(textSalario_Funcionario, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addGap(459))
		);
		gl_painel_Funcionario.setVerticalGroup(
			gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_Funcionario.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_Funcionario)
					.addGap(13)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNovo_Funcionario)
						.addComponent(btnEditar_Funcionario)
						.addComponent(btnCancelar_Funcionario)
						.addComponent(btnDeletar_Funcionario))
					.addGap(11)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome_Funcionario))
						.addComponent(textNome_Funcionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNumCasa_Funcionario))
						.addComponent(textNumCasa_Funcionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCPF_Funcionario))
						.addComponent(textCPF_Funcionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCidade_Funcionario))
						.addComponent(textCidade_Funcionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(3)
							.addComponent(lblIdade_Funcionario))
						.addComponent(textIdade_Funcionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEstado_Funcionario))
						.addComponent(textEstado_Funcionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEndereco_Funcionario))
						.addComponent(textEndereco_Funcionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(3)
							.addComponent(lblID_Funcionario))
						.addComponent(textID_Funcionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCargo_Funcionario))
						.addComponent(textCargo_Funcionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(3)
							.addComponent(lblLoja_Funcionario))
						.addComponent(textLoja_Funcionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGap(3)
							.addComponent(lblSalario_Funcionario))
						.addComponent(textSalario_Funcionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBuscar_Funcionario)
								.addComponent(btnOk_Funcionario))
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(gl_painel_Funcionario.createSequentialGroup()
							.addGroup(gl_painel_Funcionario.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSalvar_Funcionario)
								.addComponent(btnLimpar_Funcionario)
								.addComponent(btnAtualizar_Funcionario))
							.addGap(11)))
					.addComponent(scrollPane_Funcionario, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
					.addContainerGap())
		);
		painel_Funcionario.setLayout(gl_painel_Funcionario);
		/* Fim da tela do Funcionario */
		
		/* Inicio da tela do Produto */
		JPanel painel_Produtos = new JPanel();
		painel_Produtos.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Produtos.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Produto", null, painel_Produtos, null);
		
		JLabel lblCadastro_Produto = new JLabel("Cadastro de Produtos");
		lblCadastro_Produto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_Produto.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JScrollPane scrollPane_Produto = new JScrollPane();
		
		JButton btnNovo_Produto = new JButton("Novo");
		btnNovo_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textProduto_Produto.setEditable(true);
				textCodigo_Produto.setEditable(true);
				textCusto_Produto.setEditable(true);
				textVenda_Produto.setEditable(true);
			}
		});
		btnNovo_Produto.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/plus.png")));
		btnNovo_Produto.setBackground(Color.WHITE);
		btnNovo_Produto.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnEditar_Produto = new JButton("Editar");
		btnEditar_Produto.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/Gear.png")));
		btnEditar_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textProduto_Produto.setEditable(true);
				textCodigo_Produto.setEditable(true);
				textCusto_Produto.setEditable(true);
				textVenda_Produto.setEditable(true);
			}
		});
		btnEditar_Produto.setBackground(Color.WHITE);
		btnEditar_Produto.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnDeletar_Produto = new JButton("Deletar");
		btnDeletar_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoEntity produtoSelecionado = produtos.get(table_Produto.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o produto de código " + produtoSelecionado.getCodigo()) == JOptionPane.OK_OPTION) {
					try {
						new ProdutoService().excluirProduto(produtoSelecionado.getId());
					} catch (BusinessException e1) {
						JOptionPane.showMessageDialog(null, e1.getErro());
					}
				}
			}
		});
		btnDeletar_Produto.setEnabled(false);
		btnDeletar_Produto.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/delete.png")));
		btnDeletar_Produto.setBackground(Color.WHITE);
		btnDeletar_Produto.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnCancelar_Produto = new JButton("Cancelar");
		btnCancelar_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textProduto_Produto.setEditable(false);
				textCodigo_Produto.setEditable(false);
				textCusto_Produto.setEditable(false);
				textVenda_Produto.setEditable(false);
				btnDeletar_Produto.setEnabled(false);
			}
		});
		btnCancelar_Produto.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/cancel.png")));
		btnCancelar_Produto.setBackground(Color.WHITE);
		btnCancelar_Produto.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JLabel lblVenda_Produto = new JLabel("Pre\u00E7o de venda:");
		lblVenda_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCusto_Produto = new JLabel("Pre\u00E7o de custo:");
		lblCusto_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCodigo_Produto = new JLabel("C\u00F3digo de barras:");
		lblCodigo_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblProduto_Produto = new JLabel("Produto:");
		lblProduto_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textID_Produto = new JTextField();
		textID_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		textID_Produto.setColumns(10);
		
		textCusto_Produto = new JTextField();
		textCusto_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCusto_Produto.setEditable(false);
		textCusto_Produto.setColumns(10);
		
		textVenda_Produto = new JTextField();
		textVenda_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		textVenda_Produto.setEditable(false);
		textVenda_Produto.setColumns(10);
		
		textProduto_Produto = new JTextField();
		textProduto_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		textProduto_Produto.setEditable(false);
		textProduto_Produto.setColumns(10);
		
		JLabel lblID_Produto = new JLabel("ID:");
		lblID_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textCodigo_Produto = new JTextField();
		textCodigo_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCodigo_Produto.setEditable(false);
		textCodigo_Produto.setColumns(10);
		
		JButton btnSalvar_Produto = new JButton("Salvar Cadastro");
		btnSalvar_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoEntity produto = new ProdutoEntity();
				produto.setNome(textProduto_Produto.getText());
				produto.setP_venda(Double.parseDouble((textVenda_Produto.getText())));
				produto.setP_custo(Double.parseDouble(textCusto_Produto.getText()));
				produto.setCodigo(textCodigo_Produto.getText());
				
				@SuppressWarnings("unused")
				String msg = null;
				try { 
					if(textID_Produto.getText().equals("")) {
						msg = new ProdutoService().salvarProduto(produto);
						JOptionPane.showMessageDialog(null, "Produto salvo!");
					}else {
						produto.setId(Long.parseLong(textID_Produto.getText()));
						msg = new ProdutoService().alterarProduto(produto);
						JOptionPane.showMessageDialog(null, "Produto Alterado!");
					}
				} catch (BusinessException e1) {
					JOptionPane.showMessageDialog(null, e1.getErro());
				}
			}
		});
		btnSalvar_Produto.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/floppy disk.png")));
		btnSalvar_Produto.setBackground(Color.WHITE);
		btnSalvar_Produto.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnLimpar_Produto = new JButton("Limpar Formul\u00E1rio");
		btnLimpar_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textProduto_Produto.setText("");
				textCodigo_Produto.setText("");
				textCusto_Produto.setText("");
				textID_Produto.setText("");
				textVenda_Produto.setText("");
			}
		});
		btnLimpar_Produto.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/clear.png")));
		btnLimpar_Produto.setBackground(Color.WHITE);
		btnLimpar_Produto.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnAtualizar_Produto = new JButton("Atualizar Tabela");
		btnAtualizar_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanciarTabelaProduto();
			}
		});
		btnAtualizar_Produto.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/refresh.png")));
		btnAtualizar_Produto.setBackground(Color.WHITE);
		btnAtualizar_Produto.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JLabel lblBuscar_Produto = new JLabel("Procurar por ID:");
		lblBuscar_Produto.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btnOk_Produto = new JButton("Ok");
		btnOk_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarProduto(textID_Produto.getText());
			}
		});
		btnOk_Produto.setBackground(Color.WHITE);
		GroupLayout gl_painel_Produtos = new GroupLayout(painel_Produtos);
		gl_painel_Produtos.setHorizontalGroup(
			gl_painel_Produtos.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painel_Produtos.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBuscar_Produto, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOk_Produto)
					.addGap(229)
					.addComponent(btnSalvar_Produto)
					.addGap(6)
					.addComponent(btnLimpar_Produto)
					.addGap(6)
					.addComponent(btnAtualizar_Produto)
					.addContainerGap(381, Short.MAX_VALUE))
				.addGroup(gl_painel_Produtos.createSequentialGroup()
					.addContainerGap(511, Short.MAX_VALUE)
					.addComponent(lblCadastro_Produto)
					.addGap(509))
				.addGroup(gl_painel_Produtos.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane_Produto, GroupLayout.DEFAULT_SIZE, 1182, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_painel_Produtos.createSequentialGroup()
					.addContainerGap(400, Short.MAX_VALUE)
					.addComponent(btnNovo_Produto, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar_Produto, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar_Produto)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeletar_Produto, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(399))
				.addGroup(gl_painel_Produtos.createSequentialGroup()
					.addGap(261)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProduto_Produto)
						.addComponent(lblCusto_Produto)
						.addComponent(lblVenda_Produto))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
						.addComponent(textCusto_Produto, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painel_Produtos.createSequentialGroup()
							.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
								.addComponent(textProduto_Produto, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textVenda_Produto, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodigo_Produto)
								.addComponent(lblID_Produto))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
								.addComponent(textCodigo_Produto, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textID_Produto, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))))
					.addGap(260))
		);
		gl_painel_Produtos.setVerticalGroup(
			gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_Produtos.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_Produto)
					.addGap(21)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovo_Produto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditar_Produto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar_Produto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeletar_Produto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProduto_Produto)
						.addComponent(textProduto_Produto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCodigo_Produto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo_Produto))
					.addGap(9)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.BASELINE)
						.addComponent(textVenda_Produto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textID_Produto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVenda_Produto)
						.addComponent(lblID_Produto))
					.addGap(12)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCusto_Produto)
						.addComponent(textCusto_Produto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_Produtos.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
							.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOk_Produto)
								.addComponent(lblBuscar_Produto, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(gl_painel_Produtos.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_painel_Produtos.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSalvar_Produto)
								.addComponent(btnLimpar_Produto)
								.addComponent(btnAtualizar_Produto))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane_Produto, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table_Produto = new JTable();
		table_Produto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDeletar_Produto.setEnabled(true);
			}
		});
		table_Produto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Produto", "Pre\u00E7o de Venda", "Pre\u00E7o de Custo", "C\u00F3digo de Barras"
			}
		));
		table_Produto.getColumnModel().getColumn(2).setPreferredWidth(92);
		table_Produto.getColumnModel().getColumn(3).setPreferredWidth(90);
		table_Produto.getColumnModel().getColumn(4).setPreferredWidth(98);
		scrollPane_Produto.setViewportView(table_Produto);
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
		/* Fim da tela do Produto */
	
		/* Inicio dos metodos de instanciar */
		private void instanciarTabelaCli() {
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
		
		private void instanciarTabelaForne() {
			try {
				fornecedores = new FornecedorService().listarFornecedores();
				DefaultTableModel model = (DefaultTableModel)table_Fornecedor.getModel();
				model.getDataVector().removeAllElements();
				
				for (FornecedorEntity fornecedorEntity : fornecedores) {
					model.addRow(new Object[] {fornecedorEntity.getCodigo(), fornecedorEntity.getNome(), fornecedorEntity.getCnpj(), fornecedorEntity.getEndereco(), fornecedorEntity.getNum(), fornecedorEntity.getCidade(), fornecedorEntity.getEstado()});
				}
				
			} catch (BusinessException e) {
				JOptionPane.showMessageDialog(null, "Erro ao listar os Fornecedores.");
			}
		}
		
		private void instanciarTabelaFuncio() {
			try {
				funcionarios = new FuncionarioService().listarFuncionarios();
				DefaultTableModel model = (DefaultTableModel)table_Funcionario.getModel();
				model.getDataVector().removeAllElements();
				
				for (FuncionarioEntity funcionarioEntity : funcionarios) {
					model.addRow(new Object[] {funcionarioEntity.getCodigo(), funcionarioEntity.getNome(), funcionarioEntity.getCpf(), funcionarioEntity.getIdade(), funcionarioEntity.getEndereco(), funcionarioEntity.getCargo() , funcionarioEntity.getNum(), funcionarioEntity.getCidade(), funcionarioEntity.getEstado(), funcionarioEntity.getLoja(), funcionarioEntity.getSalario()});
				}
				
			} catch (BusinessException e) {
				JOptionPane.showMessageDialog(null, "Erro ao listar os Funcionarios.");
			}
		}
		
		private void instanciarTabelaProduto() {
			try {
				produtos = new ProdutoService().listarProdutos();
				DefaultTableModel model = (DefaultTableModel)table_Produto.getModel();
				model.getDataVector().removeAllElements();
				
				for (ProdutoEntity produtoEntity : produtos) {
					model.addRow(new Object[] {produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getP_venda(), produtoEntity.getP_custo(), produtoEntity.getCodigo()});
				}
				
			} catch (BusinessException e) {
				JOptionPane.showMessageDialog(null, "Erro ao listar os Produtos.");
			}
		}
		/* Fim dos metodos de instanciar */
		
		/* Inicio dos metodos de carregar */
		public void carregarCliente(String idCliente) {
			try {
				ClienteEntity clienteEncontrado = new ClienteService().buscarID(idCliente);
				
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
				JOptionPane.showMessageDialog(null, e.getErro(), "Ocorreu um erro inesperado!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		public void carregarFornecedor(String idFornecedor) {
			try {
				FornecedorEntity fornecedorEncontrado = new FornecedorService().buscarID(idFornecedor);
				
				if(fornecedorEncontrado == null) {
					JOptionPane.showMessageDialog(null, "O fornecedor não foi encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					textEmpresa_Fornecedor.setText(fornecedorEncontrado.getNome());
					textCNPJ_Fornecedor.setText(fornecedorEncontrado.getCnpj());
					textNum_Fornecedor.setText(String.valueOf(fornecedorEncontrado.getNum()));
					textEndereco_Fornecedor.setText(fornecedorEncontrado.getEndereco());
					textCidade_Fornecedor.setText(fornecedorEncontrado.getCidade());
					textEstado_Fornecedor.setText(fornecedorEncontrado.getEstado());
				}
				
			} catch (BusinessException e) {
				JOptionPane.showMessageDialog(null, e.getErro(), "Ocorreu um erro inesperado!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		public void carregarFuncionario(String idFuncionario) {
			try {
				FuncionarioEntity funcionarioEncontrado = new FuncionarioService().buscarID(idFuncionario);
				
				if(funcionarioEncontrado == null) {
					JOptionPane.showMessageDialog(null, "O funcionario não foi encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					textNome_Funcionario.setText(funcionarioEncontrado.getNome());
					textCPF_Funcionario.setText(funcionarioEncontrado.getCpf());
					textIdade_Funcionario.setText(String.valueOf(funcionarioEncontrado.getIdade()));
					textCargo_Funcionario.setText(funcionarioEncontrado.getCargo());
					textEndereco_Funcionario.setText(funcionarioEncontrado.getEndereco());
					textNumCasa_Funcionario.setText(String.valueOf(funcionarioEncontrado.getNum()));
					textCidade_Funcionario.setText(funcionarioEncontrado.getCidade());
					textEstado_Funcionario.setText(funcionarioEncontrado.getEstado());
					textLoja_Funcionario.setText(String.valueOf(funcionarioEncontrado.getLoja()));
					textSalario_Funcionario.setText(String.valueOf(funcionarioEncontrado.getSalario()));
				}
				
			} catch (BusinessException e) {
				JOptionPane.showMessageDialog(null, e.getErro(), "Ocorreu um erro inesperado!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		public void carregarProduto(String idProduto) {
			try {
				ProdutoEntity produtoEncontrado = new ProdutoService().buscarID(idProduto);
				
				if(produtoEncontrado == null) {
					JOptionPane.showMessageDialog(null, "O produto não foi encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				} else {
					textProduto_Produto.setText(produtoEncontrado.getNome());
					textVenda_Produto.setText(String.valueOf(produtoEncontrado.getP_venda()));
					textCusto_Produto.setText(String.valueOf(produtoEncontrado.getP_custo()));
					textCodigo_Produto.setText(produtoEncontrado.getCodigo());
				}
				
			} catch (BusinessException e) {
				JOptionPane.showMessageDialog(null, e.getErro(), "Ocorreu um erro inesperado!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
}