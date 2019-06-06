package isi.died.tp.estructuras;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.InsumoLiquido;
import isi.died.tp.dominio.Unidad;

public class TestRangoABB {
	private ArbolBinarioBusqueda<Insumo> abb;
	private Insumo I1;
	private InsumoLiquido I2;
	private Insumo I3;
	private InsumoLiquido I4;
	private Insumo I5;
	private Insumo I6;
	private Insumo I7;
	private Insumo I8;
	
	@Before
	public void preTest() {
		I1 = new Insumo("I1","Descripcion1",Unidad.Kilo,100.0,10.0,3.123,false);
		I2 = new InsumoLiquido("I2", "Descripcion2", 750.0, 6.0, true, 1.141);
		I3 = new Insumo("I3","Descripcion3",Unidad.Pieza,15.0,5.0,0.200,false);
		I4 = new InsumoLiquido("I4", "Descripcion4", 500.0, 8.0, true, 1.976);
		I5 = new Insumo("I5","Descripcion5",Unidad.M2,185.25,9.0,2.100,false);
		I6 = new Insumo("I6","Descripcion6",Unidad.Metro,215.55,15.0,1.351,true);
		I7 = new Insumo("I7","Descripcion7",Unidad.M3,705.30,20.0,0.213,false);
		I8 = new Insumo("I8","Descripcion8",Unidad.Gramo,100.0,7.0,0.156,true);
		
		abb = new ArbolBinarioBusqueda<Insumo>(I1);
	}
	
	@Test
	public void testRango() {
		List<Insumo> prueba = new ArrayList<Insumo>();
		List<Insumo> esperado = new ArrayList<Insumo>();
		abb.agregar(I2);
		abb.agregar(I3);
		abb.agregar(I4);
		abb.agregar(I5);
		abb.agregar(I6);
		abb.agregar(I7);
		abb.agregar(I8);
		prueba = abb.rango(I2, I1);
		esperado.add(I1);
		esperado.add(I2);
		esperado.add(I4);
		esperado.add(I8);
		esperado.add(I5);
		
		assertEquals(esperado, prueba);
	}

}
