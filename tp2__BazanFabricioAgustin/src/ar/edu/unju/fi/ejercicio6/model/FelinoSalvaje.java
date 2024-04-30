package ar.edu.unju.fi.ejercicio6.model;

public class FelinoSalvaje {
	private String nombre;
	private byte edad;
	private Float peso;
	
	
	public FelinoSalvaje(String nombre, byte edad, Float peso) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public byte getEdad() {
		return edad;
	}


	public void setEdad(byte edad) {
		this.edad = edad;
	}


	public Float getPeso() {
		return peso;
	}


	public void setPeso(Float peso) {
		this.peso = peso;
	}


	@Override
	public String toString() {
		return "FelinoSalvaje [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}
	
	
	
}
