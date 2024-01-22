package br.com.escola;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite seu nome: ");
		String nome = entrada.nextLine();
		System.out.print("Digite sua primeira nota: ");
		float n1 = Float.parseFloat(entrada.next());
		System.out.print("Digite sua segunda nota: ");
		float n2 = Float.parseFloat(entrada.next());
		float nf = (n1 + n2) / 2;
		System.out.println(nome);
		System.out.println("Sua nota final é: " + nf);
		
		if(nf > 8) {
			System.out.println("Seu conceito é A!!!");
		} else if((nf <= 8) && (nf >= 7)){
			System.out.println("Seu conceito é B!!!");
		} else if((nf < 7) && (nf >= 6)){
			System.out.println("Seu conceito é C!!!");
		} else {
			System.out.println("Você está reprovado!!!");
		}
		
		entrada.close();
	}

}
