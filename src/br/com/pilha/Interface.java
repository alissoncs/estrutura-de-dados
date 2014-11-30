package br.com.pilha;
import java.util.Scanner;

public class Interface {
	public static class pilha {
        public pilha prox;
        public int x;
        public int vezes;
        public String placa;
    }
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int y = 0, count = 0;
        pilha est = null;
        pilha res = null;
        pilha aux = null;
        String nome;
        boolean flag;
        System.out.println("** ESTACIONAMENTO ROTATIVO ** \n");
        
        do{
            
            System.out.println("__ menu");
            System.out.println("1 - INSERIR CARRO");
            System.out.println("2 - LISTAR CARROS");
            System.out.println("3 - REMOVER CARRO");
            System.out.println("4 - SAIR");

        y = Integer.parseInt(scanner.nextLine());
        switch(y) {
            case 1:
            if(count<=10) {
                pilha t1 = new pilha();
                nome = null;
                while(nome == null || "".equals(nome)) {
                    System.out.println("Digite a identificação do carro: ");
                    nome = scanner.nextLine();
                }
                // Forma para incluir
                System.out.println("((inserindo carro...))");
                t1.placa = nome;
                t1.vezes = 0;
                    if(est == null) {
                        est = t1;
                        est.prox = null;
                    }else {
                        aux = est;
                        est = t1;
                        est.prox = aux;
                    }   
                    count++;
                // mostra carros
                System.out.println("["+count+"]__________________________");
                aux = est;
                
                while(aux!=null) {
                    System.out.print("| "+aux.placa+"["+aux.vezes+"] ");
                    aux = aux.prox;
                }
                System.out.print("|");
                System.out.println("\n__________________________");
                
              }else {
                System.out.println("** Garagem esgotada");
              }
            break;
            case 2:
                System.out.println("__________________________");
                aux = est;
                while(aux!=null) {
                    System.out.print("| "+aux.placa+"["+aux.vezes+"] ");
                    aux = aux.prox;
                }System.out.print("|");
                System.out.println("\n__________________________\n");
            break;
            case 3:
                System.out.println("REMOVER CARRO");
                nome = null;
                flag = false;
                
                while(nome == null || "".equals(nome)) {
                    System.out.println("Digite a identificação do carro: ");
                    nome = scanner.nextLine();
                }
                System.out.println();
                
                // VERIFICA SE CARRO EXISTE;
                System.out.println("((verifica se o carro existe...))");
                aux = est;
             while(aux!=null && flag == false) {
                if(aux.placa.toUpperCase().equals(nome.toUpperCase())) {
                    flag = true;
                    break;
                }
                aux = aux.prox;
             }
             if(flag == true) {
                 System.out.println("\n((Pessoa encontrada!!))\n");
                 pilha t2 = new pilha();
                 pilha t1 = new pilha();
                 
             // ALGORÍTIMO DE REMOÇÃO.... 
                while(est!=null && !est.placa.toUpperCase().equals(nome.toUpperCase())) {
                    t2.placa = est.placa;
                    t2.vezes = est.vezes+1;
                    
                    // INSERE NA FILA DE RESERVAS
                    if(res == null) {
                        res = t2;
                        res.prox = null;
                    }else {
                        aux = res;
                        res = t2;
                        res.prox = aux;
                    }
                   est = est.prox;
                }
                 System.out.println("placa:" + est.placa+ " .. ");
                 est = est.prox;
                 aux = null;
                 
                 // Joga ta res de volta para a anterior
                 aux = res;
                 while(aux != null) {
                     t1.placa = aux.placa;
                     t1.vezes = aux.vezes;
                     System.out.println("__p: "+t1.placa+" __");
                        if(est == null) {
                            est = t1;
                            est.prox = null;
                        }else {
                            aux = est;
                            est = t1;
                            est.prox = aux;
                        }
                     aux = aux.prox;
                 }
                 res = null;
                 
                 System.out.println("...terminou");
             }else {
                 System.out.println("\n((Pessoa ~não~ encontrada))\n");
             }
             
            break;
        }
        
        }while(y<=4 || y > 0);
    }
}
