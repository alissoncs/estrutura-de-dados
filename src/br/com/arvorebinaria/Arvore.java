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
			contaNivel = 0;
			System.out.println("\nLimite excedido no item "+num+"\n");
		}else {
		
		if(a.num < num) {
			if(a.d != null) add(a.d,num);
			else{
				System.out.println("Número "+num+" inserido com sucesso no nível "+contaNivel);
				a.d = new Arvore(num,contaNivel);
				contaNivel=0;
			}
		}
		else if(a.num > num) {
			if(a.e != null) add(a.e,num);
			else{
				System.out.println("Número "+num+" inserido com sucesso no nível "+contaNivel);
				a.e = new Arvore(num,contaNivel);
				contaNivel=0;
			}
		}else if(a.num == num){
			System.out.println("\n Número já existente na árvore no nível" + a.nivel);
			return null;
		}
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
	
	public static int aux;
	
	public static Arvore delete(Arvore a, int num){
		System.out.println("Tentando excluir "+num+"...");
		
		if(a == null) {
			System.out.println("- Valor digitado "+num+" não existe");
			return null;
		}else{
		if(a.num > num) {
			a.e = delete(a.e,num);
		}else if(a.num < num){
			a.d = delete(a.d,num);
		}else if(a.num == num){
			
			// Verifica se o elemento possui filhos
			if(a.d == null && a.e == null){
				a = null;
			}else if(a.d == null){
				a.e.nivel--;
				a = a.e;
			}
			else if(a.e == null){
				a.d.nivel--;
				a = a.d;
			}
			else {
				System.out.println("- Número "+num+" possui filhos");
                Arvore b = a.e;
                while (b.d != null) {
                	b.d.nivel--;
                    b = b.d;
                }
                System.out.println("");
                a.num = b.num;
                b.num = num;
                a.e = delete(a.e, num);
            }
			System.out.println("- Número "+num+" excluído com sucesso!");
		}
		}
		return a;
		
	}
	
	public static void maior(Arvore a){
        if (a.d == null) {
            System.out.println(a.num);
        } else {
        	maior(a.d);
        }
    }
	public static void menor(Arvore a){
        if (a.e == null) {
            System.out.println(a.num);
        } else {
        	menor(a.e);
        }
    }
	
	
}
