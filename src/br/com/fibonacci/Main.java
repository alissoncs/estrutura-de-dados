package br.com.fibonacci;

import br.com.helpers.Console;
import br.com.helpers.ConsoleApplication;

public class Main extends ConsoleApplication {
	
	public static void main(String[] args) {
		
		console.print("Digite o valor máximo: ");
		console.println("");
		
		int max = console.readInt();
		
		int a = 1, b = 0;
		int count = 0;
		
		console.print(1);		
		while(a < max) {
			
			a = a + b;
			b = a - b;
			
			if(a > max) {
				break;				
			}
			console.print(" " + a);
			
			count++;
		}
		
		console.println("");
		console.println("Número de iterações: " + count);
		
	}
	
}
