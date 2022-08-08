package br.com.farmaciasoft.core.service;

import java.util.List;

import br.com.farmaciasoft.core.bo.ProdutoBO;
import br.com.farmaciasoft.core.entity.ProdutoEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class ProdutoService {
	public String salvarProduto(ProdutoEntity produto) throws BusinessException {
		ProdutoBO dao = new ProdutoBO();
		return dao.salvarProduto(produto);
	}
	
	public List<ProdutoEntity> listarProdutos() throws BusinessException{
		return new ProdutoBO().listarProdutos();
	}

	public void excluirProduto(Long codigoProduto) throws BusinessException{
		new ProdutoBO().excluirProduto(codigoProduto);
	}
	
	public ProdutoEntity buscarID(String idProduto) throws BusinessException {
		return new ProdutoBO().buscarID(idProduto);
	}
	
	public String alterarProduto(ProdutoEntity produto) throws BusinessException{
		return new ProdutoBO().alterarProduto(produto);
	}
	
}