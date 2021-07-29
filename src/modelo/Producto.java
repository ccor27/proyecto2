package modelo;

import java.util.Calendar;

public class Producto {

	private String nombre;
	private String categoria;
	private String fechaHora;
	
	public Producto(String nombre, String categoria){
		this.categoria = categoria;
		this.nombre = nombre;
		cargarFechaSistema();
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
	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + "]";
	}
	
    private  void cargarFechaSistema() {

        String diaN = "";
        String mesN = "";
        String anoN = "";

        Calendar cal1 = Calendar.getInstance();

        int dia = cal1.get(Calendar.DATE);
        int mes = cal1.get(Calendar.MONTH) + 1;
        //int ano = cal1.get(Calendar.YEAR);
        int hora = cal1.get(Calendar.HOUR);
        int minuto = cal1.get(Calendar.MINUTE);

        if (dia < 10) {
            diaN += "0" + dia;
        } else {
            diaN += "" + dia;
        }
        if (mes < 10) {
            mesN += "0" + mes;
        } else {
            mesN += "" + mes;
        }

        //		fecha_Actual+= año+"-"+mesN+"-"+ diaN;
        //		fechaSistema = año+"-"+mesN+"-"+diaN+"-"+hora+"-"+minuto;
       // fechaSistema = ano + "-" + mesN + "-" + diaN;
        //		horaFechaSistema = hora+"-"+minuto;
        this.fechaHora = "D:"+dia+"/M: "+mes+"/H:"+hora+":"+minuto;
    }

}
