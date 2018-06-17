package model;

import java.util.ArrayList;

public class Livro {

	private long id;
	private String nome;
	private String autor;
	private String isbn;
	private float preco;
	private ArrayList<String> comentario;

	public Livro(long id, String nome, String autor, String isbn, float preco, ArrayList<String> comentario) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.isbn = isbn;
		this.preco = preco;
		this.comentario = comentario;
	}

	public Livro() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public ArrayList<String> getComentario() {
		return comentario;
	}

	public void setComentario(ArrayList<String> comentario) {
		this.comentario = comentario;
	}
	
	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", autor=" + autor + ", isbn=" + isbn + ", preco=" + preco
				+ ", comentario=" + comentario + "]";
	}
	
}
