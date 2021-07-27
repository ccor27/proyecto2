package modelo;

import java.util.HashMap;


import exception.ErrorNodoNoExiste;
import exception.ErrorNodoYaExiste;


public class GrafoNoDirigido {

	private HashMap<String,NodoGrafo> listaVendedores;
	private int tamanio;
	
	public GrafoNoDirigido(){
		this.listaVendedores = new HashMap<>();
	}
	/**
	 * getGrafo
	 */
	public HashMap<String, NodoGrafo> getGrafo() {
		return listaVendedores;
	}
	
	/*
	 * agregarNodo
	 * 
	 */
	public void agregarNodo(String nombreNodo, String data) throws ErrorNodoYaExiste {
		if (!listaVendedores.containsKey(nombreNodo)) {
			NodoGrafo node = new NodoGrafo(nombreNodo, data);
			listaVendedores.put(nombreNodo, node);
			tamanio = listaVendedores.size();
			System.out.println("Nodo " + nombreNodo + " agregado exitosamente");
		} else {
			throw new ErrorNodoYaExiste("Error: el nodo ya existe en el grafo");
		}
	}
	
	/**
	 * conectarNodoNoPesado
	 */
	public void conectarNodoNoPesado(String nodoOrigen, String nodoDestino) throws ErrorNodoNoExiste {
		NodoGrafo auxiliarNodoOrigen;
		NodoGrafo auxiliarNodoDestino;
		if (listaVendedores.containsKey(nodoOrigen)) {
			auxiliarNodoOrigen = listaVendedores.get(nodoOrigen);
			if (listaVendedores.containsKey(nodoDestino)) {
				auxiliarNodoDestino = listaVendedores.get(nodoDestino);
			} else {
				throw new ErrorNodoNoExiste("El nodo destino no existe");
			}
			auxiliarNodoOrigen.conectarNodoNoPesado(auxiliarNodoDestino, auxiliarNodoOrigen.buscarIndiceLibre());
			auxiliarNodoDestino.conectarNodoNoPesado(auxiliarNodoOrigen, auxiliarNodoDestino.buscarIndiceLibre());
			;
		} else {
			throw new ErrorNodoNoExiste("El nodo origen no existe");
		}
	}
	
}
