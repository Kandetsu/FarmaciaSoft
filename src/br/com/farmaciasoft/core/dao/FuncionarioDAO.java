package br.com.farmaciasoft.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.farmaciasoft.core.dao.connection.ConexaoMySQL;
import br.com.farmaciasoft.core.entity.FuncionarioEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class FuncionarioDAO {
	
	public String salvarFuncionario(FuncionarioEntity funcionario) throws BusinessException {
		String sql = "INSERT INTO FUNCIONARIO (NOME_FUNCIO, CPF_FUNCIO, IDADE_FUNCIO, ENDERECO_FUNCIO, CARGO_FUNCIO, NUMERO_FUNCIO, "
				+ "CIDADE_FUNCIO, ESTADO_FUNCIO, LOJA_FUNCIO, SALARIO_FUNCIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getCpf());
			ps.setInt(3, funcionario.getIdade());
			ps.setString(4, funcionario.getEndereco());
			ps.setString(5, funcionario.getCargo());
			ps.setInt(6, funcionario.getNum());
			ps.setString(7, funcionario.getCidade());
			ps.setString(8, funcionario.getEstado());
			ps.setInt(9, funcionario.getLoja());
			ps.setDouble(10, funcionario.getSalario());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel adicionar o Funcionário!");
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

	public List<FuncionarioEntity> listarFuncionarios() throws BusinessException {
	
		String sql = "SELECT ID_FUNCIO, NOME_FUNCIO, CPF_FUNCIO, IDADE_FUNCIO, ENDERECO_FUNCIO, CARGO_FUNCIO, NUMERO_FUNCIO, CIDADE_FUNCIO, ESTADO_FUNCIO, "
				+ "LOJA_FUNCIO, SALARIO_FUNCIO FROM FUNCIONARIO";
	
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FuncionarioEntity> funcionario = new ArrayList<FuncionarioEntity>();
	
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FuncionarioEntity funcio = new FuncionarioEntity();
				funcio.setCodigo(rs.getLong("ID_FUNCIO"));
				funcio.setNome(rs.getString("NOME_FUNCIO"));
				funcio.setCpf(rs.getString("CPF_FUNCIO"));
				funcio.setIdade(rs.getInt("IDADE_FUNCIO"));
				funcio.setEndereco(rs.getString("ENDERECO_FUNCIO"));
				funcio.setCargo(rs.getString("CARGO_FUNCIO"));
				funcio.setNum(rs.getInt("NUMERO_FUNCIO"));
				funcio.setCidade(rs.getString("CIDADE_FUNCIO"));
				funcio.setEstado(rs.getString("ESTADO_FUNCIO"));
				funcio.setLoja(rs.getInt("LOJA_FUNCIO"));
				funcio.setSalario(rs.getDouble("SALARIO_FUNCIO"));
				funcionario.add(funcio);
			}
		} catch (SQLException e) {
			throw new BusinessException("Erro ao listar os Funcionários.");
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return funcionario;
	}

	public void excluirFuncionario(Long codigoFuncionario) throws BusinessException {
		
		String sql = "DELETE FROM FUNCIONARIO WHERE ID_FUNCIO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoFuncionario);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel deletar o Funcionário!");
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public FuncionarioEntity buscarID(String idFuncionario) throws BusinessException {
		
		String sql = "SELECT ID_FUNCIO, NOME_FUNCIO, CPF_FUNCIO, IDADE_FUNCIO, ENDERECO_FUNCIO, CARGO_FUNCIO, NUMERO_FUNCIO, CIDADE_FUNCIO, "
				+ "ESTADO_FUNCIO, LOJA_FUNCIO, SALARIO_FUNCIO FROM FUNCIONARIO WHERE ID_FUNCIO = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, idFuncionario);
			
			rs = ps.executeQuery();
			
			FuncionarioEntity funcionarioEncontrado = null;
			
			if(rs.next()) {
				funcionarioEncontrado = new FuncionarioEntity();
				funcionarioEncontrado.setCodigo(rs.getLong("ID_FUNCIO"));
				funcionarioEncontrado.setNome(rs.getString("NOME_FUNCIO"));
				funcionarioEncontrado.setCpf(rs.getString("CPF_FUNCIO"));
				funcionarioEncontrado.setIdade(rs.getInt("IDADE_FUNCIO"));
				funcionarioEncontrado.setEndereco(rs.getString("ENDERECO_FUNCIO"));
				funcionarioEncontrado.setCargo(rs.getString("CARGO_FUNCIO"));
				funcionarioEncontrado.setNum(rs.getInt("NUMERO_FUNCIO"));
				funcionarioEncontrado.setCidade(rs.getString("CIDADE_FUNCIO"));
				funcionarioEncontrado.setEstado(rs.getString("ESTADO_FUNCIO"));
				funcionarioEncontrado.setLoja(rs.getInt("LOJA_FUNCIO"));
				funcionarioEncontrado.setSalario(rs.getDouble("SALARIO_FUNCIO"));
			}
			
			return funcionarioEncontrado;
			
		} catch (SQLException e) {
			throw new BusinessException("Não foi possivel procurar o Funcionário!");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
	}
	
	public String alterarFuncionario(FuncionarioEntity funcionario) throws BusinessException{
		
		String sql = "UPDATE FUNCIONARIO SET NOME_FUNCIO = ?, CPF_FUNCIO = ?, IDADE_FUNCIO = ?, ENDERECO_FUNCIO = ?, CARGO_FUNCIO = ?, NUMERO_FUNCIO = ?, "
				+ "CIDADE_FUNCIO = ?, ESTADO_FUNCIO = ?, LOJA_FUNCIO = ?, SALARIO_FUNCIO = ? WHERE ID_FUNCIO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getCpf());
			ps.setInt(3, funcionario.getIdade());
			ps.setString(4, funcionario.getEndereco());
			ps.setString(5, funcionario.getCargo());
			ps.setInt(6, funcionario.getNum());
			ps.setString(7, funcionario.getCidade());
			ps.setString(8, funcionario.getEstado());
			ps.setInt(9, funcionario.getLoja());
			ps.setDouble(10, funcionario.getSalario());
			ps.setLong(11, funcionario.getCodigo()); 
			
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
		return "Dados do Funcionario Alterado!";
	}	
}