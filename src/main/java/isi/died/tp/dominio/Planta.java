package isi.died.tp.dominio;

import java.util.ArrayList;

public class Planta {
	
	private String id;
	public ArrayList<Pedido> listaPedido;
	
	public Planta(String id) {
		this.setId(id);
		listaPedido = new ArrayList<Pedido>();
	}
	
	public void agregarPedido(Pedido P) {
		if (P.cantidadDisponible()) {
			listaPedido.add(P);
			P.producto.actualizarStock(P.cantidad);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
