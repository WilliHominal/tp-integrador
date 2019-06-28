package isi.died.tp.dominio;

public class Insumo implements Comparable<Insumo> {
	public Integer id;
	protected String descripcion;
	protected Unidad unidadDeMedida;
	protected Double costo;
	protected Integer stock;
	protected Double peso;
	protected Boolean esRefrigerado;
	
	public Insumo() {}
	public Insumo (Integer id, String descripcion, Unidad unidadDeMedida, Double costo, Integer stock, Double peso, Boolean esRefrigerado) {
		this.id = id;
		this.descripcion = descripcion;
		this.unidadDeMedida = unidadDeMedida;
		this.costo = costo;
		this.stock = stock;
		this.peso = peso;
		this.esRefrigerado = esRefrigerado;
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
