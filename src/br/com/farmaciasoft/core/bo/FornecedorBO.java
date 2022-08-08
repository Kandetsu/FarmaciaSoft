package br.com.farmaciasoft.core.bo;

import java.util.List;
import br.com.farmaciasoft.core.dao.FornecedorDAO;
import br.com.farmaciasoft.core.entity.FornecedorEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class FornecedorBO {
	public String salvarFornecedor(FornecedorEntity fornecedor) throws BusinessException {
		FornecedorDAO dao = new FornecedorDAO();
		return dao.salvarFornecedor(fornecedor);
	}
	
	public List<FornecedorEntity> listarFornecedores() throws BusinessException{
		return new FornecedorDAO().listarFornecedores();
	}

	public void excluirFornecedor(Long codigoFornecedor) throws BusinessException{
		new FornecedorDAO().excluirFornecedor(codigoFornecedor);
	}
	
	public FornecedorEntity buscarID(String idFornecedor) throws BusinessException {
		return new FornecedorDAO().buscarID(idFornecedor);
	}
	
	public String alterarFornecedor(FornecedorEntity fornecedor) throws BusinessException{
		return new FornecedorDAO().alterarFornecedor(fornecedor);
	}
	
}