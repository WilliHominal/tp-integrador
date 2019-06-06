package isi.died.tp.dominio;

public class Insumo implements Comparable<Insumo> {
	public String id;
	protected String descripcion;
	protected Unidad unidadDeMedida;
	protected Double costo;
	protected Double stock;
	protected Double peso;
	protected Boolean esRefrigerado;
	
	public Insumo() {}
	public Insumo (String id, String descripcion, Unidad unidadDeMedida, Double costo, Double stock, Double peso, Boolean esRefrigerado) {
		this.id = id;
		this.descripcion = descripcion;
		this.unidadDeMedida = unidadDeMedida;
		this.costo = costo;
		this.stock = stock;
		this.peso = peso;
		this.esRefrigerado = esRefrigerado;
	}
	
	public void actualizarStock(Double cantidadADescontar) {
		stock -= cantidadADescontar;
	}
	
	@Override
	public int compareTo(Insumo I2) {
		if (this.stock < I2.stock) {
			return -1;
		} else if (stock > I2.stock) {
			return 1;
		}
		return 0;
	}
}
