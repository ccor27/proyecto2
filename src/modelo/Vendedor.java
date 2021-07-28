package modelo;


import java.util.HashMap;

public class Vendedor {
	
	private String nombre;
	private String clave;
	private HashMap<String, Integer> contactos;
	private Arbol<Producto> listaProductos;
	
	public Vendedor(String nombre, String clave){
		this.nombre=nombre;
		this.clave = clave;
		listaProductos = new Arbol<>();
		contactos = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashMap<String, Integer> getContactos() {
		return contactos;
	}

	public void setContactos(HashMap<String, Integer> contactos) {
		this.contactos = contactos;
	}

	public Arbol<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(Arbol<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public boolean agregarProducto(Producto p){
		return listaProductos.agregar(p);
	}

	@Override
	public String toString() {
		return "Vendedor [nombre=" + nombre + ", clave=" + clave + "]";
	}
	
	
	
}
