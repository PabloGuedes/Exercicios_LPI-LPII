package questao03;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Quadrado quadrado = new Quadrado(4);
        Retangulo retangulo = new Retangulo(5, 10);
        Circulo circulo = new Circulo(5);
        Trapezio trapezio = new Trapezio(7, 3, 5);

        List<AreaCalculavel> lista = new ArrayList<>();
        lista.add(quadrado);
        lista.add(retangulo);
        lista.add(circulo);
        lista.add(trapezio);

        for (AreaCalculavel forma : lista) {
            System.out.println("Área: " + forma.calculaArea());
        }

	}

}
