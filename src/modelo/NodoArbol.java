package modelo;

public class NodoArbol <T>{
	
	private NodoArbol<T> izquierdo, derecho;
	private NodoArbol<T> padre;
	private T elemento;
	
	/**
	 * Constructor de la clase
	 * @param elemento Dato del nodo
	 */
	public NodoArbol(T elemento) {
		this.elemento = elemento;
	}
	
	public NodoArbol(T elemento, NodoArbol<T> padre) {
		this.elemento = elemento;
		this.padre = padre;
	}
	
	/**
	 * Agrega un nuevo elemento en el árbol
	 * @param elemento Nuevo dato
	 * @return true si lo pudo guardar
	 */
	public boolean agregar(T nuevo) 
	{
		Producto prdo = (Producto) nuevo;
		Producto prdo2 = (Producto) elemento;
		
		if( compareTo( prdo2, prdo ) < 0 ) 
		{
			if(izquierdo==null) {
				izquierdo = new NodoArbol<>(nuevo, this);
				return true;
			}else {
				return izquierdo.agregar(nuevo);
			}
		}
		else 
		{
			if( compareTo( prdo2, prdo ) > 0 ) 
			{
				if(derecho==null) {
					derecho = new NodoArbol<>(nuevo, this);
					return true;
				}else {
					return derecho.agregar(nuevo);
				}
			}else{
				return false;
			}
		}
		
		
	}
	
	private int compareTo(Producto prdo2, Producto prdo) {
		
		if(prdo.getNombre().compareTo(prdo2.getNombre() ) == 0){
			//son la misma
		   return 0;
		}else{
			
			if(prdo.getNombre().compareTo(prdo2.getNombre() ) < 0){
				//la primera cadena es menor
				return -1;
			}else{
				//la primera cadena es mayor
				return 1;
			}
		}
		
	}

	/**
	 * Determina si un Nodo es una Hoja
	 * @return true si es Hoja
	 */
	public boolean esHoja() {
		return izquierdo == null && derecho == null;
	}

	/**
	 * 
	 * @return
	 */
	public boolean tieneUnHijo() {
		return (izquierdo!=null && derecho==null) || (derecho!=null && izquierdo==null );
	}
	
	/**
	 * @return the izq
	 */
	public NodoArbol<T> getIzquierdo() {
		return izquierdo;
	}

	/**
	 * @param izq the izq to set
	 */
	public void setIzquierdo(NodoArbol<T> izq) {
		this.izquierdo = izq;
	}

	/**
	 * @return the der
	 */
	public NodoArbol<T> getDerecho() {
		return derecho;
	}

	/**
	 * @param der the der to set
	 */
	public void setDerecho(NodoArbol<T> der) {
		this.derecho = der;
	}

	/**
	 * @return the elemento
	 */
	public T getElemento() {
		return elemento;
	}

	/**
	 * @param elemento the elemento to set
	 */
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	/**
	 * @return the padre
	 */
	public NodoArbol<T> getPadre() {
		return padre;
	}

	/**
	 * @param padre the padre to set
	 */
	public void setPadre(NodoArbol<T> padre) {
		this.padre = padre;
	}
}
