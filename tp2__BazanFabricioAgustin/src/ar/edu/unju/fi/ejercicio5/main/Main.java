package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.origenFabricacion;

public class Main {

	public static Scanner sc=new Scanner(System.in);
	private static List<Producto> productos;
	
	public static void main(String[] args) {
		productos=new ArrayList<>();
		int opc=0;
		precargarProductos();
		do
		{
			mostrarMenu();
			opc=manejarExcepcionIngresoNumEntero();
			switch(opc)
			{
				case 1:
					mostrarProductos();
					break;
				
				case 2:
					mostrarSubMenu(opc);
					break;
					
				case 3:
					System.out.println("\nFin del programa...");
					break;
				default:
					System.out.println("\nLa opcion ingresada es incorrecta...");
			}
		}while(opc!=3);

	}
	
	/**
	 * Solo es muestra de opciones
	 */
	
	public static void mostrarMenu()
	{
		System.out.println("\n1. Mostrar Productos.");
		System.out.println("2. Realizar Compra");
		System.out.println("3. Salir.");
		System.out.print("\nIngrese opcion: ");
	}
	
	/**
	 * Solo es muestra de subopciones
	 */
	
	public static void mostrarSubMenu(int opc)
	{
		System.out.println("\n1. Pago con efectivo.");
		System.out.println("2. Pago con Tarjeta");
		System.out.print("\nIngrese opcion: ");
		do {
			opc=manejarExcepcionIngresoNumEntero();
		}while(opc<=0 || opc>2);
		if(opc==2)
		{
			System.out.print("Ingrese nro. Tarjeta: ");
			String nro_tarjeta=controlarIngresoCad();
			LocalDate fecha_pago=LocalDate.now();
		    System.out.print("Ingrese monto: ");
		    double monto=manejarExcepcionIngresoNumReal();
		    PagoTarjeta pag_tarj=new PagoTarjeta(nro_tarjeta, fecha_pago, monto);
		    pag_tarj.realizarPago(monto);
		    pag_tarj.imprimirRecibo();
		}else
		{
			if(opc==1)
			{
				LocalDate fecha_pago=LocalDate.now();
				System.out.print("Ingrese monto: ");
			    double monto=manejarExcepcionIngresoNumReal();
				PagoEfectivo pag_efectivo=new PagoEfectivo(monto, fecha_pago);
				pag_efectivo.realizarPago(monto);
				pag_efectivo.imprimirRecibo();
			}
		}
		
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
	 * Control de ingreso de cadenas
	 */
	
	public static String controlarIngresoCad()
	{
        String cad;
        
        do {
            cad=sc.next();
        } while (!cad.matches("[0-9]+") && cad.length()!=16);
        
        
        return cad;
	}
	
	

}
