package Seminario;

import java.util.ArrayList;

public class main {

public static void main(String[] args) {
				
		Produto cocacola = new Refrigerante("Coca-Cola", 10.0);
		
		FardoDeRefrigerante fardoDeRefrigerante = new FardoDeRefrigerante(new ArrayList<Produto>());
		fardoDeRefrigerante.add(cocacola, 6);
		
		System.out.println("Valor do fardo de Coca-Cola: R$" + fardoDeRefrigerante.getValor());
	}

}
