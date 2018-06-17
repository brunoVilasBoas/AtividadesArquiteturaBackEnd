package model;

import java.util.ArrayList;

public class Carrinho {
	
	private long id;
	private ArrayList<Livro> items;
	private float totalCarrinho;
	
	public Carrinho(long id, ArrayList<Livro> items, float totalCarrinho) {
		super();
		this.id = id;
		this.items = items;
		this.totalCarrinho = totalCarrinho;
	}
	
	public Carrinho() {
		
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public ArrayList<Livro> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Livro> items) {
		this.items = items;
	}
	
	public float getTotalCarrinho() {
		return totalCarrinho;
	}
	
	public void setTotalCarrinho(float totalCarrinho) {
		this.totalCarrinho = totalCarrinho;
	}

}
