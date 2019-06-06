package isi.died.tp.estructuras;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.InsumoLiquido;
import isi.died.tp.dominio.Pedido;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Unidad;

public class PlantaTest {
	private Insumo I1;
	private InsumoLiquido I2;
	private Planta P;
	private Pedido ped1;
	private Pedido ped2;
	private Pedido ped3;
	
	@Before
	public void preTest() {
		I1 = new Insumo("Celular","Descripcion1",Unidad.Pieza,10500.0,100.0,0.278,false);
		I2 = new InsumoLiquido("Oxigeno liquido", "Descripcion2", 2500.0, 2500.0, true, 1.141);
		P = new Planta("Planta 1");
		ped1 = new Pedido(I1,200.0);
		ped2 = new Pedido(I2, 1000.0);
		ped3 = new Pedido(I1, 15.0);
	}

	@Test
	public void testAgregarPedido() {
		this.preTest();
		P.agregarPedido(ped1);
		P.agregarPedido(ped2);
		P.agregarPedido(ped3);
		ArrayList<Pedido> listaEsperada = new ArrayList<Pedido>();
		listaEsperada.add(ped2);listaEsperada.add(ped3);
		assertEquals(listaEsperada, P.listaPedido);
	}
	
	@Test
	public void testPesoLiquido() {
		this.preTest();
		Double peso = ped2.getPeso();
		Double res = I2.densidad*ped2.cantidad/1000;
		assertEquals(res,peso);
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
