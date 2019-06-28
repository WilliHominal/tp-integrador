package isi.died.tp.dominio;

public class InsumoLiquido extends Insumo {

	public Double densidad;
	
	public InsumoLiquido(Integer id, String descripcion, Double costo, Integer stock, Boolean esRefrigerado, Double densidad) {
		this.id = id;
		this.descripcion = descripcion;
		this.costo = costo;
		this.stock = stock;
		this.esRefrigerado = esRefrigerado;
		this.unidadDeMedida = Unidad.Litro;
		this.densidad = densidad;
	}
	
	public Double getPeso(Double volumen) {
		return densidad*(volumen/1000);
	}
}
