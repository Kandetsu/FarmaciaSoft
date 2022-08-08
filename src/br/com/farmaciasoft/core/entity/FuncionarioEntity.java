package br.com.farmaciasoft.core.entity;

public class FuncionarioEntity extends ClienteEntity{
	
	private String cargo;
	private Integer loja;
	private Double salario;
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Integer getLoja() {
		return loja;
	}
	public void setLoja(Integer loja) {
		this.loja = loja;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
}
