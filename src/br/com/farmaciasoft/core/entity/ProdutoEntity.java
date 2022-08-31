package br.com.farmaciasoft.core.entity;

public class ProdutoEntity {

	private String nome, codigo;
	private Long id;
	private Double pCusto, pVenda;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getpCusto() {
		return pCusto;
	}
	public void setpCusto(Double pCusto) {
		this.pCusto = pCusto;
	}
	public Double getpVenda() {
		return pVenda;
	}
	public void setpVenda(Double pVenda) {
		this.pVenda = pVenda;
	}	
	
	
	
}