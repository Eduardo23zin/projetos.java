package aula9;
import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
	private static int totalEmprestimos = 0;
	private static HashMap<Aluno, ArrayList<Livro>> emprestimos = new HashMap<>();
	
	public Biblioteca(int totalEmprestimos) {
		this.totalEmprestimos = 0;

	}
	
	public static void registrarEmprestimo() {
		totalEmprestimos++;
	}
	                                                                                                                                                                         
	public static void registrarDevolucao() {
		totalEmprestimos--;
	}                                                         
	     
	public static void registrarAlunoComLivro(Aluno aluno, Livro l) {
		// Verifica se o aluno já existe no Hashmap
		if(!emprestimos.containsKey(aluno)) {
			emprestimos.put(aluno, new ArrayList<>()); // Cria a lista de livros se o aluno não existir
		}
		
		// Pega a lista de livros que ja foram emprestados pelo aluno
		ArrayList<Livro> livrosEmprestados = emprestimos.get(aluno);
		
		
		// Verifica se o aluno pegou 3 livros
		if(livrosEmprestados.size() >= 3){
			System.out.println("Já atingiu o limite de 3 livros. ");
	    }else if(!l.isDisponivel()){ // Se o livro estiver com outro aluno, ele printa a mensagem, e se caso o aluno tentar pegar um 4° livro também 
	    	System.out.println("O livro não está disponível. ");
	    }else {
		    livrosEmprestados.add(l);
		     registrarEmprestimo();
		     aluno.emprestarLivro(l);
		     l.marcarComoEmprestado();
		     System.out.println("O Aluno(a): " + aluno + " Com o " + l + " Foi registrado na biblioteca " );
		
	   }
	}
		
	
	
	public static void removerAlunoComLivro(Aluno aluno, Livro l) {
		
		if(emprestimos.containsKey(aluno)) {
			ArrayList<Livro> livrosEmprestados = emprestimos.get(aluno);
		
		
		if(livrosEmprestados.remove(l)) { //Remove o livro da lista
			registrarDevolucao();
			l.marcarComoDevolvido();
			System.out.println("O aluno(a): " + aluno + " devolveu " + l);
		}else {
			System.out.println("O aluno não tem esse livre emprestado. ");
		}
		
		//Se a lista tiver vazia, remove o aluno do hashmap
		if(livrosEmprestados.isEmpty()){
			emprestimos.remove(aluno);
			
		}
	} else {
		System.out.println("Esse aluno não tem livros emprestados. ");
		}
		
	}
	
	public static void exibirEmprestimos() {
		if(emprestimos.isEmpty()) {
			System.out.println("Nenhum empréstimo registrado");
		}else {
			System.out.println("Lista de empréstimos ativos: " + totalEmprestimos);
			for(Aluno aluno: emprestimos.keySet()) {
				ArrayList<Livro> l = emprestimos.get(aluno);
				System.out.println("Aluno(a): " + aluno + " pegou emprestado " + l);
			}
			
		}
		
	}
	
	
	
	public static void totalEmprestimos() {
		System.out.println("O total de emprestimos é: " + totalEmprestimos);
		
	}
	
	
}
