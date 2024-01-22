package questao01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaContato {

	public static void main(String[] args) {
		List<Contato> lista = new ArrayList<Contato>();
		
		Contato a = new Contato(50, 19, "Pablo", "pablo123", "pablo@email.com", "111111111", 80);
		Contato b = new Contato(20, 20, "André", "andre123", "andre@email.com", "222222222", 75);
		Contato c = new Contato(30, 23, "Victor", "victor123", "victor@email.com", "333333333", 85);
		Contato d = new Contato(40, 27, "Paulo", "paulo123", "paulo@email.com", "4444444444", 90);
		Contato e = new Contato(10, 18, "João", "joao123", "joao@email.com", "5555555555", 70);
		lista.add(a);
		lista.add(b);
		lista.add(c);
		lista.add(d);
		lista.add(e);
						
		Collections.sort(lista, new Comparator<Contato>(){
			public int compare(Contato contatoa, Contato contatoe) {
				return Float.compare(contatoa.getPeso(), contatoe.getPeso());
			}
		});
		Contato menorPeso = lista.get(0);
		
		Collections.sort(lista, new Comparator<Contato>() {
			public int compare(Contato contatoa, Contato contatoe) {
				return Integer.compare(contatoa.getIdade(), contatoe.getIdade());
			}
		});
		Contato maiorIdade = lista.get(lista.size() - 1);
		
		Contato maiorEmail = Collections.max(lista, new Comparator<Contato>(){
			public int compare(Contato contatoa, Contato contatoe) {
				return Integer.compare(contatoa.getEmail().length(), contatoe.getEmail().length());
			}
		});
		
		Contato menorEmail = Collections.min(lista, new Comparator<Contato>() {
			public int compare(Contato contatoa, Contato contatoe) {
				return Integer.compare(contatoa.getEmail().length(), contatoe.getEmail().length());
			}
		});
		
		Collections.sort(lista, new Comparator<Contato>() {
			public int compare(Contato contatoa, Contato contatoe) {
				return Integer.compare(contatoa.getId(), contatoe.getId());
			}
		});
		
		System.out.println("Identificar na lista, o objeto Contato com o menor peso.");
		System.out.println("Nome: " + menorPeso.getNome());
		System.out.println("Peso: " + menorPeso.getPeso());
		System.out.println();
		System.out.println("Identificar na lista, o objeto Contato com o maior idade.");
		System.out.println("Nome: " + maiorIdade.getNome());
		System.out.println("Idade: " + maiorIdade.getIdade());
		System.out.println();
		System.out.println("Identificar na lista, os objetos Contato com o e-mail mais longo e o mais curto.");
		System.out.println("Objeto com e-mail mais longo: " + maiorEmail.getNome());
		System.out.println("E-mail: " + maiorEmail.getEmail());
		System.out.println("Objeto com e-mail mais curto: " + menorEmail.getNome());
		System.out.println("E-mail: " + menorEmail.getEmail());
		System.out.println();
		System.out.println("Ordenar a lista de objetos Contato pelo id de forma crescente.");
        for (Contato contato : lista) {
            System.out.println("ID Contato: " + contato.getId() + ", Nome: " + contato.getNome() + ".");
        }
		
	}

}