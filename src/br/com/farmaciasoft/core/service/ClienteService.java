package br.com.farmaciasoft.core.service;

import java.util.List;

import br.com.farmaciasoft.core.bo.ClienteBO;
import br.com.farmaciasoft.core.entity.ClienteEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class ClienteService {

	//Responsavel por execução dos serviços
	
	public String salvarCliente (ClienteEntity cliente) throws BusinessException {
		ClienteBO bo = new ClienteBO();
		return bo.salvarCliente(cliente);
	}
	
	public List<ClienteEntity> listarCliente() throws BusinessException{
		return new ClienteBO().listarClientes();
	}

	public void excluirCliente(Long codigoCliente) throws BusinessException{
		new ClienteBO().excluirCliente(codigoCliente);
	}
	public ClienteEntity buscarID(String idCliente) throws BusinessException {
		return new ClienteBO().buscarID(idCliente);
	}
	
	public String alterarCliente(ClienteEntity cliente) throws BusinessException{
		return new ClienteBO().alterarCliente(cliente);
	}
	
}
