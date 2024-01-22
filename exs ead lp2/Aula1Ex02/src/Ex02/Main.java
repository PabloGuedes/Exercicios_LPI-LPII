package Ex02;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static String cf;
	
	public static void main(String args[]) {
		ArrayList<Aluno> alunos = new ArrayList<>();
		
		System.out.print("Quantidade de Alunos: ");
		
		Scanner sc = new Scanner(System.in);
		
		int numAlunos = sc.nextInt();
		for(int i = 1; i <= numAlunos; i++) {
			System.out.print("Digite seu nome: ");
			String nome = sc.next();
			System.out.print("Digite sua primeira nota: ");
			float n1 = Float.parseFloat(sc.next());
			System.out.print("Digite sua segunda nota: ");
			float n2 = Float.parseFloat(sc.next());
			float nf = (n1 + n2) / 2;
			
			if(nf > 8) {
				cf = "Seu conceito é A!!!";
			} else if((nf <= 8) && (nf >= 7)){
				cf = "Seu conceito é B!!!";
			} else if((nf < 7) && (nf >= 6)){
				cf = "Seu conceito é C!!!";
			} else {
				cf = "Você está reprovado!!!";
			}
			
			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			aluno.setN1(n1);
			aluno.setN2(n2);
			aluno.setNf(nf);
			aluno.setCf(cf);
			alunos.add(aluno);
		}
		sc.close();
		
		for(int i = 0; i < alunos.size(); i++) {
			System.out.println(alunos.get(i).nome);
			System.out.println(alunos.get(i).nf);
			System.out.println(alunos.get(i).cf);
		}
	}
}
