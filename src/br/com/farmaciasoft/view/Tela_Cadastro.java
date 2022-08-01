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

public class Tela_Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textIdade;
	private JTextField textEndereco;
	private JTextField textNumCasa;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTable tableCliente;
	private List<ClienteEntity> clientes;
	private JTextField textID;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel painel_1 = new JPanel();
		painel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_1.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Tela Inicial", null, painel_1, null);
		
		JLabel lblFarmaciaSoft = new JLabel("FarmaciaSoft");
		lblFarmaciaSoft.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarmaciaSoft.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JTextPane txtpnMensagemBV = new JTextPane();
		txtpnMensagemBV.setBackground(Color.LIGHT_GRAY);
		txtpnMensagemBV.setFont(new Font("Calibri", Font.BOLD, 16));
		txtpnMensagemBV.setText("Seja Bem-vindo(a) ao projeto que estou realizando referente a cadastros!");
		GroupLayout gl_painel_1 = new GroupLayout(painel_1);
		gl_painel_1.setHorizontalGroup(
			gl_painel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_1.createSequentialGroup()
					.addGroup(gl_painel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_1.createSequentialGroup()
							.addGap(293)
							.addComponent(lblFarmaciaSoft, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painel_1.createSequentialGroup()
							.addGap(283)
							.addComponent(txtpnMensagemBV, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(321, Short.MAX_VALUE))
		);
		gl_painel_1.setVerticalGroup(
			gl_painel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFarmaciaSoft, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(101)
					.addComponent(txtpnMensagemBV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(179, Short.MAX_VALUE))
		);
		painel_1.setLayout(gl_painel_1);
		
		JPanel painel_2 = new JPanel();
		painel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_2.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Cliente", null, painel_2, null);
		
		JLabel lblCadastro_C = new JLabel("Cadastro De Cliente");
		lblCadastro_C.setVerticalAlignment(SwingConstants.TOP);
		lblCadastro_C.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_C.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setHorizontalAlignment(SwingConstants.LEFT);
		lblCPF.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdade.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereco.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNumCasa = new JLabel("N\u00FAmero da casa:");
		lblNumCasa.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumCasa.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JButton btnSalvar = new JButton("Salvar Cadastro");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteEntity cliente = new ClienteEntity();
				cliente.setNome(textNome.getText());
				cliente.setCpf(textCPF.getText());
				cliente.setIdade(Integer.parseInt(textIdade.getText()));
				cliente.setEndereco(textEndereco.getText());
				cliente.setNum(textNumCasa.getText());
				cliente.setCidade(textCidade.getText());
				cliente.setEstado(textEstado.getText());
				
				@SuppressWarnings("unused")
				String msg = null;
				try { 
					if(textID.getText().equals("")) {
						msg = new ClienteService().salvarCliente(cliente);
						JOptionPane.showMessageDialog(null, "Cliente salvo!");
					}else {
						cliente.setCodigo(Long.parseLong(textID.getText()));
						msg = new ClienteService().alterarCliente(cliente);
						JOptionPane.showMessageDialog(null, "Cliente Alterado");
					}
				} catch (BusinessException e1) {
					JOptionPane.showMessageDialog(null, e1.getErro());
				}
				}
		});
		btnSalvar.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnLimpar = new JButton("Limpar Formul\u00E1rio");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText("");
				textCPF.setText("");
				textIdade.setText("");
				textEndereco.setText("");
				textNumCasa.setText("");
				textCidade.setText("");
				textEstado.setText("");
			}
		});
		btnLimpar.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JButton btnAtualizar = new JButton("Atualizar Tabela");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanciarTabela();
			}
		});
		btnAtualizar.setFont(new Font("Calibri", Font.BOLD, 13));
		
		textNome = new JTextField();
		textNome.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNome.setEnabled(false);
		textNome.setColumns(10);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCPF.setEnabled(false);
		textCPF.setColumns(10);
		
		textIdade = new JTextField();
		textIdade.setFont(new Font("Calibri", Font.PLAIN, 14));
		textIdade.setEnabled(false);
		textIdade.setColumns(10);
		
		textEndereco = new JTextField();
		textEndereco.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEndereco.setEnabled(false);
		textEndereco.setColumns(10);
		
		textNumCasa = new JTextField();
		textNumCasa.setFont(new Font("Calibri", Font.PLAIN, 14));
		textNumCasa.setEnabled(false);
		textNumCasa.setColumns(10);
		
		textCidade = new JTextField();
		textCidade.setFont(new Font("Calibri", Font.PLAIN, 14));
		textCidade.setEnabled(false);
		textCidade.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setFont(new Font("Calibri", Font.PLAIN, 14));
		textEstado.setEnabled(false);
		textEstado.setColumns(10);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteEntity clienteSelecionado = clientes.get(tableCliente.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o usuário de código " + clienteSelecionado.getCodigo()) == JOptionPane.OK_OPTION) {
					try {
						new ClienteService().excluirCliente(clienteSelecionado.getCodigo());
					} catch (BusinessException e1) {
						JOptionPane.showMessageDialog(null, e1.getErro());
					}
				}
			}
		});
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setEnabled(true);
				textCPF.setEnabled(true);
				textIdade.setEnabled(true);
				textEndereco.setEnabled(true);
				textNumCasa.setEnabled(true);
				textCidade.setEnabled(true);
				textEstado.setEnabled(true);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setEnabled(false);
				textCPF.setEnabled(false);
				textIdade.setEnabled(false);
				textEndereco.setEnabled(false);
				textNumCasa.setEnabled(false);
				textCidade.setEnabled(false);
				textEstado.setEnabled(false);
				btnDeletar.setEnabled(false);
			}
		});
		btnCancelar.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JScrollPane scrollPaneCliente = new JScrollPane();
		
		JLabel lblBuscar = new JLabel("Procurar :");
		lblBuscar.setFont(new Font("Calibri", Font.BOLD, 14));
		
		btnDeletar.setEnabled(false);
		btnDeletar.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		JButton btnBuscar = new JButton("Ok");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCliente(textID.getText());
			}
		});
		btnBuscar.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblID = new JLabel("ID:");
		lblID.setHorizontalAlignment(SwingConstants.LEFT);
		lblID.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textID = new JTextField();
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setFont(new Font("Calibri", Font.PLAIN, 14));
		textID.setColumns(10);
		GroupLayout gl_painel_2 = new GroupLayout(painel_2);
		gl_painel_2.setHorizontalGroup(
			gl_painel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_2.createSequentialGroup()
					.addGroup(gl_painel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_2.createSequentialGroup()
							.addGap(299)
							.addComponent(lblCadastro_C))
						.addGroup(gl_painel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_painel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome)
								.addComponent(lblCPF)
								.addComponent(lblIdade)
								.addComponent(lblEndereco))
							.addGap(33)
							.addGroup(gl_painel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painel_2.createSequentialGroup()
									.addGroup(gl_painel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(textIdade, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
										.addComponent(textCPF, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
										.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_painel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNumCasa)
										.addComponent(lblCidade)
										.addComponent(lblEstado)))
								.addGroup(gl_painel_2.createSequentialGroup()
									.addComponent(textEndereco, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_painel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(textID, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEstado, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCidade, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNumCasa, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_painel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNovo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBuscar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(97)
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLimpar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAtualizar))
						.addGroup(gl_painel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneCliente, GroupLayout.PREFERRED_SIZE, 742, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_painel_2.setVerticalGroup(
			gl_painel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_C)
					.addGap(23)
					.addGroup(gl_painel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovo)
						.addComponent(btnCancelar)
						.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_painel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumCasa)
						.addComponent(textNumCasa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painel_2.createSequentialGroup()
							.addGroup(gl_painel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCPF)
								.addComponent(textCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_painel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIdade)
								.addComponent(textIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_painel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEndereco)
								.addComponent(textEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_painel_2.createSequentialGroup()
							.addGroup(gl_painel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCidade)
								.addComponent(textCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_painel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEstado)
								.addComponent(textEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_painel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(textID, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_painel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSalvar)
							.addComponent(btnLimpar)
							.addComponent(btnAtualizar))
						.addGroup(gl_painel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBuscar)
							.addComponent(btnBuscar)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneCliente, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		
		tableCliente = new JTable();
		tableCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDeletar.setEnabled(true);
			}
		});
		
		
		tableCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Idade", "Endere\u00E7o", "N\u00FAmero", "Cidade", "Estado"
			}
		));
		scrollPaneCliente.setViewportView(tableCliente);
		painel_2.setLayout(gl_painel_2);
		
		JPanel painel_3 = new JPanel();
		painel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_3.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Fornecedor", null, painel_3, null);
		
		JLabel lblCadastro_F = new JLabel("Cadastro de Fornecedor");
		lblCadastro_F.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_F.setFont(new Font("Calibri", Font.BOLD, 20));
		GroupLayout gl_painel_3 = new GroupLayout(painel_3);
		gl_painel_3.setHorizontalGroup(
			gl_painel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_3.createSequentialGroup()
					.addGap(275)
					.addComponent(lblCadastro_F)
					.addContainerGap(299, Short.MAX_VALUE))
		);
		gl_painel_3.setVerticalGroup(
			gl_painel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_F)
					.addContainerGap(373, Short.MAX_VALUE))
		);
		painel_3.setLayout(gl_painel_3);
		
		JPanel painel_4 = new JPanel();
		painel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_4.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Funcionario", null, painel_4, null);
		
		JLabel lblCadastro_Fu = new JLabel("Cadastro de Funcion\u00E1rio");
		lblCadastro_Fu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_Fu.setFont(new Font("Calibri", Font.BOLD, 20));
		GroupLayout gl_painel_4 = new GroupLayout(painel_4);
		gl_painel_4.setHorizontalGroup(
			gl_painel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_4.createSequentialGroup()
					.addGap(281)
					.addComponent(lblCadastro_Fu)
					.addContainerGap(289, Short.MAX_VALUE))
		);
		gl_painel_4.setVerticalGroup(
			gl_painel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_Fu)
					.addContainerGap(373, Short.MAX_VALUE))
		);
		painel_4.setLayout(gl_painel_4);
		
		JPanel painel_5 = new JPanel();
		painel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel_5.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Produtos", null, painel_5, null);
		
		JLabel lblCadastro_P = new JLabel("Cadastro de Produtos");
		lblCadastro_P.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro_P.setFont(new Font("Calibri", Font.BOLD, 20));
		GroupLayout gl_painel_5 = new GroupLayout(painel_5);
		gl_painel_5.setHorizontalGroup(
			gl_painel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_5.createSequentialGroup()
					.addGap(277)
					.addComponent(lblCadastro_P)
					.addContainerGap(315, Short.MAX_VALUE))
		);
		gl_painel_5.setVerticalGroup(
			gl_painel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastro_P)
					.addContainerGap(373, Short.MAX_VALUE))
		);
		painel_5.setLayout(gl_painel_5);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		contentPane.setLayout(gl_contentPane);
			
		}
		private void instanciarTabela() {
			try {
				clientes = new ClienteService().listarCliente();
				DefaultTableModel model = (DefaultTableModel)tableCliente.getModel();
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
					textNome.setText(clienteEncontrado.getNome());
					textCPF.setText(clienteEncontrado.getCpf());
					textIdade.setText(String.valueOf(clienteEncontrado.getIdade()));
					textEndereco.setText(clienteEncontrado.getEndereco());
					textNumCasa.setText(clienteEncontrado.getNum());
					textCidade.setText(clienteEncontrado.getCidade());
					textEstado.setText(clienteEncontrado.getEstado());
				}
				
			} catch (BusinessException e) {
				JOptionPane.showMessageDialog(null, e.getErro(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
		}
}
