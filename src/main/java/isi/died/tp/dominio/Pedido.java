package isi.died.tp.dominio;

public class Pedido {

	public Insumo producto;
	public Double cantidad;
	
	public Pedido(Insumo P, Double cantidad) {
		this.producto = P;
		this.cantidad = cantidad;
	}
	
	public Boolean cantidadDisponible() {
		return (producto.stock >= cantidad);
	}
	public Double calcularCosto() {
		return producto.costo*cantidad;
	}
	public Double getPeso() {
		if (producto instanceof InsumoLiquido) {
			return ((InsumoLiquido) producto).getPeso(cantidad);
		} else {
			return producto.peso;
		}
	}

}
