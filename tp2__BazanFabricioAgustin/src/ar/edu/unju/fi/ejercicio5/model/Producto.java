package ar.edu.unju.fi.ejercicio5.model;

public class Producto {
	 private int codigo;
	 private String descripción;
	 private double prec_unitario;
	 private boolean prod_disponible;
	 private origenFabricacion origen_fabricacion;
	 private categoria categorias;
	 
	 public enum origenFabricacion{
		 ARGENTINA, CHINA, BRASIL, URUGAY
	 }
	 
	 public enum categoria{
		 TELEFONIA,INFORMATICA,ELECTROHOGAR,HERRAMIENTAS
	 }

	public Producto(int codigo, String descripción, double prec_unitario, boolean prod_disponible,
			origenFabricacion origen_fabricacion, categoria categorias) {
		this.codigo = codigo;
		this.descripción = descripción;
		this.prec_unitario = prec_unitario;
		this.prod_disponible = prod_disponible;
		this.origen_fabricacion = origen_fabricacion;
		this.categorias = categorias;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public double getPrec_unitario() {
		return prec_unitario;
	}

	public void setPrec_unitario(double prec_unitario) {
		this.prec_unitario = prec_unitario;
	}

	public boolean isProd_disponible() {
		return prod_disponible;
	}

	public void setProd_disponible(boolean prod_disponible) {
		this.prod_disponible = prod_disponible;
	}

	public origenFabricacion getOrigen_fabricacion() {
		return origen_fabricacion;
	}

	public void setOrigen_fabricacion(origenFabricacion origen_fabricacion) {
		this.origen_fabricacion = origen_fabricacion;
	}

	public categoria getCategorias() {
		return categorias;
	}

	public void setCategorias(categoria categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripción=" + descripción + ", prec_unitario=" + prec_unitario
				+ ", prod_disponible=" + prod_disponible + ", origen_fabricacion=" + origen_fabricacion
				+ ", categorias=" + categorias + "]";
	}

	 
}
