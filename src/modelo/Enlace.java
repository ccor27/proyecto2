package modelo;

public class Enlace {

	private NodoGrafo nodo;
	private double peso;

	public Enlace(NodoGrafo nodo, double peso) {
		this.nodo = nodo;
		this.peso = peso;
	}

	public NodoGrafo getNodo() {
		return nodo;
	}

	public void setNodo(NodoGrafo nodo) {
		this.nodo = nodo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Enlace [nodo=" + nodo + ", peso=" + peso + "]";
	}

}
