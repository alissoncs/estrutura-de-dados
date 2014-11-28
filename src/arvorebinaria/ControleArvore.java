package arvorebinaria;
import java.util.Scanner;

public class ControleArvore {

	private static Scanner scanner = new Scanner(System.in);
	
	public static class Arvore {
		int num, nivel;
		Arvore e,d;
		public Arvore(int num){
			this.num = num;
		}
		public Arvore(){}
	}
	
	protected static Arvore add(int valor,Arvore arvore){
		
		if(arvore == null) {
			arvore = new Arvore();
			arvore.num = valor;
		}else{	
			if(arvore.num > valor){
				arvore.e = add(valor,arvore.e);
			}else{
				arvore.d = add(valor,arvore.d);
			}
		}
		return arvore;
		
	}

	
	protected static void print(Arvore arvore){
		if(arvore != null){
			print(arvore.e);
			System.out.print(arvore.num + "["+arvore.nivel+"]  ");
			print(arvore.d);
			
		}
	}
	public static void main(String[] args) {

		int menu = 0;
		Arvore raiz;
		
		System.out.println("** Árvore binaria ** \n");
		
		do{
			
			System.out.println("\n[1] Inserir");
			System.out.println("[2] Consultar");
			
			menu = Integer.parseInt(scanner.nextLine());
			
			switch(menu){
				case 1:
					add(16,raiz);
					add(4,raiz);
					add(2,raiz);
					add(6,raiz);
					add(8,raiz);
					add(3,raiz);
					print(raiz);
					
				break;
				case 2:
					print(raiz);
				break;
			}
			
		}while(menu>0 && menu<=4);
		

	}
	private static int getValor(){
		System.out.println("\n Digite o valor: ");
		return Integer.parseInt(scanner.nextLine());	
	}

}
