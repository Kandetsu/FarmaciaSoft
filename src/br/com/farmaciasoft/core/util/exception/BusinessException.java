package br.com.farmaciasoft.core.util.exception;

public class BusinessException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String erro;
	
	public BusinessException() {
		
	}
	
	public BusinessException(String excecao) {
		this.erro = excecao;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
}
