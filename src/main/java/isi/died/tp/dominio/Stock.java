package isi.died.tp.dominio;

public class Stock {
	public Integer id;
	public Integer cantidad;
	public Integer puntoPedido;
	public Insumo insumo;
	
	public Stock(Integer id, Integer cantidad, Integer puntoPedido, Insumo I) {
		this.id = id;
		this.cantidad = cantidad;
		this.puntoPedido = puntoPedido;
		this.insumo = I;
	}

	public Double getPrecioTotal() {
		return cantidad*insumo.costo;
	}

	public Insumo getInsumo() {
		return this.insumo;
	}
}