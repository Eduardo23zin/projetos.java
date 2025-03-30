package aula9;

public class Main {

	public static void main(String[] args) {
		/*
		Aluno aluno1 = new Aluno("Carlos ", "123456 ");
		Livro livro1 = new Livro("Dom Casmurro ", "Machado de Assis " , true);
		
		Biblioteca.exibirEmprestimos(); // exibe os empréstimos ativos
		aluno1.emprestarLivro(livro1);
		livro1.marcarComoEmprestado();
		Biblioteca.registrarAlunoComLivro(aluno1, livro1);
		// Biblioteca.exibirEmprestimos();
		System.out.println("O livro: " + livro1 + "está disponível? " + livro1.isDisponivel());
		aluno1.devolverLivro(livro1);
	    livro1.marcarComoDevolvido();
		Biblioteca.registrarDevolucao();
		System.out.println("O livro: " + livro1 + "está disponível? " + livro1.isDisponivel());
		*/
		
		
	
		
		
		
		
		
		
		Aluno aluno1 = new Aluno("Maria ", "789101 ");
		Aluno aluno2 = new Aluno("Carlos ", "123456");
		Aluno aluno3 = new Aluno("José ", "112233");
		Livro livro1 = new Livro("Dom Casmurro ", "Machado de Assis " , true);
		Livro livro2 = new Livro("Harry Potter ", "J. K. Rowling " , true);
		Livro livro3 = new Livro("Shrek! ", "William Steig ", true);
		Livro livro4 = new Livro("Naruto ", "Masashi Kishimoto ", true);
		
		Biblioteca.exibirEmprestimos(); // exibe os empréstimos ativos
		System.out.println("O " + livro1 + "está disponível? " + livro1.isDisponivel());
		Biblioteca.registrarAlunoComLivro(aluno1, livro1);
		System.out.println("O " + livro2 + "está disponível? " + livro2.isDisponivel());
		Biblioteca.registrarAlunoComLivro(aluno1, livro2);
		System.out.println("O " + livro3 + "está disponível? " + livro3.isDisponivel());
		Biblioteca.registrarAlunoComLivro(aluno1, livro3);
		System.out.println("O " + livro4 + "está disponível? " + livro4.isDisponivel());
		Biblioteca.registrarAlunoComLivro(aluno1, livro4); // Testando se o aluno pode pegar um 4° livro
		
		Biblioteca.registrarAlunoComLivro(aluno2, livro3); // Testando se um outro aluno pode pegar um livro que já esteja emprestado
		Biblioteca.removerAlunoComLivro(aluno1, livro3);  // Removendo livro da lista de livros emprestados
		Biblioteca.registrarAlunoComLivro(aluno2, livro4); // Registrando outro aluno com livro
		Biblioteca.registrarAlunoComLivro(aluno3, livro3); // Registrando outro aluno com livro
		Biblioteca.exibirEmprestimos(); // Exibe os empréstimos ativos
		Biblioteca.totalEmprestimos(); // Total de empréstimos feitos
		
		
		
                   
	
	   
		

		
	

	}

}
