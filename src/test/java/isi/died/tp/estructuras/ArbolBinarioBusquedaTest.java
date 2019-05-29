package isi.died.tp.estructuras;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArbolBinarioBusquedaTest {
	private ArbolBinarioBusqueda<Integer> abb;
	private ArbolBinarioBusqueda<Integer> abb2;

	@Before
	public void preTest() {
		abb = new ArbolBinarioBusqueda<Integer>(5);
		abb.agregar(30);
		abb.agregar(20);
		abb.agregar(40);
		abb.agregar(15);
		abb2 = new ArbolBinarioBusqueda<Integer>(10);
		abb2.agregar(1);
		abb2.agregar(15);
	}
	
	@Test
	public void testContiene() {
		this.preTest();
		boolean res1 = abb.contiene(15);
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
		fail("Not yet implemented");
	}

	@Test
	public void testProfundidad() {
		this.preTest();
		Integer profEsperada = 3;
		Integer prof = abb.profundidad();
		assertEquals(profEsperada, prof);
	}

	@Test
	public void testCuentaNodosDeNivel() {
		this.preTest();
		Integer resEsperado = 2;
		Integer res = abb.cuentaNodosDeNivel(2);
		assertEquals(resEsperado, res);
	}

	@Test
	public void testEsCompleto() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsLleno() {
		this.preTest();
		boolean res1 = abb.esLleno();
		boolean res2 = abb2.esLleno();
		assertEquals(false, res1);
		assertEquals(true, res2);
	}

}
