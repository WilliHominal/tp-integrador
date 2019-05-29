package isi.died.tp.estructuras;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda<E extends Comparable<E>> extends Arbol<E> {

	protected Arbol<E> izquierdo;
	protected Arbol<E> derecho;
	
	public ArbolBinarioBusqueda(){
		this.valor=null;
		this.izquierdo=new ArbolVacio<E>();
		this.derecho=new ArbolVacio<E>();
	}
	
	public ArbolBinarioBusqueda(E e){
		this.valor=e;
		this.izquierdo=new ArbolVacio<E>();
		this.derecho=new ArbolVacio<E>();
	}
	
	public ArbolBinarioBusqueda(E e,Arbol<E> i,Arbol<E> d){
		this.valor=e;
		this.izquierdo=i;
		this.derecho=d;
	}
	
	@Override
	public List<E> preOrden() {
		List<E> lista = new ArrayList<E>();
		lista.add(this.valor);
		lista.addAll(this.izquierdo.preOrden());
		lista.addAll(this.derecho.preOrden());
		return lista;
	}
	@Override
	public List<E> inOrden() {
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.preOrden());
		lista.add(this.valor);
		lista.addAll(this.derecho.preOrden());
		return lista;
	}
	@Override
	public List<E> posOrden() {
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.preOrden());
		lista.addAll(this.derecho.preOrden());
		lista.add(this.valor);
		return lista;

	}
	@Override
	public boolean esVacio() {
		return false;
	}
        
	@Override
	public E valor() {
		return this.valor;
	}
	
	@Override
	public Arbol<E> izquierdo() {
		return this.izquierdo;
	}
	
	@Override
	public Arbol<E> derecho() {
		return this.derecho;
	}


	@Override
	public void agregar(E a) {
		if(this.valor.compareTo(a)<1) {
			if (this.derecho.esVacio()) this.derecho = new ArbolBinarioBusqueda<E>(a);
			else this.derecho.agregar(a);
		}else {
			if (this.izquierdo.esVacio()) this.izquierdo= new ArbolBinarioBusqueda<E>(a);
			else this.izquierdo.agregar(a);
		}
	}
	
	@Override
	public boolean equals(Arbol<E> unArbol) {
		return this.valor.equals(unArbol.valor()) && this.izquierdo.equals(unArbol.izquierdo()) && this.derecho.equals(unArbol.derecho());
	}

	@Override
	public boolean contiene(E unValor) {
		// TODO 1.a
		if (this.valor == unValor || this.derecho.contiene(unValor) || this.izquierdo.contiene(unValor)) {
			return true;
		}
		return false;
	}

	private int altura() {
		if (this.izquierdo instanceof ArbolBinarioBusqueda) {
			if (this.derecho() instanceof ArbolBinarioBusqueda) {
				return Math.max(((ArbolBinarioBusqueda<E>) this.izquierdo).altura()+1, ((ArbolBinarioBusqueda<E>) this.derecho).altura()+1);
			} else {
				return ((ArbolBinarioBusqueda<E>) this.izquierdo).altura()+1;
			}
		} else {
			if (this.derecho instanceof ArbolBinarioBusqueda) {
				return ((ArbolBinarioBusqueda<E>) this.derecho).altura()+1;
			} else {
				return 1;
			}
		}	
	}
	
	@Override
	public int profundidad() {
		// TODO 1.b
		return this.altura()-1;
	}

	@Override
	public int cuentaNodosDeNivel(int nivel) {
		// TODO 1.c
		if(nivel == 0)
			return 1;
		else
			return this.izquierdo.cuentaNodosDeNivel(nivel-1) + this.derecho.cuentaNodosDeNivel(nivel -1);
	}

	@Override
	public boolean esCompleto() {
		// TODO 1.d
		if (this.izquierdo.profundidad() == this.derecho.profundidad()) {
			return this.esLleno();
		} else if (this.izquierdo.profundidad() > this.derecho.profundidad()) {
			return this.izquierdo.esCompleto();
		}
		
		return false;
	}

	@Override
	public boolean esLleno() {
		// TODO 1.e
		if (this.cuentaNodosDeNivel(this.profundidad()) == Math.pow(2, this.profundidad()))
			return true;
		return false;
	}

}
