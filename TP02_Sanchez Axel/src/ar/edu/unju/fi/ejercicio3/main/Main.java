package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {
    public static void main(String[] args) {
        Provincia[] provincias = Provincia.values();
        System.out.println("** Información de Provincias **\n");
        for (Provincia provincia : provincias) {
            System.out.println("Provincia: " + provincia.name());
            System.out.println("Habitantes: " + provincia.getCantidadPoblacion());
            System.out.println("Superficie: " + provincia.getSuperficie() + " km^2");
            System.out.println("Densidad: " + provincia.calcularDensidad() + " (h/km^2)\n");
        }
    }
}
