package br.com.fila;
import java.util.Scanner;

public class Interface {
	private static class fila {
        public int num;
        public String nome;
        public fila prox;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        fila inicio1 = null;
        fila inicio2 = null;
        fila inicio3 = null;
        fila fim = null;
        fila aux = null;
        int dig,a,b,c;
        String nome;
        boolean state = false;
do {
   System.out.println("*******************");
        menu1();
    dig = Integer.parseInt(scanner.nextLine());
switch(dig) {
case 1:
            fila fila1 = new fila();
            fila fila2 = new fila();
            fila fila3 = new fila();
            System.out.println("Digite o nome");
            nome = scanner.nextLine();
            menu2();
            a = Integer.parseInt(scanner.nextLine());
    switch(a) {
       case 1:
        fila1.nome = nome;
            if(inicio1==null) {
                inicio1=fila1;
                fim = fila1;
                fila1.prox = null;
            }else {   
                aux = inicio1;
                while(aux != null) {
                    if(aux.prox == null) {
                       fila1.prox = null;
                       aux.prox = fila1;
                       break; 
                    }
                    aux = aux.prox;
                }
            }
            System.out.println("PESSOA INSERIDA COM SUCESSO na fila PREFERENCIAL");
        break;
    case 2:
        fila2.nome = nome;
            if(inicio2==null) {
                inicio2=fila2;
                fim = fila2;
                fila2.prox = null;
            }else {
                aux = inicio2;
                while(aux != null) {
                    if(aux.prox == null) {
                       fila2.prox = null;
                       aux.prox = fila2;
                       break; 
                    }
                    aux = aux.prox;
                }
            }
            System.out.println("PESSOA INSERIDA COM SUCESSO na fila EXTRATO");
        break;
    case 3:
        fila3.nome = nome;
            if(inicio3==null) {
                inicio3=fila3;
                fim = fila3;
                fila3.prox = null;
            }else {
                aux = inicio3;
                while(aux != null) {
                    if(aux.prox == null) {
                       fila3.prox = null;
                       aux.prox = fila3;
                       break; 
                    }
                    aux = aux.prox;
                }
            }
            System.out.println("PESSOA INSERIDA COM SUCESSO na fila SAQUE");
        break;
    } // switch a
    
break;
case 2:
    menu2();
    a = Integer.parseInt(scanner.nextLine());
    nome = "";
    switch(a) {
        case 1: 
         aux = inicio1; 
         nome = "PREFERENCIAL";
        break;
        case 2:
         aux = inicio2;
         nome = "EXTRATO";
        break;
        case 3:
         aux = inicio3;
         nome = "SAQUE";
        break;
    }
    if(aux != null) {
        System.out.println("*******************");
        System.out.println("Pessoas na fila "+nome);
        while(aux != null) {
            System.out.print("// " + aux.nome + " //");
            aux = aux.prox;
        }
        System.out.println();
    }else {
        System.out.println("\nFila Vazia\n");
    }
    
break;

// ATENDER
case 3:
    
    System.out.println("// ATENDER FILA");
    menu2();
    a = Integer.parseInt(scanner.nextLine());
    boolean[] f = new boolean[3];
    f[0] = (inicio1 != null);
    f[1] = (inicio2 != null);
    f[2] = (inicio3 != null);
    
    nome = "";
    
    if(f[0] == false && f[1] == false && f[2] == false) {
        System.out.println("\n******************************");
        System.out.println("Todas as filas estão vazias!");
        System.out.println("****************************** \n");
    }else {
        //for(int j = 0; j < 3; j++) {
        if(f[a-1] != false) {
            switch(a) {
                case 1: 
                 inicio1 = inicio1.prox;
                 nome = "PREFERENCIAL";
                break;
                case 2:
                 inicio2 = inicio2.prox;
                 nome = "EXTRATO";
                break;
                case 3:
                 inicio3 = inicio3.prox;
                 nome = "SAQUE";
                break;
            }
            System.out.println(nome+" Atendido com sucesso \n");
        }else {
            System.out.println("Fila solicitada está vazia \n Procurando nas outras filas...");
            // Varre as listas para limpar
            for(int j = 0; j<3;j++) {
                if(j != (a-1) && f[j] != false) {
                    switch(j+1) {
                        case 1: 
                         inicio1 = inicio1.prox;
                         nome = "PREFERENCIAL";
                        break;
                        case 2:
                         inicio2 = inicio2.prox;
                         nome = "EXTRATO";
                        break;
                        case 3:
                         inicio3 = inicio3.prox;
                         nome = "SAQUE";
                        break;
                    }
                    System.out.println(nome+" atendido com sucesso \n");
                    state = true;
                    break; // quebra loop caso encontre algum vazio
                }
            }
        }

    }
    
    
break;
// ATENDER
// ESVAZIAR ALGUMA FILA
case 4:
    System.out.println("\n ESVAZIAR FILA: \n");
    menu2();
    a = Integer.parseInt(scanner.nextLine());
    nome = "";
    switch(a) {
            case 1: 
                inicio1 = null;
                fila1 = null;
                nome = "PREFERENCIAL";
            break;
            case 2:
                 inicio2 = null;
                 fila2 = null;
                 nome = "EXTRATO";
            break;
            case 3:
                 inicio3 = null;
                 fila3 = null;
                 nome = "SAQUE";
            break;
    }
            System.out.println(nome+" esvaziada com sucesso \n");
break;

// esvaziar todas as filas
case 5:
    inicio1 = null;
    fila1 = null;
    inicio2 = null;
    fila2 = null;
    inicio3 = null;
    fila3 = null;
    
    System.out.println("\n Todas as filas esvaziadas com sucesso!");
break;
    
    }    
System.out.println("*******************");
}while(dig<6);
    
     
    }
    private static void menu1() {
        System.out.println();
        System.out.println("Digite uma opção abaixo");
        System.out.println("1 - Inserir pessoa");
        System.out.println("2 - Listar pessoas");
        System.out.println("3 - Atender pessoa");
        System.out.println("4 - Esvaziar fila");
        System.out.println("5 - Esvaziar todas as filas");
        System.out.println("6 - sair");
        System.out.println();
    }
    private static void menu2() {
        System.out.println();
        System.out.println("ESCOLHA UMA FILA");
        System.out.println("1 - Preferencial");
        System.out.println("2 - Extrato");
        System.out.println("3 - Saque");
        System.out.println();
    }
}
