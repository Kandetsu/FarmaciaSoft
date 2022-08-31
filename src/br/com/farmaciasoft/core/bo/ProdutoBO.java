package br.com.farmaciasoft.core.bo;

import java.util.List;

import br.com.farmaciasoft.core.dao.ProdutoDAO;
import br.com.farmaciasoft.core.entity.ProdutoEntity;
import br.com.farmaciasoft.core.util.exception.BusinessException;

public class ProdutoBO {
	public String salvarProduto(ProdutoEntity produto) throws BusinessException {
		if (produto.getNome() == null || produto.getNome().equals("")) {
			throw new BusinessException("O produto precisa ser preenchido!");
		}else if (produto.getpVenda() == null || produto.getpVenda() < 0.10) {
			throw new BusinessException("O preço de venda está inválido!");
		}else if (produto.getpCusto() == null || produto.getpCusto() < 0.01) {
			throw new BusinessException("O preço de custo está inválido!");
		}else if (produto.getCodigo() == null || produto.getCodigo().equals("")) {
			throw new BusinessException("O código de barras não está preenchido!");
		}else {
			ProdutoDAO dao = new ProdutoDAO();
			return dao.salvarProduto(produto);
		}
	}
	
	public List<ProdutoEntity> listarProdutos() throws BusinessException{
		return new ProdutoDAO().listarProdutos();
	}

	public void excluirProduto(Long codigoProduto) throws BusinessException{
		new ProdutoDAO().excluirProduto(codigoProduto);
	}
	
	public ProdutoEntity buscarID(String idProduto) throws BusinessException {
		return new ProdutoDAO().buscarID(idProduto);
	}
	
	public String alterarProduto(ProdutoEntity produto) throws BusinessException{
		return new ProdutoDAO().alterarProduto(produto);
	}
	
}