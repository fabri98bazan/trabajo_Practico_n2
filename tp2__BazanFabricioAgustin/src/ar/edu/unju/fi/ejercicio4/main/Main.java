package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	
	public static Scanner sc=new Scanner(System.in);
	private static List<Jugador> jugadores;

	public static void main(String[] args) {
		jugadores=new ArrayList<>();
		int opc=0;
		do
		{
			mostrarMenu();
			opc=manejarExcepcionIngresoNumEntero();
			switch(opc)
			{
				case 1:
					darAltaJugadores();
					break;
					
				case 2:
					mostrarJugadores();
					break;
				
				case 3:
					modificarPosicionJugador();
					break;
					
				case 4:
					eliminarJugador();
					break;
					
				case 5:
					System.out.println("Fin del programa!!!");
					break;
				
				default:System.out.println("No ha ingresado una opcion correcta");
			}
		}while(opc!=5);

	}

	/**
	 * Solo muestre el menu principal
	 */
	
	public static void mostrarMenu() {
		System.out.println("\n1) Alta a jugador");
		System.out.println("2) Mostrar todos los jugadores");
		System.out.println("3) Modificar la posicion de un jugador");
		System.out.println("4) Eliminar Jugador");
		System.out.println("5) Salir");
		System.out.print("\nIngrese opcion: ");
	}
	
	/**
	 * Maneja excepcion de numeros enteros
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
	 * Maneja excepciones con numeros reales
	 * @return
	 */
	public static double manejarExcepcionIngresoNumDouble() {
		boolean band=false;
		double n= 0.0;
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
	 * Maneja el control de que la cadena de caracteres no vuelva vacía
	 * @return
	 */
	
	public static String controlIngresoPalabra() {
		boolean band=false;
		String nombre;
		do {
			nombre=sc.next();
			if(nombre.length()<3 || nombre.matches(".*[^a-zA-Z].*")==true)
				System.out.println("Debe ingresar correctamente");
			else
				band=true;
		}while(band==false);
		return nombre;
	}
	
	/**
	 *  Valida el año de nacimiento
	 * @return
	 */
	
	public static int validarFechaAño() {
		int a=0;
		do
			a=manejarExcepcionIngresoNumEntero();
		while(a<1950 || a>2018);
		
		return a;
	}
	
	/**
	 *  Valida el mes
	 * @return
	 */
	public static int validarFechaMes() {
		int a=0;
		do
			a=manejarExcepcionIngresoNumEntero();
		while(a<1 || a>12);
		
		return a;
	}
	
	/**
	 * Valida el dia basandose en el mes nacido
	 * @param mes
	 * @return
	 */
	
	public static int validarFechaDia(int mes) {
		int a=0;
		boolean band=false;
		do
		{
			do
				a=manejarExcepcionIngresoNumEntero();
			while(a<1 || a>31);
			
			if(mes==2 && a<29)
				band=true;
			else
			{
				if((mes==1 && a<=31) || (mes==3 && a<=31) ||(mes==5 && a<=31) ||(mes==7 && a<=31) ||(mes==8 && a<=31) ||(mes==10 && a<=31) ||(mes==12 && a<=31))
					band=true;
				else
				{
					if((mes==4 && a<=30) || (mes==6 && a<=30) ||(mes==9 && a<=30) ||(mes==11 && a<=30))
						band=true;
				}
			}
		}while(band==false);
		return a;
	}
	
	/**
	 *  valida el ingreso de estatura
	 * @return
	 */
	
	public static double ingresarEstatura() {
		double estatura;
		do
			estatura=manejarExcepcionIngresoNumDouble();
		while(estatura<1 || estatura>2.5);
		return estatura;
	}
	
	/**
	 *  Valida el ingresp de peso
	 * @return
	 */
	public static double ingresarPeso() {
		double peso;
		do
			peso=manejarExcepcionIngresoNumDouble();
		while(peso<52 || peso>120);
		return peso;
	}
	
	/**
	 * CONTROLAR LOS NOMBRES Y APELLIDOS
	 */
	
	public static boolean controlarNomyAp(String nom, String ap)
	{
		boolean band=false;
		if(!jugadores.isEmpty())
		{
			for(Jugador j: jugadores)
			{
				if(j.getNombre().equals(nom) && j.getApellido().equals(ap))
				{
					band=true;
					break;
				}
			}
		}
		return band;
	}
	
	/**
	 * DAR DE ALTA A JUGADORES
	 */
	
	public static void darAltaJugadores()
	{
		System.out.println("****ALTA DE JUGADORES****");
		String nombre, apellido;
		System.out.print("Ingrese nombre del jugador: ");
		nombre=controlIngresoPalabra();
		System.out.print("Ingrese apellido del jugador: ");
		apellido=controlIngresoPalabra();
		if(controlarNomyAp(nombre, apellido)==false)
		{
			Posicion[] pos=Posicion.values();
			int d,m,a,opc=0, i=1;
			Jugador jugador=new Jugador();
			jugador.setNombre(nombre);
			jugador.setApellido(apellido);
			System.out.print("Ingrese la Nacionalidad del Jugador: ");
			jugador.setNacionalidad(controlIngresoPalabra());
			System.out.print("Ingrese año de nacimiento(1950-2018): ");
			a=validarFechaAño();
			System.out.print("Ingrese mes de nacimiento(1-12): ");
			m=validarFechaMes();
			System.out.print("Ingrese día de nacimiento(1-31): ");
			d=validarFechaDia(m);
			LocalDate fechaNac=LocalDate.of(a, m, d);
			jugador.setFechaNac(fechaNac);
			System.out.print("Ingrese estatura: ");
			jugador.setEstatura(ingresarEstatura());
			System.out.print("Ingrese Peso: ");
			jugador.setPeso(ingresarPeso());
			for(Posicion p: pos)
			{
				System.out.println(i+". "+p);
				i++;
			}
			do
			{
				System.out.print("Seleccione su posicion: ");
				opc=manejarExcepcionIngresoNumEntero();
			}while(opc<0 || opc>4);
			
			jugador.setPosicion(pos[opc-1]);
			
			jugadores.add(jugador);

		}else
			System.out.println("EL JUGADOR INGRESADO, YA ESTÁ EN LA LISTA");
	}
	
	/**
	 * muestra todos los objetos guardados en el arraylist de choferes
	 */
	public static void mostrarJugadores()
	{
		if(!jugadores.isEmpty())
		{
			System.out.println("-----LISTA DE JUGADORES------");
			jugadores.forEach(c->System.out.println(c));
		}else
			System.out.println("LA LISTA ESTÁ VACIA");
		
	}
	
	/**
	 * modificar posicion de un jugador
	 */
	
	public static void eliminarJugador()
	{
		if(!jugadores.isEmpty())
		{
			System.out.println("-----ELIMINAR JUGADOR--------");
			String nombre, apellido;
			System.out.print("Ingrese nombre del jugador: ");
			nombre=controlIngresoPalabra();
			System.out.print("Ingrese apellido del jugador: ");
			apellido=controlIngresoPalabra();
			if(controlarNomyAp(nombre, apellido)==true)
			{
				Iterator<Jugador> iterator=jugadores.iterator();
				while(iterator.hasNext())
				{
					Jugador jugador= iterator.next();
					if(jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido))
					{
						System.out.println("*DATOS DEL JUGADOR A ELIMINAR*");
						System.out.println(jugador.toString());
						iterator.remove();
						System.out.println("JUGADOR ELIMINADO");
					}
				}
				
			}else
				System.out.println("EL JUGADOR QUE INGRESÓ NO EXISTE");
		}else
			System.out.println("LA LISTA ESTÁ VACIA");
	}
	
	/**
	 * MODIFICA LA POSICION DEL JUGADOR
	 */
	
	public static void modificarPosicionJugador()
	{
		Posicion[] pos=Posicion.values();
		int i=1, opc=0;
		if(!jugadores.isEmpty())
		{
			System.out.println("-----MODIFICAR LA POSICION DEL JUGADOR--------");
			String nombre, apellido;
			System.out.print("Ingrese nombre del jugador: ");
			nombre=controlIngresoPalabra();
			System.out.print("Ingrese apellido del jugador: ");
			apellido=controlIngresoPalabra();
			if(controlarNomyAp(nombre, apellido)==true)
			{
				for(Jugador j: jugadores)
				{
					if(j.getNombre().equals(nombre) && j.getApellido().equals(apellido))
					{
						for(Posicion p: pos)
						{
							System.out.println(i+". "+p);
							i++;
						}
						do
						{
							System.out.print("Seleccione su posicion: ");
							opc=manejarExcepcionIngresoNumEntero();
						}while(opc<0 || opc>4);
						
						j.setPosicion(pos[opc-1]);
						System.out.println("---MODIFICACION EXITOSA---");
						System.out.println(j.toString());
						break;
					}
				}
				
			}else
				System.out.println("EL JUGADOR QUE INGRESÓ NO EXISTE");
		}else
			System.out.println("LA LISTA ESTÁ VACIA");
	}
	
}

