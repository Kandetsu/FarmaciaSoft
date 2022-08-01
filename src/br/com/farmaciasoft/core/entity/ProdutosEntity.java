package br.com.farmaciasoft.core.entity;

public class ProdutosEntity {

	private String nome;
	private Long codigo;
	private Double p_custo, p_venda;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Double getPreco_custo() {
		return p_custo;
	}
	public void setPreco_custo(Double p_custo) {
		this.p_custo = p_custo;
	}
	public Double getPreco_venda() {
		return p_venda;
	}
	public void setPreco_venda(Double preco_venda) {
		this.p_venda = preco_venda;
	}	
}