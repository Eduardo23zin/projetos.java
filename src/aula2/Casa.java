package aula2;


public class Casa {
	String cor;
	Porta porta1;
	Porta porta2;
	Porta porta3;
	
	
	void pinta(String s) {
		cor = s;
	}
	
	int quantasPortasEstaoAbertas() {
		int abertas = 0;
		if(porta1.estaAberta())abertas++;
		if(porta2.estaAberta())abertas++;
		if(porta3.estaAberta())abertas++;
		return abertas;
		
		
			
		
	}
}



 
