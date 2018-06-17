package model;

import java.util.ArrayList;

public class Livros {
	
	private Livro livro;
	private ArrayList<Livro> listaLivro = new ArrayList<Livro>();
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public ArrayList<Livro> getListaLivro() {
		return listaLivro;
	}
	
	public void setListaLivro(ArrayList<Livro> listaLivro) {
		this.listaLivro = listaLivro;
	}
	
	public void add(Livro novoLivro) {
		listaLivro.add(novoLivro);
		novoLivro = new Livro();
	}
	
	public void mostraLista(){
		for (Livro livros : listaLivro) {
			System.out.println(livros.toString());
		}
		return;
	}
}	