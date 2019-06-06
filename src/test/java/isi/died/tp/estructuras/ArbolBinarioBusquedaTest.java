package isi.died.tp.estructuras;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ArbolBinarioBusquedaTest {
	private ArbolBinarioBusqueda<Integer> abb;
	private ArbolBinarioBusqueda<Integer> abb2;
	private ArbolBinarioBusqueda<Integer> abb3;
	private ArbolBinarioBusqueda<Integer> abb4;
	private ArbolBinarioBusqueda<Integer> abb5;

	@Before
	public void preTest() {
		abb = new ArbolBinarioBusqueda<Integer>(10);
		abb2 = new ArbolBinarioBusqueda<Integer>(10);
		abb2.agregar(14);
		abb3 = new ArbolBinarioBusqueda<Integer>(10);
		abb3.agregar(5);
		abb4 = new ArbolBinarioBusqueda<Integer>(15);
		abb4.agregar(10);
		abb4.agregar(8);
		abb4.agregar(12);
		abb4.agregar(20);
		abb4.agregar(17);
		abb4.agregar(23);
		abb5 = new ArbolBinarioBusqueda<Integer>(15);
		abb5.agregar(10);
		abb5.agregar(20);
		abb5.agregar(8);
		abb5.agregar(12);
	}
	
	@Test
	public void testContiene() {
		this.preTest();
		boolean res1 = abb.contiene(10);
		boolean res2 = abb.contiene(1);
		boolean resultadoEsperado1 = true;
		boolean resultadoEsperado2 = false;
		assertEquals(resultadoEsperado1, res1);
		assertEquals(resultadoEsperado2, res2);
	}

	@Test
	public void testEqualsArbolOfE() {
		fail("Not yet implemented");
	}

	@Test
	public void testAgregar() {
		ArbolBinarioBusqueda<Integer> abb1 = new ArbolBinarioBusqueda<Integer>(10);
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(10); lista.add(6); lista.add(5); lista.add(8); lista.add(7); lista.add(9); lista.add(15); lista.add(20);
		abb1.agregar(6);
		abb1.agregar(5);
		abb1.agregar(8);
		abb1.agregar(9);
		abb1.agregar(15);
		abb1.agregar(20);
		abb1.agregar(7);
		assertEquals(lista,abb1.preOrden());
	}

	@Test
	public void testProfundidad() {
		this.preTest();
		int prof = abb.profundidad();
		assertEquals(0, prof);
		prof = abb2.profundidad();
		assertEquals(1, prof);
		prof = abb3.profundidad();
		assertEquals(1, prof);
		prof = abb4.profundidad();
		assertEquals(2, prof);
		prof = abb5.profundidad();
		assertEquals(2, prof);
	}

	@Test
	public void testCuentaNodosDeNivel() {
		this.preTest();
		int res = abb4.cuentaNodosDeNivel(2);
		assertEquals(4, res);
		res = abb5.cuentaNodosDeNivel(2);
		assertEquals(2, res);
	}

	@Test
	public void testEsCompleto() {
		this.preTest();
		boolean res = abb.esCompleto();
		assertEquals(true, res);
		res = abb2.esCompleto();
		assertEquals(false,res);
		res = abb3.esCompleto();
		assertEquals(true,res);
		res = abb4.esCompleto();
		assertEquals(true,res);
		res = abb5.esCompleto();
		assertEquals(true,res);
	}

	@Test
	public void testEsLleno() {
		this.preTest();
		boolean res1 = abb.esLleno();
		boolean res2 = abb2.esLleno();
		assertEquals(true, res1);
		assertEquals(false, res2);
	}

}
