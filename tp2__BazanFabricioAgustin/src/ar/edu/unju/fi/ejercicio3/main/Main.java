package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {
	
	public static void main(String[] args) {
		int i;
		Provincia[] prov=Provincia.values();
		for(Provincia p: prov)
		{
			System.out.println("\n");
			System.out.println("\nPROVINCIA: "+p);
			System.out.println("Cantidad de habitantes: "+p.getCant_poblacion());
			System.out.println("superficie: "+p.getSuperficie());
			System.out.println("Densidad poblacional: "+p.calcularDensidadPoblacional());	
			System.out.println("\n");
			System.out.println();
		}

	}
	
}
