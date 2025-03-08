package aula2;

public class Main {

	public static void main(String[] args) {
		Pessoa pessoa1 = new Pessoa ();
		pessoa1.nome = "João";
		pessoa1.idade = 16;
		
		System.out.printf("João tem %d anos \n" ,  pessoa1.idade);
		
		System.out.printf("Ele fez aniversário \n");
		pessoa1.fazAniversario();
	
		System.out.printf("João fez outro aniversário \n");
		pessoa1.fazAniversario();
		
		System.out.printf("Fez mais um aniversário \n");
		pessoa1.fazAniversario();
		
		
Porta porta = new Porta();
		
		porta.abre();
		System.out.println("A porta está aberta?" + porta.estaAberta());
		porta.fecha();
		System.out.println("A porta está aberta?" + porta.estaAberta());
		porta.pinta("vermelho");
		System.out.println("A cor da porta é: " + porta.cor);
		porta.dimensaoX = 0.7;
		porta.dimensaoY = 2.0;
		porta.dimensaoZ = 0.05;
		System.out.println("Dimensões desta porta são: " + porta.dimensaoX + "m x" + porta.dimensaoY + "m x" + porta.dimensaoZ + "m");
		
		porta.abre();
		System.out.println("A porta está aberta?" + porta.estaAberta());
		porta.fecha();
		System.out.println("A porta está aberta?" + porta.estaAberta());
		porta.pinta("Azul");
		System.out.println("A cor desta porta é: " + porta.cor);
		porta.dimensaoX = 0.5;
		porta.dimensaoY = 1.95;
		porta.dimensaoZ = 0.06;
		System.out.println("As dimensões desta porta é: " + porta.dimensaoX + "m x" + porta.dimensaoY + "m x" + porta.dimensaoZ + "m");
		
		Casa casa = new Casa();
		casa.pinta("Azul");
		System.out.println("A cor da casa é: " + casa.cor);
		Porta porta1 = new Porta();
		Porta porta2 = new Porta();
		Porta porta3 = new Porta();
		
		casa.porta1 = porta1;
		casa.porta2 = porta2;
		casa.porta3 = porta3;
		
		casa.porta1.abre();
		System.out.println("A porta está aberta? " + porta1.estaAberta());
		casa.porta2.abre();
		System.out.println("A porta está aberta? " + porta2.estaAberta());
		casa.porta3.abre();
		System.out.println("A porta está aberta? " + porta3.estaAberta());
		casa.porta2.fecha();
		
		System.out.println("Portas abertas na casa: " + casa.quantasPortasEstaoAbertas());
		
	}

}
