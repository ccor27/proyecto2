package ModelFactoryController;

import java.util.ArrayList;
import java.util.HashMap;

import exception.ErrorNodoNoExiste;
import exception.ErrorNodoYaExiste;
import modelo.Enlace;
import modelo.GrafoNoDirigido;
import modelo.NodoGrafo;
import modelo.Producto;
import modelo.Vendedor;

public class RedSocialController {

	ModelFactory controller;
	HashMap<String,NodoGrafo> grafos;
	 public RedSocialController() {
		 controller = ModelFactory.getInstance();
		 grafos=controller.getGrafoNoDirigido();
	}
	 
	 public HashMap<String,NodoGrafo> getGrafoNoDirigido(){
		 return this.grafos;
	 }
	 
	 public void crearVendedor(Vendedor vendedor) throws ErrorNodoYaExiste{
		 controller.agregarNodo(vendedor);
	 }

	public boolean agregarProdVendedor(String vendedorSeleccionado, Producto p) {
		
		return controller.agregarProdVendedor(vendedorSeleccionado,p);
	}

	public Vendedor obtenerVendedor(String nombreVendedor) {
		
		return controller.obtenerVendedor(nombreVendedor);
	}

	public void conectarVendedores(Vendedor vendOrigen, Vendedor vendDestino) throws ErrorNodoNoExiste {
		
		controller.conectarVendedores(vendOrigen,vendDestino);
	}

	public ArrayList<Enlace> getListaEnlaces(String nombre) {
		
		return controller.getListaEnlaces(nombre);
				
	}


	 
}
