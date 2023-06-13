package Loja;

import java.util.ArrayList;
import java.util.List;

public class Loja {
	
private List<Produto> produtos = new ArrayList<>();
public String nome;

public Loja(String nome) {
	this.nome = nome;
}

public void adicionaProduto(Produto produto) {
	produtos.add(produto);
}

public List<Produto> getProdutos(){
	return produtos;
}

public void RemoveProduto(String nome) throws Exception{
	for (Produto produto : produtos) {
		if(nome== produto.getNome()) {
			if(produto.getQuantidade() > 0) {
				produto.setQuantidade(produto.getQuantidade()-1);
			return;
			}else {
				throw new Exception ("O produto está indisponível no estoque");
			}
		}
	}
	throw new Exception("O produto não foi encontrado");
}

}
