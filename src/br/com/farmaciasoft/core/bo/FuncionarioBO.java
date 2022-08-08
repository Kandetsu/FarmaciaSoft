package br.com.farmaciasoft.core.bo;

import java.util.List;

import br.com.farmaciasoft.core.dao.FuncionarioDAO;
import br.com.farmaciasoft.core.entity.FuncionarioEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class FuncionarioBO {
	public String salvarFuncionario(FuncionarioEntity funcionario) throws BusinessException {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.salvarFuncionario(funcionario);
	}
	
	public List<FuncionarioEntity> listarFuncionarios() throws BusinessException{
		return new FuncionarioDAO().listarFuncionarios();
	}

	public void excluirFuncionario(Long codigoFuncionario) throws BusinessException{
		new FuncionarioDAO().excluirFuncionario(codigoFuncionario);
	}
	
	public FuncionarioEntity buscarID(String idFuncionario) throws BusinessException {
		return new FuncionarioDAO().buscarID(idFuncionario);
	}
	
	public String alterarFuncionario(FuncionarioEntity funcionario) throws BusinessException{
		return new FuncionarioDAO().alterarFuncionario(funcionario);
	}
	
}