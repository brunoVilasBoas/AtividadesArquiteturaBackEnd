package model;

import java.util.ArrayList;

public class Pedidos {
	
	private Pedido pedido;
	private ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public ArrayList<Pedido> getListaPedido() {
		return listaPedido;
	}
	
	public void setListaPedido(ArrayList<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}
	
	public void add(Pedido novoPedido) {
		listaPedido.add(novoPedido);
		novoPedido = new Pedido();
	}
	
	public void mostraLista(){
		for (Pedido pedidos : listaPedido) {
			System.out.println(pedidos.toString());
		}
		return;
	}
	
	
	
	
	
}
