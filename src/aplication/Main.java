package aplication;

import exception.ErrorNodoNoExiste;
import exception.ErrorNodoYaExiste;
import modelo.GrafoNoDirigido;
import modelo.Vendedor;

public class Main {

	public static void main(String[] args) throws ErrorNodoYaExiste, ErrorNodoNoExiste {
		
		GrafoNoDirigido grafoTareas = new GrafoNoDirigido();
		Vendedor v1 = new Vendedor("A","1");
		Vendedor v2 = new Vendedor("B", "2");
		Vendedor v3 = new Vendedor("C", "3");
		Vendedor v4 = new Vendedor("D", "4");
		Vendedor v5 = new Vendedor("E", "5");
		grafoTareas.agregarNodo(v1);
		grafoTareas.agregarNodo(v2);
		grafoTareas.agregarNodo(v3);
		grafoTareas.agregarNodo(v4);
		grafoTareas.agregarNodo(v5);
		grafoTareas.conectarNodoNoPesado(v1, v2);
		grafoTareas.conectarNodoNoPesado(v1, v3);
		grafoTareas.conectarNodoNoPesado(v1, v4);
		grafoTareas.conectarNodoNoPesado(v1, v5);
		//System.out.println(grafoTareas.getlistaVendedores());
	//	System.out.println(grafoTareas.getlistaVendedores().get(1).getVendedor().getContactos().toString());
//		grafoTareas.agregarNodo("A", "1");
//		grafoTareas.agregarNodo("B", "2");
//		grafoTareas.agregarNodo("C", "3");
//		grafoTareas.agregarNodo("D", "4");
//		grafoTareas.agregarNodo("E", "5");
//		grafoTareas.conectarNodoNoPesado("A", "B");
//		grafoTareas.conectarNodoNoPesado("A", "C");
//		grafoTareas.conectarNodoNoPesado("A", "D");
//		grafoTareas.conectarNodoNoPesado("B", "E");
		

	}

}
