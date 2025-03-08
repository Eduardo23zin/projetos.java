package aula2;

public class Porta {
	boolean aberta;
	String cor;
	double dimensaoX;
	double dimensaoY;
	double dimensaoZ;
		

		
		public void abre() {
			aberta = true;
		}
		
		public void fecha() {
			aberta = false;
		}
		
		void pinta(String s) {
			cor = s;
		}
		
		public boolean estaAberta() {
			return aberta;
		}
	
}
