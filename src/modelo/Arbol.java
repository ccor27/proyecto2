package modelo;

import java.util.ArrayList;

public class Arbol<T> {
	
	private NodoArbol<T> raiz;
	private int peso;
	private ArrayList<Producto> lista = new ArrayList();
	
	/**
	 * Verifica si un árbol está vacío
	 * @return true si está vacío
	 */
	public boolean estaVacio() {
		return raiz==null;
	}
	
	/**
	 * Agrega un nuevo elemento al árbol
	 * @param elemento Nuevo dato
	 * @return true si lo pudo guardar
	 */
	public boolean agregar(T elemento) {		
		if(estaVacio()) {
			raiz = new NodoArbol<>(elemento);
			peso++;
			return true;
		}else if(raiz.agregar(elemento)){	
			peso++;
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Realiza el recorrido inorden en el árbol binario
	 */
	public void inorden() {
		inorden(raiz);
		System.out.println();
	}
	
	/**
	 * Realiza el recorrido inorden en el árbol binario
	 * @param n Nodo raíz
	 */
	private void inorden(NodoArbol<T> n) {
		if(n!=null) {
			inorden(n.getIzquierdo());
			lista.add((Producto) n.getElemento());
			//System.out.print(n.getElemento()+"\t");
			inorden(n.getDerecho());
		}
	}
	
	public ArrayList<Producto> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Producto> lista) {
		this.lista = lista;
	}

	/**
	 * @return the raiz
	 */
	public NodoArbol<T> getRaiz() {
		return raiz;
	}
	/**
	 * @param raiz the raiz to set
	 */
	public void setRaiz(NodoArbol<T> raiz) {
		this.raiz = raiz;
	}
	/**
	 * @return the peso
	 */
	public int getPeso() {
		return peso;
	}

}
