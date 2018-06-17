package model;

import java.util.ArrayList;

public class Carrinhos {
	
	private Carrinho carrinho;
	private ArrayList<Carrinho> listaCarrinho = new ArrayList<Carrinho>();

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public ArrayList<Carrinho> getListaCarrinho() {
		return listaCarrinho;
	}

	public void setListaCarrinho(ArrayList<Carrinho> listaCarrinho) {
		this.listaCarrinho = listaCarrinho;
	}

	public void add(Carrinho novoCarrinho) {
		listaCarrinho.add(novoCarrinho);
		novoCarrinho = new Carrinho();
	}
	
	public void mostraLista(){
		for (Carrinho carrinhos : listaCarrinho) {
			System.out.println(carrinhos.toString());
		}
		return;
	}
}
