package model;

public class Pedido {
	
	private long id;
	private Carrinho itemsPedido;
	private float totalPedido;
	private String status;
	
	public Pedido(long id, Carrinho itemsPedido, float totalPedido, String status) {
		super();
		this.id = id;
		this.itemsPedido = itemsPedido;
		this.totalPedido = totalPedido;
		this.status = status;
	}
	
	public Pedido() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Carrinho getItemsPedido() {
		return itemsPedido;
	}

	public void setItemsPedido(Carrinho itemsPedido) {
		this.itemsPedido = itemsPedido;
	}

	public float getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(float totalPedido) {
		this.totalPedido = totalPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
