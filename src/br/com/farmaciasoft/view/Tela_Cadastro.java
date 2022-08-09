package br.com.farmaciasoft.view;

/* Importação das bibliotecas usadas */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.SwingConstants;
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
import javax.swing.UIManager;

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
					frame.setLocationRelativeTo(null);
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
		setBounds(100, 100, 1275, 750);
		contentPane_FarmaciaSoft = new JPanel();
		contentPane_FarmaciaSoft.setBackground(Color.BLACK);
		contentPane_FarmaciaSoft.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_FarmaciaSoft.setOpaque(false);
		setContentPane(contentPane_FarmaciaSoft);
		
		JTabbedPane tabbedPane_FarmaciaSoft = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_FarmaciaSoft.setBounds(5, 5, 1250, 705);
		
		/* Inicio da tela de Boas Vindas */
		JPanel painel_BoasVindas = new JPanel();
		painel_BoasVindas.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_BoasVindas.setBackground(Color.WHITE);
		tabbedPane_FarmaciaSoft.addTab("Tela Inicial", null, painel_BoasVindas, null);
		
		JLabel lblFarmaciaSoft = new JLabel("FarmaciaSoft");
		lblFarmaciaSoft.setBounds(541, 11, 123, 32);
		lblFarmaciaSoft.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarmaciaSoft.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JTextPane txtpn_mensagemBV = new JTextPane();
		txtpn_mensagemBV.setBounds(517, 270, 171, 86);
		txtpn_mensagemBV.setBackground(UIManager.getColor("CheckBox.light"));
		txtpn_mensagemBV.setForeground(Color.black);
		txtpn_mensagemBV.setFont(new Font("Calibri", Font.BOLD, 16));
		txtpn_mensagemBV.setText("Seja Bem-vindo(a) ao projeto que estou realizando referente a cadastros!");
		txtpn_mensagemBV.setOpaque(false);
		painel_BoasVindas.setLayout(null);
		painel_BoasVindas.add(lblFarmaciaSoft);
		painel_BoasVindas.add(txtpn_mensagemBV);
		
		JLabel lblBackground_BV = new JLabel("");
		lblBackground_BV.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/background.jpg")));
		lblBackground_BV.setBackground(Color.WHITE);
		lblBackground_BV.setBounds(0, 0, 1250, 705);
		painel_BoasVindas.add(lblBackground_BV);
		JPanel painel_Cliente = new JPanel();
		painel_Cliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Cliente.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Cliente", null, painel_Cliente, null);
		
		JLabel lblCadastro_Cliente = new JLabel("Cadastro De Cliente");
		lblCadastro_Cliente.setBounds(530, 12, 184, 25);
		lblCadastro_Cliente.setVerticalAlignment(SwingConstants.TOP);
		lblCadastro_Cliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_Cliente.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JLabel lblNome_Cliente = new JLabel("Nome: ");
		lblNome_Cliente.setBounds(312, 132, 41, 18);
		lblNome_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCPF_Cliente = new JLabel("CPF:");
		lblCPF_Cliente.setBounds(312, 162, 24, 18);
		lblCPF_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblCPF_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblIdade_Cliente = new JLabel("Idade:");
		lblIdade_Cliente.setBounds(312, 192, 36, 18);
		lblIdade_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdade_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEndereco_Cliente = new JLabel("Endere\u00E7o:");
		lblEndereco_Cliente.setBounds(312, 222, 57, 18);
		lblEndereco_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereco_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNumCasa_Cliente = new JLabel("N\u00FAmero da casa:");
		lblNumCasa_Cliente.setBounds(609, 101, 95, 18);
		lblNumCasa_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumCasa_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCidade_Cliente = new JLabel("Cidade:");
		lblCidade_Cliente.setBounds(609, 132, 42, 18);
		lblCidade_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEstado_Cliente = new JLabel("Estado:");
		lblEstado_Cliente.setBounds(609, 162, 42, 18);
		lblEstado_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JButton btnSalvar_Cliente = new JButton("Salvar Cadastro");
		btnSalvar_Cliente.setBounds(376, 284, 160, 25);
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
		btnLimpar_Cliente.setBounds(546, 284, 160, 25);
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
		btnAtualizar_Cliente.setBounds(714, 284, 160, 25);
		btnAtualizar_Cliente.setBackground(Color.WHITE);
		btnAtualizar_Cliente.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/refresh.png")));
		btnAtualizar_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanciarTabelaCli();
			}
		});
		btnAtualizar_Cliente.setFont(new Font("Calibri", Font.BOLD, 13));
		
		textNome_Cliente = new JTextField();
		textNome_Cliente.setBounds(375, 129, 224, 24);
		textNome_Cliente.setEditable(false);
		textNome_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNome_Cliente.setColumns(10);
		
		textCPF_Cliente = new JTextField();
		textCPF_Cliente.setBounds(375, 159, 224, 24);
		textCPF_Cliente.setEditable(false);
		textCPF_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCPF_Cliente.setColumns(10);
		
		textIdade_Cliente = new JTextField();
		textIdade_Cliente.setBounds(375, 189, 224, 24);
		textIdade_Cliente.setEditable(false);
		textIdade_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textIdade_Cliente.setColumns(10);
		
		textEndereco_Cliente = new JTextField();
		textEndereco_Cliente.setBounds(375, 219, 224, 24);
		textEndereco_Cliente.setEditable(false);
		textEndereco_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEndereco_Cliente.setColumns(10);
		
		textNumCasa_Cliente = new JTextField();
		textNumCasa_Cliente.setBounds(714, 99, 224, 24);
		textNumCasa_Cliente.setEditable(false);
		textNumCasa_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNumCasa_Cliente.setColumns(10);
		
		textCidade_Cliente = new JTextField();
		textCidade_Cliente.setBounds(714, 129, 224, 24);
		textCidade_Cliente.setEditable(false);
		textCidade_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCidade_Cliente.setColumns(10);
		
		textEstado_Cliente = new JTextField();
		textEstado_Cliente.setBounds(714, 159, 224, 24);
		textEstado_Cliente.setEditable(false);
		textEstado_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEstado_Cliente.setColumns(10);
		
		JButton btnDeletar_Cliente = new JButton("Deletar");
		btnDeletar_Cliente.setBounds(755, 59, 105, 25);
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
		btnNovo_Cliente.setBounds(410, 59, 105, 25);
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
		btnCancelar_Cliente.setBounds(640, 59, 105, 25);
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
		scrollPane_Cliente.setBounds(11, 320, 1224, 346);
		
		JLabel lblBuscar_Cliente = new JLabel("Procurar por ID:");
		lblBuscar_Cliente.setBounds(11, 289, 95, 18);
		lblBuscar_Cliente.setFont(new Font("Calibri", Font.BOLD, 14));
		
		btnDeletar_Cliente.setEnabled(false);
		btnDeletar_Cliente.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnBuscar_Cliente = new JButton("Ok");
		btnBuscar_Cliente.setBounds(110, 284, 50, 25);
		btnBuscar_Cliente.setBackground(Color.WHITE);
		btnBuscar_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCliente(textID_Cliente.getText());
			}
		});
		btnBuscar_Cliente.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblID_Cliente = new JLabel("ID:");
		lblID_Cliente.setBounds(312, 101, 17, 18);
		lblID_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblID_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textID_Cliente = new JTextField();
		textID_Cliente.setBounds(375, 99, 224, 24);
		textID_Cliente.setHorizontalAlignment(SwingConstants.CENTER);
		textID_Cliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		textID_Cliente.setColumns(10);
		
		JButton btnEditar_Cliente = new JButton("Editar");
		btnEditar_Cliente.setBounds(525, 59, 105, 25);
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
		painel_Cliente.setLayout(null);
		painel_Cliente.add(lblCadastro_Cliente);
		painel_Cliente.add(btnNovo_Cliente);
		painel_Cliente.add(btnEditar_Cliente);
		painel_Cliente.add(btnCancelar_Cliente);
		painel_Cliente.add(btnDeletar_Cliente);
		painel_Cliente.add(lblIdade_Cliente);
		painel_Cliente.add(lblEndereco_Cliente);
		painel_Cliente.add(lblCPF_Cliente);
		painel_Cliente.add(lblNome_Cliente);
		painel_Cliente.add(textCPF_Cliente);
		painel_Cliente.add(textNome_Cliente);
		painel_Cliente.add(lblCidade_Cliente);
		painel_Cliente.add(lblNumCasa_Cliente);
		painel_Cliente.add(textIdade_Cliente);
		painel_Cliente.add(textEndereco_Cliente);
		painel_Cliente.add(lblID_Cliente);
		painel_Cliente.add(lblEstado_Cliente);
		painel_Cliente.add(textNumCasa_Cliente);
		painel_Cliente.add(textCidade_Cliente);
		painel_Cliente.add(textEstado_Cliente);
		painel_Cliente.add(textID_Cliente);
		painel_Cliente.add(scrollPane_Cliente);
		painel_Cliente.add(lblBuscar_Cliente);
		painel_Cliente.add(btnBuscar_Cliente);
		painel_Cliente.add(btnSalvar_Cliente);
		painel_Cliente.add(btnLimpar_Cliente);
		painel_Cliente.add(btnAtualizar_Cliente);
		
		JLabel lblBackground_Cliente = new JLabel("");
		lblBackground_Cliente.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/background.jpg")));
		lblBackground_Cliente.setBounds(0, 0, 1250, 705);
		painel_Cliente.add(lblBackground_Cliente);
		/* Fim da tela do Cliente */
		
		/* Inicio da tela do Fornecedor */
		JPanel painel_Funcionario = new JPanel();
		painel_Funcionario.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Funcionario.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Funcionario", null, painel_Funcionario, null);
		
		JLabel lblCadastro_Funcionario = new JLabel("Cadastro de Funcion\u00E1rio");
		lblCadastro_Funcionario.setBounds(520, 12, 205, 25);
		lblCadastro_Funcionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_Funcionario.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JButton btnNovo_Funcionario = new JButton("Novo");
		btnNovo_Funcionario.setBounds(410, 59, 105, 25);
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
		btnEditar_Funcionario.setBounds(525, 59, 105, 25);
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
		btnDeletar_Funcionario.setBounds(755, 59, 105, 25);
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
		btnCancelar_Funcionario.setBounds(640, 59, 105, 25);
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
		lblNome_Funcionario.setBounds(312, 131, 38, 18);
		lblNome_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCPF_Funcionario = new JLabel("CPF:");
		lblCPF_Funcionario.setBounds(312, 161, 24, 18);
		lblCPF_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblIdade_Funcionario = new JLabel("Idade:");
		lblIdade_Funcionario.setBounds(312, 191, 36, 18);
		lblIdade_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEndereco_Funcionario = new JLabel("Endere\u00E7o:");
		lblEndereco_Funcionario.setBounds(312, 221, 57, 18);
		lblEndereco_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textNome_Funcionario = new JTextField();
		textNome_Funcionario.setBounds(375, 129, 224, 24);
		textNome_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNome_Funcionario.setEditable(false);
		textNome_Funcionario.setColumns(10);
		
		textCPF_Funcionario = new JTextField();
		textCPF_Funcionario.setBounds(375, 159, 224, 24);
		textCPF_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCPF_Funcionario.setEditable(false);
		textCPF_Funcionario.setColumns(10);
		
		textIdade_Funcionario = new JTextField();
		textIdade_Funcionario.setBounds(375, 189, 224, 24);
		textIdade_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textIdade_Funcionario.setEditable(false);
		textIdade_Funcionario.setColumns(10);
		
		textEndereco_Funcionario = new JTextField();
		textEndereco_Funcionario.setBounds(375, 219, 224, 24);
		textEndereco_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEndereco_Funcionario.setEditable(false);
		textEndereco_Funcionario.setColumns(10);
		
		JLabel lblNumCasa_Funcionario = new JLabel("N\u00FAmero da casa:");
		lblNumCasa_Funcionario.setBounds(609, 101, 95, 18);
		lblNumCasa_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCidade_Funcionario = new JLabel("Cidade:");
		lblCidade_Funcionario.setBounds(609, 131, 42, 18);
		lblCidade_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEstado_Funcionario = new JLabel("Estado:");
		lblEstado_Funcionario.setBounds(609, 161, 42, 18);
		lblEstado_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblID_Funcionario = new JLabel("ID:");
		lblID_Funcionario.setBounds(312, 101, 17, 18);
		lblID_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textNumCasa_Funcionario = new JTextField();
		textNumCasa_Funcionario.setBounds(712, 99, 224, 24);
		textNumCasa_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNumCasa_Funcionario.setEditable(false);
		textNumCasa_Funcionario.setColumns(10);
		
		textCidade_Funcionario = new JTextField();
		textCidade_Funcionario.setBounds(712, 129, 224, 24);
		textCidade_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCidade_Funcionario.setEditable(false);
		textCidade_Funcionario.setColumns(10);
		
		textEstado_Funcionario = new JTextField();
		textEstado_Funcionario.setBounds(712, 159, 224, 24);
		textEstado_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEstado_Funcionario.setEditable(false);
		textEstado_Funcionario.setColumns(10);
		
		textID_Funcionario = new JTextField();
		textID_Funcionario.setBounds(375, 99, 224, 24);
		textID_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textID_Funcionario.setColumns(10);
		
		JButton btnSalvar_Funcionario = new JButton("Salvar Cadastro");
		btnSalvar_Funcionario.setBounds(376, 284, 160, 25);
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
		btnLimpar_Funcionario.setBounds(546, 284, 160, 25);
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
		btnAtualizar_Funcionario.setBounds(716, 284, 160, 25);
		btnAtualizar_Funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanciarTabelaFuncio();
			}
		});
		btnAtualizar_Funcionario.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/refresh.png")));
		btnAtualizar_Funcionario.setBackground(Color.WHITE);
		btnAtualizar_Funcionario.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JScrollPane scrollPane_Funcionario = new JScrollPane();
		scrollPane_Funcionario.setBounds(11, 320, 1224, 346);
		
		JLabel lblCargo_Funcionario = new JLabel("Cargo:");
		lblCargo_Funcionario.setBounds(609, 191, 37, 18);
		lblCargo_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textCargo_Funcionario = new JTextField();
		textCargo_Funcionario.setBounds(712, 189, 224, 24);
		textCargo_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCargo_Funcionario.setEditable(false);
		textCargo_Funcionario.setColumns(10);
		
		JLabel lblLoja_Funcionario = new JLabel("Loja:");
		lblLoja_Funcionario.setBounds(609, 221, 56, 18);
		lblLoja_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textLoja_Funcionario = new JTextField();
		textLoja_Funcionario.setBounds(712, 219, 224, 24);
		textLoja_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textLoja_Funcionario.setEditable(false);
		textLoja_Funcionario.setColumns(10);
		
		JLabel lblSalario_Funcionario = new JLabel("Sal\u00E1rio:");
		lblSalario_Funcionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalario_Funcionario.setBounds(439, 252, 56, 18);
		lblSalario_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textSalario_Funcionario = new JTextField();
		textSalario_Funcionario.setBounds(510, 249, 224, 24);
		textSalario_Funcionario.setFont(new Font("Calibri", Font.PLAIN, 14));
		textSalario_Funcionario.setEditable(false);
		textSalario_Funcionario.setColumns(10);
		
		JLabel lblBuscar_Funcionario = new JLabel("Procurar por ID:");
		lblBuscar_Funcionario.setBounds(11, 289, 95, 18);
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
		btnOk_Funcionario.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
		btnOk_Funcionario.setBounds(110, 284, 50, 25);
		btnOk_Funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarFuncionario(textID_Funcionario.getText());
			}
		});
		btnOk_Funcionario.setBackground(Color.WHITE);
		painel_Funcionario.setLayout(null);
		painel_Funcionario.add(lblBuscar_Funcionario);
		painel_Funcionario.add(btnOk_Funcionario);
		painel_Funcionario.add(btnSalvar_Funcionario);
		painel_Funcionario.add(btnLimpar_Funcionario);
		painel_Funcionario.add(btnAtualizar_Funcionario);
		painel_Funcionario.add(scrollPane_Funcionario);
		painel_Funcionario.add(lblCadastro_Funcionario);
		painel_Funcionario.add(btnNovo_Funcionario);
		painel_Funcionario.add(btnEditar_Funcionario);
		painel_Funcionario.add(btnCancelar_Funcionario);
		painel_Funcionario.add(btnDeletar_Funcionario);
		painel_Funcionario.add(lblNome_Funcionario);
		painel_Funcionario.add(textNome_Funcionario);
		painel_Funcionario.add(lblNumCasa_Funcionario);
		painel_Funcionario.add(textNumCasa_Funcionario);
		painel_Funcionario.add(lblCPF_Funcionario);
		painel_Funcionario.add(textCPF_Funcionario);
		painel_Funcionario.add(lblCidade_Funcionario);
		painel_Funcionario.add(textCidade_Funcionario);
		painel_Funcionario.add(lblIdade_Funcionario);
		painel_Funcionario.add(textIdade_Funcionario);
		painel_Funcionario.add(lblEstado_Funcionario);
		painel_Funcionario.add(textEstado_Funcionario);
		painel_Funcionario.add(lblEndereco_Funcionario);
		painel_Funcionario.add(textEndereco_Funcionario);
		painel_Funcionario.add(lblID_Funcionario);
		painel_Funcionario.add(textID_Funcionario);
		painel_Funcionario.add(lblCargo_Funcionario);
		painel_Funcionario.add(textCargo_Funcionario);
		painel_Funcionario.add(lblLoja_Funcionario);
		painel_Funcionario.add(textLoja_Funcionario);
		painel_Funcionario.add(lblSalario_Funcionario);
		painel_Funcionario.add(textSalario_Funcionario);
		
		JLabel lblBackground_Funcionario = new JLabel("");
		lblBackground_Funcionario.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/background.jpg")));
		lblBackground_Funcionario.setBounds(0, 0, 1250, 705);
		painel_Funcionario.add(lblBackground_Funcionario);
		JPanel painel_Fornecedor = new JPanel();
		painel_Fornecedor.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Fornecedor.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Fornecedor", null, painel_Fornecedor, null);
		
		JLabel lblCadastro_Fornecedor = new JLabel("Cadastro de Fornecedor");
		lblCadastro_Fornecedor.setBounds(522, 12, 201, 25);
		lblCadastro_Fornecedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_Fornecedor.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JButton btnNovo_Fornecedor = new JButton("Novo");
		btnNovo_Fornecedor.setBounds(410, 59, 105, 25);
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
		btnEditar_Fornecedor.setBounds(525, 59, 105, 25);
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
		btnDeletar_Fornecedor.setBounds(755, 59, 105, 25);
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
		btnCancelar_Fornecedor.setBounds(640, 59, 105, 25);
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
		lblEmpresa_Fornecedor.setBounds(256, 132, 107, 18);
		lblEmpresa_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCNPJ_Fornecedor = new JLabel("CNPJ:");
		lblCNPJ_Fornecedor.setBounds(256, 162, 31, 18);
		lblCNPJ_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEndereco_Fornecedor = new JLabel("Endere\u00E7o:");
		lblEndereco_Fornecedor.setBounds(256, 192, 57, 18);
		lblEndereco_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNum_Fornecedor = new JLabel("N\u00FAmero:");
		lblNum_Fornecedor.setBounds(256, 222, 50, 18);
		lblNum_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textEmpresa_Fornecedor = new JTextField();
		textEmpresa_Fornecedor.setBounds(373, 129, 224, 24);
		textEmpresa_Fornecedor.setEditable(false);
		textEmpresa_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEmpresa_Fornecedor.setColumns(10);
		
		textCNPJ_Fornecedor = new JTextField();
		textCNPJ_Fornecedor.setBounds(373, 159, 224, 24);
		textCNPJ_Fornecedor.setEditable(false);
		textCNPJ_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCNPJ_Fornecedor.setColumns(10);
		
		textEndereco_Fornecedor = new JTextField();
		textEndereco_Fornecedor.setBounds(373, 189, 224, 24);
		textEndereco_Fornecedor.setEditable(false);
		textEndereco_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEndereco_Fornecedor.setColumns(10);
		
		textNum_Fornecedor = new JTextField();
		textNum_Fornecedor.setBounds(373, 219, 224, 24);
		textNum_Fornecedor.setEditable(false);
		textNum_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNum_Fornecedor.setColumns(10);
		
		JLabel lblCidade_Fornecedor = new JLabel("Cidade:");
		lblCidade_Fornecedor.setBounds(609, 101, 42, 18);
		lblCidade_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEstado_Fornecedor = new JLabel("Estado:");
		lblEstado_Fornecedor.setBounds(609, 132, 42, 18);
		lblEstado_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblID_Fornecedor = new JLabel("ID:");
		lblID_Fornecedor.setBounds(256, 101, 17, 18);
		lblID_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textID_Fornecedor = new JTextField();
		textID_Fornecedor.setBounds(375, 99, 224, 24);
		textID_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textID_Fornecedor.setColumns(10);
		
		textEstado_Fornecedor = new JTextField();
		textEstado_Fornecedor.setBounds(712, 129, 224, 24);
		textEstado_Fornecedor.setEditable(false);
		textEstado_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEstado_Fornecedor.setColumns(10);
		
		textCidade_Fornecedor = new JTextField();
		textCidade_Fornecedor.setBounds(712, 99, 224, 24);
		textCidade_Fornecedor.setEditable(false);
		textCidade_Fornecedor.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCidade_Fornecedor.setColumns(10);
		
		JButton btnSalvar_Fornecedor = new JButton("Salvar Cadastro");
		btnSalvar_Fornecedor.setBounds(376, 284, 160, 25);
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
		btnLimpar_Fornecedor.setBounds(546, 284, 160, 25);
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
		btnAtualizar_Fornecedor.setBounds(716, 284, 160, 25);
		btnAtualizar_Fornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanciarTabelaForne();
			}
		});
		btnAtualizar_Fornecedor.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/refresh.png")));
		btnAtualizar_Fornecedor.setBackground(Color.WHITE);
		btnAtualizar_Fornecedor.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JScrollPane scrollPane_Fornecedor = new JScrollPane();
		scrollPane_Fornecedor.setBounds(11, 320, 1224, 346);
		
		JLabel lblBuscar_Fornecedor = new JLabel("Procurar por ID:");
		lblBuscar_Fornecedor.setBounds(11, 289, 95, 18);
		lblBuscar_Fornecedor.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btnOk_Fornecedor = new JButton("Ok");
		btnOk_Fornecedor.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
		btnOk_Fornecedor.setBounds(110, 284, 50, 25);
		btnOk_Fornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarFornecedor(textID_Fornecedor.getText());
			}
		});
		btnOk_Fornecedor.setBackground(Color.WHITE);
		
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
		painel_Fornecedor.setLayout(null);
		painel_Fornecedor.add(lblBuscar_Fornecedor);
		painel_Fornecedor.add(btnOk_Fornecedor);
		painel_Fornecedor.add(btnSalvar_Fornecedor);
		painel_Fornecedor.add(btnLimpar_Fornecedor);
		painel_Fornecedor.add(btnAtualizar_Fornecedor);
		painel_Fornecedor.add(lblCadastro_Fornecedor);
		painel_Fornecedor.add(btnNovo_Fornecedor);
		painel_Fornecedor.add(btnEditar_Fornecedor);
		painel_Fornecedor.add(btnCancelar_Fornecedor);
		painel_Fornecedor.add(btnDeletar_Fornecedor);
		painel_Fornecedor.add(scrollPane_Fornecedor);
		painel_Fornecedor.add(lblNum_Fornecedor);
		painel_Fornecedor.add(lblEndereco_Fornecedor);
		painel_Fornecedor.add(lblCNPJ_Fornecedor);
		painel_Fornecedor.add(lblEmpresa_Fornecedor);
		painel_Fornecedor.add(textEmpresa_Fornecedor);
		painel_Fornecedor.add(textNum_Fornecedor);
		painel_Fornecedor.add(textEndereco_Fornecedor);
		painel_Fornecedor.add(textCNPJ_Fornecedor);
		painel_Fornecedor.add(lblID_Fornecedor);
		painel_Fornecedor.add(lblEstado_Fornecedor);
		painel_Fornecedor.add(lblCidade_Fornecedor);
		painel_Fornecedor.add(textCidade_Fornecedor);
		painel_Fornecedor.add(textEstado_Fornecedor);
		painel_Fornecedor.add(textID_Fornecedor);
		
		JLabel lblBackground_Fornecedor = new JLabel("");
		lblBackground_Fornecedor.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/background.jpg")));
		lblBackground_Fornecedor.setBounds(0, 0, 1250, 705);
		painel_Fornecedor.add(lblBackground_Fornecedor);
		/* Fim da tela do Fornecedor */
		
		/* Inicio da tela do Funcionario */
		/* Fim da tela do Funcionario */
		
		/* Inicio da tela do Produto */
		JPanel painel_Produtos = new JPanel();
		painel_Produtos.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_Produtos.setBackground(Color.LIGHT_GRAY);
		tabbedPane_FarmaciaSoft.addTab("Produto", null, painel_Produtos, null);
		
		JLabel lblCadastro_Produto = new JLabel("Cadastro de Produtos");
		lblCadastro_Produto.setBounds(531, 12, 183, 25);
		lblCadastro_Produto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_Produto.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JScrollPane scrollPane_Produto = new JScrollPane();
		scrollPane_Produto.setBounds(11, 320, 1224, 346);
		
		JButton btnNovo_Produto = new JButton("Novo");
		btnNovo_Produto.setBounds(410, 59, 105, 25);
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
		btnEditar_Produto.setBounds(525, 59, 105, 25);
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
		btnDeletar_Produto.setBounds(755, 59, 105, 25);
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
		btnCancelar_Produto.setBounds(640, 59, 105, 25);
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
		lblVenda_Produto.setBounds(275, 162, 90, 18);
		lblVenda_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCusto_Produto = new JLabel("Pre\u00E7o de custo:");
		lblCusto_Produto.setBounds(609, 101, 86, 18);
		lblCusto_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCodigo_Produto = new JLabel("C\u00F3digo de barras:");
		lblCodigo_Produto.setBounds(609, 132, 98, 18);
		lblCodigo_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblProduto_Produto = new JLabel("Produto:");
		lblProduto_Produto.setBounds(275, 132, 49, 18);
		lblProduto_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textID_Produto = new JTextField();
		textID_Produto.setBounds(375, 99, 224, 24);
		textID_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		textID_Produto.setColumns(10);
		
		textCusto_Produto = new JTextField();
		textCusto_Produto.setBounds(712, 99, 224, 24);
		textCusto_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCusto_Produto.setEditable(false);
		textCusto_Produto.setColumns(10);
		
		textVenda_Produto = new JTextField();
		textVenda_Produto.setBounds(375, 159, 224, 24);
		textVenda_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		textVenda_Produto.setEditable(false);
		textVenda_Produto.setColumns(10);
		
		textProduto_Produto = new JTextField();
		textProduto_Produto.setBounds(375, 129, 224, 24);
		textProduto_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		textProduto_Produto.setEditable(false);
		textProduto_Produto.setColumns(10);
		
		JLabel lblID_Produto = new JLabel("ID:");
		lblID_Produto.setBounds(275, 101, 17, 18);
		lblID_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textCodigo_Produto = new JTextField();
		textCodigo_Produto.setBounds(712, 129, 224, 24);
		textCodigo_Produto.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCodigo_Produto.setEditable(false);
		textCodigo_Produto.setColumns(10);
		
		JButton btnSalvar_Produto = new JButton("Salvar Cadastro");
		btnSalvar_Produto.setBounds(376, 284, 160, 25);
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
		btnLimpar_Produto.setBounds(546, 284, 160, 25);
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
		btnAtualizar_Produto.setBounds(716, 284, 160, 25);
		btnAtualizar_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanciarTabelaProduto();
			}
		});
		btnAtualizar_Produto.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/refresh.png")));
		btnAtualizar_Produto.setBackground(Color.WHITE);
		btnAtualizar_Produto.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JLabel lblBuscar_Produto = new JLabel("Procurar por ID:");
		lblBuscar_Produto.setBounds(11, 289, 95, 18);
		lblBuscar_Produto.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btnOk_Produto = new JButton("Ok");
		btnOk_Produto.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
		btnOk_Produto.setBounds(110, 284, 50, 25);
		btnOk_Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarProduto(textID_Produto.getText());
			}
		});
		btnOk_Produto.setBackground(Color.WHITE);
		
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
		contentPane_FarmaciaSoft.setLayout(null);
		scrollPane_Produto.setViewportView(table_Produto);
		painel_Produtos.setLayout(null);
		painel_Produtos.add(lblBuscar_Produto);
		painel_Produtos.add(btnOk_Produto);
		painel_Produtos.add(btnSalvar_Produto);
		painel_Produtos.add(btnLimpar_Produto);
		painel_Produtos.add(btnAtualizar_Produto);
		painel_Produtos.add(lblCadastro_Produto);
		painel_Produtos.add(scrollPane_Produto);
		painel_Produtos.add(btnNovo_Produto);
		painel_Produtos.add(btnEditar_Produto);
		painel_Produtos.add(btnCancelar_Produto);
		painel_Produtos.add(btnDeletar_Produto);
		painel_Produtos.add(lblProduto_Produto);
		painel_Produtos.add(lblCusto_Produto);
		painel_Produtos.add(lblVenda_Produto);
		painel_Produtos.add(textCusto_Produto);
		painel_Produtos.add(textProduto_Produto);
		painel_Produtos.add(textVenda_Produto);
		painel_Produtos.add(lblCodigo_Produto);
		painel_Produtos.add(lblID_Produto);
		painel_Produtos.add(textCodigo_Produto);
		painel_Produtos.add(textID_Produto);
		
		JLabel lblBackground_Produto = new JLabel("");
		lblBackground_Produto.setIcon(new ImageIcon(Tela_Cadastro.class.getResource("/br/com/farmaciasoft/view/assets/background.jpg")));
		lblBackground_Produto.setBounds(0, 0, 1250, 705);
		painel_Produtos.add(lblBackground_Produto);
		contentPane_FarmaciaSoft.add(tabbedPane_FarmaciaSoft);
			
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