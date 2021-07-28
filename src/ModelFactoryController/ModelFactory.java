package ModelFactoryController;

import java.util.HashMap;

import exception.ErrorNodoNoExiste;
import exception.ErrorNodoYaExiste;
import modelo.GrafoNoDirigido;
import modelo.NodoGrafo;
import modelo.Producto;
import modelo.Vendedor;

public class ModelFactory {
	
	
	private GrafoNoDirigido grafos;
	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder { 
		// El constructor de Singleton puede ser llamado desde aquí al ser protected
		private final static ModelFactory eINSTANCE = new ModelFactory();
	}
	
	// Método para obtener la instancia de nuestra clase
	public static ModelFactory getInstance() {
		return SingletonHolder.eINSTANCE;
	}
	public ModelFactory(){
		iniciar();
	}

	public void iniciar(){
		grafos = new GrafoNoDirigido();
	}
	
	public GrafoNoDirigido getGrafo(){
		return this.grafos;
	}
	
	public HashMap<String,NodoGrafo> getGrafoNoDirigido(){
		return this.grafos.getlistaVendedores();
	}
	public void agregarNodo(Vendedor vendedor) throws ErrorNodoYaExiste {
		grafos.agregarNodo(vendedor);
		
	}
	public boolean agregarProdVendedor(String vendedorSeleccionado, Producto p) {
		
		return grafos.agregarProdVendedor(vendedorSeleccionado, p);
	}
	public Object obtenerVendedor(String nombreVendedor) {
		
		return grafos.obtenerVendedor(nombreVendedor);
	}
	public void conectarVendedores(Vendedor vendOrigen, Vendedor vendDestino) throws ErrorNodoNoExiste {
		
		grafos.conectarNodoNoPesado(vendOrigen, vendDestino);
	}

}
