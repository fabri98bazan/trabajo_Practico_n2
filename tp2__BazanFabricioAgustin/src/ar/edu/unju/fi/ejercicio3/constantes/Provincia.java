package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(125000,25000), SALTA(225000,25600), TUCUMAN(625000,75000), CATAMARCA(580000,190000), LA_RIOJA(150000,75000), SANTIAGO_DEL_ESTERO(895000,125000);
	
	private int cant_poblacion;
	private double superficie;
	
	private Provincia(int cant_poblacion, double superficie) {
		this.cant_poblacion=cant_poblacion;
		this.superficie=superficie;
	}

	public int getCant_poblacion() {
		return cant_poblacion;
	}

	public void setCant_poblacion(int cant_poblacion) {
		this.cant_poblacion = cant_poblacion;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
	/**
	 * METODO PARA CALCULAR LA DENSIDAD POBLACIONAL
	 */
	
	public double calcularDensidadPoblacional()
	{
		return cant_poblacion/superficie;
	}
	
	
	
}
