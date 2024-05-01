package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio7.model.Producto;
import ar.edu.unju.fi.ejercicio7.model.Producto.categoria;
import ar.edu.unju.fi.ejercicio7.model.Producto.origenFabricacion;

public class Main {
	
	public static Scanner sc=new Scanner(System.in);
	private static List<Producto> productos;

	public static void main(String[] args) {
		productos= new ArrayList<>();
		precargarProductos();
		int opc=0;
		do
		{
			mostrarMenu();
			opc=manejarExcepcionIngresoNumEntero();
			switch(opc)
			{
				case 1:
					mostrarProd();
					break;
					
				case 2:
					mostrarProdFaltantes();
					break;
					
				case 3:
					incrementoProd();
					break;
					
				case 4:
					mostrarProdHogarDisp();
					break;
					
				case 5:
					break;
					
				case 6:
					break;
					
				case 7: System.out.println("Fin del Programa!!"); break;
				
				default: System.out.println("La opcion ingresada no es correcta");
			}
		}while(opc!=7);
		sc.close();
	}
	
	/**
	 * Muestra el menu
	 */
	
	public static void mostrarMenu()
	{
		System.out.println("\n1. Mostrar Productos");
		System.out.println("2. Mostrar Productos faltantes");
		System.out.println("3. Incrementar los precios de productos en un %20");
		System.out.println("4. Mostrar Productos Electrohogar y disponibles");
		System.out.println("5. Ordenar los productos de forma descendente");
		System.out.println("6. Mostrar Productos con nombres en mayusculas");
		System.out.println("7. Salir");
		System.out.print("\nIngresar opcion: ");
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
	 * Precarga de Productos
	 */
	
	public static void precargarProductos()
	{
		origenFabricacion[] org=origenFabricacion.values();
		categoria[] cat=categoria.values();
		Producto p1=new Producto(126,"Televisor_HD", 65800.55, true, org[2], cat[2]);
		productos.add(p1);
		Producto p2=new Producto(116,"SmartPhone_Samsung", 165800.59, false, org[0], cat[0]);
		productos.add(p2);
		Producto p3=new Producto(180,"Procesador_i5", 11800.50, false, org[3], cat[1]);
		productos.add(p3);
		Producto p4=new Producto(176,"Refrigerador", 565800.09, false, org[1], cat[2]);
		productos.add(p4);
		Producto p5=new Producto(111,"Ventilador", 5800.17, true, org[0], cat[2]);
		productos.add(p5);
		Producto p6=new Producto(109,"Pistola_Clavos", 15000.15, true, org[1], cat[3]);
		productos.add(p6);
		Producto p7=new Producto(198,"Taladro", 44250.00, true, org[0], cat[3]);
		productos.add(p7);
		Producto p8=new Producto(127,"Aire_Acondicionado", 789800.48, true, org[3], cat[2]);
		productos.add(p8);
		Producto p9=new Producto(123,"Samsung_GalaxyA9", 195500.62, false, org[1], cat[0]);
		productos.add(p9);
		Producto p10=new Producto(137,"Mouse_Inhalambrico", 13500, true, org[2], cat[1]);
		productos.add(p10);
		Producto p11=new Producto(191,"Monitor_34''", 78950.25, false, org[0], cat[1]);
		productos.add(p11);
		Producto p12=new Producto(138,"Teclado_Inhalambrico", 35000.98, true, org[1], cat[1]);
		productos.add(p12);
		Producto p13=new Producto(135,"Parlante_Bluethoe", 22598.99, false, org[2], cat[2]);
		productos.add(p13);
		Producto p14=new Producto(117,"Caja_Herramientas", 58000.00, true, org[3], cat[3]);
		productos.add(p14);
		Producto p15=new Producto(199,"Modem", 45600.00, false, org[1], cat[0]);
		productos.add(p15);
	}
	
	/**
	 * Mostrar productos disponibles
	 */

	public static void mostrarProd()
	{
		Consumer<Producto> printConsumerProd= p->System.out.println(p);
		productos.forEach(printConsumerProd);
	}
	
	/**
	 * Muestra los faltantes
	 */
	
	public static void mostrarProdFaltantes()
	{
		List<Producto> faltantes = new ArrayList<>();
		Predicate<Producto> filterDispProd=Producto->Producto.isProd_disponible()==false;
		faltantes=productos.stream().filter(filterDispProd).collect(Collectors.toList());
		Consumer<Producto> printConsumerProd= p->System.out.println(p);
		faltantes.forEach(printConsumerProd);
	}
	
	/**
	 * Incrementar 20%
	 */
	
	public static void incrementoProd()
	{
		Consumer<Producto> printConsumerProd= p->System.out.println(p);
		
		Function<Producto, Producto> producIncr=(p)->
		{
			double resultado=(p.getPrec_unitario()*0.20)+p.getPrec_unitario();
			p.setPrec_unitario(resultado);
			return p;
		};
		List<Producto> productosIncrementados=new ArrayList<>();
		productosIncrementados=productos.stream().map(producIncr).collect(Collectors.toList());
		productosIncrementados.forEach(printConsumerProd);
		
	}
	
	/**
	 * Mostrar productos de ElectroHogar y disponibles
	 */
	public static void mostrarProdHogarDisp()
	{
		Consumer<Producto> printConsumerProd= p->System.out.println(p);
		
		List<Producto> disponible = new ArrayList<>();
		Predicate<Producto> filterDispProd=p-> p.isProd_disponible() && p.getCategorias()==p.getCategorias().ELECTROHOGAR;
		disponible=productos.stream().filter(filterDispProd).collect(Collectors.toList());
		disponible.forEach(printConsumerProd);
	}
	
}
