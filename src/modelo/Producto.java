package modelo;

public class Producto {

	private String nombre;
	private String categoria;
	
	public Producto(String nombre, String categoria){
		this.categoria = categoria;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + "]";
	}
	


}
