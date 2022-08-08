package br.com.farmaciasoft.core.entity;

public class ProdutoEntity {

	private String nome, codigo;
	private Long id;
	private Double p_custo, p_venda;
	
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
	public Double getP_custo() {
		return p_custo;
	}
	public void setP_custo(Double p_custo) {
		this.p_custo = p_custo;
	}
	public Double getP_venda() {
		return p_venda;
	}
	public void setP_venda(Double p_venda) {
		this.p_venda = p_venda;
	}	
	
	
	
}