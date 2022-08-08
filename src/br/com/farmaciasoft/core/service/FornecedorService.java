package br.com.farmaciasoft.core.service;

import java.util.List;

import br.com.farmaciasoft.core.bo.FornecedorBO;
import br.com.farmaciasoft.core.entity.FornecedorEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class FornecedorService {
	public String salvarFornecedor(FornecedorEntity fornecedor) throws BusinessException {
		FornecedorBO dao = new FornecedorBO();
		return dao.salvarFornecedor(fornecedor);
	}
	
	public List<FornecedorEntity> listarFornecedores() throws BusinessException{
		return new FornecedorBO().listarFornecedores();
	}

	public void excluirFornecedor(Long codigoFornecedor) throws BusinessException{
		new FornecedorBO().excluirFornecedor(codigoFornecedor);
	}
	
	public FornecedorEntity buscarID(String idFornecedor) throws BusinessException {
		return new FornecedorBO().buscarID(idFornecedor);
	}
	
	public String alterarFornecedor(FornecedorEntity fornecedor) throws BusinessException{
		return new FornecedorBO().alterarFornecedor(fornecedor);
	}
}