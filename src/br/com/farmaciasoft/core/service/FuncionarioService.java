package br.com.farmaciasoft.core.service;

import java.util.List;

import br.com.farmaciasoft.core.bo.FuncionarioBO;
import br.com.farmaciasoft.core.entity.FuncionarioEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class FuncionarioService {
	public String salvarFuncionario(FuncionarioEntity funcionario) throws BusinessException {
		FuncionarioBO dao = new FuncionarioBO();
		return dao.salvarFuncionario(funcionario);
	}
	
	public List<FuncionarioEntity> listarFuncionarios() throws BusinessException{
		return new FuncionarioBO().listarFuncionarios();
	}

	public void excluirFuncionario(Long codigoFuncionario) throws BusinessException{
		new FuncionarioBO().excluirFuncionario(codigoFuncionario);
	}
	
	public FuncionarioEntity buscarID(String idFuncionario) throws BusinessException {
		return new FuncionarioBO().buscarID(idFuncionario);
	}
	
	public String alterarFuncionario(FuncionarioEntity funcionario) throws BusinessException{
		return new FuncionarioBO().alterarFuncionario(funcionario);
	}
	
}