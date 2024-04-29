package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {

	private String nro_tarjeta;
	private LocalDate fecha_pago;
	private double monto;
	
	
	
	public PagoTarjeta(String nro_tarjeta, LocalDate fecha_pago, double monto) {
		this.nro_tarjeta = nro_tarjeta;
		this.fecha_pago = fecha_pago;
		this.monto = monto;
	}
	
	

	public String getNro_tarjeta() {
		return nro_tarjeta;
	}



	public void setNro_tarjeta(String nro_tarjeta) {
		this.nro_tarjeta = nro_tarjeta;
	}



	public LocalDate getFecha_pago() {
		return fecha_pago;
	}



	public void setFecha_pago(LocalDate fecha_pago) {
		this.fecha_pago = fecha_pago;
	}



	public double getMonto() {
		return monto;
	}



	public void setMonto(double monto) {
		this.monto = monto;
	}

	


	@Override
	public String toString() {
		return "PagoTarjeta [nro_tarjeta=" + nro_tarjeta + ", fecha_pago=" + fecha_pago + ", monto=" + monto + "]";
	}



	@Override
	public void realizarPago(double monto) {
		this.setMonto((monto*0.15)+monto);
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("\nNro. Tarjeta: "+nro_tarjeta);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String fechaFormateada = fecha_pago.format(formatter);
	    System.out.println("Fecha de pago: "+fechaFormateada);
	    System.out.println("Monto pagado: "+monto);
	}
	
}
