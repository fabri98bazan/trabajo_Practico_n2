package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	
	private double monto_pagado;
	private LocalDate fecha_pago;
	
	

	public PagoEfectivo(double monto_pagado, LocalDate fecha_pago) {
		this.monto_pagado = monto_pagado;
		this.fecha_pago = fecha_pago;
	}
	
	

	public double getMonto_pagado() {
		return monto_pagado;
	}



	public void setMonto_pagado(double monto_pagado) {
		this.monto_pagado = monto_pagado;
	}



	public LocalDate getFecha_pago() {
		return fecha_pago;
	}



	public void setFecha_pago(LocalDate fecha_pago) {
		this.fecha_pago = fecha_pago;
	}


	

	@Override
	public String toString() {
		return "PagoEfectivo [monto_pagado=" + monto_pagado + ", fecha_pago=" + fecha_pago + "]";
	}



	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		
	}

}
