package Ex04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	private static String cf;

    public static void main(String args[]) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        Random random = new Random();

        System.out.print("Quantidade de Alunos: ");
        try (Scanner scanner = new Scanner(System.in)) {
			int numAlunos = scanner.nextInt();

			for (int i = 1; i <= numAlunos; i++) {
			    String nome = "Aluno " + i;
			    float n1 = random.nextFloat() * 10; // Gera nota entre 0 e 10
			    float n2 = random.nextFloat() * 10;
			    float nf = (n1 + n2) / 2;

			    if (nf > 8) {
			        cf = "Seu conceito é A!!!";
			    } else if ((nf <= 8) && (nf >= 7)) {
			        cf = "Seu conceito é B!!!";
			    } else if ((nf < 7) && (nf >= 6)) {
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
		}
		// Gravação no arquivo CSV
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("alunos_notas.csv"));
            for (Aluno aluno : alunos) {
                String line = aluno.getNome() + "," + aluno.getN1() + "," + aluno.getN2() + "," + aluno.getNf() + "," + aluno.getCf();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
            System.out.println(aluno.getNf());
            System.out.println(aluno.getCf());
        }
    }
}
