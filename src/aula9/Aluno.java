package aula9;

import java.util.ArrayList;

public class Aluno {
	private String nome;
	private String matricula;
	private ArrayList<Livro> livrosEmprestados;
	
	
	public Aluno(String nome, String matricula){
		this.nome = nome;
		this.matricula = matricula;
		this.livrosEmprestados = new ArrayList<>();
		
	}
	
	public void emprestarLivro(Livro l) {
		if(l.isDisponivel() && livrosEmprestados.size() < 3) {
			livrosEmprestados.add(l);
			l.marcarComoEmprestado();
		}else {
			System.out.println("O livro não está disponivel ou você atingiu o limite de livros");
		}
	}
	
	public void devolverLivro(Livro l) {
		if(!l.isDisponivel()) {
			l.marcarComoDevolvido();
			System.out.println("O livro foi devolvido");
		}else {
			System.out.println("Já está disponivel");
		}
		
	}
	public String getNome() {
		return nome;
	}
	
	public String toString() {
		return nome + " Matrícula: " + matricula;
	}
	


}


