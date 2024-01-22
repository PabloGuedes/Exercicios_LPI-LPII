package Ex03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	private static String cf;

    public static void main(String args[]) {
        ArrayList<Aluno> alunos = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("alunos.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String nome = data[0];
                float n1 = Float.parseFloat(data[1]);
                float n2 = Float.parseFloat(data[2]);
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
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(alunos.get(i).getNome());
            System.out.println(alunos.get(i).getNf());
            System.out.println(alunos.get(i).getCf());
        }
    }
}
