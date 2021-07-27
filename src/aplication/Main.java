package aplication;

import exception.ErrorNodoNoExiste;
import exception.ErrorNodoYaExiste;
import modelo.GrafoNoDirigido;

public class Main {

	public static void main(String[] args) throws ErrorNodoYaExiste, ErrorNodoNoExiste {
		
		GrafoNoDirigido grafoTareas = new GrafoNoDirigido();
		grafoTareas.agregarNodo("A", "1");
		grafoTareas.agregarNodo("B", "2");
		grafoTareas.agregarNodo("C", "3");
		grafoTareas.agregarNodo("D", "4");
		grafoTareas.agregarNodo("E", "5");
		grafoTareas.conectarNodoNoPesado("A", "B");
		grafoTareas.conectarNodoNoPesado("A", "C");
		grafoTareas.conectarNodoNoPesado("A", "D");
		System.out.println(grafoTareas.getGrafo());

	}

}
