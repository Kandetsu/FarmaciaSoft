package br.com.farmaciasoft.core.entity;

public class ClienteEntity extends PessoaEntity {

	//Definir Váriaveis
	
	private String cpf;
	private Integer idade, verifica;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Integer getVerifica() {
		return verifica;
	}
	public void setVerifica(Integer verifica) {
		this.verifica = verifica;
	}
	
	
}