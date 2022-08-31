package br.com.farmaciasoft.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.farmaciasoft.core.dao.connection.ConexaoMySQL;
import br.com.farmaciasoft.core.entity.ProdutoEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class ProdutoDAO {

	public String salvarProduto(ProdutoEntity produto) throws BusinessException {
		String sql = "INSERT INTO PRODUTO (NOME_PRODUTO, VENDA_PRODUTO, CUSTO_PRODUTO, CODBARRAS_PRODUTO) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getpVenda());
			ps.setDouble(3, produto.getpCusto());
			ps.setString(4, produto.getCodigo());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel adicionar o Produto!");
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

	public List<ProdutoEntity> listarProdutos() throws BusinessException {
	
		String sql = "SELECT ID_PRODUTO, NOME_PRODUTO, VENDA_PRODUTO, CUSTO_PRODUTO, CODBARRAS_PRODUTO FROM PRODUTO";
	
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProdutoEntity> produto = new ArrayList<ProdutoEntity>();
	
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProdutoEntity produ = new ProdutoEntity();
				produ.setId(rs.getLong("ID_PRODUTO"));
				produ.setNome(rs.getString("NOME_PRODUTO"));
				produ.setpVenda(rs.getDouble("VENDA_PRODUTO"));
				produ.setpCusto(rs.getDouble("CUSTO_PRODUTO"));
				produ.setCodigo(rs.getString("CODBARRAS_PRODUTO"));
				produto.add(produ);
			}
		} catch (SQLException e) {
			throw new BusinessException("Erro ao listar os Produtos.");
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return produto;
	}

	public void excluirProduto(Long codigoProduto) throws BusinessException {
		
		String sql = "DELETE FROM PRODUTO WHERE ID_PRODUTO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoProduto);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel deletar o Produto!");
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public ProdutoEntity buscarID(String idProduto) throws BusinessException {
		
		String sql = "SELECT ID_PRODUTO, NOME_PRODUTO, VENDA_PRODUTO, CUSTO_PRODUTO, CODBARRAS_PRODUTO FROM PRODUTO WHERE ID_PRODUTO = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, idProduto);
			
			rs = ps.executeQuery();
			
			ProdutoEntity produtoEncontrado = null;
			
			if(rs.next()) {
				produtoEncontrado = new ProdutoEntity();
				produtoEncontrado.setId(rs.getLong("ID_PRODUTO"));
				produtoEncontrado.setNome(rs.getString("NOME_PRODUTO"));
				produtoEncontrado.setpVenda(rs.getDouble("VENDA_PRODUTO"));
				produtoEncontrado.setpCusto(rs.getDouble("CUSTO_PRODUTO"));
				produtoEncontrado.setCodigo(rs.getString("CODBARRAS_PRODUTO"));
			}
			
			return produtoEncontrado;
			
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel procurar o Produto!");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
	}
	
	public String alterarProduto(ProdutoEntity produto) throws BusinessException{
		
		String sql = "UPDATE FORNECEDOR SET NOME_PRODUTO = ?, VENDA_PRODUTO = ?, CUSTO_PRODUTO = ?, CODBARRAS_PRODUTO = ? WHERE ID_PRODUTO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getpVenda());
			ps.setDouble(3, produto.getpCusto());
			ps.setString(4, produto.getCodigo());
			ps.setLong(5, produto.getId());
			
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
		return "Dados do Produto Alterado!";
	}	
}