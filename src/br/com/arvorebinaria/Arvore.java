package br.com.arvorebinaria;

public class Arvore {
	int num,nivel;
	Arvore e,d;
	
	public Arvore(){}
	public Arvore(int num){
		this.num = num;
		this.e = this.d = null;
	}
	public Arvore(int num,int nivel){
		this.num = num;
		this.nivel = nivel;
		this.e = this.d = null;
	}
	
	
	public static int limite = 4,contaNivel = 0;
	
	// Controle
	public static Arvore add(Arvore a, int num){
		
		contaNivel++;
		
		// Caso exceda o limite da árvore
		if(contaNivel >= limite){
			System.out.println("\nLimite excedido no item "+num+"\n");
			return null;
		}
		
		if(a.num < num) {
			if(a.d != null) add(a.d,num);
			else{
				a.d = new Arvore(num,contaNivel);
				contaNivel=0;
			}
		}
		else if(a.num > num) {
			if(a.e != null) add(a.e,num);
			else{
				a.e = new Arvore(num,contaNivel);
				contaNivel=0;
			}
		}else if(a.num == num){
			System.out.println("\n Número já existente na árvore no nível" + a.nivel);
			return null;
		}
		
		return a;
	}
	public static void print(Arvore a){
		if(a!=null){
			print(a.e);
			System.out.print(a.num+"["+a.nivel+"]  ");
			print(a.d);
		}
	}
	
	
}
