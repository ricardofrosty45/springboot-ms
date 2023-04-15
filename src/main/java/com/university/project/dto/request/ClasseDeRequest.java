package com.university.project.dto.request;

public class ClasseDeRequest {

	private String nome;
	private String email;
	private Integer idade;
	private EnderecoRequest enderecoRequest;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public EnderecoRequest getEnderecoRequest() {
		return enderecoRequest;
	}

	public void setEnderecoRequest(EnderecoRequest enderecoRequest) {
		this.enderecoRequest = enderecoRequest;
	}

}
