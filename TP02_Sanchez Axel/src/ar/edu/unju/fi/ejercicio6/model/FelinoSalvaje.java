package ar.edu.unju.fi.ejercicio6.model;

public class FelinoSalvaje {
	
	public String nombre;
	public byte edad;
	public float peso;
	
	 public FelinoSalvaje() {
		// TODO Auto-generated constructor stub
	} 
	 
	public FelinoSalvaje(String nombre, byte edad, float peso) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public byte getEdad() {
		return edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "FelinoSalvaje [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}	
	
}