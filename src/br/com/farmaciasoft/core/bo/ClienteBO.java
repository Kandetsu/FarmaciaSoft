package br.com.farmaciasoft.core.bo;

import java.util.List;

import br.com.farmaciasoft.core.dao.ClienteDAO;
import br.com.farmaciasoft.core.entity.ClienteEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class ClienteBO {

	//Fazer Regras De Negócio
	
	public String salvarCliente(ClienteEntity cliente) throws BusinessException {
		
		if(cliente.getNome() == null || cliente.getNome().equals("")) {
			throw new BusinessException("O Nome precisa ser preenchido!");
		}else if(cliente.getCpf() == null || cliente.getCpf().equals("")) {
			throw new BusinessException("O CPF precisa ser preenchido!");
		}else if(cliente.getIdade() < 0 || cliente.getIdade() >= 110) {
			throw new BusinessException("A Idade está no formato errado!");
		}else if(cliente.getEndereco() == null || cliente.getEndereco().equals("")){
			throw new BusinessException("O Endereço precisa ser preenchido!");
		}else if(cliente.getNum() <= 0){
			throw new BusinessException("O Número da casa é menor que 1!");
		}else if(cliente.getCidade() == null || cliente.getCidade().equals("")){
			throw new BusinessException("A Cidade precisa ser preenchido!");
		}else if(cliente.getEstado() == null || cliente.getEstado().equals("")){
			throw new BusinessException("O Estado precisa ser preenchido!");
		}else {
			ClienteDAO dao = new ClienteDAO();
			return dao.salvarCliente(cliente);
		}
	}
	
	public List<ClienteEntity> listarClientes() throws BusinessException{
		return new ClienteDAO().listarClientes();
	}

	public void excluirCliente(Long codigoCliente) throws BusinessException{
		new ClienteDAO().excluirCliente(codigoCliente);
	}
	
	public ClienteEntity buscarID(String idCliente) throws BusinessException {
		return new ClienteDAO().buscarID(idCliente);
	}
	
	public String alterarCliente(ClienteEntity cliente) throws BusinessException{
		return new ClienteDAO().alterarCliente(cliente);
	}
	
	public ClienteEntity autenticar(String login, String senha) throws BusinessException{
		return new ClienteDAO().autenticar(login, senha);
	}
	
}