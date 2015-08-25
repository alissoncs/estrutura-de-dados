package br.com.helpers;

import java.util.Scanner;

public class Console {

	private static Console instance;
	
	public static final Console getInstance() {
		
		if(instance == null) {
			
			instance = new Console();
			
		}
		
		return instance;
		
	}
	
	private Scanner scanner;
	
	public Console() {
		
		scanner = new Scanner(System.in);
		
	}
	
	public void println(String value) {
		
		System.out.println(value);
		
	}
	
	public void print(String value) {
		
		System.out.print(value);
		
	}
	
	public void print(int value) {
		
		print(String.valueOf(value));
		
	}
	
	public void print(double value) {
		
		print(String.valueOf(value));
		
	}
	
	public String read() {
		
		return scanner.nextLine();
		
	}
	
	public int readInt() throws NumberFormatException {
		
		int value;
		
		try {
			
			value = Integer.parseInt(scanner.nextLine());
			return value;
			
		}catch(NumberFormatException e) {
			throw e;
		}
		
	}
	
	public double readDouble() {

		double value;
		
		try {
			
			value = Double.parseDouble(scanner.nextLine());
			return value;
			
		}catch(NumberFormatException e) {
			throw e;
		}
		
	}
	
}
