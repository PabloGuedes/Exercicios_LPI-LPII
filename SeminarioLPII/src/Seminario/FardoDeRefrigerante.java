package Seminario;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FardoDeRefrigerante implements Produto {
	
	private List<Produto> produtos = new ArrayList<>();
	
	public FardoDeRefrigerante(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public void add(Produto ...produtos) {
		this.produtos.addAll(Arrays.asList(produtos));
	}
	
	public void add(Produto produto, int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			this.produtos.add(produto);
		}
	}
	
	public void remove(Produto produto) {
		produtos.remove(produto);
	}
	
	@Override
	public Double getValor() {
		Double soma = 0d;
		
		for (Produto produto : produtos) {
			soma += produto.getValor();
		}
		
		return soma;
	}
}
