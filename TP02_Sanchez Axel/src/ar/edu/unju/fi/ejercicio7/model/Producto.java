package ar.edu.unju.fi.ejercicio7.model;

public class Producto {
	private String nombre;
	private String codigo;
	private float precio;
	private boolean estado;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, String codigo, float precio, boolean estado) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}	

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio + "]";
	}	

}