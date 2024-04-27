package ar.edu.unju.fi.ejercicio2.model;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {
	private int codigo;
	private Mes mes;
	private int dia;
	private String descripcion;
	
	public Efemeride() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Efemeride [codigo=" + codigo + ", mes=" + mes + ", dia=" + dia + ", descripcion=" + descripcion + "]";
	}
	
	
}
