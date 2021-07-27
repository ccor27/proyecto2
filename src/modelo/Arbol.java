package modelo;



public class Arbol<T> {
	
	private NodoArbol<T> raiz;
	private int peso;
	
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
	public void agregar(T elemento) {		
		if(estaVacio()) {
			raiz = new NodoArbol<>(elemento);
			peso++;
		}else if(raiz.agregar(elemento)){			
			peso++;
		}		
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
