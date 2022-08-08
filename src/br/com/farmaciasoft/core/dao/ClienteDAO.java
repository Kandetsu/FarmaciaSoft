package br.com.farmaciasoft.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.farmaciasoft.core.dao.connection.ConexaoMySQL;
import br.com.farmaciasoft.core.entity.ClienteEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class ClienteDAO {

	//Camada Referente Ao Banco De Dados
	
	public String salvarCliente(ClienteEntity cliente) throws BusinessException {
		String sql = "INSERT INTO CLIENTE (NOME_CLI, CPF_CLI, IDADE_CLI, ENDERECO_CLI, NUM_CLI, CIDADE_CLI, ESTADO_CLI) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setInt(3, cliente.getIdade());
			ps.setString(4, cliente.getEndereco());
			ps.setInt(5, cliente.getNum());
			ps.setString(6, cliente.getCidade());
			ps.setString(7, cliente.getEstado());
			
			ps.execute();
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel adicionar o Cliente");
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}
		}
		return null;
	}
	
	public List<ClienteEntity> listarClientes() throws BusinessException {
		
		String sql = "SELECT ID_CLI, NOME_CLI, CPF_CLI, IDADE_CLI, ENDERECO_CLI, NUM_CLI, CIDADE_CLI, ESTADO_CLI FROM CLIENTE";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClienteEntity> cliente = new ArrayList<ClienteEntity>();
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ClienteEntity cli = new ClienteEntity();
				cli.setCodigo(rs.getLong("ID_CLI"));
				cli.setNome(rs.getString("NOME_CLI"));
				cli.setCpf(rs.getString("CPF_CLI"));
				cli.setIdade(rs.getInt("IDADE_CLI"));
				cli.setEndereco(rs.getString("ENDERECO_CLI"));
				cli.setNum(rs.getInt("NUM_CLI"));
				cli.setCidade(rs.getString("CIDADE_CLI"));
				cli.setEstado(rs.getString("ESTADO_CLI"));
				cliente.add(cli);
			}
		} catch (SQLException e) {
			throw new BusinessException("Erro ao listar os Clientes.");
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cliente;
	}
	
	public void excluirCliente(Long codigoCliente) throws BusinessException {
		
		String sql = "DELETE FROM CLIENTE WHERE ID_CLI = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoCliente);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel deletar o Cliente!");
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public ClienteEntity buscarID(String idCliente) throws BusinessException {
		
		String sql = "SELECT ID_CLI, NOME_CLI, CPF_CLI, IDADE_CLI, ENDERECO_CLI, NUM_CLI, CIDADE_CLI, ESTADO_CLI FROM CLIENTE WHERE ID_CLI = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, idCliente);
			
			rs = ps.executeQuery();
			
			ClienteEntity clienteEncontrado = null;
			
			if(rs.next()) {
				clienteEncontrado = new ClienteEntity();
				clienteEncontrado.setCodigo(rs.getLong("ID_CLI"));
				clienteEncontrado.setNome(rs.getString("NOME_CLI"));
				clienteEncontrado.setCpf(rs.getString("CPF_CLI"));
				clienteEncontrado.setIdade(rs.getInt("IDADE_CLI"));
				clienteEncontrado.setEndereco(rs.getString("ENDERECO_CLI"));
				clienteEncontrado.setNum(rs.getInt("NUM_CLI"));
				clienteEncontrado.setCidade(rs.getString("CIDADE_CLI"));
				clienteEncontrado.setEstado(rs.getString("ESTADO_CLI"));
			}
			
			return clienteEncontrado;
			
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel procurar o Cliente!");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
	}
	
	public String alterarCliente(ClienteEntity cliente) throws BusinessException{
		
		String sql = "UPDATE CLIENTE SET NOME_CLI = ?, CPF_CLI = ?, IDADE_CLI = ?, ENDERECO_CLI = ?, NUM_CLI = ?, CIDADE_CLI = ?, ESTADO_CLI = ? WHERE ID_CLI = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setInt(3, cliente.getIdade());
			ps.setString(4, cliente.getEndereco());
			ps.setInt(5, cliente.getNum());
			ps.setString(6, cliente.getCidade());
			ps.setString(7, cliente.getEstado());
			ps.setLong(8, cliente.getCodigo());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new BusinessException("Erro ao atualizar os dados!");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Dados do Cliente Alterado!";
	}
	
}