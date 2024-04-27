package ar.edu.unju.fi.ejercicio2.main;

import ar.edu.unju.fi.ejercicio2.model.Efemeride;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static Scanner sc=new Scanner(System.in);
	private static List<Efemeride> efemiredes;
	
	public static void main(String[] args) {
		efemiredes=new ArrayList<>();
		int opc=0;
		do
		{
			mostrarMenu();
			opc=manejarExcepcionIngresoNumEntero();
			switch(opc)
			{
				case 1:
					cargarEfmirede();
					break;
				case 2:
					mostrarEfemiredes();
					break;
				case 3:
					eliminarEfemirede();
					break;
				case 4:
					modificarEfemeride();
					break;
				case 5:
					System.out.println("Fin del Programa!!");
					break;
				default:
					System.out.println("No ha seleccionado correctamente alguna opcion");
			}
		}while(opc!=5);
	}
	
	/**
	 * Mostrar el menu principal
	 */
	public static void mostrarMenu()
	{
		System.out.println("\n1.Crear efemeride");
		System.out.println("2.Mostrar efemerides");
		System.out.println("3.Eliminar un efemeride");
		System.out.println("4.Modificar efemeride");
		System.out.println("5.Salir");
		System.out.print("Ingrese su opcion: ");
	}
	
	/**
	 * Manejar excepcion de numeros  enteros
	 * @return
	 */
	
	public static int manejarExcepcionIngresoNumEntero() {
		boolean band=false;
		int n=0;
		do
		{
			band=false;
			try
			{
				n=sc.nextInt();
				band=true;
			}
			catch(InputMismatchException ex)
			{
				System.out.println("Error al ingresar");
				sc.next();
				
			}
		}while(band==false);
		return n;
	}
	
	/**
	 * Manejar que la cadena de caracteres no vuelva vacia
	 * @return
	 */
	
	public static String controlIngresoPalabra() {
		boolean band=false;
		String palabra;
		do {
			palabra=sc.next();
			if(palabra.length()<3 || palabra.matches(".*[^a-zA-Z].*")==true)
				System.out.println("Debe ingresar correctamente");
			else
				band=true;
		}while(band==false);
		return palabra;
	}
	
	/**
	 * Control de código de producto
	 */
	
	public static int controlIngresoCodigo()
	{
		int cod=0;
		do
			cod=manejarExcepcionIngresoNumEntero();
		while(cod<0 || cod>9999);
		return cod;
	}
	
	/**
	 * Controlar el ingreso de codigo repetido 
	 */
	
	public static boolean controlarCod(int cod)
	{
		boolean band=false;
		if(!efemiredes.isEmpty())
		{
			for(Efemeride efe: efemiredes)
			{
				if(efe.getCodigo()==cod)
				{
					band=true;
					break;
				}
			}
		}
		return band;
	}
	
	/**
	 * Controlar ingreso de numero
	 */
	
	public static int controlarIngresoNumero()
	{
		int n=0;
		do
		{
			n=manejarExcepcionIngresoNumEntero();
		}while(n<0 || n>12);
		return n;
	}
	
	/**
	 * Crear un efemirede
	 */
	
	public static void cargarEfmirede()
	{
		System.out.println("****ALTA DE UN EFEMIREDE****");
		int cod, mes;
		Mes[] meses=Mes.values();
		System.out.print("Ingrese codigo del Efemirede: ");
		cod=controlIngresoCodigo();
		if(controlarCod(cod)==false)
		{
			Efemeride efemire=new Efemeride();
			efemire.setCodigo(cod);
			System.out.print("Ingrese un número del 1 al 12: ");
			mes=controlarIngresoNumero();
			efemire.setDia(mes);
			efemire.setMes(meses[mes-1]);
			System.out.print("Ingrese descripción: ");
			efemire.setDescripcion(controlIngresoPalabra());
			efemiredes.add(efemire);
			System.out.println("****AGREGADO CON EXITO****");
		}else
			System.out.println("El codigo ingresado ya existe");
	}
	
	/**
	 * Mostrar objetos del ArrayList
	 */
	
	public static void mostrarEfemiredes()
	{
		if(!efemiredes.isEmpty())
		{
			System.out.println("-----LISTA DE EFEMIREDES------");
			efemiredes.forEach(t->System.out.println(t));
		}else
			System.out.println("LA LISTA ESTÁ VACIA");
		
	}
	
	/**
	 * eLIMINAR UN OBJETO DEL ARRAYLIST
	 */
	
	public static void eliminarEfemirede()
	{	
		int cod;
		if(!efemiredes.isEmpty())
		{
			System.out.println("***ELIMINAR UN EFEMIREDE***");
			System.out.print("Ingrese un codigo: ");
			cod=manejarExcepcionIngresoNumEntero();
			if(controlarCod(cod)==true)
			{
				Iterator <Efemeride> iterator=efemiredes.iterator();
				while(iterator.hasNext())
				{
					Efemeride efemeride=iterator.next();
					if(efemeride.getCodigo()==cod)
					{
						System.out.println("**OBJETO A ELIMINAR**");
						System.out.println(efemeride.toString());
						iterator.remove();
						System.out.println("**SE ELIMINO CON EXITO**");
					}
				}
			}else
				System.out.println("EL CODIGO INGRESADO NO EXISTE EN ESTA LISTA");
			
		}else
			System.out.println("LA LISTA ESTA VACIA");
	}
	
	/**
	 * MODIFICAR UN OBJETO
	 */
	
	public static void modificarEfemeride()
	{
		
		if(!efemiredes.isEmpty())
		{
			int cod, mes;
			Mes[] meses=Mes.values();
			System.out.println("***MODIFICAR UN EFEMIREDE***");
			System.out.print("Ingrese un codigo: ");
			cod=manejarExcepcionIngresoNumEntero();
			if(controlarCod(cod)==true)
			{
				for(Efemeride efe: efemiredes)
				{
					if(efe.getCodigo()==cod)
					{
						System.out.print("Ingrese un NUEVO número del 1 al 12: ");
						mes=controlarIngresoNumero();
						efe.setDia(mes);
						efe.setMes(meses[mes-1]);
						System.out.print("Ingrese UNA NUEVA descripción: ");
						efe.setDescripcion(controlIngresoPalabra());
						System.out.println("****MODIFICADO CON EXITO****");
					}
				}
			}else
				System.out.println("EL CODIGO INGRESADO NO EXISTE EN ESTA LISTA");
			
		}else
			System.out.println("LA LISTA ESTA VACIA");
	}
	

}
