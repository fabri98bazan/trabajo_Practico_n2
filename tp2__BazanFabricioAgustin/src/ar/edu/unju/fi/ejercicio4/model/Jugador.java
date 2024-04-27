package ar.edu.unju.fi.ejercicio4.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private String nacionalidad;
	private LocalDate fechaNac;
	private double estatura;
	private double peso;
	private Posicion posicion;
	
	public Jugador() {
	
	}

	public Jugador(String nombre, String apellido, String nacionalidad, LocalDate fechaNac, double estatura, double peso,
			Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.fechaNac = fechaNac;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}



	//Inicio de la seccion de metodos
	public int calcularEdad() {
		int edad;
		LocalDate fechaActual=LocalDate.now();
		LocalDate fechaNacimiento=fechaNac;
		Period periodo = Period.between(fechaNacimiento, fechaActual);
		edad=periodo.getYears();
		return edad;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public LocalDate getFechaNac() {
		return fechaNac;
	}



	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}



	public double getEstatura() {
		return estatura;
	}



	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public Posicion getPosicion() {
		return posicion;
	}



	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}



	@Override
	public String toString() {
		return "\nNombre: " + nombre + " Apellido: " + apellido + "\nNacionalidad: " + nacionalidad + "\nFecha de Nacimiento: "
				+ fechaNac + "\nEstatura: " + estatura + "\nPeso: " + peso + "\nPosicion: " + posicion + " Edad: "+ calcularEdad();
	}
	
	
	
	
	
}