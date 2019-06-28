package isi.died.tp.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Planta {
	public Integer id;
	public String nombre;
	public ArrayList<Stock> stocks;
	
	public Planta() {};
	public Planta(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		stocks = new ArrayList<Stock>();
	}
	public String getNombre() {
		return nombre;
	}
	public void anadirStock(Stock S1) {
		stocks.add(S1);
	}
	
	public Double costoTotal() {
		Double res = stocks.stream().mapToDouble((s) -> s.getPrecioTotal()).sum();
		return res;
	}
	public List<Insumo> stockEntre(Integer s1, Integer s2) {
		Predicate<Stock> entreS1yS2 = (s) -> (s.insumo.stock >= s1 && s.insumo.stock <= s2);
		List<Insumo> listaInsumos = stocks.stream().filter(entreS1yS2).map((s) -> s.getInsumo()).collect(Collectors.toList());
		return listaInsumos;
	}
	public Boolean necesitaInsumo(Insumo i) {
		Predicate<Stock> stockInsumo = (s) -> (s.insumo == i);
		Stock stockEnPlanta = (Stock) stocks.stream().filter(stockInsumo);
		return stockEnPlanta.cantidad < stockEnPlanta.puntoPedido;
	}
	
}
