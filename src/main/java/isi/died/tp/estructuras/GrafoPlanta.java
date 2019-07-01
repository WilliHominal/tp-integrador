package isi.died.tp.estructuras;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.function.Predicate;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
public class GrafoPlanta extends Grafo<Planta> {
public void imprimirDistanciaAdyacentes(Planta inicial) {
	List<Planta> adyacentes = super.getAdyacentes(inicial);
	for(Planta unAdyacente: adyacentes) {
		Arista<Planta> camino = super.buscarArista(inicial, unAdyacente);
		System.out.println("camino de "+inicial.getNombre()+" a "+ unAdyacente.getNombre()+ " tiene valor de "+ camino.getValor() );
	}
}
 // a
 public Planta buscarPlanta(Planta inicial, Insumo i, Integer saltos) {
	Boolean encontrado = false;
	Stack<Planta> pendientes = new Stack<Planta>();
	HashSet<Planta> marcados = new HashSet<Planta>();
	marcados.add(inicial);
	pendientes.push(inicial);
	while(!pendientes.isEmpty() && !encontrado){
		Planta actual = pendientes.pop();
		List<Planta> adyacentes = this.getAdyacentes(actual);
		if (actual.necesitaInsumo(i)) {
			return actual;
		} else {
			for(Planta p : adyacentes){
				if(!marcados.contains(p)){ 
					pendientes.push(p);
					marcados.add(p);
				}
			}
		}
	}	
	return null;
 }
 // b
 public Planta buscarPlanta(Planta inicial, Insumo i) { }
 // c
 public Planta buscarPlanta(Insumo i) { }
}