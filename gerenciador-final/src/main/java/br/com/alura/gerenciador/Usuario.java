package br.com.alura.gerenciador;

public class Usuario {

	private String email;
	private String senha;

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public String getEmail() {
		return email;
	}

}
