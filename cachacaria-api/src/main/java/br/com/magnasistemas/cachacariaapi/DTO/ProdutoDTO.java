package br.com.magnasistemas.cachacariaapi.DTO;

import java.time.LocalDateTime;

public class ProdutoDTO {
	
	private long id;
	
	private String nome;
	
	private double preco;
	
	private String sabor;
	
	private LocalDateTime validade; // 2021-05-21T15:14:30",
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}


	public LocalDateTime getValidade() {
		return validade;
	}

	public void setValidade(LocalDateTime validade) {
		this.validade = validade;
	}

	
	
	
	
	
	
}
