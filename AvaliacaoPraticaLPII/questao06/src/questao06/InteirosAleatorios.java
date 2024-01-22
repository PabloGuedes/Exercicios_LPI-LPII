package questao06;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InteirosAleatorios {
	
	public static void main(String[] args) {
		Random random = new Random();
		
		Map<Integer, Integer> contNum = new HashMap<>();
		Set<Integer> ordemNum = new LinkedHashSet<>();
		
		for (int i = 0; i < 1000; i++) {
            int numAleatorio = random.nextInt(100);

            contNum.put(numAleatorio, contNum.getOrDefault(numAleatorio, 0) + 1);
            ordemNum.add(numAleatorio);
        }
		
		for (int num : ordemNum) {
            int qtd = contNum.get(num);
            
            System.out.println("O número " + num + " foi gerado aleatoriamente " + qtd + " vezes.");
        }
		
	}
}
