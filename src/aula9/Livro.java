package aula9;

public class Livro {
	private String titulo;
	private String autor;
	private boolean disponivel;
	
	public Livro(String livro, String autor, boolean disponivel) {
		this.titulo = livro;
		this.autor = autor;
		this.disponivel = disponivel;
	}
	
	public boolean isDisponivel() {
		
		return disponivel;
	}
	
	public void marcarComoEmprestado() {
		disponivel = false;
	}
	
	public void marcarComoDevolvido() {
		disponivel = true;
	}
	
	public String toString() {
		return "Livro " + titulo +  "do Autor: " + autor;
	}

}
