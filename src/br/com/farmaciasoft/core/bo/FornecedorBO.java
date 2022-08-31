package br.com.farmaciasoft.core.bo;

import java.util.List;
import br.com.farmaciasoft.core.dao.FornecedorDAO;
import br.com.farmaciasoft.core.entity.FornecedorEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class FornecedorBO {
	public String salvarFornecedor(FornecedorEntity fornecedor) throws BusinessException {
		if(fornecedor.getNome() == null || fornecedor.getNome().equals("")) {
			throw new BusinessException("O Nome precisa ser preenchido!");
		}else if(fornecedor.getCnpj() == null || fornecedor.getCnpj().equals("")) {
			throw new BusinessException("O CNPJ precisa ser preenchido!");
		}else if(fornecedor.getEndereco() == null || fornecedor.getEndereco().equals("")){
			throw new BusinessException("O Endereço precisa ser preenchido!");
		}else if(fornecedor.getNum() <= 0){
			throw new BusinessException("O Número da empresa é menor que 1!");
		}else if(fornecedor.getCidade() == null || fornecedor.getCidade().equals("")){
			throw new BusinessException("A Cidade precisa ser preenchido!");
		}else if(fornecedor.getEstado() == null || fornecedor.getEstado().equals("")){
			throw new BusinessException("O Estado precisa ser preenchido!");
		}else {
			FornecedorDAO dao = new FornecedorDAO();
			return dao.salvarFornecedor(fornecedor);
		}
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