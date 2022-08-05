package br.com.farmaciasoft.view;

import javax.swing.JOptionPane;

import br.com.farmaciasoft.core.entity.ClienteEntity;
import br.com.farmaciasoft.core.service.ClienteService;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class teste {

	public static void main(String[] args) {

//		Monttando o objeto com as informações da tela
		ClienteEntity cliente = new ClienteEntity();
		cliente.setNome("???");
		cliente.setCpf("1111111");
		cliente.setEndereco("???");
		cliente.setNum(1);
		cliente.setIdade(22);
		cliente.setCidade("???");
		cliente.setEstado("???");

//		Estou chamando meu CORE/Backend para salvar o usuario em questão
		ClienteService us = new ClienteService();
		try {
			System.out.println(us.salvarCliente(cliente));
		}catch (BusinessException e){
			JOptionPane.showMessageDialog(null, e.getErro());
		}
		
	}
}
