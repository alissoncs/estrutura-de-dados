package br.com.arvorebinaria;

import java.util.Scanner;

public class Interface {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static void menu(){
		
		System.out.println("\n\n[1] Inserir");
		System.out.println("[2] Exibir");
		System.out.println("[3] Exibir maior");
		System.out.println("[4] Exibir menor");
		System.out.println("[5] Excluir número");
		System.out.println("[6] Sair\n");
	}
	private static int getValor(){
		return Integer.parseInt(scanner.nextLine());
	}
	
	private static Arvore raiz = null;
	
	public static void main(String[] args) {
		System.out.println("** Árvore binária **");
		
		int t,tmp;
	
		Arvore.limite = 4;
		
		do {
			
			menu();
			t = getValor();
			
			switch(t){
				case 1:
					
					/*/System.out.println("\n Digite o valor para inserir: \n");
					tmp = getValor();
					
					if(raiz == null){
						raiz = new Arvore(tmp);
					}else{
						raiz = Arvore.add(raiz,tmp);
					}*/
					raiz = new Arvore(11);
					raiz = Arvore.add(raiz,12);
					raiz = Arvore.add(raiz,9);
					raiz = Arvore.add(raiz,28);
					raiz = Arvore.add(raiz,4);
					raiz = Arvore.add(raiz,6);
					raiz = Arvore.add(raiz,0);
					raiz = Arvore.add(raiz,2);
					
					Arvore.print(raiz);
					
				break;
				
				case 2:
					Arvore.print(raiz);
				break;
				
				
			
			}
			
		}while(t>0 && t<6);
		
		
		System.out.println("** Fim Árvore binária **");
	}
}
