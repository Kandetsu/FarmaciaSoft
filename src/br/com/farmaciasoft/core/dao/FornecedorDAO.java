package br.com.farmaciasoft.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.farmaciasoft.core.dao.connection.ConexaoMySQL;
import br.com.farmaciasoft.core.entity.FornecedorEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class FornecedorDAO {

	public String salvarFornecedor(FornecedorEntity fornecedor) throws BusinessException {
		String sql = "INSERT INTO FORNECEDOR (EMPRESA_FORNE, CNPJ_FORNE, ENDERECO_FORNE, NUMERO__FORNE, CIDADE_FORNE, ESTADO_FORNE) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, fornecedor.getCnpj());
			ps.setString(3, fornecedor.getEndereco());
			ps.setInt(4, fornecedor.getNum());
			ps.setString(5, fornecedor.getCidade());
			ps.setString(6, fornecedor.getEstado());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel adicionar o Fornecedor");
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

	public List<FornecedorEntity> listarFornecedores() throws BusinessException {
	
		String sql = "SELECT ID_FORNE, EMPRESA_FORNE, CNPJ_FORNE, ENDERECO_FORNE, NUMERO__FORNE, CIDADE_FORNE, ESTADO_FORNE FROM FORNECEDOR";
	
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FornecedorEntity> fornecedor = new ArrayList<FornecedorEntity>();
	
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FornecedorEntity forne = new FornecedorEntity();
				forne.setCodigo(rs.getLong("ID_FORNE"));
				forne.setNome(rs.getString("EMPRESA_FORNE"));
				forne.setCnpj(rs.getString("CNPJ_FORNE"));
				forne.setEndereco(rs.getString("ENDERECO_FORNE"));
				forne.setNum(rs.getInt("NUMERO__FORNE"));
				forne.setCidade(rs.getString("CIDADE_FORNE"));
				forne.setEstado(rs.getString("ESTADO_FORNE"));
				fornecedor.add(forne);
			}
		} catch (SQLException e) {
			throw new BusinessException("Erro ao listar os Fornecedores.");
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fornecedor;
	}

	public void excluirFornecedor(Long codigoFornecedor) throws BusinessException {
		
		String sql = "DELETE FROM FORNECEDOR WHERE ID_FORNE = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoFornecedor);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel deletar o Fornecedor!");
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public FornecedorEntity buscarID(String idFornecedor) throws BusinessException {
		
		String sql = "SELECT ID_FORNE, EMPRESA_FORNE, CNPJ_FORNE, ENDERECO_FORNE, NUMERO__FORNE, CIDADE_FORNE, ESTADO_FORNE FROM FORNECEDOR WHERE ID_FORNE = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, idFornecedor);
			
			rs = ps.executeQuery();
			
			FornecedorEntity fornecedorEncontrado = null;
			
			if(rs.next()) {
				fornecedorEncontrado = new FornecedorEntity();
				fornecedorEncontrado.setCodigo(rs.getLong("ID_FORNE"));
				fornecedorEncontrado.setNome(rs.getString("EMPRESA_FORNE"));
				fornecedorEncontrado.setCnpj(rs.getString("CNPJ_FORNE"));
				fornecedorEncontrado.setEndereco(rs.getString("ENDERECO_FORNE"));
				fornecedorEncontrado.setNum(rs.getInt("NUMERO__FORNE"));
				fornecedorEncontrado.setCidade(rs.getString("CIDADE_FORNE"));
				fornecedorEncontrado.setEstado(rs.getString("ESTADO_FORNE"));
			}
			
			return fornecedorEncontrado;
			
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel procurar o Fornecedor!");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
	}
	
	public String alterarFornecedor(FornecedorEntity fornecedor) throws BusinessException{
		
		String sql = "UPDATE FORNECEDOR SET EMPRESA_FORNE = ?, CNPJ_FORNE = ?, ENDERECO_FORNE = ?, NUMERO__FORNE = ?, CIDADE_FORNE = ?, ESTADO_FORNE = ? WHERE ID_FORNE = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, fornecedor.getCnpj());
			ps.setString(3, fornecedor.getEndereco());
			ps.setInt(4, fornecedor.getNum());
			ps.setString(5, fornecedor.getCidade());
			ps.setString(6, fornecedor.getEstado());
			ps.setLong(7, fornecedor.getCodigo());
			
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
		return "Dados do Fornecedor Alterado!";
	}	
}