package br.com.farmaciasoft.core.bo;

import java.util.List;

import br.com.farmaciasoft.core.dao.FuncionarioDAO;
import br.com.farmaciasoft.core.entity.FuncionarioEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class FuncionarioBO {
	public String salvarFuncionario(FuncionarioEntity funcionario) throws BusinessException {
		if(funcionario.getNome() == null || funcionario.getNome().equals("")) {
			throw new BusinessException("O Nome precisa ser preenchido!");
		}else if(funcionario.getCpf() == null || funcionario.getCpf().equals("")) {
			throw new BusinessException("O CPF precisa ser preenchido!");
		}else if(funcionario.getIdade() < 0 || funcionario.getIdade() >= 110) {
			throw new BusinessException("A Idade está no formato errado!");
		}else if(funcionario.getEndereco() == null || funcionario.getEndereco().equals("")){
			throw new BusinessException("O Endereço precisa ser preenchido!");
		}else if(funcionario.getNum() <= 0){
			throw new BusinessException("O Número da casa é menor que 1!");
		}else if(funcionario.getCidade() == null || funcionario.getCidade().equals("")){
			throw new BusinessException("A Cidade precisa ser preenchido!");
		}else if(funcionario.getEstado() == null || funcionario.getEstado().equals("")){
			throw new BusinessException("O Estado precisa ser preenchido!");
		}else if (funcionario.getCargo() == null || funcionario.getCargo().equals("")) {
			throw new BusinessException("O Cargo precisa ser preenchido!");
		}else if (funcionario.getLoja() == null) {
			throw new BusinessException("A Loja precisa ser preenchida!");
		}else if (funcionario.getSalario() == null) {
			throw new BusinessException("O Salário precisa ser preenchido!");
		}else {
			FuncionarioDAO dao = new FuncionarioDAO();
			return dao.salvarFuncionario(funcionario);
		}
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