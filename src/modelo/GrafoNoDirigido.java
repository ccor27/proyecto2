package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import exception.ErrorNodoNoExiste;
import exception.ErrorNodoYaExiste;


public class GrafoNoDirigido {

	private HashMap<String,NodoGrafo> listaVendedores;
	private int tamanio;
	
	public GrafoNoDirigido(){
		this.listaVendedores = new HashMap<>();
	}
	/**
	 * getListaGrafos
	 */
	public HashMap<String,NodoGrafo> getlistaVendedores() {
		return listaVendedores;
	}
	
	/*
	 * agregarNodo
	 * 
	 */
	public void agregarNodo(Vendedor vendedor) throws ErrorNodoYaExiste {
		if (!listaVendedores.containsKey(vendedor.getClave())) {
			NodoGrafo node = new NodoGrafo(vendedor, vendedor.getClave());
			getlistaVendedores().put(vendedor.getClave(),node);
			tamanio = listaVendedores.size();
			System.out.println("Nodo " + vendedor.getNombre() + " agregado exitosamente");
		} else {
			throw new ErrorNodoYaExiste("Error: el nodo ya existe en el grafo");
		}
	}
	
	/**
	 * conectarNodoNoPesado
	 */
	public void conectarNodoNoPesado(Vendedor nodoOrigen, Vendedor nodoDestino) throws ErrorNodoNoExiste {
		NodoGrafo auxiliarNodoOrigen;
		NodoGrafo auxiliarNodoDestino;
		if (listaVendedores.containsKey(nodoOrigen.getClave())) {
			auxiliarNodoOrigen = listaVendedores.get(nodoOrigen.getClave());
			if (listaVendedores.containsKey(nodoDestino.getClave())) {
				auxiliarNodoDestino = listaVendedores.get(nodoDestino.getClave());
			} else {
				throw new ErrorNodoNoExiste("El nodo destino no existe");
			}
			auxiliarNodoOrigen.conectarNodoNoPesado(auxiliarNodoDestino, auxiliarNodoOrigen.buscarIndiceLibre());
			auxiliarNodoDestino.conectarNodoNoPesado(auxiliarNodoOrigen, auxiliarNodoDestino.buscarIndiceLibre());
			//System.out.println(listaVendedores.toString());
		} else {
			throw new ErrorNodoNoExiste("El nodo origen no existe");
		}
	}
	
	public boolean agregarProdVendedor(String nombreVendedor, Producto p){
		
		Vendedor vend = null;
		boolean centinela = false;
		// Definir Iterator para extraer o imprimir valores 
		for( Iterator it = listaVendedores.keySet().iterator(); it.hasNext();) { 
			
			String s = (String)it.next();
			String s1 = (String)listaVendedores.get(s).getVendedor().getNombre();
			if(s1.equalsIgnoreCase(nombreVendedor)){
				System.out.println("entro agregarprodvendedro linea 72 grafonodirigido");
				vend=listaVendedores.get(s).getVendedor();
				break;
			}
			
		}
		
		if(vend!=null){//verificamos que el vendedor exista
			if(vend.agregarProducto(p)){
				centinela = true;
				//vend.getListaProductos().inorden();
			}
					
		}
		return centinela;
	}
	
	public Vendedor obtenerVendedor(String nombreVendedor){
		
		Vendedor vend = null;
		for( Iterator it = listaVendedores.keySet().iterator(); it.hasNext();) { 
			String s = (String)it.next();
			String s1 = (String)listaVendedores.get(s).getVendedor().getNombre();
			if(s1.equalsIgnoreCase(nombreVendedor)){
				vend=listaVendedores.get(s).getVendedor();
				break;
			}
			
		}
		return vend;
	}
	
	public ArrayList<Enlace> getListaEnlace(String nombre){
		
		NodoGrafo node = null;
		ArrayList<Enlace> enlaces = null;
		for( Iterator it = listaVendedores.keySet().iterator(); it.hasNext();) { 
			String s = (String)it.next();
			String s1 = (String)listaVendedores.get(s).getVendedor().getNombre();
			if(s1.equalsIgnoreCase(nombre)){
				node = listaVendedores.get(s);
				System.out.println("nodo: "+node);
				enlaces = node.getListaEnlaces();
				System.out.println("enlaces: "+enlaces);
			}
		}
		return enlaces;
	}
	
	
	
}
