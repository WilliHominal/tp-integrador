package isi.died.tp.estructuras;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.InsumoLiquido;
import isi.died.tp.dominio.Stock;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Unidad;

public class PlantaTest {
	private Insumo I1;
	private InsumoLiquido I2;
	private Planta P;
	private Stock stock1;
	private Stock stock2;
	private Stock stock3;
	
	@Before
	public void preTest() {
		I1 = new Insumo(1,"Descripcion1",Unidad.Pieza,100.0,100,0.278,false);
		I2 = new InsumoLiquido(2, "Descripcion2", 225.0, 75, true, 1.141);
		P = new Planta(1, "Planta 1");
		stock1 = new Stock(1,2,10,I1);
		stock2 = new Stock(2,5,20,I2);
		stock3 = new Stock(3,3, 15, I1);
	}

	@Test
	public void testAddStock() {
		this.preTest();
		P.anadirStock(stock1);
		P.anadirStock(stock2);
		P.anadirStock(stock3);
		ArrayList<Stock> listaEsperada = new ArrayList<Stock>();
		listaEsperada.add(stock1);listaEsperada.add(stock2);listaEsperada.add(stock3);
		assertEquals(listaEsperada, P.stocks);
	}
	
	@Test
	public void testPesoLiquido() {
		this.preTest();
		Double peso = ((InsumoLiquido)stock2.insumo).getPeso(stock2.cantidad);
		Double res = I2.densidad*stock2.cantidad/1000;
		assertEquals(res, peso);
	}

	@Test
	public void testComparable() {
		this.preTest();
		ArrayList<Insumo> listaPrueba = new ArrayList<Insumo>();
		ArrayList<Insumo> listaEsperada = new ArrayList<Insumo>();
		listaPrueba.add(I1); listaPrueba.add(I2);
		Collections.sort(listaPrueba);
		listaEsperada.add(I2); listaEsperada.add(I1);
		assertEquals(listaEsperada,listaPrueba);
	}
}