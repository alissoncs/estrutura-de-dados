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
		System.out.println("[6] Excluir tudo");
		System.out.println("[7] Sair\n");
	}
	private static int getValor(){
		boolean n = false;
		int p = 0;
		
		do{
			try{
				p = Integer.parseInt(scanner.nextLine());
				n = true;
			}catch(Exception e){
				System.out.println("Valor inválido");
				n = false;
			}
		}while(n == false);
		
		return p;
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
					System.out.println("Digite o valor para inserir: ");
					tmp = getValor();
					
					if(raiz == null){
						raiz = new Arvore(tmp);
						System.out.println("Número "+tmp+" inserido com sucesso no nível 0");
					}else{
						raiz = Arvore.add(raiz,tmp);
					}
					
					/*raiz = new Arvore(100);
					raiz = Arvore.add(raiz,50);
					raiz = Arvore.add(raiz,75);
					raiz = Arvore.add(raiz,80);
					raiz = Arvore.add(raiz,60);
					raiz = Arvore.add(raiz,25);
					raiz = Arvore.add(raiz,12);
					raiz = Arvore.add(raiz,120);
					raiz = Arvore.add(raiz,130);
					raiz = Arvore.add(raiz,110);
					*/
					
					Arvore.print(raiz);
					
				break;
				
				case 2:
					System.out.println("\nValor na árvore: \n");
					Arvore.print(raiz);
				break;
				
				case 3:
					System.out.println("Valor maior: ");
					Arvore.maior(raiz);
				break;
				
				case 4:
					System.out.println("Valor menor: ");
					Arvore.menor(raiz);
				break;
				
				case 5:
					System.out.println("Digite o valor para excluir: ");
					tmp = getValor();
					
					raiz = Arvore.delete(raiz,tmp);
					
				break;
				case 6:
					raiz = null;
					System.out.println("Árvore removida");
				break;
			}
			
		}while(t>0 && t<7);
		
		
		System.out.println("** Fim Árvore binária **");
	}
}
