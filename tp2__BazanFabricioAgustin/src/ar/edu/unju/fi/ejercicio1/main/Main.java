package ar.edu.unju.fi.ejercicio1.main;

import java.util.Scanner;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.origenFabricacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static Scanner sc=new Scanner(System.in);
	private static List<Producto> productos;
	
	public static void main(String[] args) {
		int opc=0;
		productos=new ArrayList<>();
		do
		{
			mostrarMenu();
			opc=manejarExcepcionIngresoNumEntero();
			switch(opc)
			{
				case 1:
					cargarProducto();
					break;
					
				case 2:
					mostrarProductos();
					break;
					
				case 3:
					modificarProducto();
					break;
					
				case 4:
					System.out.println("FIN DEL PROGRAMA");
					break;
				
				default:System.out.println("Error al ingresar una opcion");
			}
			
		}while(opc!=4);
	}
	
	/**
	 * Muestra el menu principal
	 */
	public static void mostrarMenu() {
		System.out.println("\n1. Crear Producto");
		System.out.println("2. Mostrar Productos");
		System.out.println("3. Modificar producto");
		System.out.println("4. Salir");
		System.out.print("\nIngrese opcion: ");
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
	 * Manejar excepcion de numeros reales
	 * @return
	 */
	public static double manejarExcepcionIngresoNumReal() {
		boolean band=false;
		double n=0;
		do
		{
			band=false;
			try
			{
				n=sc.nextDouble();
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
	 * Controla el ingreso de numeros reales
	 * @return
	 */
	
	public static double controlIngresoPrecio()
	{
		double precio=0;
		do
			precio=manejarExcepcionIngresoNumReal();
		while(precio<0 || precio>9999);
		return precio;
	}
	
	/**
	 * Controla el ingreso de numeros reales
	 * @return
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
	 * Control de código de producto
	 */
	
	public static boolean codRepetido(int cod)
	{
		boolean band=false;
		
		for(Producto prod: productos)
		{
			if(prod.getCodigo()==cod)
			{
				band=true;
				break;
			}
		}

		return band;
	}
	
	/**
	 * Cargar productos  
	 */
	
	public static void cargarProducto() 
	{
		int opc=0, i=1;
		origenFabricacion[] origenes=origenFabricacion.values();
		categoria[] categorias=categoria.values();

		System.out.println("\n********ALTA DE PRODUCTO*********");
		System.out.print("Ingrese codigo del producto: ");
		int cod= controlIngresoCodigo();
		if(productos.isEmpty()||codRepetido(cod)==false)
		{
			Producto prod=new Producto();
			prod.setCodigo(cod);
			System.out.print("Ingrese descripcion: ");
			prod.setDescripción(controlIngresoPalabra());
			System.out.print("Ingrese precio unitario: ");
			prod.setPrec_unitario(controlIngresoPrecio());
			System.out.print("Seleccione su país de origen: ");
			
			for(origenFabricacion org: origenes)
			{
				System.out.println("\n"+i+" "+org);
				i++;
			}

			do
			{
				System.out.print("Ingrese una de las opciones: ");
				opc=manejarExcepcionIngresoNumEntero();
			}while(opc<0 || opc>4);
				
			prod.setOrigen_fabricacion(origenes[opc-1]);
			
			System.out.print("\nSeleccione su categoria: ");
			i=1;
			for(categoria cat: categorias)
			{
				System.out.println("\n"+i+" "+cat);
				i++;
			}
				
			do
			{
				System.out.print("Ingrese una de las opciones: ");
				opc=manejarExcepcionIngresoNumEntero();
			}while(opc<0 || opc>4);
			
			prod.setCategorias(categorias[opc-1]);
			
			System.out.println("\nPRODUCTO DADO DE ALTA: ");
			productos.add(prod);
		}else
			System.out.println("El codigo ingresado ya existe");
		
	}
	
	/**
	 * Mostrar Productos
	 */
	
	public static void mostrarProductos()
	{
		System.out.println("*****LISTA DE PRODUCTOS*****");
		if(!productos.isEmpty())
		{
			productos.forEach(t->System.out.println(t));
		}else
			System.out.println("Lista de productos vacia");
	}
	
	/**
	 * Modificar Productos
	 */
	
	public static void modificarProducto()
	{
		int opc=0, i=1;
		origenFabricacion[] origenes=origenFabricacion.values();
		categoria[] categorias=categoria.values();
		System.out.println("****MODIFICAR PRODUCTO****");
		if(!productos.isEmpty())
		{
			System.out.println("Ingrese codigo del producto");
			int cod=manejarExcepcionIngresoNumEntero();
			for(Producto p:productos)
			{
				if(p.getCodigo()==cod)
				{
					
					System.out.print("Ingrese NUEVA descripcion: ");
					p.setDescripción(controlIngresoPalabra());
					System.out.print("Ingrese NUEVO precio unitario: ");
					p.setPrec_unitario(controlIngresoPrecio());
					System.out.print("Seleccione su país de origen: ");
					
					for(origenFabricacion org: origenes)
					{
						System.out.println("\n"+i+" "+org);
						i++;
					}

					do
					{
						System.out.print("Ingrese una de las opciones: ");
						opc=manejarExcepcionIngresoNumEntero();
					}while(opc<0 || opc>4);
						
					p.setOrigen_fabricacion(origenes[opc-1]);
					
					System.out.print("\nSeleccione su categoria: ");
					i=1;
					for(categoria cat: categorias)
					{
						System.out.println("\n"+i+" "+cat);
						i++;
					}
						
					do
					{
						System.out.print("Ingrese una de las opciones: ");
						opc=manejarExcepcionIngresoNumEntero();
					}while(opc<0 || opc>4);
					
					p.setCategorias(categorias[opc-1]);
					System.out.println("****SE HA MODIFICADO EL PRODUCTO CON EXITO***");
				}
			}
		}else
			System.out.println("Lista vacia");
		
	}
	
	
}
