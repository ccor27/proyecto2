package modelo;

import java.util.ArrayList;





public class NodoGrafo {

	private Vendedor vendedor; 
	private String dato;
	private ArrayList<Enlace> listaEnlaces;
	
	public NodoGrafo() {
	
	}
	public NodoGrafo(Vendedor vendedor, String data){
		this.listaEnlaces = new ArrayList<>();
		//listaEnlaces.add(null);
		this.dato=data;
		this.vendedor =vendedor;
	}
	public Vendedor getNombre() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public String getData() {
		return dato;
	}
	public void setData(String data) {
		this.dato = data;
	}
	public ArrayList<Enlace> getListaEnlaces() {
		return listaEnlaces;
	}
	public void setListaEnlaces(ArrayList<Enlace> listaEnlaces) {
		this.listaEnlaces = listaEnlaces;
	}
	
	public Vendedor getVendedor(){
		return this.vendedor;
	}
	
	
	public int buscarIndiceLibre() {
		int indiceDisponible = -1;
		Enlace enlaceAuxiliar = null;
		if(listaEnlaces.size()==0){
			indiceDisponible=0;
		}else{
			for (int i = 0; i < listaEnlaces.size(); i++) {
				enlaceAuxiliar = listaEnlaces.get(i);
				if (enlaceAuxiliar == null) {
					indiceDisponible = i;
					i = listaEnlaces.size();
				}
			}
			listaEnlaces.add(null);
		}
		

		return indiceDisponible;
	}
	/**
	 * se conecta con el nodo destiny y en ese trayecto hay tanto peso
	 *
	 * @param destiny
	 * @param index
	 * @param peso
	 */
	public void conectarNodoPesado(NodoGrafo nodo, int indice, double peso) {
		if (buscarNodoPorNombre(nodo.getVendedor().getNombre()) == null && nodo != null) {
			if (indice < listaEnlaces.size()) {
				listaEnlaces.set(indice, new Enlace(nodo, peso));
			} else {
				int n = indice - listaEnlaces.size();
				for (int i = 0; i < n; i++) {
					listaEnlaces.add(null);
				}
				listaEnlaces.add(new Enlace(nodo, peso));
			}
		}
	}
	
	public NodoGrafo buscarNodoPorNombre(String nombre) {
		for (int i = 0; i < listaEnlaces.size(); i++) {
			if (listaEnlaces.get(i) != null) {
				if (listaEnlaces.get(i).getNodo().getVendedor().getNombre().equalsIgnoreCase(nombre)) {
					return listaEnlaces.get(i).getNodo();
				}
			}
		}
		return null;
	}
	
	public void conectarNodoNoPesado(NodoGrafo nombreNodoDestino, int index) {
		if (index < listaEnlaces.size()) {

			listaEnlaces.set(index, new Enlace(nombreNodoDestino, 0));
		} else {
			int n = index - listaEnlaces.size();
			for (int i = 0; i < n; i++) {
				listaEnlaces.add(null);
			}
			listaEnlaces.add(new Enlace(nombreNodoDestino, 0));
		}
	}
	
	
	public String toString() {
		String message = vendedor.getNombre() + ": \n\t\t";
		message += "{" + dato + "}\n\t\t";
		message += "listaEnlaces: " + listaEnlaces.size() + "\n\t\t";
		for (int i = 0; i < listaEnlaces.size(); i++) {
			message += "[" + i + "]:";
			if (listaEnlaces.get(i) != null) {
				message += listaEnlaces.get(i).getNodo().getNombre() + "\n\t\t";
			} else {
				message += null + "\n\t\t";
			}
		}

		return message;
	}

}
